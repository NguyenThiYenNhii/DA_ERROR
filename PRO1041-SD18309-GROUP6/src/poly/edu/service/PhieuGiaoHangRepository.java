package poly.edu.service;

import java.sql.CallableStatement;
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
        String sql = "select PhieuGiaoHang.ID_GH, KhachHang.DienThoai, NhanVien.TenNV, PhiVanChuyen, PhieuGiaoHang.NgayGiao, TenDC, TrangThaiGH, TrangThaiTT, PhieuGiaoHang.GhiChu from PhieuGiaoHang\n"
                + "                 join KhachHang on PhieuGiaoHang.ID_KH = KhachHang.ID_KH\n"
                + "                 join NhanVien on PhieuGiaoHang.ID_NV = NhanVien.ID_NV\n"
                + "                 join DiaChi on PhieuGiaoHang.ID_DC =  DiaChi.ID_DC\n"
                + "                 join HoaDon on PhieuGiaoHang.ID_HD = HoaDon.ID_HD";
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
        Connection cn = DBContext.getConnection();
        try {
            CallableStatement cs = cn.prepareCall("{call dbo.insert_PhieuGiaoHang(?,?,?,?,?,?,?,?)}");
            cs.setObject(5, gh.getSDT());
            cs.setObject(6, gh.getTenNV());
            cs.setObject(7, gh.getPhiVC());
            cs.setDate(1, new Date(gh.getNgayGiao().getTime()));
            cs.setObject(8, gh.getDC());
            cs.setObject(2, gh.getTtGH().equalsIgnoreCase("Đang Giao") ? "1" : "0");
            cs.setObject(3, gh.getTtTT().equalsIgnoreCase("Đã Thanh Toán") ? "1" : "0");
            cs.setObject(4, gh.getGhiChu());
            row = cs.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    @Override
    public Integer updateGH(PhieuGiaoHang gh) {
        Integer row = null;
        Connection cn = DBContext.getConnection();
        try {
            CallableStatement cs = cn.prepareCall("{call dbo.update_PhieuGiaoHang(?,?,?,?,?,?,?,?,?)}");
            cs.setObject(6, gh.getSDT());
            cs.setObject(7, gh.getTenNV());
            cs.setObject(8, gh.getPhiVC());
            cs.setDate(2, new Date(gh.getNgayGiao().getTime()));
            cs.setObject(9, gh.getDC());
            cs.setObject(3, gh.getTtGH().equalsIgnoreCase("Đang Giao") ? "1" : "0");
            cs.setObject(4, gh.getTtTT().equalsIgnoreCase("Đã Thanh Toán") ? "1" : "0");
            cs.setObject(5, gh.getGhiChu());
            cs.setObject(1, gh.getMaGH());
            row = cs.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    @Override
    public Integer deleteGH(int index, Integer maGH) {
        Integer row = null;
        Connection cn = DBContext.getConnection();
        try {
            CallableStatement cs = cn.prepareCall("{call dbo.delete_PhieuGiaoHang(?)}");
            cs.setObject(1, maGH);
            row = cs.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    @Override
    public ArrayList<PhieuGiaoHang> selectById(String gh) {
        ArrayList<PhieuGiaoHang> lst = new ArrayList<>();
        Connection cn = DBContext.getConnection();
        String sql = "select PhieuGiaoHang.ID_GH, KhachHang.DienThoai, NhanVien.TenNV, PhiVanChuyen, PhieuGiaoHang.NgayGiao, TenDC, TrangThaiGH, TrangThaiTT, PhieuGiaoHang.GhiChu from PhieuGiaoHang\n"
                + "                 join KhachHang on PhieuGiaoHang.ID_KH = KhachHang.ID_KH\n"
                + "                 join NhanVien on PhieuGiaoHang.ID_NV = NhanVien.ID_NV\n"
                + "                 join DiaChi on PhieuGiaoHang.ID_DC =  DiaChi.ID_DC\n"
                + "                 join HoaDon on PhieuGiaoHang.ID_HD = HoaDon.ID_HD where KhachHang.DienThoai like '%" + gh + "%'";
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
    public ArrayList<PhieuGiaoHang> selectByGH(int gh) {
        ArrayList<PhieuGiaoHang> lst = new ArrayList<>();
        Connection cn = DBContext.getConnection();
        String sql = "select PhieuGiaoHang.ID_GH, KhachHang.DienThoai, NhanVien.TenNV, PhiVanChuyen, PhieuGiaoHang.NgayGiao, TenDC, TrangThaiGH, TrangThaiTT, PhieuGiaoHang.GhiChu from PhieuGiaoHang\n"
                + "                 join KhachHang on PhieuGiaoHang.ID_KH = KhachHang.ID_KH\n"
                + "                 join NhanVien on PhieuGiaoHang.ID_NV = NhanVien.ID_NV\n"
                + "                 join DiaChi on PhieuGiaoHang.ID_DC =  DiaChi.ID_DC\n"
                + "                 join HoaDon on PhieuGiaoHang.ID_HD = HoaDon.ID_HD where TrangThaiGH = " + gh;
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
    public ArrayList<PhieuGiaoHang> selectByTT(int tt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
