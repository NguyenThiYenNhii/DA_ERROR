
package poly.edu.service;

import java.util.ArrayList;
import java.util.List;
import javaapplication2.model.NhanVien;
import java.sql.*;
import javaapplication2.model.ChucVu;
import javaapplication2.model.TaiKhoan;
import poly.edu.repository.DBContext;

public class NhanVien_Resository {
    
    Connection conn = DBContext.getConnection();
    
    public List<NhanVien> getAll(){
        List <NhanVien> listAll = new ArrayList<>();
        try {
            String sql = "SELECT * FROM dbo.NhanVien \n" +
                "JOIN dbo.TaiKhoan ON TaiKhoan.ID_TK = NhanVien.ID_TK\n" +
                "JOIN dbo.ChucVu ON ChucVu.ID_CV = NhanVien.ID_CV";
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ResultSet rs = ppstm.executeQuery();
            while (rs.next()) {                
                TaiKhoan tk = new TaiKhoan();
                tk.setId(rs.getInt(3));
                tk.setTk(rs.getString(11));
                tk.setMk(rs.getString(12));
                
                ChucVu cv = new ChucVu();
                cv.setId(rs.getInt(2));
                cv.setTenCV(rs.getString(14));
                
                NhanVien nv = new NhanVien(rs.getInt(1), cv, tk,rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9));
                listAll.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAll;
    }
    
    public List<NhanVien> getByName(String name){
        List <NhanVien> listAll = new ArrayList<>();
        try {
            String sql = "SELECT * FROM dbo.NhanVien \n" +
                    "JOIN dbo.TaiKhoan ON TaiKhoan.ID_TK = NhanVien.ID_TK\n" +
                    "JOIN dbo.ChucVu ON ChucVu.ID_CV = NhanVien.ID_CV\n" +
                "WHERE TenNV like N'%"+name+"%'";
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ResultSet rs = ppstm.executeQuery();
            while (rs.next()) {                
                TaiKhoan tk = new TaiKhoan();
                tk.setId(rs.getInt(3));
                tk.setTk(rs.getString(11));
                tk.setMk(rs.getString(12));
                
                ChucVu cv = new ChucVu();
                cv.setId(rs.getInt(2));
                cv.setTenCV(rs.getString(14));
                
                NhanVien nv = new NhanVien(rs.getInt(1), cv, tk,rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9));
                listAll.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAll;
    }
    
        public List<NhanVien> getByChucVu(int chucVu){
        List <NhanVien> listAll = new ArrayList<>();
        try {
            String sql = "SELECT * FROM dbo.NhanVien \n" +
                    "JOIN dbo.TaiKhoan ON TaiKhoan.ID_TK = NhanVien.ID_TK\n" +
                    "JOIN dbo.ChucVu ON ChucVu.ID_CV = NhanVien.ID_CV\n" +
                "WHERE NhanVien.ID_CV =" + chucVu;
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ResultSet rs = ppstm.executeQuery();
            while (rs.next()) {                
                TaiKhoan tk = new TaiKhoan();
                tk.setId(rs.getInt(3));
                tk.setTk(rs.getString(11));
                tk.setMk(rs.getString(12));
                
                ChucVu cv = new ChucVu();
                cv.setId(rs.getInt(2));
                cv.setTenCV(rs.getString(14));
                
                NhanVien nv = new NhanVien(rs.getInt(1), cv, tk,rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9));
                listAll.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAll;
    }
        
    public Integer xoaNhanVien(long id){
        Integer row = null;
        String sql = "DELETE FROM dbo.NhanVien WHERE ID_CV = ?";
        try {
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ppstm.setLong(1, id);
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
    
    public Integer updateNhanVien(NhanVien nv){
        Integer row = null;
        String sql = "UPDATE dbo.NhanVien SET ID_CV = ?, TenNV = ?, Email = ?, SoDienThoai = ?, NgaySinh = ?, GioiTinh = ?, DiaChi = ? WHERE ID_NV = ?";
        try {
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ppstm.setInt(1, nv.getCv().getId());
            ppstm.setString(2, nv.getTenNV());
            ppstm.setString(3, nv.getEmail());
            ppstm.setString(4, nv.getSdt());
            ppstm.setString(5, nv.getNgaySinh());
            ppstm.setInt(6, nv.getGioiTinh());
            ppstm.setString(7, nv.getDiaChi());
            ppstm.setInt(8, nv.getId());
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  row;
    }
}
