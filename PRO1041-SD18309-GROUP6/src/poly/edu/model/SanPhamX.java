/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.model;

import java.sql.ResultSet;
import poly.edu.repository.Context;
import poly.edu.repository.DBContext;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author Pham Quang Thien
 */
public class SanPhamX {
     public static ResultSet getOne(String idSP){
         
//         Integer row = null;
         String sql = "select*from SanPham where MaSP = ?";
         return Context.executeQuery(sql, idSP);
//         Connection cn = DBContext.getConnection();
//         try {
//             PreparedStatement pre = cn.prepareStatement(sql);
//             pre.setString(1, idSP);
//             row = pre.executeUpdate();
//         } catch (SQLException ex) {
//             Logger.getLogger(SanPhamX.class.getName()).log(Level.SEVERE, null, ex);
//         }
//         return row;
     }
     
     public static ResultSet getOne1(String idSP){
         
//         Integer row = null;
         String sql = "select*from SanPham where MaTL = ?";
         return Context.executeQuery(sql, idSP);
//         Connection cn = DBContext.getConnection();
//         try {
//             PreparedStatement pre = cn.prepareStatement(sql);
//             pre.setString(1, idSP);
//             row = pre.executeUpdate();
//         } catch (SQLException ex) {
//             Logger.getLogger(SanPhamX.class.getName()).log(Level.SEVERE, null, ex);
//         }
//         return row;
     }
}
