package poly.edu.repository;

import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {

    public static String USER = "sa";
    public static String PASS = "123456";
    public static String URL = "jdbc:sqlserver://localhost:1433;databaseName=DU_AN_1;encrypt=true;trustServerCertificate=true";

    // Chạy và được gọi đầu tiên
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static void main(String[] args) {
        Connection con = getConnection();
        if (con != null) {
            System.out.println("Kết nối thành công");
        }else {
            System.out.println("Lỗi kết nối");
        }
    }
}
