package poly.edu.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import poly.edu.model.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import poly.edu.model.NhanVien;
import poly.edu.model.SanPham;
import poly.edu.repository.Auth;
import poly.edu.repository.DBContext;

public class HoaDonRepository implements HDInter {

    @Override
    public ArrayList<HoaDon> getAllHD() {
        ArrayList<HoaDon> lst = new ArrayList<>();
        String sql = "select*from HoaDon hd\n"
                + "JOIN NhanVien nv ON nv.ID_NV = hd.ID_NV ";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pre = cn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setTenNV(rs.getString("TenNV"));
                
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt("ID_HD"));
                hd.setTenNV(nv.getTenNV());
                hd.setTenKH(rs.getString("TenKH"));
                hd.setNgayTao(rs.getDate("NgayDat"));
                hd.setTrangThai(rs.getString("TrangThai"));
                lst.add(hd);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }

    @Override
    public Integer addHD(HoaDon hd) {
        Integer row = null;
        String sql = "insert into HoaDon( ID_NV, TenKH, NgayDat, TrangThai) values(?,?,?,?)";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pre = cn.prepareStatement(sql);
            pre.setString(1, hd.getTenNV());
            pre.setString(2, hd.getTenKH());
            pre.setDate(3, new Date(hd.getNgayTao().getTime()));
            pre.setString(4, hd.getTrangThai());
            row = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    public static void loadDatatoGH(JTable tbl, SanPham sp, String slmua) {
        DefaultTableModel mol = (DefaultTableModel) tbl.getModel();
        Object obj[] = new Object[7];
        obj[0] = sp.getId();
        obj[1] = sp.getTenSP();
        obj[2] = slmua;
        obj[3] = sp.getDonGia();
        obj[4] = "";
        BigDecimal bd1 = BigDecimal.valueOf(Double.parseDouble(slmua));
        obj[5] = bd1.multiply(sp.getDonGia());
        obj[6] = "Chưa thanh toán";
        mol.addRow(obj);
    }

    public static String taiQuay(JTable tbl) {
        double tongTien = 0;
        for (int i = 0; i < tbl.getRowCount(); i++) {
            tongTien += Double.parseDouble(tbl.getValueAt(i, 5).toString());
        }
        return String.valueOf(tongTien);
    }

}
