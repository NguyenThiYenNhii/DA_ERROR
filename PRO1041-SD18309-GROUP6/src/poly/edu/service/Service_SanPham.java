package poly.edu.service;

import java.sql.*;
import java.util.ArrayList;
import poly.edu.model.ChatLieu;
import poly.edu.model.KichThuoc;
import poly.edu.model.MauSac;
import poly.edu.repository.DBContext;
import poly.edu.model.SanPham;
import poly.edu.model.TheLoai;

public class Service_SanPham implements Interface_sanPham {

    @Override
    public ArrayList<SanPham> getAllSanPham() {
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            String sql = "SELECT sp.ID_SP, sp.TenSP, tl.TenTL, kt.TenKT, ms.TenMS, cl.TenCL, sp.DonGia, sp.SoLuongTon, sp.TrangThai FROM SanPham sp \n"
                    + "JOIN MauSac ms ON ms.ID_MS = sp.ID_MS\n"
                    + "JOIN TheLoai tl ON tl.ID_TL = sp.ID_TL\n"
                    + "JOIN ChatLieu cl ON cl.ID_CL = sp.ID_CL\n"
                    + "JOIN KichThuoc kt ON kt.ID_KT = sp.ID_KT";
            Connection con = DBContext.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                TheLoai tl = new TheLoai();
                tl.setTenTL(rs.getString("TenTL"));

                KichThuoc kt = new KichThuoc();
                kt.setTenKT(rs.getString("TenKT"));

                MauSac ms = new MauSac();
                ms.setTenMS(rs.getString("TenMS"));

                ChatLieu cl = new ChatLieu();
                cl.setTenCL(rs.getString("TenCL"));

                SanPham sp = new SanPham();
                sp.setId(rs.getInt("ID_SP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setTheLoai(tl);
                sp.setChatLieu(cl);
                sp.setMauSac(ms);
                sp.setKichThuoc(kt);
                sp.setDonGia(rs.getDouble("DonGia"));
                sp.setSoLuongTon(rs.getInt("SoLuongTon"));
                sp.setTrangThai(rs.getString("TrangThai"));

                list.add(sp);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<TheLoai> getAllTheLoai() {
        ArrayList<TheLoai> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM TheLoai";
            Connection con = DBContext.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                TheLoai tl = new TheLoai();
                tl.setId(rs.getInt("ID_TL"));
                tl.setTenTL(rs.getString("TenTL"));

                list.add(tl);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<MauSac> getAllMauSac() {
        ArrayList<MauSac> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM MauSac";
            Connection con = DBContext.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setId(rs.getInt("ID_MS"));
                ms.setTenMS(rs.getString("TenMS"));

                list.add(ms);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<KichThuoc> getAllKichThuoc() {
        ArrayList<KichThuoc> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM KichThuoc";
            Connection con = DBContext.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                KichThuoc kt = new KichThuoc();
                kt.setId(rs.getInt("ID_KT"));
                kt.setTenKT(rs.getString("TenKT"));

                list.add(kt);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<ChatLieu> getAllChatLieu() {
        ArrayList<ChatLieu> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ChatLieu";
            Connection con = DBContext.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                ChatLieu cl = new ChatLieu();
                cl.setId(rs.getInt("ID_CL"));
                cl.setTenCL(rs.getString("TenCL"));

                list.add(cl);
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
            pr.setObject(2, sp.getTheLoai().getTenTL());
            pr.setObject(3, sp.getKichThuoc().getTenKT());
            pr.setObject(4, sp.getMauSac().getTenMS());
            pr.setObject(5, sp.getChatLieu().getTenCL());
            pr.setObject(6, sp.getDonGia());
            pr.setObject(7, sp.getSoLuongTon());
            pr.setObject(8, sp.getTrangThai());

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
            pr.setObject(2, sp.getTheLoai().getTenTL());
            pr.setObject(3, sp.getKichThuoc().getTenKT());
            pr.setObject(4, sp.getMauSac().getTenMS());
            pr.setObject(5, sp.getChatLieu().getTenCL());
            pr.setObject(6, sp.getDonGia());
            pr.setObject(7, sp.getSoLuongTon());
            pr.setObject(8, sp.getTrangThai());
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
