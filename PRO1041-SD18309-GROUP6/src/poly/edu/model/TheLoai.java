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
    private String tl;

    public TheLoai() {
    }

    public TheLoai(int id, String tl) {
        this.id = id;
        this.tl = tl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTl() {
        return tl;
    }

    public void setTl(String tl) {
        this.tl = tl;
    }

    @Override
    public String toString() {
        return tl;
    }

   
}
