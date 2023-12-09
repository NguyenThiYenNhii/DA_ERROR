/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.service;

import java.util.ArrayList;
import poly.edu.model.DotGiamGia;
import java.sql.*;
import java.util.List;
import poly.edu.repository.DBContext;

/**
 *
 * @author ADMIN
 */
public class DotGiamGiaDAO implements Interface_DotGiamGia {

    public ArrayList<DotGiamGia> getAllDotGiamGia() {
        ArrayList<DotGiamGia> listdgg = new ArrayList<>();
        try {
            String sql = "select*from DotGiamGia";
            Connection con = DBContext.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                DotGiamGia dgg = new DotGiamGia();
                dgg.setID_DGG(rs.getInt("ID_DGG"));
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

    @Override
    public Integer add(DotGiamGia dgg) {
        Integer row = null;
        String sql = "INSERT INTO DotGiamGia( TeNDGG, NgayBatDau, NgayKetThuc,LoaiGiamGia, GiaTriGG, DieuKienGiamGia, MoTa) VALUES (?,?,?,?,?,?,?)";
        Connection con = DBContext.getConnection();
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, dgg.getTenDGG());
            pr.setObject(2, dgg.getNgayBatDau());
            pr.setObject(3, dgg.getNgayKetThuc());
            pr.setObject(4, dgg.getLoaiGiamGia());
            pr.setObject(5, dgg.getGiaTriGG());
            pr.setObject(6, dgg.getDieuKienGiamGia());
            pr.setObject(7, dgg.getMoTa());
            row = pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    @Override
    public Integer update(DotGiamGia dgg) {
        Integer row = null;
        String sql = "UPDATE DotGiamGia SET TeNDGG = ?, NgayBatDau = ?, NgayKetThuc = ?,LoaiGiamGia = ?, GiaTriGG = ?, DieuKienGiamGia= ?, MoTa = ? WHERE ID_DGG =?";
        Connection con = DBContext.getConnection();
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(8, dgg.getID_DGG());
            pr.setObject(1, dgg.getTenDGG());
            pr.setObject(2, dgg.getNgayBatDau());
            pr.setObject(3, dgg.getNgayKetThuc());
            pr.setObject(4, dgg.getLoaiGiamGia());
            pr.setObject(5, dgg.getGiaTriGG());
            pr.setObject(6, dgg.getDieuKienGiamGia());
            pr.setObject(7, dgg.getMoTa());
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


    public List<DotGiamGia> getMaDGG(int ID_DGG) {
        List<DotGiamGia> listdgg = new ArrayList<>();
        try {
            String sql = "select * from DotGiamGia where ID_DGG like'%" + ID_DGG + "%'";
            Connection cn = DBContext.getConnection();
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ResultSet rs = ptsm.executeQuery();
            while (rs.next()) {
                DotGiamGia dgg = new DotGiamGia();
                dgg.setID_DGG(rs.getInt("ID_DGG"));
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
