/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Helper.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author turanozturk
 */
public class DoktorIslemleri implements Islemler{
    
    DbHelper dbHelper = new DbHelper();
    Connection connection = null;
    ResultSet rs = null;
    Statement statement = null;
    
    public ArrayList<Doktor> Listele(String sql){
    ArrayList<Doktor> doktorlar = new ArrayList<Doktor>();
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while(rs.next()){
                doktorlar.add( new Doktor( 
                        rs.getInt("id") , 
                        rs.getString("isim_soyisim"),
                        rs.getString("tckn"),
                        rs.getInt("poliklinik_id"),
                        rs.getString("telefon"),
                        rs.getString("adres"),
                        rs.getString("cinsiyet"),
                        rs.getString("dogum_tarihi")
                ));
            }
            
        } catch (SQLException e) {
            dbHelper.showMessage(e);
        }
        
        return doktorlar;
        
    }
    
    public String idToDoktor(int id){
        
        String doktorAdi = "";
        
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM doktorlar WHERE id = '"+ id +"' ");
            while(rs.next()){
            doktorAdi = rs.getString("isim_soyisim");
            }
            
        } catch (SQLException e) {
            dbHelper.showMessage(e);
    }
        return doktorAdi;
    }
    
    public boolean Ekle(Doktor doktor){
                   
        try {
            connection = dbHelper.getConnection();
            System.out.println("BAĞLANDIssss");
        } catch (SQLException ex) {
            dbHelper.showMessage(ex);
        }
        
        
        try {
                String query = "INSERT INTO `doktorlar`(`isim_soyisim`, `tckn`, `dogum_tarihi`, `telefon`, `cinsiyet`, `adres`, `poliklinik_id`)"
                + " values (?,?,?,?,?,?,?)";
                
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString (1, doktor.getisimSoyisim());
                preparedStmt.setString (2, doktor.getTckn());
                preparedStmt.setString (3, doktor.getDogumTarihi());
                preparedStmt.setString (4, doktor.getTelefon());
                System.out.println(doktor.getCinsiyet());
                preparedStmt.setString (5, doktor.getCinsiyet());
                preparedStmt.setString (6, doktor.getAdres());
                preparedStmt.setInt (7, doktor.getPoliklinikId());
                
                // execute the preparedstatement
                preparedStmt.execute();
                return true;
                } catch (SQLException ex) {
                dbHelper.showMessage(ex);
                return false;
                } 
    }
    
    public boolean Guncelle(Doktor doktor){
                   
        try {
            connection = dbHelper.getConnection();
            System.out.println("BAĞLANDI");
        } catch (SQLException ex) {
            dbHelper.showMessage(ex);
        }
        
        
        try {
                statement = connection.createStatement();
                String sql = "";
                sql = " UPDATE `doktorlar` SET `isim_soyisim`= '"+doktor.getisimSoyisim()+"' ,`tckn`= '"+doktor.getTckn()+"',`dogum_tarihi`= '"+doktor.getDogumTarihi()+"',`telefon`= '"+doktor.getTelefon()+"',`cinsiyet`= '"+doktor.getCinsiyet()+"',`adres`= '"+doktor.getAdres()+"',`poliklinik_id`= '"+doktor.getPoliklinikId()+"' WHERE id = '"+doktor.getId()+"' "; 
                statement.execute(sql);
                return true;
            } catch (SQLException ex) {
                dbHelper.showMessage(ex);
                return false;
            } 
    }
    
    public boolean Sil(Doktor doktor){
                   
        try {
            connection = dbHelper.getConnection();
            System.out.println("BAĞLANDI");
        } catch (SQLException ex) {
            dbHelper.showMessage(ex);
        }
        
        
        try {
                statement = connection.createStatement();
                String sql = "";
                sql = "DELETE FROM doktorlar WHERE id = '"+ doktor.getId() +"' "; 
                statement.executeUpdate(sql);
                return true;
            } catch (SQLException ex) {
                dbHelper.showMessage(ex);
                return false;
            } 
    }

 
    
    
}
