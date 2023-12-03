
package poly.edu.model;

public class ChucVu {
    private int id;
    private String tenCV;
    private String ghiChu;

    public ChucVu() {
    }

    public ChucVu(int id, String tenCV, String ghiChu) {
        this.id = id;
        this.tenCV = tenCV;
        this.ghiChu = ghiChu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    
    
}
