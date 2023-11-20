package poly.edu.service;

import java.sql.*;
import java.util.ArrayList;
import poly.edu.utility.DBContext;
import poly.edu.model.SanPham;

public class Service_SanPham implements Interface_sanPham {

    @Override
    public ArrayList<SanPham> getAllSanPham() {
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM SanPham";
            Connection con = DBContext.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setId(rs.getInt("ID_SP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setTheLoai(rs.getString("TheLoai"));
                sp.setKichThuoc(rs.getString("KichThuoc"));
                sp.setMauSac(rs.getString("MauSac"));
                sp.setChatLieu(rs.getString("ChatLieu"));
                sp.setDonGia(rs.getDouble("DonGia"));
                sp.setSoLuongTon(rs.getInt("SoLuongTon"));
                sp.setTrangThai(rs.getString("TrangThai"));
                
                list.add(sp);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Integer add(SanPham sp) {
        Integer row = null;
        String sql = "INSERT INTO SanPham (TenSP, TheLoai, KichThuoc, MauSac, ChatLieu, DonGia, SoLuongTon, TrangThai) VALUES (?,?,?,?,?,?,?,?)";
        Connection con = DBContext.getConnection();
        
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, sp.getTenSP());
            pr.setObject(2, sp.getTheLoai());
            pr.setObject(3, sp.getKichThuoc());
            pr.setObject(4, sp.getMauSac());
            pr.setObject(5, sp.getChatLieu());
            pr.setObject(6, sp.getDonGia());
            pr.setObject(7, sp.getSoLuongTon());
            pr.setObject(8, sp.isTrangThai());
            
            row = pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return row;
    }

    @Override
    public Integer update(SanPham sp) {
        Integer row = null;
        String sql = "UPDATE SanPham SET TenSP =?, TheLoai =?, KichThuoc =?, MauSac =?, ChatLieu =?, DonGia = ?, SoLuongTon = ?, TrangThai =? WHERE ID_SP = ?";
        Connection con = DBContext.getConnection();
        
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, sp.getTenSP());
            pr.setObject(2, sp.getTheLoai());
            pr.setObject(3, sp.getKichThuoc());
            pr.setObject(4, sp.getMauSac());
            pr.setObject(5, sp.getChatLieu());
            pr.setObject(6, sp.getDonGia());
            pr.setObject(7, sp.getSoLuongTon());
            pr.setObject(8, sp.isTrangThai());
            pr.setObject(9, sp.getId());
            
            row = pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return row;
    }

    @Override
    public Integer delete(int index, int masp) {
        Integer row = null;
        String sql = "DELETE FROM SanPham WHERE ID_SP =?";
        Connection con = DBContext.getConnection();
        
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, masp);
            
            row = pr.executeUpdate();
        } catch (Exception e) {
        }
        
        return row;
    }

}
