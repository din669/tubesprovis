package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Server { 
    public static Connection con;
    
    public static Connection serverData() throws SQLException {
        String url = "jdbc:mysql://localhost/db10119216restaurant";
        String user = "root";
        String pass = "";
        try {       
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Gagal koneksi karena " + e.getMessage());
        }
        return con;
    }
}
