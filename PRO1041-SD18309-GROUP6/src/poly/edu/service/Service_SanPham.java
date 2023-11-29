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

    Connection con = DBContext.getConnection();

    @Override
    public ArrayList<SanPham> getAllSanPham() {
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM SanPham sp \n"
            + "LEFT JOIN MauSac ms ON ms.ID_MS = sp.ID_MS\n"
            + "LEFT JOIN TheLoai tl ON tl.ID_TL = sp.ID_TL\n"
            + "LEFT JOIN ChatLieu cl ON cl.ID_CL = sp.ID_CL\n"
            + "LEFT JOIN KichThuoc kt ON kt.ID_KT = sp.ID_KT\n"
            + "LEFT JOIN HinhAnh ha ON ha.ID_HA = sp.ID_HA";
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                TheLoai tl = new TheLoai();
                tl.setTl(rs.getString("TenTL"));

                KichThuoc kt = new KichThuoc();
                kt.setTenKT(rs.getString("TenKT"));

                MauSac ms = new MauSac();
                ms.setTenMS(rs.getString("TenMS"));

                ChatLieu cl = new ChatLieu();
                cl.setTenCL(rs.getString("TenCL"));

                SanPham sp = new SanPham();
                sp.setId(rs.getInt("ID_SP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setTl(tl);
                sp.setCl(cl);
                sp.setMs(ms);
                sp.setKt(kt);
                sp.setDonGia(rs.getBigDecimal("DonGia"));
                sp.setSoLuongTon(rs.getInt("SoLuongTon"));
                sp.setTrangThai(rs.getInt("TrangThai"));

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
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                TheLoai tl = new TheLoai();
                tl.setId(rs.getInt("ID_TL"));
                tl.setTl(rs.getString("TenTL"));

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
//
//    public Integer addSanPham(SanPham sp) {
//        Integer row = null;
//        String sql = "pr_Insert_SanPham";
//        try {
//            CallableStatement cbsm = con.prepareCall("{call pr_Insert_SanPham(?, ?, ?, ?, ?, ?, ?, ?)}");
//            cbsm.setObject(1, sp.getTenSP());
//            cbsm.setObject(2, sp.getTl().getTl());
//            cbsm.setObject(3, sp.getKt().getTenKT());
//            cbsm.setObject(4, sp.getMs().getTenMS());
//            cbsm.setObject(5, sp.getCl().getTenCL());
//            cbsm.setObject(6, sp.getDonGia());
//            cbsm.setObject(7, sp.getSoLuongTon());
//            cbsm.setObject(8, sp.getTrangThai());
//
//            row = cbsm.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return row;
//    }

    @Override
    public Integer add(SanPham sp) {
        Integer row = null;
        String sql = "INSERT INTO SanPham (TenSP, TheLoai, KichThuoc, MauSac, ChatLieu, DonGia, SoLuongTon, TrangThai) VALUES (?,?,?,?,?,?,?,?)";
        Connection con = DBContext.getConnection();

        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, sp.getTenSP());
            pr.setObject(2, sp.getTl().getTl());
            pr.setObject(3, sp.getKt().getTenKT());
            pr.setObject(4, sp.getMs().getTenMS());
            pr.setObject(5, sp.getCl().getTenCL());
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
//            pr.setObject(1, sp.getTenSP());
//            pr.setObject(2, sp.getTheLoai());
//            pr.setObject(3, sp.getKichThuoc());
//            pr.setObject(4, sp.getMauSac());
//            pr.setObject(5, sp.getChatLieu());
//            pr.setObject(6, sp.getDonGia());
//            pr.setObject(7, sp.getSoLuongTon());
//            pr.setObject(8, sp.getTrangThai());
//            pr.setObject(9, sp.getId());

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
