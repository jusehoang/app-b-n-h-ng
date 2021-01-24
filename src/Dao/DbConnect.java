/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author hung
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hung
 */
public class DbConnect {
    public static Connection getConnection()throws SQLException{
        try {
            Connection cons = null;
            Class.forName("com.mysql.jdbc.Driver");
            cons = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root","tuanhung1999");
            return cons;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return  null;
    }
    public static void main(String[] args) throws SQLException,NullPointerException {
        System.out.println(getConnection());
    }
}
