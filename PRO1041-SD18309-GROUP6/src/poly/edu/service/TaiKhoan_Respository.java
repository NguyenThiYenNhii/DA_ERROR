
package poly.edu.service;

import javaapplication2.model.TaiKhoan;
import java.sql.*;
import poly.edu.repository.DBContext;

public class TaiKhoan_Respository {
    
    private Connection conn = DBContext.getConnection();
    
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
