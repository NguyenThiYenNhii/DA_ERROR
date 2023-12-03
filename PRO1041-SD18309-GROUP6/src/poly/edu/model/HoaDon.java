package poly.edu.model;

import java.util.Date;

public class HoaDon {
    private int maHD;
    private String tenNV;
    private String tenKH;
    private Date ngayTao;
    private String trangThai;

    public HoaDon() {
    }

    public HoaDon(int maHD, String tenNV, String tenKH, Date ngayTao, String trangThai) {
        this.maHD = maHD;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
