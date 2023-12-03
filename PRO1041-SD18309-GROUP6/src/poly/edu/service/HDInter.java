package poly.edu.service;

import java.util.ArrayList;
import poly.edu.model.HoaDon;

public interface HDInter {
    ArrayList<HoaDon> getAllHD();
    Integer addHD(HoaDon hd);
}
