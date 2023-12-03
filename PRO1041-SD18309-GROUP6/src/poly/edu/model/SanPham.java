
package poly.edu.model;

import java.math.BigDecimal;

public class SanPham {
    private int id;
    private String tenSP;
    private TheLoai tl;
    private KichThuoc kt;
    private MauSac ms;
    private ChatLieu cl;
    private BigDecimal donGia;
    private int soLuongTon;
    private int trangThai;

    public SanPham() {
    }

    public SanPham(int id, String tenSP, TheLoai tl, KichThuoc kt, MauSac ms, ChatLieu cl, BigDecimal donGia, int soLuongTon, int trangThai) {
        this.id = id;
        this.tenSP = tenSP;
        this.tl = tl;
        this.kt = kt;
        this.ms = ms;
        this.cl = cl;
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
        this.trangThai = trangThai;
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

    public TheLoai getTl() {
        return tl;
    }

    public void setTl(TheLoai tl) {
        this.tl = tl;
    }

    public KichThuoc getKt() {
        return kt;
    }

    public void setKt(KichThuoc kt) {
        this.kt = kt;
    }

    public MauSac getMs() {
        return ms;
    }

    public void setMs(MauSac ms) {
        this.ms = ms;
    }

    public ChatLieu getCl() {
        return cl;
    }

    public void setCl(ChatLieu cl) {
        this.cl = cl;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return tenSP;
    }
    
    public Object[] toDataRow(){
        return new Object[]{
            this.getId(),
            this.getTenSP(),
            this.getTl().getTl(),
            this.getKt().getTenKT(),
            this.getMs().getTenMS(),
            this.getCl().getTenCL(),
            this.getDonGia(),
            this.getSoLuongTon(),
            this.getTrangThai() == 0 ?  "Hết Hàng" : "Còn Hàng",
        };
    }
}
