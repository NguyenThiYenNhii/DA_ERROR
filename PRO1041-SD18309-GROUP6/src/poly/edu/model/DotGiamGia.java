/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class DotGiamGia {
    private int ID_DGG;
    private String tenDGG;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String loaiGiamGia;
    private String giaTriGG;
    private String dieuKienGiamGia;
    private String moTa;
    private int id_kh,id_sp;

    public DotGiamGia() {
    }

    public DotGiamGia(int ID_DGG, String tenDGG, Date ngayBatDau, Date ngayKetThuc, String loaiGiamGia, String giaTriGG, String dieuKienGiamGia, String moTa, int id_kh, int id_sp) {
        this.ID_DGG = ID_DGG;
        this.tenDGG = tenDGG;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.loaiGiamGia = loaiGiamGia;
        this.giaTriGG = giaTriGG;
        this.dieuKienGiamGia = dieuKienGiamGia;
        this.moTa = moTa;
        this.id_kh = id_kh;
        this.id_sp = id_sp;
    }

    public int getID_DGG() {
        return ID_DGG;
    }

    public void setID_DGG(int ID_DGG) {
        this.ID_DGG = ID_DGG;
    }

    public String getTenDGG() {
        return tenDGG;
    }

    public void setTenDGG(String tenDGG) {
        this.tenDGG = tenDGG;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getLoaiGiamGia() {
        return loaiGiamGia;
    }

    public void setLoaiGiamGia(String loaiGiamGia) {
        this.loaiGiamGia = loaiGiamGia;
    }

    public String getGiaTriGG() {
        return giaTriGG;
    }

    public void setGiaTriGG(String giaTriGG) {
        this.giaTriGG = giaTriGG;
    }

    public String getDieuKienGiamGia() {
        return dieuKienGiamGia;
    }

    public void setDieuKienGiamGia(String dieuKienGiamGia) {
        this.dieuKienGiamGia = dieuKienGiamGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getId_kh() {
        return id_kh;
    }

    public void setId_kh(int id_kh) {
        this.id_kh = id_kh;
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    @Override
    public String toString() {
        return "DotGiamGia{" + "ID_DGG=" + ID_DGG + ", tenDGG=" + tenDGG + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", loaiGiamGia=" + loaiGiamGia + ", giaTriGG=" + giaTriGG + ", dieuKienGiamGia=" + dieuKienGiamGia + ", moTa=" + moTa + ", id_kh=" + id_kh + ", id_sp=" + id_sp + '}';
    }

    
}
