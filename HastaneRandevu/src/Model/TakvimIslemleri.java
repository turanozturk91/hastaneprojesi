/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Helper.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author turanozturk
 */
public class TakvimIslemleri {
    
        DbHelper dbHelper = new DbHelper();
        Connection connection = null;
        ResultSet rs = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
    
    
    public String intToSaat(int intSaat){
        String saat = "";
        
        switch(intSaat){
        
            case 1:
                saat = "09:00";
                break;
            case 2:
                saat = "09:15";
                break;
            case 3:
                saat = "09:30";
                break;
            case 4:
                saat = "09:45";
                break;
            case 5:
                saat = "10:00";
                break;
            case 6:
                saat = "10:15";
                break;
            case 7:
                saat = "10:30";
                break;
            case 8:
                saat = "10:45";
                break;
            case 9:
                saat = "11:00";
                break;
            case 10:
                saat = "11:15";
                break;
            case 11:
                saat = "11:30";
                break;
            case 12:
                saat = "11:45";
                break;
            case 13:
                saat = "12:00";
                break;
            case 14:
                saat = "12:15";
                break;
            case 15:
                saat = "12:30";
                break;
            case 16:
                saat = "12:45";
                break;
            case 17:
                saat = "14:00";
                break;
            case 18:
                saat = "14:15";
                break;
            case 19:
                saat = "14:30";
                break;
            case 20:
                saat = "14:45";
                break;
            case 21:
                saat = "15:00";
                break;
            case 22:
                saat = "15:15";
                break;
            case 23:
                saat = "15:30";
                break;
            case 24:
                saat = "15:45";
                break;
            case 25:
                saat = "16:00";
                break;
            case 26:
                saat = "16:15";
                break;
            case 27:
                saat = "16:30";
                break;
            case 28:
                saat = "16:45";
                break;
            case 29:
                saat = "17:00";
                break;
            case 30:
                saat = "17:15";
                break;
            case 31:
                saat = "17:30";
                break;
            case 32:
                saat = "17:45";
                break;
            
        }
    
        return saat;
      
    }
        
    public int saatToInt(String Stringsaat){
    
        int saat = 0;
        
        switch(Stringsaat){
        
            case  "09:00" :
                saat = 1;
                break;
            case  "09:15" :
                saat = 2;
                break;
            case  "09:30" :
                saat = 3;
                break;
            case  "09:45" :
                saat = 4;
                break;
            case  "10:00" :
                saat = 5;
                break;
            case  "10:15" :
                saat = 6;
                break;
            case  "10:30" :
                saat = 7;
                break;
            case  "10:45" :
                saat = 8;
                break;
            case  "11:00" :
                saat = 9;
                break;
            case  "11:15" :
                saat = 10;
                break;
            case  "11:30" :
                saat = 11;
                break;
            case  "11:45" :
                saat = 12;
                break;
            case  "12:00" :
                saat = 13;
                break;
            case  "12:15" :
                saat = 14;
                break;
            case  "12:30" :
                saat = 15;
                break;
            case  "12:45" :
                saat = 16;
                break;
            case  "14:00" :
                saat = 17;
                break;
            case  "14:15" :
                saat = 18;
                break;
            case  "14:30" :
                saat = 19;
                break;
            case  "14:45" :
                saat = 20;
                break;
            case  "15:00" :
                saat = 21;
                break;
            case  "15:15" :
                saat = 22;
                break;
            case  "15:30" :
                saat = 23;
                break;
            case  "15:45" :
                saat = 24;
                break;
            case  "16:00" :
                saat = 25;
                break;
            case  "16:15" :
                saat = 26;
                break;
            case  "16:30" :
                saat = 27;
                break;
            case  "16:45" :
                saat = 28;
                break;
            case  "17:00" :
                saat = 29;
                break;
            case  "17:15":
                saat = 30;
                break;
            case  "17:30" :
                saat = 31;
                break;
            case  "17:45" :
                saat = 32;
                break;
            
        }
        
        return saat;
    }
    
        
    public ArrayList<String> uygunSaatler(String date, int doktorID){
       
        ArrayList<String> uygunSaatler = new ArrayList<String>();
            try {
                connection = dbHelper.getConnection();
                statement = connection.createStatement();
                String sql = "";
                int status = 0;
                for(int i = 1; i <= 32; i++){
                sql = "SELECT * FROM randevular WHERE randevu_tarih = '"+ date +"' AND doktor_id = "+ doktorID +" AND randevu_saat = "+ i +" ";
                    
                  rs = statement.executeQuery(sql);
                  while(rs.next()){
                      status = 1;
                  }
                  if( status == 0){
                      uygunSaatler.add(intToSaat(i));
                  }
                  status = 0;
                }
            

            } catch (SQLException e) {
                dbHelper.showMessage(e);
            }

            return uygunSaatler;

        }
    
    public ArrayList<String> uygunSaatler(String date, int doktorID, int mevcutSaat){
       
        ArrayList<String> uygunSaatler = new ArrayList<String>();
            try {
                connection = dbHelper.getConnection();
                statement = connection.createStatement();
                String sql = "";
                int status = 0;
                for(int i = 1; i <= 32; i++){
                sql = "SELECT * FROM randevular WHERE randevu_tarih = '"+ date +"' AND doktor_id = "+ doktorID +" AND randevu_saat = "+ i +" ";
                    
                  rs = statement.executeQuery(sql);
                  
                  if(mevcutSaat == i){
                      uygunSaatler.add(intToSaat(mevcutSaat));
                  }
                  
                  while(rs.next()){
                      status = 1;
                  }
                  if( status == 0){
                      uygunSaatler.add(intToSaat(i));
                  }
                  status = 0;
                }
            

            } catch (SQLException e) {
                dbHelper.showMessage(e);
            }

            return uygunSaatler;

        }
    
    public ArrayList<String> uygunSaatler(String date, String mevcutDate, int doktorID, int mevcutDoktorID ,int mevcutSaat){
       
        ArrayList<String> uygunSaatler = new ArrayList<String>();
            try {
                connection = dbHelper.getConnection();
                statement = connection.createStatement();
                String sql = "";
                int status = 0;
                for(int i = 1; i <= 32; i++){
                sql = "SELECT * FROM randevular WHERE randevu_tarih = '"+ date +"' AND doktor_id = "+ doktorID +" AND randevu_saat = "+ i +" ";
                    
                  rs = statement.executeQuery(sql);
                  
                  if( (date.equals(mevcutDate)) && (doktorID == mevcutDoktorID) && (mevcutSaat == i) ){
                      uygunSaatler.add(intToSaat(mevcutSaat));
                  }
                  
                  while(rs.next()){
                      status = 1;
                  }
                  if( status == 0){
                      uygunSaatler.add(intToSaat(i));
                  }
                  status = 0;
                }
            

            } catch (SQLException e) {
                dbHelper.showMessage(e);
            }

            return uygunSaatler;

        }
    
      
}
