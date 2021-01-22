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
public class PoliklinikIslemleri implements Islemler{
    
    DbHelper dbHelper = new DbHelper();
    Connection connection = null;
    ResultSet rs = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    
    public ArrayList<Poliklinik> Listele(String sql){
    ArrayList<Poliklinik> poliklinikler = new ArrayList<Poliklinik>();
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while(rs.next()){
                poliklinikler.add( new Poliklinik( rs.getInt("id") , rs.getString("poliklinik_adi") ));
            }
            
        } catch (SQLException e) {
            dbHelper.showMessage(e);
        }
        
        return poliklinikler;
        
    }
    
    
    public String idToPoliklinik(int id){
        
        String poliklinikAdi = "";
        
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM poliklinikler WHERE id = '"+ id +"' ");
            while(rs.next()){
            poliklinikAdi = rs.getString("poliklinik_adi");
            }
            
        } catch (SQLException e) {
            dbHelper.showMessage(e);
    }
        return poliklinikAdi;
    }
    
    public int PoliklinikToID(String poliklinik){
   
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM poliklinikler WHERE poliklinik_adi = '"+ poliklinik +"' ");
            while(rs.next()){
            int poliklinikID = rs.getInt("id");
            return poliklinikID;
            }
            
        } catch (SQLException e) {
            dbHelper.showMessage(e);
            return 0;
    }
        return 0;
    }
    
     public boolean Guncelle(Poliklinik poliklinik){
                   
        try {
            connection = dbHelper.getConnection();
            System.out.println("BAĞLANDI");
        } catch (SQLException ex) {
            dbHelper.showMessage(ex);
        }
        
        
        try {
                statement = connection.createStatement();
                String sql = "";
                sql = " UPDATE `poliklinikler` SET `poliklinik_adi`= '"+poliklinik.getPoliklinikAdi()+"' WHERE id = '"+poliklinik.getPoliklinikID()+"' "; 
                statement.execute(sql);
                return true;
            } catch (SQLException ex) {
                dbHelper.showMessage(ex);
                return false;
            } 
    }
     
    public boolean Sil(Poliklinik poliklinik){
                   
        try {
            connection = dbHelper.getConnection();
            System.out.println("BAĞLANDI");
        } catch (SQLException ex) {
            dbHelper.showMessage(ex);
        }
        
        
        try {
                statement = connection.createStatement();
                String sql = "";
                sql = "DELETE FROM poliklinikler WHERE id = '"+ poliklinik.getPoliklinikID()+"' "; 
                statement.executeUpdate(sql);
                return true;
            } catch (SQLException ex) {
                dbHelper.showMessage(ex);
                return false;
            } 
    }
    
    public boolean Ekle(Poliklinik Poliklinik){
                   
        try {
            connection = dbHelper.getConnection();
            System.out.println("BAĞLANDI");
        } catch (SQLException ex) {
            dbHelper.showMessage(ex);
        }
        
        
        try {
                String query = "INSERT INTO `poliklinikler`(`poliklinik_adi`)"
                + " values (?)";
                
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString (1, Poliklinik.getPoliklinikAdi());
        
                // execute the preparedstatement
                preparedStmt.execute();
                return true;
                } catch (SQLException ex) {
                dbHelper.showMessage(ex);
                return false;
                } 
    }
    

}
