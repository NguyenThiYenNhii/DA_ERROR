/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.model;

/**
 *
 * @author FPTSHOP
 */
public class GiamGiaKH {
    private int MaTKH;
    private int MaKH;
    private boolean  vaitro;
    private String GiatriGG,DieuKienGG,Mota,Hinhthuc;

    public GiamGiaKH() {
    }

    public GiamGiaKH(int MaTKH, int MaKH, boolean vaitro, String GiatriGG, String DieuKienGG, String Mota, String Hinhthuc) {
        this.MaTKH = MaTKH;
        this.MaKH = MaKH;
        this.vaitro = vaitro;
        this.GiatriGG = GiatriGG;
        this.DieuKienGG = DieuKienGG;
        this.Mota = Mota;
        this.Hinhthuc = Hinhthuc;
    }

    public int getMaTKH() {
        return MaTKH;
    }

    public void setMaTKH(int MaTKH) {
        this.MaTKH = MaTKH;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public boolean isVaitro() {
        return vaitro;
    }

    public void setVaitro(boolean vaitro) {
        this.vaitro = vaitro;
    }

    public String getGiatriGG() {
        return GiatriGG;
    }

    public void setGiatriGG(String GiatriGG) {
        this.GiatriGG = GiatriGG;
    }

    public String getDieuKienGG() {
        return DieuKienGG;
    }

    public void setDieuKienGG(String DieuKienGG) {
        this.DieuKienGG = DieuKienGG;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public String getHinhthuc() {
        return Hinhthuc;
    }

    public void setHinhthuc(String Hinhthuc) {
        this.Hinhthuc = Hinhthuc;
    }

    @Override
    public String toString() {
        return "GiamGiaKH{" + "MaTKH=" + MaTKH + ", MaKH=" + MaKH + ", vaitro=" + vaitro + ", GiatriGG=" + GiatriGG + ", DieuKienGG=" + DieuKienGG + ", Mota=" + Mota + ", Hinhthuc=" + Hinhthuc + '}';
    }

   
}
