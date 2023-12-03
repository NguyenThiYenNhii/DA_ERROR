package poly.edu.service;

import java.util.ArrayList;
import poly.edu.model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import poly.edu.model.ChatLieu;
import poly.edu.model.KichThuoc;
import poly.edu.model.MauSac;
import poly.edu.model.SanPhamX;
import poly.edu.model.TheLoai;
import poly.edu.repository.DBContext;

public class SanPhamRepository implements XObject {
    Connection con = DBContext.getConnection();
    @Override
    public ArrayList<SanPham> getAllSP() {
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
            System.out.println(e);
        }
        return list;
    }

    //hàm lấy sp
    public static SanPham getSP(String idSP) {
        ResultSet rs = SanPhamX.getOne(idSP);
        try {
            if (rs.next()) {
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
                return sp;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
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
