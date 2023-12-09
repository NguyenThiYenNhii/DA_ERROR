
package poly.edu.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Yen Nhi
 */
public class ChiTietSP {
     private int id;
    private String tenSP;
    private NhaCungCap ncc;
    private Date ngaySanXuat;
    private BigDecimal donGia;
    private String hinh;

    public ChiTietSP() {
    }

    public ChiTietSP(int id, String tenSP, NhaCungCap ncc, Date ngaySanXuat, BigDecimal donGia, String hinh) {
        this.id = id;
        this.tenSP = tenSP;
        this.ncc = ncc;
        this.ngaySanXuat = ngaySanXuat;
        this.donGia = donGia;
        this.hinh = hinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public NhaCungCap getNcc() {
        return ncc;
    }

    public void setNcc(NhaCungCap ncc) {
        this.ncc = ncc;
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    @Override
    public String toString() {
        return "ChiTietSP{" + "id=" + id + ", tenSP=" + tenSP + ", ncc=" + ncc + ", ngaySanXuat=" + ngaySanXuat + ", donGia=" + donGia + ", hinh=" + hinh + '}';
    }

    
    
    
}
