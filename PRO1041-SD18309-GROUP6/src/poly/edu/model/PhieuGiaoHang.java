package poly.edu.model;

import java.util.Date;

public class PhieuGiaoHang {
    private int maGH;
    private String SDT;
    private String tenNV;
    private double phiVC;
    private Date ngayGiao;
    private String DC;
    private String ttGH;
    private String ttTT;
    private String ghiChu;

    public PhieuGiaoHang() {
    }

    public PhieuGiaoHang(int maGH, String SDT, String tenNV, double phiVC, Date ngayGiao, String DC, String ttGH, String ttTT, String ghiChu) {
        this.maGH = maGH;
        this.SDT = SDT;
        this.tenNV = tenNV;
        this.phiVC = phiVC;
        this.ngayGiao = ngayGiao;
        this.DC = DC;
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

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public double getPhiVC() {
        return phiVC;
    }

    public void setPhiVC(double phiVC) {
        this.phiVC = phiVC;
    }

    public Date getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(Date ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public String getDC() {
        return DC;
    }

    public void setDC(String DC) {
        this.DC = DC;
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
