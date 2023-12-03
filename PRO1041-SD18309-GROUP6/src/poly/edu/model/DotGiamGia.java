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
    private DotGiamGiaTheoSP tenSP;
    private DotGiamGiaTheoKH tenKH;
    private String tenDGG;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String loaiGiamGia;
    private String giaTriGG;
    private String dieuKienGiamGia;
    private String moTa;

    public DotGiamGia() {
    }

    public DotGiamGia(int ID_DGG, DotGiamGiaTheoSP tenSP, DotGiamGiaTheoKH tenKH, String tenDGG, Date ngayBatDau, Date ngayKetThuc, String loaiGiamGia, String giaTriGG, String dieuKienGiamGia, String moTa) {
        this.ID_DGG = ID_DGG;
        this.tenSP = tenSP;
        this.tenKH = tenKH;
        this.tenDGG = tenDGG;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.loaiGiamGia = loaiGiamGia;
        this.giaTriGG = giaTriGG;
        this.dieuKienGiamGia = dieuKienGiamGia;
        this.moTa = moTa;
    }

    public int getID_DGG() {
        return ID_DGG;
    }

    public void setID_DGG(int ID_DGG) {
        this.ID_DGG = ID_DGG;
    }

    public DotGiamGiaTheoSP getTenSP() {
        return tenSP;
    }

    public void setTenSP(DotGiamGiaTheoSP tenSP) {
        this.tenSP = tenSP;
    }

    public DotGiamGiaTheoKH getTenKH() {
        return tenKH;
    }

    public void setTenKH(DotGiamGiaTheoKH tenKH) {
        this.tenKH = tenKH;
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

    @Override
    public String toString() {
        return "DotGiamGia{" + "ID_DGG=" + ID_DGG + ", tenSP=" + tenSP + ", tenKH=" + tenKH + ", tenDGG=" + tenDGG + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", loaiGiamGia=" + loaiGiamGia + ", giaTriGG=" + giaTriGG + ", dieuKienGiamGia=" + dieuKienGiamGia + ", moTa=" + moTa + '}';
    }

    


    
   
}
