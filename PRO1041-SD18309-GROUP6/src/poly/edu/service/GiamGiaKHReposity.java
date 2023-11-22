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
import poly.edu.model.GiamGiaKH;
import poly.edu.repository.DBContext;

/**
 *
 * @author FPTSHOP
 */
public class GiamGiaKHReposity {
    public ArrayList<GiamGiaKH> getall(){
    ArrayList<GiamGiaKH> gkh = new ArrayList<>();
    String sql = "select * from GiamGiaTheoKH";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ResultSet rs = ptsm.executeQuery();
            while (rs.next()) {                
                GiamGiaKH kh = new GiamGiaKH();
                kh.setMaTKH(rs.getInt("ID_TKH"));
                kh.setMaKH(rs.getInt("ID_KH"));
                kh.setVaitro(rs.getBoolean("VaiTro"));
                kh.setGiatriGG(rs.getString("GiaTriGG"));
                kh.setDieuKienGG(rs.getString("DieuKienGG"));
                kh.setMota(rs.getString("MoTa"));
                kh.setHinhthuc(rs.getString("Hinhthuc"));
                gkh.add(kh);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return gkh;
    }
    public List<GiamGiaKH>getMaKH(int MaKH){
    List<GiamGiaKH> kh = new ArrayList<>();
        try {
            String sql = "select * from GiamGiaTheoKH where ID_KH like'%"+MaKH+"%'";
        Connection cn = DBContext.getConnection();
        PreparedStatement ptsm = cn.prepareStatement(sql);
            ResultSet rs = ptsm.executeQuery();
            while (rs.next()) {                
             GiamGiaKH k = new GiamGiaKH();
              k.setMaTKH(rs.getInt("ID_TKH"));
                k.setMaKH(rs.getInt("ID_KH"));
                k.setVaitro(rs.getBoolean("VaiTro"));
                k.setGiatriGG(rs.getString("GiaTriGG"));
                k.setDieuKienGG(rs.getString("DieuKienGG"));
                k.setMota(rs.getString("MoTa"));
                k.setHinhthuc(rs.getString("Hinhthuc"));
                kh.add(k);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return kh;
    }
  public Integer SAVE(GiamGiaKH D){
         Integer row = null;
        
        Connection cn = DBContext.getConnection();
        String sql = "insert into GiamGiaTheoKH ( ID_KH, VaiTro, GiaTriGG,DieuKienGG,MoTa,Hinhthuc) values(?,?,?,?,?,?)";
        try {
            PreparedStatement pre = cn.prepareStatement(sql);
       
          pre.setInt(1, D.getMaKH());
          pre.setBoolean(2, D.isVaitro());
          pre.setString(3, D.getGiatriGG());
          pre.setString(4, D.getDieuKienGG());
          pre.setString(5, D.getMota());
          pre.setString(6, D.getHinhthuc());
            row = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }
  public Integer updateSinhVien(GiamGiaKH D) {
        Integer row = null;
        String sql = "update GiamGiaTheoKH\n"
                + "set VaiTro =?,GiaTriGG=?,DieuKienGG=?,MoTa=?,Hinhthuc=?\n"
                + "where ID_KH like ?";
        //tao ket noi
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pre = cn.prepareStatement(sql);
         pre.setInt(6, D.getMaKH());
          pre.setBoolean(1, D.isVaitro());
          pre.setString(2, D.getGiatriGG());
          pre.setString(3, D.getDieuKienGG());
          pre.setString(4, D.getMota());
          pre.setString(5, D.getHinhthuc());
            row =  pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }
  public Integer Delete(int MaKH){
  Integer row = null;
        String sql = "DELETE FROM GiamGiaTheoKH WHERE ID_KH LIKE ?";
        Connection con = DBContext.getConnection();

        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setInt(1, MaKH);
            row = pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }
}
