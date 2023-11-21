/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.model;

/**
 *
 * @author Yen Nhi
 */
public class KichThuoc {
    private int id;
    private String tenKT;

    public KichThuoc() {
    }

    public KichThuoc(int id, String tenKT) {
        this.id = id;
        this.tenKT = tenKT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKT() {
        return tenKT;
    }

    public void setTenKT(String tenKT) {
        this.tenKT = tenKT;
    }

    @Override
    public String toString() {
        return tenKT;
    }
    
    
}
