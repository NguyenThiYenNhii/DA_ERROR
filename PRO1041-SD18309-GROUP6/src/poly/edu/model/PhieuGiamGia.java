/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.model;

import java.util.Date;

/**
 *
 * @author FPTSHOP
 */
public class PhieuGiamGia {
   private int MaGG,MaKH,MaTSP,MaTKH;
   private int MaSP;
   private Date Ngaybatdau,NgayHH;
   private String GiaTriGG;
   private boolean trangthai;
   private String Ngaytao;
   private String NgaySuDung;
   private String Mota;
   private String DieuKien;
 private String Hinhthuc;
 private String TenGG;

    public PhieuGiamGia() {
    }

    public PhieuGiamGia(int MaGG, int MaKH, int MaTSP, int MaTKH, int MaSP, Date Ngaybatdau, Date NgayHH, String GiaTriGG, boolean trangthai, String Ngaytao, String NgaySuDung, String Mota, String DieuKien, String Hinhthuc, String TenGG) {
        this.MaGG = MaGG;
        this.MaKH = MaKH;
        this.MaTSP = MaTSP;
        this.MaTKH = MaTKH;
        this.MaSP = MaSP;
        this.Ngaybatdau = Ngaybatdau;
        this.NgayHH = NgayHH;
        this.GiaTriGG = GiaTriGG;
        this.trangthai = trangthai;
        this.Ngaytao = Ngaytao;
        this.NgaySuDung = NgaySuDung;
        this.Mota = Mota;
        this.DieuKien = DieuKien;
        this.Hinhthuc = Hinhthuc;
        this.TenGG = TenGG;
    }

    public int getMaGG() {
        return MaGG;
    }

    public void setMaGG(int MaGG) {
        this.MaGG = MaGG;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public int getMaTSP() {
        return MaTSP;
    }

    public void setMaTSP(int MaTSP) {
        this.MaTSP = MaTSP;
    }

    public int getMaTKH() {
        return MaTKH;
    }

    public void setMaTKH(int MaTKH) {
        this.MaTKH = MaTKH;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }

    public Date getNgaybatdau() {
        return Ngaybatdau;
    }

    public void setNgaybatdau(Date Ngaybatdau) {
        this.Ngaybatdau = Ngaybatdau;
    }

    public Date getNgayHH() {
        return NgayHH;
    }

    public void setNgayHH(Date NgayHH) {
        this.NgayHH = NgayHH;
    }

    public String getGiaTriGG() {
        return GiaTriGG;
    }

    public void setGiaTriGG(String GiaTriGG) {
        this.GiaTriGG = GiaTriGG;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public String getNgaytao() {
        return Ngaytao;
    }

    public void setNgaytao(String Ngaytao) {
        this.Ngaytao = Ngaytao;
    }

    public String getNgaySuDung() {
        return NgaySuDung;
    }

    public void setNgaySuDung(String NgaySuDung) {
        this.NgaySuDung = NgaySuDung;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public String getDieuKien() {
        return DieuKien;
    }

    public void setDieuKien(String DieuKien) {
        this.DieuKien = DieuKien;
    }

    public String getHinhthuc() {
        return Hinhthuc;
    }

    public void setHinhthuc(String Hinhthuc) {
        this.Hinhthuc = Hinhthuc;
    }

    public String getTenGG() {
        return TenGG;
    }

    public void setTenGG(String TenGG) {
        this.TenGG = TenGG;
    }

    @Override
    public String toString() {
        return "PhieuGiamGia{" + "MaGG=" + MaGG + ", MaKH=" + MaKH + ", MaTSP=" + MaTSP + ", MaTKH=" + MaTKH + ", MaSP=" + MaSP + ", Ngaybatdau=" + Ngaybatdau + ", NgayHH=" + NgayHH + ", GiaTriGG=" + GiaTriGG + ", trangthai=" + trangthai + ", Ngaytao=" + Ngaytao + ", NgaySuDung=" + NgaySuDung + ", Mota=" + Mota + ", DieuKien=" + DieuKien + ", Hinhthuc=" + Hinhthuc + ", TenGG=" + TenGG + '}';
    }

    
}
