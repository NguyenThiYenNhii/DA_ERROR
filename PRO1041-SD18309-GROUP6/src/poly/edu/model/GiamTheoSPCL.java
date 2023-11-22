/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.model;

/**
 *
 * @author FPTSHOP
 */
public class GiamTheoSPCL {
    private int MaTSP;
    private String MaSP;
private String GiaTrigg;
private String DieuKienGG ;
private String MoTa;

    public GiamTheoSPCL() {
    }

    public GiamTheoSPCL(int MaTSP, String MaSP, String GiaTrigg, String DieuKienGG, String MoTa) {
        this.MaTSP = MaTSP;
        this.MaSP = MaSP;
        this.GiaTrigg = GiaTrigg;
        this.DieuKienGG = DieuKienGG;
        this.MoTa = MoTa;
    }

    public int getMaTSP() {
        return MaTSP;
    }

    public void setMaTSP(int MaTSP) {
        this.MaTSP = MaTSP;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getGiaTrigg() {
        return GiaTrigg;
    }

    public void setGiaTrigg(String GiaTrigg) {
        this.GiaTrigg = GiaTrigg;
    }

    public String getDieuKienGG() {
        return DieuKienGG;
    }

    public void setDieuKienGG(String DieuKienGG) {
        this.DieuKienGG = DieuKienGG;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    @Override
    public String toString() {
        return "GiamTheoSPCL{" + "MaTSP=" + MaTSP + ", MaSP=" + MaSP + ", GiaTrigg=" + GiaTrigg + ", DieuKienGG=" + DieuKienGG + ", MoTa=" + MoTa + '}';
    }

   

}
