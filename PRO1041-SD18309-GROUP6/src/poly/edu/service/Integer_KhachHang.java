/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.edu.service;

import java.util.ArrayList;
import poly.edu.model.KhachHang;

/**
 *
 * @author TXT DIGITAL
 */
public interface Integer_KhachHang {

    ArrayList<KhachHang> getAllKhachHang();

    Integer add(KhachHang kh);

    Integer update(KhachHang kh);

    Integer delete(int index, int ID);
    
    ArrayList <KhachHang> selectById (String sdt);

}
