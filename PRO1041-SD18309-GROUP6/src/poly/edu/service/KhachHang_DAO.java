/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import poly.edu.model.KhachHang;
import poly.edu.repository.DBContext;

/**
 *
 * @author TXT DIGITAL
 */
public class KhachHang_DAO implements Integer_KhachHang {

    @Override
    public ArrayList<KhachHang> getAllKhachHang() {

        ArrayList<KhachHang> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM KhachHang";
            Connection con = DBContext.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setID(rs.getInt("ID_KH"));
                kh.setTen(rs.getString("TenKH"));
                kh.setMatkhau(rs.getString("MatKhau"));
                kh.setGioitinh(rs.getString("GioiTinh"));
                kh.setNgaysinh(rs.getDate("NgaySinh"));
                kh.setDiachi(rs.getString("DiaChi"));
                kh.setSdt(rs.getString("DienThoai"));
                kh.setTrangthai(rs.getString("TrangThai"));

                list.add(kh);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return list;

    }

    @Override
    public Integer add(KhachHang kh) {
        Integer row = null;
        String sql = "INSERT INTO KhachHang(TenKH,MatKhau,GioiTinh, NgaySinh, DiaChi, DienThoai, TrangThai) VALUES (?,?,?,?,?,?,?)";
        Connection con = DBContext.getConnection();

        try {
            PreparedStatement pr = con.prepareStatement(sql);

            pr.setObject(1, kh.getTen());
            pr.setObject(2, kh.getMatkhau());
            pr.setObject(3, kh.getGioitinh());
            pr.setObject(4, kh.getNgaysinh());
            pr.setObject(5, kh.getDiachi());
            pr.setObject(6, kh.getSdt());
            pr.setObject(7, kh.getTrangthai());

            row = pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return row;

    }

    @Override
    public Integer update(KhachHang kh) {

        Integer row = null;
        String sql = "UPDATE KhachHang SET TenKH = ?, MatKhau = ?, GioiTinh =?, NgaySinh = ?, DiaChi = ?, DienThoai = ?, TrangThai = ? WHERE ID_KH = ?";
        Connection con = DBContext.getConnection();

        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(8, kh.getID());
            pr.setObject(1, kh.getTen());
            pr.setObject(2, kh.getMatkhau());
            pr.setObject(3, kh.getGioitinh());
            pr.setObject(4, kh.getNgaysinh());
            pr.setObject(5, kh.getDiachi());
            pr.setObject(6, kh.getSdt());
            pr.setObject(7, kh.getTrangthai());

            row = pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return row;
    }

    @Override
    public Integer delete(int index, int ID) {
        Integer row = null;
        String sql = "DELETE FROM KhachHang WHERE ID_KH =?";
        Connection con = DBContext.getConnection();

        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, ID);

            row = pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return row;
    }

}
