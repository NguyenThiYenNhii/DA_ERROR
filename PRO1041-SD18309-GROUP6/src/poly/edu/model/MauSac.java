/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.model;

/**
 *
 * @author Yen Nhi
 */
public class MauSac {
    private int id;
    private String tenMS;

    public MauSac() {
    }

    public MauSac(int id, String tenMS) {
        this.id = id;
        this.tenMS = tenMS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenMS() {
        return tenMS;
    }

    public void setTenMS(String tenMS) {
        this.tenMS = tenMS;
    }

    @Override
    public String toString() {
        return tenMS;
    }
    
    
}
