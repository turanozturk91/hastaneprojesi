/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Helper.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author turanozturk
 */
public class RandevuIslemleri implements Islemler{
    
    private TakvimIslemleri takvimIslemleri = new TakvimIslemleri();
    
    DbHelper dbHelper = new DbHelper();
    Connection connection = null;
    ResultSet rs = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    
    public boolean Ekle(Randevu randevu){
                   
        try {
            connection = dbHelper.getConnection();
            System.out.println("BAĞLANDI");
        } catch (SQLException ex) {
            dbHelper.showMessage(ex);
        }
        
        
        try {
                String query = "INSERT INTO `randevular`(`hasta_isimsoyisim`, `hasta_tckn`, `hasta_tel`, `hasta_adres`, `doktor_id`, `poliklinik_id`, `randevu_saat`, `randevu_tarih`, `hasta_dogumtarihi` , `hasta_cinsiyet`)"
                + " values (?,?,?,?,?,?,?,?,?,?)";
                
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString (1, randevu.getHasta().getisimSoyisim());
                preparedStmt.setString (2, randevu.getHasta().getTckn());
                preparedStmt.setString (3, randevu.getHasta().getTelefon());
                preparedStmt.setString (4, randevu.getHasta().getAdres());
                preparedStmt.setInt (5, randevu.getDoktorId());
                preparedStmt.setInt (6, randevu.getPoliklinikId());
                preparedStmt.setInt (7, takvimIslemleri.saatToInt(randevu.getSaat()));
                preparedStmt.setString (8, randevu.getTarih());
                preparedStmt.setString (9, randevu.getHasta().getDogumTarihi());
                preparedStmt.setString (10, randevu.getHasta().getCinsiyet());
                // execute the preparedstatement
                preparedStmt.execute();
                return true;
                } catch (SQLException ex) {
                dbHelper.showMessage(ex);
                return false;
                } 
    }
    
    
    public ArrayList<Randevu> Listele(String sql){
    ArrayList<Randevu> randevular = new ArrayList<Randevu>();
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while(rs.next()){
                Hasta hasta = new Hasta();
                hasta.setisimSoyisim(rs.getString("hasta_isimsoyisim"));
                hasta.setDogumTarihi(rs.getString("hasta_dogumtarihi"));
                hasta.setCinsiyet(rs.getString("hasta_cinsiyet"));
                hasta.setTckn(rs.getString("hasta_tckn"));
                hasta.setTelefon(rs.getString("hasta_tel"));
                hasta.setAdres(rs.getString("hasta_adres"));
                Randevu randevu = new Randevu();
                randevu.setId(rs.getInt("id"));
                randevu.setPoliklinikId(rs.getInt("poliklinik_id"));
                randevu.setDoktorId(rs.getInt("doktor_id"));
                randevu.setSaat(takvimIslemleri.intToSaat(rs.getInt("randevu_saat")));
                randevu.setTarih(rs.getString("randevu_tarih"));
                randevu.setHasta(hasta);
                randevular.add(randevu);
            }
            
        } catch (SQLException e) {
            dbHelper.showMessage(e);
        }
        
        return randevular;
        
    }
    
    public boolean Sil(Randevu randevu){
                   
        try {
            connection = dbHelper.getConnection();
            System.out.println("BAĞLANDI");
        } catch (SQLException ex) {
            dbHelper.showMessage(ex);
        }
        
        
        try {
                statement = connection.createStatement();
                String sql = "";
                sql = "DELETE FROM randevular WHERE id = '"+ randevu.getId() +"' "; 
                statement.executeUpdate(sql);
                return true;
            } catch (SQLException ex) {
                dbHelper.showMessage(ex);
                return false;
            } 
    }
    
    public boolean Guncelle(Randevu randevu){
                   
        try {
            connection = dbHelper.getConnection();
            System.out.println("BAĞLANDI");
        } catch (SQLException ex) {
            dbHelper.showMessage(ex);
        }
        
        
        try {
                statement = connection.createStatement();
                String sql = "";
                System.out.println(takvimIslemleri.saatToInt(randevu.getSaat()));
                sql = "UPDATE `randevular` SET hasta_isimsoyisim = '"+randevu.getHasta().getisimSoyisim()+"', hasta_dogumtarihi = '"+randevu.getHasta().getDogumTarihi()+"', hasta_cinsiyet = '"+randevu.getHasta().getCinsiyet()+"', hasta_tckn = '"+randevu.getHasta().getTckn()+"', hasta_tel = '"+randevu.getHasta().getTelefon()+"', hasta_adres = '"+randevu.getHasta().getAdres()+"', doktor_id = '"+randevu.getDoktorId()+"', poliklinik_id = '"+randevu.getPoliklinikId()+"', randevu_saat = '"+takvimIslemleri.saatToInt(randevu.getSaat())+"', randevu_tarih = '"+randevu.getTarih()+"' WHERE id = '"+randevu.getId()+"' "; 
                statement.execute(sql);
                return true;
            } catch (SQLException ex) {
                dbHelper.showMessage(ex);
                return false;
            } 
    }
    
   
        
    
}
