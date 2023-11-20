/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.edu.service;

import java.util.ArrayList;
import poly.edu.model.DotGiamGia;

/**
 *
 * @author ADMIN
 */
public interface Interface_DotGiamGia {

    ArrayList<DotGiamGia> getAllDotGiamGia();

    Integer add(DotGiamGia dgg);

    Integer update(DotGiamGia dgg);

    Integer delete(int index, Integer ID_DGG);
}
