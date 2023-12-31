/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import poly.edu.model.PhieuGiamGia;
import poly.edu.repository.DBContext;

/**
 *
 * @author FPTSHOP
 */
public class PhieuGiamGiaReposity {
    public ArrayList<PhieuGiamGia> getall(){
    ArrayList<PhieuGiamGia> gkh = new ArrayList<>();
    String sql = "select *from PhieuGiamGia JOIN GiamGiaTheoKH on PhieuGiamGia.ID_TKH = GiamGiaTheoKH.ID_TKH\n"
            + " JOIN DotGiamGia on PhieuGiamGia.ID_DGG = DotGiamGia.ID_DGG";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ResultSet rs = ptsm.executeQuery();
            while (rs.next()) {                
                PhieuGiamGia kh = new PhieuGiamGia();
                kh.setMaGG(rs.getInt("ID_GG"));
                kh.setMaKH(rs.getInt("ID_KH"));
                kh.setMaSP(rs.getInt("ID_SP"));
                kh.setTenGG(rs.getString("TeNDGG"));
                kh.setHinhthuc(rs.getString("Hinhthuc"));
              kh.setNgaybatdau(rs.getDate("NgayBatDau"));
                kh.setNgayHH(rs.getDate("NgayHH"));
                 kh.setGiaTriGG(rs.getString("GiaTriGG"));
                  kh.setTrangthai(rs.getBoolean("TrangThai"));
                   kh.setNgaytao(rs.getString("NgayTao"));
                    kh.setNgaySuDung(rs.getString("NgaySuDung"));
                    kh.setDieuKien(rs.getString("DieuKienGG"));
                     kh.setMota(rs.getString("MOTA"));
                gkh.add(kh);
                
            }
            return gkh;
        } catch (Exception e) {
            System.out.println(e);
        }
        return gkh;
    }
//   public Integer SAVE(PhieuGiamGia G){
//         Integer row = null;
//        
//        Connection cn = DBContext.getConnection();
//        try {
//           CallableStatement pre = cn.prepareCall("{call dbo.dbo.PhieuGiamGia (?,?,?,?,?,?,?,?,?)}");
//     pre.setInt(2, G.getMaSP());
//     pre.setString(1, G.getTenGG());
//     pre.setString(3, G.getHinh());
//     pre.setDate(4, new java.sql.Date(G.getNgaybatdau().getTime()));
//     pre.setDate(5, new java.sql.Date(G.getNgayHH().getTime()));
//     pre.setString(6, G.getGiaTriGG());
//     pre.setBoolean(7, G.isTrangthai());
//     pre.setString(8, G.getDieuKien());
//     pre.setString(9, G.getMota());  
//            row = pre.executeUpdate();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return row;
//    }
public Integer SAVE(PhieuGiamGia G) {
    Integer row = null;
    Connection cn = DBContext.getConnection();
    try {
        CallableStatement pre = cn.prepareCall("{call dbo.ins_PhieuGiamGia1 (?,?,?,?,?,?,?,?,?)}");
        pre.setString(1, G.getTenGG());
        
        pre.setInt(2, G.getMaSP());
        pre.setString(3, G.getHinhthuc());
        pre.setDate(4, new java.sql.Date(G.getNgaybatdau().getTime()));
        pre.setDate(5, new java.sql.Date(G.getNgayHH().getTime()));
        pre.setString(6, G.getGiaTriGG());
        pre.setBoolean(7, G.isTrangthai());
        pre.setString(8, G.getDieuKien());
        pre.setString(9, G.getMota());
        row = pre.executeUpdate();
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    e.printStackTrace();
    }
    return row;
}

//    public Integer Delete(String Magg){
//  Integer row = null;
//        String sql = "DELETE FROM PhieuGiamGia WHERE ID_GG LIKE ?";
//        Connection con = DBContext.getConnection();
//
//        try {
//            PreparedStatement pr = con.prepareStatement(sql);
//            pr.setString(1, Magg);
//            row = pr.executeUpdate();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return row;
//    }
public Integer Delete(int index, Integer maGH) {
        Integer row = null;
        Connection cn = DBContext.getConnection();
        try {
            CallableStatement cs = cn.prepareCall("{call dbo.delete_PhieuGiamGia(?)}");
            cs.setObject(1, maGH);
            row = cs.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    public Integer update(PhieuGiamGia g) {
        Integer row = null;
        String sql = "update PhieuGiamGia \n"
                + "set ID_SP=?,Hinhthuc=?,NgayBatDau=?,NgayHH =?,GiaTriGG =?,TrangThai=?,MOTA=?\n"
                + "where ID_SP like ?";
        //tao ket noi
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pre = cn.prepareStatement(sql);
     pre.setInt(1, g.getMaSP());
     pre.setString(2, g.getHinhthuc());
     pre.setDate(3, new java.sql.Date(g.getNgaybatdau().getTime()));
     pre.setDate(4, new java.sql.Date(g.getNgayHH().getTime()));
     pre.setString(5, g.getGiaTriGG());
     pre.setBoolean(6, g.isTrangthai());
     pre.setString(7, g.getMota()); 
     pre.setInt(8, g.getMaSP());
            //thi hanh statement
            row =  pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }
      public List<PhieuGiamGia>getMa(int MA){
  List<PhieuGiamGia> lst = new ArrayList<>();
      try {
          String sql = "select *from PhieuGiamGia WHERE ID_SP like '%"+MA+"%'";
  Connection cn = DBContext.getConnection();
          PreparedStatement ptsm = cn.prepareStatement(sql);
          ResultSet rs = ptsm.executeQuery();
          while (rs.next()) {              
  PhieuGiamGia kh = new PhieuGiamGia();
  
               kh.setMaGG(rs.getInt("ID_GG"));
                kh.setMaKH(rs.getInt("ID_KH"));
                kh.setMaSP(rs.getInt("ID_SP"));
kh.setTenGG(rs.getString("TeNDGG"));
                kh.setHinhthuc(rs.getString("Hinhthuc"));
              kh.setNgaybatdau(rs.getDate("NgayBatDau"));
                kh.setNgayHH(rs.getDate("NgayHH"));
                 kh.setGiaTriGG(rs.getString("GiaTriGG"));
                  kh.setTrangthai(rs.getBoolean("TrangThai"));
                   kh.setNgaytao(rs.getString("NgayTao"));
                    kh.setNgaySuDung(rs.getString("NgaySuDung"));
                    kh.setDieuKien(rs.getString("DieuKienGG"));
                     kh.setMota(rs.getString("MOTA"));
                lst.add(kh);
           
          }
      } catch (Exception e) {
          e.printStackTrace();
          
      }
      return lst;
  }
}
