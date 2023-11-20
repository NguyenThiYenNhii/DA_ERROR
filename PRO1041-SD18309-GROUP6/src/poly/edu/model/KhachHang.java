/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.model;

import java.util.Date;

/**
 *
 * @author TXT DIGITAL
 */
public class KhachHang { 
    private int ID;
    private String ten;
    private String matkhau;
    private String gioitinh;
    private Date ngaysinh;
    private String diachi;
    private String sdt;
    private String trangthai;

    public KhachHang() {
    }

    public KhachHang(int ID, String ten, String matkhau, String gioitinh, Date ngaysinh, String diachi, String sdt, String trangthai) {
        this.ID = ID;
        this.ten = ten;
        this.matkhau = matkhau;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.trangthai = trangthai;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "ID=" + ID + ", ten=" + ten + ", matkhau=" + matkhau + ", gioitinh=" + gioitinh + ", ngaysinh=" + ngaysinh + ", diachi=" + diachi + ", =" + sdt + ", trangthai=" + trangthai + '}';
    }

    
    
    
    
    
    
}
