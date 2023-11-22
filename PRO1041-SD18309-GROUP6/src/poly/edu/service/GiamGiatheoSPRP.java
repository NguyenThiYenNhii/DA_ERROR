/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import poly.edu.model.GiamTheoSPCL;
import poly.edu.repository.DBContext;

/**
 *
 * @author FPTSHOP
 */
public class GiamGiatheoSPRP {
    public ArrayList<GiamTheoSPCL> getall(){
    ArrayList<GiamTheoSPCL> gkh = new ArrayList<>();
    String sql = "select * from GiamGiaTheoSP";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ResultSet rs = ptsm.executeQuery();
            while (rs.next()) {                
                GiamTheoSPCL kh = new GiamTheoSPCL();
                kh.setMaTSP(rs.getInt("ID_TSP"));
                kh.setMaSP(rs.getString("ID_SP"));
                kh.setGiaTrigg(rs.getString("GiaTriGG"));
                kh.setDieuKienGG(rs.getString("DieuKienGG"));
                kh.setMoTa(rs.getString("MoTa"));
                gkh.add(kh);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return gkh;
    }
     public List<GiamTheoSPCL>getMa(int MA){
  List<GiamTheoSPCL> lst = new ArrayList<>();
      try {
          String sql = "SELECT * FROM GiamGiaTheoSP WHERE ID_SP like '%"+MA+"%'";
  Connection cn = DBContext.getConnection();
          PreparedStatement ptsm = cn.prepareStatement(sql);
          ResultSet rs = ptsm.executeQuery();
          while (rs.next()) {              
  GiamTheoSPCL kh = new GiamTheoSPCL();
                kh.setMaTSP(rs.getInt("ID_TSP"));
                kh.setMaSP(rs.getString("ID_SP"));
                kh.setGiaTrigg(rs.getString("GiaTriGG"));
                kh.setDieuKienGG(rs.getString("DieuKienGG"));
                kh.setMoTa(rs.getString("MoTa"));
                lst.add(kh);
          }
      } catch (Exception e) {
          e.printStackTrace();
          
      }
      return lst;
  }
     public Integer SAVE(GiamTheoSPCL D){
         Integer row = null;
        
        Connection cn = DBContext.getConnection();
        String sql = "insert into GiamGiaTheoSP( ID_SP, GiaTriGG, GiaTriGG,DieuKienGG,MoTa) values(?,?,?,?,?)";
        try {
            PreparedStatement pre = cn.prepareStatement(sql);
       
          pre.setString(1, D.getMaSP());
          pre.setString(2, D.getGiaTrigg());
          pre.setString(3, D.getDieuKienGG());
          pre.setString(4, D.getMoTa());
            row = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }
     public Integer update(GiamTheoSPCL D) {
        Integer row = null;
        String sql = "update GiamGiaTheoSP\n"
                + "set GiaTriGG=?,DieuKienGG=?,MoTa=?\n"
                + "where ID_SP like ?";
        //tao ket noi
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pre = cn.prepareStatement(sql);
        pre.setString(4, D.getMaSP());
          pre.setString(3, D.getGiaTrigg());
          pre.setString(2, D.getDieuKienGG());
          pre.setString(1, D.getMoTa());
            row =  pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }
     public Integer Delete(String Ma){
  Integer row = null;
        String sql = "DELETE FROM GiamGiaTheoSP WHERE ID_SP LIKE ?";
        Connection con = DBContext.getConnection();

        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setString(1, Ma);
            row = pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }
}
