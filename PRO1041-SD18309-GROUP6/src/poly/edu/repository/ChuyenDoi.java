package poly.edu.repository;

import java.text.NumberFormat;

public class ChuyenDoi {
    public static String DinhDangTien(double tien) {
        return NumberFormat.getNumberInstance().format(tien);
    }
}
