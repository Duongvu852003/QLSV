
package edu.poly.poly.app.helpers;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHelper {

  
    public static Connection getConnection() throws Exception{
       //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       String url = "jdbc:msqlserver://localhost:3306/g52apr";
       String user = "sa";
       String password = "duongvu852003";
       Connection con = DriverManager.getConnection(url, user, password);
        return con;      
    }
    public static void main(String[] args) throws Exception {
        System.out.println(getConnection());
    }

    public static Connection openConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
