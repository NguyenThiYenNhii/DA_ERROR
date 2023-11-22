package poly.edu.service;

import java.util.ArrayList;
import poly.edu.service.GHInter;
import poly.edu.model.PhieuGiaoHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import poly.edu.repository.DBContext;

public class PhieuGiaoHangRepository implements GHInter {

    @Override
    public ArrayList<PhieuGiaoHang> getAllGH() {
        ArrayList<PhieuGiaoHang> lst = new ArrayList<>();
        Connection cn = DBContext.getConnection();
        String sql = "select PhieuGiaoHang.ID_GH, KhachHang.DienThoai, TenNV, PhiVanChuyen, PhieuGiaoHang.NgayGiao, TenDC, TrangThaiGH, TrangThaiTT, PhieuGiaoHang.GhiChu from PhieuGiaoHang\n"
                + "join KhachHang on PhieuGiaoHang.ID_KH = KhachHang.ID_KH\n"
                + "join NhanVien on PhieuGiaoHang.ID_NV = NhanVien.ID_NV\n"
                + "join DiaChi on PhieuGiaoHang.ID_DC =  DiaChi.ID_DC\n"
                + "join HoaDon on PhieuGiaoHang.ID_HD = HoaDon.ID_HD";
        try {
            PreparedStatement pre = cn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                PhieuGiaoHang g = new PhieuGiaoHang();
                g.setMaGH(rs.getInt("ID_GH"));
                g.setSDT(rs.getString("DienThoai"));
                g.setTenNV(rs.getString("TenNV"));
                g.setPhiVC(rs.getDouble("PhiVanChuyen"));
                g.setNgayGiao(rs.getDate("NgayGiao"));
                g.setDC(rs.getString("TenDC"));
                g.setTtGH(rs.getString("TrangThaiGH"));
                g.setTtTT(rs.getString("TrangThaiTT"));
                g.setGhiChu(rs.getString("GhiChu"));
                lst.add(g);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }

    @Override
    public Integer addGH(PhieuGiaoHang gh) {
        Integer row = null;
        String sql = "insert into PhieuGiaoHang(ID_KH,ID_NV,ID_HD,NgayGiao,ID_DC,TrangThaiGH,TrangThaiTT,GhiChu)\n"
                + "values(?,?,?,?,?,?,?,?)";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pre = cn.prepareStatement(sql);
            pre.setString(1, gh.getSDT());
            pre.setString(2, gh.getTenNV());
            pre.setDouble(3, gh.getPhiVC());
            pre.setDate(4, new Date(gh.getNgayGiao().getTime()));
            pre.setString(5, gh.getDC());
            pre.setString(6, gh.getTtGH());
            pre.setString(7, gh.getTtTT());
            pre.setString(8, gh.getGhiChu());
            row = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    @Override
    public Integer updateGH(PhieuGiaoHang gh) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer deleteGH(int index, Integer maGH) {
        Integer row = null;
        String sql = "delete from PhieuGiaoHang where ID_GH = ?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pre = cn.prepareStatement(sql);
            pre.setInt(1, maGH);
            row = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

}
