package poly.edu.service;

import java.util.ArrayList;
import poly.edu.model.SanPham;

public interface Interface_sanPham {

    ArrayList<SanPham> getAllSanPham();

    Integer add(SanPham sp);

    Integer update(SanPham sp);

    Integer delete(int index, int masp);

}
