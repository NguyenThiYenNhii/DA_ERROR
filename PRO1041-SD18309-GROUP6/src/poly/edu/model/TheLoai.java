/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.model;

/**
 *
 * @author Yen Nhi
 */
public class TheLoai {
    private int id;
    private String tenTL;

    public TheLoai() {
    }

    public TheLoai(int id, String tenTL) {
        this.id = id;
        this.tenTL = tenTL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTL() {
        return tenTL;
    }

    public void setTenTL(String tenTL) {
        this.tenTL = tenTL;
    }

    @Override
    public String toString() {
        return tenTL;
    }
    
    
}
