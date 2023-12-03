
package poly.edu.service;

import poly.edu.model.TaiKhoan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import poly.edu.repository.DBContext;

public class TaiKhoan_Respository {
    
    private Connection conn = DBContext.getConnection();
    
    public List<TaiKhoan> getAll(){
        String sql = "SELECT * FROM dbo.TaiKhoan";
        List<TaiKhoan> list = new ArrayList<>();
        try {
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ResultSet rs = ppstm.executeQuery();
            while (rs.next()) {                
                list.add(new TaiKhoan(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public TaiKhoan getbyTaiKhoan(String tk){
        String sql = "SELECT * FROM dbo.TaiKhoan WHERE TenTK = '"+tk+"';";
        List<TaiKhoan> list = new ArrayList<>();
        try {
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ResultSet rs = ppstm.executeQuery();
            while (rs.next()) {                
                list.add(new TaiKhoan(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
    public Integer updateTK(TaiKhoan tk){
        Integer row = null;
        String sql = "UPDATE dbo.TaiKhoan SET TenTK = ?, MatKhau = ? WHERE ID_TK = ?";
        try {
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ppstm.setString(1, tk.getTk());
            ppstm.setString(2, tk.getMk());
            ppstm.setInt(3, tk.getId());
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
    

}
