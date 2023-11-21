/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.model;

/**
 *
 * @author Yen Nhi
 */
public class ChatLieu {
    private int id;
    private String tenCL;

    public ChatLieu() {
    }

    public ChatLieu(int id, String tenCL) {
        this.id = id;
        this.tenCL = tenCL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenCL() {
        return tenCL;
    }

    public void setTenCL(String tenCL) {
        this.tenCL = tenCL;
    }

    @Override
    public String toString() {
        return tenCL;
    }
    
    
}
