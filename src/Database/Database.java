/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Muhammad Dila
 */
public class Database {
    private static Connection MySQLDataBase;
    public static Connection configDB()throws SQLException{
       try{
           String url ="jdbc:mysql://localhost:3306/db_rula";
           String user = "root";
           String password = "";
           
           DriverManager.registerDriver (new com.mysql.jdbc.Driver());
           MySQLDataBase = DriverManager.getConnection(url,user,password);
       }catch(SQLException e){
           System.out.println("Koneksi GAGAL");
       }
       return MySQLDataBase;
   }
}
