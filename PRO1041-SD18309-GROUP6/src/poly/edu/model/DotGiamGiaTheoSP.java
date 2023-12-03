/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.model;

/**
 *
 * @author ADMIN
 */
public class DotGiamGiaTheoSP {
    private int ID_TSP;
    private String tenSP;

    public DotGiamGiaTheoSP() {
    }

    public DotGiamGiaTheoSP(int ID_TSP, String tenSP) {
        this.ID_TSP = ID_TSP;
        this.tenSP = tenSP;
    }

    public int getID_TSP() {
        return ID_TSP;
    }

    public void setID_TSP(int ID_TSP) {
        this.ID_TSP = ID_TSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    @Override
    public String toString() {
        return tenSP ;
    }
    
}
