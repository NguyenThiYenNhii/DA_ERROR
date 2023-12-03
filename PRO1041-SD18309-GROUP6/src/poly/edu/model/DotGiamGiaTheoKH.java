/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.model;

/**
 *
 * @author ADMIN
 */
public class DotGiamGiaTheoKH {
    private int ID_TKH;
    private String tenKH;

    public DotGiamGiaTheoKH() {
    }

    public DotGiamGiaTheoKH(int ID_TKH, String tenKH) {
        this.ID_TKH = ID_TKH;
        this.tenKH = tenKH;
    }

    public int getID_TKH() {
        return ID_TKH;
    }

    public void setID_TKH(int ID_TKH) {
        this.ID_TKH = ID_TKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    @Override
    public String toString() {
        return tenKH ;
    }

    
    
}
