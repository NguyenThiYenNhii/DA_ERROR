package poly.edu.service;

import java.util.ArrayList;
import poly.edu.model.PhieuGiaoHang;

public interface GHInter {
    ArrayList<PhieuGiaoHang> getAllGH();
    Integer addGH(PhieuGiaoHang gh);
    Integer updateGH(PhieuGiaoHang gh);
    Integer deleteGH(int index, Integer maGH);
    ArrayList<PhieuGiaoHang> selectById(String gh);
    ArrayList<PhieuGiaoHang> selectByGH(int gh);
    ArrayList<PhieuGiaoHang> selectByTT(int tt);
}