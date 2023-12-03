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
import poly.edu.model.Lavie;
import poly.edu.model.NhanVien;
import poly.edu.model.SanPham;
import poly.edu.repository.Auth;
import poly.edu.repository.Context;
import poly.edu.repository.DBContext;

public class HoaDonRepository implements HDInter {

    @Override
    public ArrayList<HoaDon> getAllHD() {
        ArrayList<HoaDon> lst = new ArrayList<>();
        String sql = "select*from HoaDon";
        Connection cn = Context.getConnection();
        try {
            PreparedStatement pre = cn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt("MaHD"));
                hd.setTenNV(rs.getString("TenNV"));
                hd.setTenKH(rs.getString("TenKH"));
                hd.setNgayTao(rs.getDate("NgayTao"));
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
        String sql = "insert into HoaDon( TenNV, TenKH, NgayTao, TrangThai) values(?,?,?,?)";
        Connection cn = Context.getConnection();
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
    
    public static void loadDatatoGH(JTable tbl, Lavie sp, String slmua){
        DefaultTableModel mol =  (DefaultTableModel) tbl.getModel();
        Object obj[] = new Object[7];
        obj[0] = sp.getMaSP();
        obj[1] = sp.getTenSP();
        obj[2] = slmua;
        obj[3] = sp.getDonGia();
        obj[4] = "";
        obj[5] = Double.parseDouble(slmua) * sp.getDonGia();
        obj[6] = "Chưa thanh toán";
        mol.addRow(obj);
    }
    
    public static String taiQuay(JTable tbl){
        double tongTien = 0;
        for(int i = 0; i < tbl.getRowCount(); i++){
            tongTien += Double.parseDouble(tbl.getValueAt(i, 5).toString());
        }
        return String.valueOf(tongTien);
    }

}
