package poly.edu.service;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import poly.edu.model.ChiTietSP;
import poly.edu.model.NhaCungCap;
import poly.edu.repository.DBContext;

/**
 *
 * @author Yen Nhi
 */
public class ChiTietSanPham_Service {

    Connection con = DBContext.getConnection();

    public ArrayList<ChiTietSP> getAllChiTiet() {
        ArrayList<ChiTietSP> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM SanPham sp \n"
                    + "JOIN NhaCungCap ncc ON ncc.ID_NCC = sp.ID_NCC";
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setTenNCC(rs.getString("TenCT"));

                ChiTietSP sp = new ChiTietSP();
                sp.setId(rs.getInt("ID_SP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setNcc(ncc);
                sp.setNgaySanXuat(rs.getDate("NgaySanXuat"));
                sp.setDonGia(rs.getBigDecimal("DonGia"));
                sp.setHinh(rs.getString("Hinh"));

                list.add(sp);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Integer add(ChiTietSP sp) {
        Integer row = null;
        Connection con = DBContext.getConnection();

        try {
            CallableStatement cs = con.prepareCall("{call dbo.insert_SanPhamCT(?,?,?,?,?)}");
            cs.setObject(1, sp.getTenSP());
            cs.setObject(2, sp.getNcc().getTenNCC());
            cs.setObject(3, sp.getNgaySanXuat());
            cs.setObject(4, sp.getDonGia());
            cs.setObject(5, sp.getHinh());

            row = cs.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return row;
    }

    public Integer update(ChiTietSP sp) {
        Integer row = null;
        Connection con = DBContext.getConnection();

        try {
            CallableStatement cs = con.prepareCall("{call dbo.update_SanPhamCT(?,?,?,?,?,?)}");
            cs.setObject(2, sp.getTenSP());
            cs.setObject(3, sp.getNcc().getTenNCC());
            cs.setObject(4, sp.getNgaySanXuat());
            cs.setObject(5, sp.getDonGia());
            cs.setObject(6, sp.getHinh());
            cs.setObject(1, sp.getId());

            row = cs.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return row;
    }
    
    public Integer delete(int index, int masp) {
        Integer row = null;
        Connection con = DBContext.getConnection();

        try {
            CallableStatement cs = con.prepareCall("{call dbo.delete_SanPhamCT(?)}");
            cs.setObject(1, masp);

            row = cs.executeUpdate();
        } catch (Exception e) {
        }

        return row;
    }
}
