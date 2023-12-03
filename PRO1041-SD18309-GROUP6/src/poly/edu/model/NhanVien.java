
package poly.edu.model;

public class NhanVien {
    private int id;
    private ChucVu cv;
    private TaiKhoan tk;
    private String tenNV;
    private String email;
    private String sdt;
    private int gioiTinh;
    private String ngaySinh;
    private String diaChi;

    public NhanVien() {
    }

    public NhanVien(int id, ChucVu cv, TaiKhoan tk, String tenNV, String email, String sdt, int gioiTinh, String ngaySinh, String diaChi) {
        this.id = id;
        this.cv = cv;
        this.tk = tk;
        this.tenNV = tenNV;
        this.email = email;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ChucVu getCv() {
        return cv;
    }

    public void setCv(ChucVu cv) {
        this.cv = cv;
    }

    public TaiKhoan getTk() {
        return tk;
    }

    public void setTk(TaiKhoan tk) {
        this.tk = tk;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

     
    
    public Object[] toDataRow(){
        return new Object[]{
            this.getId(),
            this.getCv().getTenCV(),
            this.getTk().getTk(),
            this.getTk().getMk(),
            this.getTenNV(),
            this.getSdt(),
            this.getEmail(),
            this.getGioiTinh() == 0 ? "Nam" : "Nữ",
            this.getNgaySinh(),
            this.getDiaChi()
        };
    }
}
