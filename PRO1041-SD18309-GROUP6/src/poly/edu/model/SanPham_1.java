package poly.edu.model;

public class SanPham_1 {
    private int maSP;
    private String tenSP;
    private String theLoai;
    private String chatLieu;
    private String kichThuoc;
    private String mauSac;
    private int soLuong;
    private double donGia;

    public SanPham_1() {
    }

    public SanPham_1(int maSP, String tenSP, String theLoai, String chatLieu, String kichThuoc, String mauSac, int soLuong, double donGia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.theLoai = theLoai;
        this.chatLieu = chatLieu;
        this.kichThuoc = kichThuoc;
        this.mauSac = mauSac;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
}
