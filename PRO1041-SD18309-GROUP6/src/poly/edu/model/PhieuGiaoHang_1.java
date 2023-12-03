package poly.edu.model;

import java.util.Date;

public class PhieuGiaoHang_1 {
    private int maGH;
    private Date ngayGiao;
    private int maKH;
    private int maNV;
    private int maSP;
    private String ttGH;
    private String ttTT;
    private String ghiChu;

    public PhieuGiaoHang_1() {
    }

    public PhieuGiaoHang_1(int maGH, Date ngayGiao, int maKH, int maNV, int maSP, String ttGH, String ttTT, String ghiChu) {
        this.maGH = maGH;
        this.ngayGiao = ngayGiao;
        this.maKH = maKH;
        this.maNV = maNV;
        this.maSP = maSP;
        this.ttGH = ttGH;
        this.ttTT = ttTT;
        this.ghiChu = ghiChu;
    }

    public int getMaGH() {
        return maGH;
    }

    public void setMaGH(int maGH) {
        this.maGH = maGH;
    }

    public Date getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(Date ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTtGH() {
        return ttGH;
    }

    public void setTtGH(String ttGH) {
        this.ttGH = ttGH;
    }

    public String getTtTT() {
        return ttTT;
    }

    public void setTtTT(String ttTT) {
        this.ttTT = ttTT;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
