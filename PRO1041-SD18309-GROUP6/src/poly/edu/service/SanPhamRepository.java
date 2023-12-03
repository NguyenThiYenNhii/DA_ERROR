package poly.edu.service;

import java.util.ArrayList;
import poly.edu.model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import poly.edu.model.ChatLieu;
import poly.edu.model.KichThuoc;
import poly.edu.model.Lavie;
import poly.edu.model.MauSac;
import poly.edu.model.SanPhamX;
import poly.edu.model.TheLoai;
import poly.edu.repository.Context;
import poly.edu.repository.DBContext;

public class SanPhamRepository implements XObject {
        Connection cn = Context.getConnection();
    @Override
    public ArrayList<Lavie> getAllSP() {
        ArrayList<Lavie> lst = new ArrayList<>();
        String sql = "select MaSP, TenSP, TenTL, ChatLieu, KichThuoc, TenMS, SoLuong, DonGia from SanPham\n"
                + "join TheLoai on SanPham.MaTL = TheLoai.MaTL\n"
                + "join ChatLieu on SanPham.MaCL = ChatLieu.MaCL\n"
                + "join KichThuoc on SanPham.MaKT = KichThuoc.MaKT\n"
                + "join MauSac on SanPham.MaMS = MauSac.MaMS";
        try {
            PreparedStatement pre = cn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Lavie sp = new Lavie();
                sp.setMaSP(rs.getInt("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setTheLoai(rs.getString("TenTL"));
                sp.setChatLieu(rs.getString("ChatLieu"));
                sp.setKichThuoc(rs.getString("KichThuoc"));
                sp.setMauSac(rs.getString("TenMS"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonGia(rs.getDouble("DonGia"));
                lst.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }

    //hàm lấy sp
    public static Lavie getSP(String idSP) {
        Lavie sp = new Lavie();
        ResultSet rs = SanPhamX.getOne(idSP);
        try {
            if (rs.next()) {
                sp.setMaSP(rs.getInt("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setTheLoai(rs.getString("MaTL"));
                sp.setChatLieu(rs.getString("MaCL"));
                sp.setKichThuoc(rs.getString("MaKT"));
                sp.setMauSac(rs.getString("MaMS"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonGia(rs.getDouble("DonGia"));
                return sp;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    //hàm lấy sp
    public static Lavie getSP1(String idSP) {
        Lavie sp = new Lavie();
        ResultSet rs = SanPhamX.getOne1(idSP);
        try {
            if (rs.next()) {
                sp.setMaSP(rs.getInt("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setTheLoai(rs.getString("MaTL"));
                sp.setChatLieu(rs.getString("MaCL"));
                sp.setKichThuoc(rs.getString("MaKT"));
                sp.setMauSac(rs.getString("MaMS"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonGia(rs.getDouble("DonGia"));
                return sp;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public ArrayList<Lavie> selectbytheLoai(String tl) {
        ArrayList<Lavie> lst = new ArrayList<>();
        String sql = "select MaSP, TenSP, TenTL, ChatLieu, KichThuoc, TenMS, SoLuong, DonGia from SanPham\n"
                + "join TheLoai on SanPham.MaTL = TheLoai.MaTL\n"
                + "join ChatLieu on SanPham.MaCL = ChatLieu.MaCL\n"
                + "join KichThuoc on SanPham.MaKT = KichThuoc.MaKT\n"
                + "join MauSac on SanPham.MaMS = MauSac.MaMS where SanPham.TenSP like '%" + tl +"%'";
        try {
            PreparedStatement pre = cn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Lavie sp = new Lavie();
                sp.setMaSP(rs.getInt("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setTheLoai(rs.getString("TenTL"));
                sp.setChatLieu(rs.getString("ChatLieu"));
                sp.setKichThuoc(rs.getString("KichThuoc"));
                sp.setMauSac(rs.getString("TenMS"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonGia(rs.getDouble("DonGia"));
                lst.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }
    
//    @Override
//    public ArrayList<SanPham> selectBySQL(String sql, Object... args) {
////         ArrayList<SanPham> lst = new ArrayList<>();
////         try {
////            ResultSet rs = DBContext.ex
////        } catch (Exception e) {
////        }
//    }
}
