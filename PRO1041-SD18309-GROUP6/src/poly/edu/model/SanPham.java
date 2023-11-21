
package poly.edu.model;

public class SanPham {
    private int id;
    private String tenSP;
    private TheLoai theLoai;
    private KichThuoc kichThuoc;
    private MauSac mauSac;
    private ChatLieu chatLieu;
    private double donGia;
    private int soLuongTon;
    private String trangThai;

    public SanPham() {
    }

    public SanPham(int id, String tenSP, TheLoai theLoai, KichThuoc kichThuoc, MauSac mauSac, ChatLieu chatLieu, double donGia, int soLuongTon, String trangThai) {
        this.id = id;
        this.tenSP = tenSP;
        this.theLoai = theLoai;
        this.kichThuoc = kichThuoc;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
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

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }

    public KichThuoc getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(KichThuoc kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public ChatLieu getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(ChatLieu chatLieu) {
        this.chatLieu = chatLieu;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SanPham{" + "id=" + id + ", tenSP=" + tenSP + ", theLoai=" + theLoai + ", kichThuoc=" + kichThuoc + ", mauSac=" + mauSac + ", chatLieu=" + chatLieu + ", donGia=" + donGia + ", soLuongTon=" + soLuongTon + ", trangThai=" + trangThai + '}';
    }

}
