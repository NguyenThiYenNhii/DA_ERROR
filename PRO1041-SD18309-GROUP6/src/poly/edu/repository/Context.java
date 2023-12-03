package poly.edu.repository;

import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Context {

    public static String USER = "sa";
    public static String PASS = "123456";
    public static String URL = "jdbc:sqlserver://localhost:1433;databaseName=PRO1041_DA;encrypt=true;trustServerCertificate=true";

    // Chạy và được gọi đầu tiên
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Context.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(Context.class.getName()).log(Level.SEVERE, null, ex);
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
    
//    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
//        Connection conn = DriverManager.getConnection(URL, USER, PASS);
//        PreparedStatement stmt;
//        if (sql.trim().startsWith("{")) {
//            stmt = conn.prepareCall(sql); // PROC
//        } else {
//            stmt = conn.prepareStatement(sql); // SQL
//        }
//
//        for (int i = 0; i < args.length; i++) {
//            stmt.setObject(i + 1, args[i]);
//        }
//        return stmt;
//    }
//
//    public static int update(String sql, Object... args) throws SQLException {
//        try {
//            PreparedStatement stmt = DBContext.getStmt(sql, args);
//            try {
//                return stmt.executeUpdate();
//            } finally {
//                stmt.getConnection();
//            }
//        } catch (Exception e) {
//            throw  new RuntimeException(e);
//        }
//    }
//
//    public static ResultSet query(String sql, Object... args) throws SQLException {
//        PreparedStatement stmt = DBContext.getStmt(sql, args);
//        return stmt.executeQuery();
//    }
//
//    public static Object value(String sql, Object... args) {
//        try {
//            ResultSet rs = DBContext.query(sql, args);
//            if (rs.next()) {
//                return rs.getObject(0);
//            }
//            rs.getStatement().getConnection().close();
//            return null;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    
    public static ResultSet executeQuery(String url, Object... args) {
        try {
            PreparedStatement ppsm = getConnection().prepareStatement(url);
            for (int i = 0; i < args.length; i++) {
                ppsm.setObject(i + 1, args[i]);
            }
            return ppsm.executeQuery();
        } catch (SQLException ex) {
        }
        return null;
    }

    public static int executeUpdate(String url, Object... args) {
        try {
            PreparedStatement ppsm = getConnection().prepareStatement(url);
            for (int i = 0; i < args.length; i++) {
                ppsm.setObject(i + 1, args[i]);
            }
            return ppsm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
}
