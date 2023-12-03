package poly.edu.service;

import java.util.List;
import poly.edu.repository.DBContext;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import poly.edu.model.ChucVu;
import poly.edu.model.NhanVien;
import poly.edu.model.TaiKhoan;



public class NhanVien_Respository {
    
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
    
       public NhanVien getByIdTaiKhoan(int id){
        NhanVien nv = null;
        try {
            String sql = "SELECT * FROM dbo.NhanVien \n" +
                    "JOIN dbo.TaiKhoan ON TaiKhoan.ID_TK = NhanVien.ID_TK\n" +
                    "JOIN dbo.ChucVu ON ChucVu.ID_CV = NhanVien.ID_CV\n" +
                "WHERE NhanVien.ID_TK =" + id;
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
              
                 nv = new NhanVien(rs.getInt(1), cv, tk,rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
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
    
    public Integer addNhanVien(NhanVien nv){
        Integer row = null;
        String sql = "dbo.insert_NhanVien_TaiKhoan";
        try {
            CallableStatement cbsm = conn.prepareCall
                ("{call dbo.insert_NhanVien_TaiKhoan(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cbsm.setInt(1,nv.getCv().getId());
            cbsm.setString(2,nv.getTenNV());
            cbsm.setString(3,nv.getEmail());
            cbsm.setString(4,nv.getSdt());
            cbsm.setInt(5,nv.getGioiTinh());
            cbsm.setString(6, nv.getNgaySinh());
            cbsm.setString(7, nv.getDiaChi());
            cbsm.setString(8, nv.getTk().getTk());
            cbsm.setString(9, nv.getTk().getMk());
            
            row = cbsm.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
}
