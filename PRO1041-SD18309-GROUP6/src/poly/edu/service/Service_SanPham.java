package poly.edu.service;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
                    + " JOIN MauSac ms ON ms.ID_MS = sp.ID_MS\n"
                    + " JOIN TheLoai tl ON tl.ID_TL = sp.ID_TL\n"
                    + " JOIN ChatLieu cl ON cl.ID_CL = sp.ID_CL\n"
                    + " JOIN KichThuoc kt ON kt.ID_KT = sp.ID_KT";
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

    @Override
    public Integer add(SanPham sp) {
        Integer row = null;
        Connection con = DBContext.getConnection();

        try {
            CallableStatement cs = con.prepareCall("{call dbo.insert_SanPham(?,?,?,?,?,?,?,?)}");
            cs.setObject(1, sp.getTenSP());
            cs.setObject(2, sp.getTl().getTl());
            cs.setObject(3, sp.getKt().getTenKT());
            cs.setObject(4, sp.getMs().getTenMS());
            cs.setObject(5, sp.getCl().getTenCL());
            cs.setObject(6, sp.getDonGia());
            cs.setObject(7, sp.getSoLuongTon());
            cs.setObject(8, sp.getTrangThai());

            row = cs.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return row;
    }

    @Override
    public Integer update(SanPham sp) {
        Integer row = null;
        Connection con = DBContext.getConnection();

        try {
            CallableStatement cs = con.prepareCall("{call dbo.update_SanPham(?,?,?,?,?,?,?,?,?)}");
            cs.setObject(2, sp.getTenSP());
            cs.setObject(3, sp.getTl().getTl());
            cs.setObject(4, sp.getKt().getTenKT());
            cs.setObject(5, sp.getMs().getTenMS());
            cs.setObject(6, sp.getCl().getTenCL());
            cs.setObject(7, sp.getDonGia());
            cs.setObject(8, sp.getSoLuongTon());
            cs.setObject(9, sp.getTrangThai());
            cs.setObject(1, sp.getId());

            row = cs.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return row;
    }

    @Override
    public Integer delete(int index, int masp) {
        Integer row = null;
        Connection con = DBContext.getConnection();

        try {
            CallableStatement cs = con.prepareCall("{call dbo.delete_SanPham(?)}");
            cs.setObject(1, masp);

            row = cs.executeUpdate();
        } catch (Exception e) {
        }

        return row;
    }

    public ArrayList<SanPham> getByTheLoai(String theloai) {
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM SanPham sp \n"
                    + "LEFT JOIN MauSac ms ON ms.ID_MS = sp.ID_MS\n"
                    + "LEFT JOIN TheLoai tl ON tl.ID_TL = sp.ID_TL\n"
                    + "LEFT JOIN ChatLieu cl ON cl.ID_CL = sp.ID_CL\n"
                    + "LEFT JOIN KichThuoc kt ON kt.ID_KT = sp.ID_KT\n"
                    + "WHERE sp.TheLoai LIKE N'%"+theloai+"%'";
            PreparedStatement ppstm = con.prepareStatement(sql);
            ResultSet rs = ppstm.executeQuery();
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
            e.printStackTrace();
        }
        return list;
    }
    
}
