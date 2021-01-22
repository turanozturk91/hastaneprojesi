/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Helper.DbHelper;
import Helper.DbHelper;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author turanozturk
 */
public class CalisanIslemleri {
    
    DbHelper helper = new DbHelper();
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    
    public boolean CalisanEkle(String name, String surname, String tckn, String password, int type){
        
        String sql = "INSERT INTO `calisanlar`(`isim`, `soyisim`, `tckn`, `parola`, `calisan_tipi`) VALUES ('"+name+"','"+surname+"',"
                + "'"+tckn+"','"+password+"',"+type+" )";
        
        try {
            connection = helper.getConnection();
            System.out.println("BAĞLANDI");
        } catch (SQLException ex) {
            helper.showMessage(ex);
        }
        
        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(sql);
            int result = statement.executeUpdate();
            if(result == 1){
                return true;
            }else{
                return false;
            }
           
        } catch (SQLException ex) {
            helper.showMessage(ex);
            return false;
        }
        
    
    }
   
    
    
}
