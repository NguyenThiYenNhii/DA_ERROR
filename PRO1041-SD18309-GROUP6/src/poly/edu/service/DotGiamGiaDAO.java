/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.service;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import poly.edu.model.DotGiamGia;
import poly.edu.model.DotGiamGiaTheoKH;
import poly.edu.model.DotGiamGiaTheoSP;
import poly.edu.repository.DBContext;


/**
 *
 * @author ADMIN
 */

public class DotGiamGiaDAO implements Interface_DotGiamGia {

    public ArrayList<DotGiamGia> getAllDotGiamGia() {
        ArrayList<DotGiamGia> listdgg = new ArrayList<>();
        try {
            String sql = "select dg.ID_DGG, sp.TenSP, kh.TenKH, dg.TeNDGG, dg.NgayBatDau, dg.NgayKetThuc, dg.GiaTriGG, dg.DieuKienGiamGia, dg.MoTa\n"
                    + "FROM DotGiamGia dg\n"
                    + " LEFT JOIN DotGiamGiaTheoSP sp ON dg.ID_DGG = sp.ID_DGG\n"
                    + " LEFT JOIN DotGiamGiaTheoKH kh ON dg.ID_TKH = kh.ID_TKH";
            Connection con = DBContext.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                DotGiamGia dgg = new DotGiamGia();
                DotGiamGiaTheoSP sp = new DotGiamGiaTheoSP();
                sp.setTenSP(rs.getString("TenSP"));
                DotGiamGiaTheoKH kh = new DotGiamGiaTheoKH();
                kh.setTenKH(rs.getString("TenKH"));
                dgg.setTenSP(sp);
                dgg.setTenKH(kh);
                dgg.setID_DGG(rs.getInt("ID_DGG"));
                
                dgg.setTenDGG(rs.getString("TeNDGG"));
                dgg.setNgayBatDau(rs.getDate("NgayBatDau"));
                dgg.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                dgg.setGiaTriGG(rs.getString("GiaTriGG"));
                dgg.setDieuKienGiamGia(rs.getString("DieuKienGiamGia"));
                dgg.setMoTa(rs.getString("MoTa"));
                listdgg.add(dgg);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listdgg;
    }

    
    public ArrayList<DotGiamGiaTheoSP> getAllDotGiamGiaTheoSP() {
        ArrayList<DotGiamGiaTheoSP> listdgg = new ArrayList<>();
        try {
            String sql = "SELECT * FROM DotGiamGiaTheoSP";
            Connection con = DBContext.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                DotGiamGiaTheoSP sp = new DotGiamGiaTheoSP();
                sp.setID_TSP(rs.getInt("ID_TSP"));
                sp.setTenSP(rs.getString("TenSP"));

                listdgg.add(sp);
            }
        } catch (Exception e) {
        }
        return listdgg;
    }
    
    public ArrayList<DotGiamGiaTheoKH> getAllDotGiamGiaTheoKH() {
        ArrayList<DotGiamGiaTheoKH> listdgg = new ArrayList<>();
        try {
            String sql = "SELECT * FROM DotGiamGiaTheoKH";
            Connection con = DBContext.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                DotGiamGiaTheoKH kh = new DotGiamGiaTheoKH();
                kh.setID_TKH(rs.getInt("ID_TKH"));
                kh.setTenKH(rs.getString("TenKH"));

                listdgg.add(kh);
            }
        } catch (Exception e) {
        }
        return listdgg;
    }
    
    
    @Override
    public Integer add(DotGiamGia dgg) {
        Integer row = null;
        Connection con = DBContext.getConnection();
        try {
            CallableStatement cs = con.prepareCall("{call dbo.insert_DotGiamGia(?,?,?,?,?,?,?,?)}");
            cs.setObject(1, dgg.getTenSP().getTenSP());
            cs.setObject(2, dgg.getTenKH().getTenKH());
            cs.setObject(3, dgg.getTenDGG());
            cs.setObject(4, dgg.getGiaTriGG());
            cs.setObject(5, dgg.getNgayBatDau());
            cs.setObject(6, dgg.getNgayKetThuc());
            cs.setObject(7, dgg.getDieuKienGiamGia());
            cs.setObject(8, dgg.getMoTa());
            row = cs.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    @Override
    public Integer update(DotGiamGia dgg) {
        Integer row = null;
        Connection con = DBContext.getConnection();
        try {
            CallableStatement cs = con.prepareCall("{call dbo.update_DotGiamGia(?,?,?,?,?,?,?,?,?)}");
            cs.setObject(2, dgg.getTenSP().getTenSP());
            cs.setObject(3, dgg.getTenKH().getTenKH());
            cs.setObject(4, dgg.getTenDGG());
            cs.setObject(5, dgg.getGiaTriGG());
            cs.setObject(6, dgg.getNgayBatDau());
            cs.setObject(7, dgg.getNgayKetThuc());
            cs.setObject(8, dgg.getDieuKienGiamGia());
            cs.setObject(9, dgg.getMoTa());
            cs.setObject(1, dgg.getID_DGG());
            row = cs.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    @Override
    public Integer delete(int index, Integer ID_DGG) {
        Integer row = null;
        Connection con = DBContext.getConnection();
        try {
            CallableStatement cs = con.prepareCall("{call dbo.delete_DotGiamGia(?)}");
            cs.setObject(1, ID_DGG);
            row = cs.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }
    public List<DotGiamGia> getID_DGG(int ID_DGG) {
        List<DotGiamGia> listdgg = new ArrayList<>();
        try {
            String sql = "select * from DotGiamGia where ID_DGG like'%" + ID_DGG + "%'";
            Connection cn = DBContext.getConnection();
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ResultSet rs = ptsm.executeQuery();
            while (rs.next()) {
                DotGiamGia dgg = new DotGiamGia();
                dgg.setID_DGG(rs.getInt("ID_DGG"));
                DotGiamGiaTheoSP sp = new DotGiamGiaTheoSP();
                sp.setTenSP(rs.getString("TenSP"));
                DotGiamGiaTheoKH kh = new DotGiamGiaTheoKH();
                kh.setTenKH(rs.getString("TenKH"));
                dgg.setTenSP(sp);
                dgg.setTenKH(kh);
                dgg.setTenDGG(rs.getString("TeNDGG"));
                dgg.setNgayBatDau(rs.getDate("NgayBatDau"));
                dgg.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                dgg.setLoaiGiamGia(rs.getString("LoaiGiamGia"));
                dgg.setGiaTriGG(rs.getString("GiaTriGG"));
                dgg.setDieuKienGiamGia(rs.getString("DieuKienGiamGia"));
                dgg.setMoTa(rs.getString("MoTa"));
                listdgg.add(dgg);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listdgg;

    }

    

}

