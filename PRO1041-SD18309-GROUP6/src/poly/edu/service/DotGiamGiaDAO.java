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
        String sql = "INSERT INTO DotGiamGiaTheoKH(TenKH) VALUES (?)"
                + "INSERT INTO DotGiamGiaTheoSP(TenSP) VALUES (?)"
                + "INSERT INTO DotGiamGia( TeNDGG, NgayBatDau, NgayKetThuc, GiaTriGG, DieuKienGiamGia, MoTa) VALUES (?,?,?,?,?,?)";
        Connection con = DBContext.getConnection();
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            DotGiamGiaTheoKH kh = new DotGiamGiaTheoKH();
            DotGiamGiaTheoSP sp = new DotGiamGiaTheoSP();
            pr.setObject(1, kh.getTenKH());
            pr.setObject(2, sp.getTenSP());
            pr.setObject(3, dgg.getTenDGG());
            //pr.setObject(4, dgg.getTenSP().getTenSP());
            //pr.setObject(5, dgg.getTenKH().getTenKH());
            pr.setObject(4, dgg.getNgayBatDau());
            pr.setObject(5, dgg.getNgayKetThuc());
            pr.setObject(6, dgg.getGiaTriGG());
            pr.setObject(7, dgg.getDieuKienGiamGia());
            pr.setObject(8, dgg.getMoTa());
            row = pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    @Override
    public Integer update(DotGiamGia dgg) {
        Integer row = null;
        String sql = "UPDATE DotGiamGia SET TeNDGG = ?,TenSP=?, TenKH=?, NgayBatDau = ?, NgayKetThuc = ?, GiaTriGG = ?, DieuKienGiamGia= ?, MoTa = ? WHERE ID_DGG =?";
        Connection con = DBContext.getConnection();
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(9, dgg.getID_DGG());
            pr.setObject(1, dgg.getTenDGG());
            pr.setObject(2, dgg.getTenSP().getTenSP());
            pr.setObject(3, dgg.getTenKH().getTenKH());
            pr.setObject(4, dgg.getNgayBatDau());
            pr.setObject(5, dgg.getNgayKetThuc());
            pr.setObject(6, dgg.getGiaTriGG());
            pr.setObject(7, dgg.getDieuKienGiamGia());
            pr.setObject(8, dgg.getMoTa());
            row = pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    @Override
    public Integer delete(int index, Integer ID_DGG) {
        Integer row = null;
        String sql = "DELETE FROM DotGiamGia WHERE ID_DGG = ?";
        Connection con = DBContext.getConnection();
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, ID_DGG);
            row = pr.executeUpdate();
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
