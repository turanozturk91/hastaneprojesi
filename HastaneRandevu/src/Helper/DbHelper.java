/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author turanozturk
 */
public class DbHelper {
    
    static final String userName = "root";
    static final String password = "root";
    static final String dbUrl = "jdbc:mysql://localhost:8889/hastane?useSSL=false";
    
    public Connection getConnection() throws SQLException{
    
        return DriverManager.getConnection(dbUrl,userName,password);
        
    }
    
    public void showMessage(SQLException e){
        System.out.println("ERROR : " + e.getMessage());
        System.out.println("ERROR CODE : " + e.getErrorCode());
    }
 
}
