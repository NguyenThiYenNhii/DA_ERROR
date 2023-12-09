
package poly.edu.model;

/**
 *
 * @author Yen Nhi
 */
public class NhaCungCap {
    private int id;
    private String tenNCC;

    public NhaCungCap() {
    }

    public NhaCungCap(int id, String tenNCC) {
        this.id = id;
        this.tenNCC = tenNCC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    @Override
    public String toString() {
        return tenNCC ;
    }
    
    
}
