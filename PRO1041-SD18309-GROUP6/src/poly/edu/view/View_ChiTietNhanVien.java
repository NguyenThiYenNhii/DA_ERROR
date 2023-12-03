package poly.edu.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import poly.edu.model.ChucVu;
import poly.edu.model.NhanVien;
import poly.edu.model.TaiKhoan;
import poly.edu.service.TaiKhoan_Respository;
import poly.edu.service.NhanVien_Respository;

public class View_ChiTietNhanVien extends javax.swing.JFrame {

    private int index;
    private List<NhanVien> listTong;
    private final NhanVien_Respository nvr = new NhanVien_Respository();
    private final TaiKhoan_Respository tkr = new TaiKhoan_Respository();
//    private View_ vT = new View_NhanVien_Tong();

    public View_ChiTietNhanVien(int row) {
        initComponents();
        this.setLocationRelativeTo(null);

        index = row;
        this.combobox();
        this.showForm(index);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btn_Exit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_ID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_Tk = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_Mk = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rdo_QuanLy = new javax.swing.JRadioButton();
        rdo_NhanVien = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txt_TenNhanVien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtA_GhiChu = new javax.swing.JTextArea();
        txt_SDT = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbx_GioiTinh = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txt_Email = new javax.swing.JTextField();
        btn_Sua = new javax.swing.JButton();
        txt_DiaChi = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btn_Xoa = new javax.swing.JButton();
        dateCh_NgaySinh = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nhân Viên Chi Tiết");

        btn_Exit.setText("Thoát");
        btn_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExitActionPerformed(evt);
            }
        });

        jLabel2.setText("ID :");

        txt_ID.setEditable(false);

        jLabel3.setText("Tài khoản :");

        jLabel4.setText("Mật khẩu :");

        jLabel5.setText("Chức vụ :");

        buttonGroup1.add(rdo_QuanLy);
        rdo_QuanLy.setText("Quản Lý");

        buttonGroup1.add(rdo_NhanVien);
        rdo_NhanVien.setSelected(true);
        rdo_NhanVien.setText("Nhân Viên");

        jLabel6.setText("Tên nhân viên :");

        jLabel7.setText("Ngày sinh :");

        jLabel8.setText("Số điện thoại :");

        jLabel9.setText("Ghi chú :");

        txtA_GhiChu.setColumns(20);
        txtA_GhiChu.setRows(5);
        jScrollPane1.setViewportView(txtA_GhiChu);

        jLabel10.setText("Giới tính :");

        cbx_GioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Email :");

        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        jLabel13.setText("Địa chỉ :");

        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(rdo_QuanLy)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdo_NhanVien))
                                    .addComponent(txt_Tk, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Mk, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_TenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbx_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_Sua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Xoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Exit))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(43, 43, 43)
                                        .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7))))
                                .addGap(21, 21, 21)
                                .addComponent(dateCh_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 6, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_TenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addComponent(dateCh_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbx_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_Tk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_Mk, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rdo_QuanLy)
                            .addComponent(rdo_NhanVien))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Exit)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Sua)
                        .addComponent(btn_Xoa)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_ExitActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
        int conf = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa nhân viên này đi không", "Thông Báo",
                JOptionPane.YES_NO_CANCEL_OPTION);
        if (conf == JOptionPane.YES_OPTION) {
            if (this.checkValidate() == true) {
                mess("Bạn Chưa Nhập Đủ Thông Tin Vui Lòng Kiểm Tra Lại");
                return;
            }
            NhanVien nv = getInputNhanVien();
            TaiKhoan tk = getTaiKhoan();

            if (nvr.updateNhanVien(nv) != null) {
                if(tkr.updateTK(tk) != null)
                    mess("Sửa thành công");
                else 
                    mess("Sửa thành công");
            }
            else  if (nvr.updateNhanVien(nv) == null && tkr.updateTK(tk) == null)
                mess("Sửa thất bại");
                
        } else {
            return;
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        long id = Long.parseLong(txt_ID.getText());
        int conf = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa nhân viên này đi không", "Thông Báo",
                JOptionPane.YES_NO_CANCEL_OPTION);
        if (conf == JOptionPane.YES_OPTION) {
            if (nvr.xoaNhanVien(id) != null) {
                mess("Xóa thành công");
                clearForm();
            }
            else
                mess("Xóa thất bại");
        } else {
            return;
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Exit;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbx_GioiTinh;
    private com.toedter.calendar.JDateChooser dateCh_NgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdo_NhanVien;
    private javax.swing.JRadioButton rdo_QuanLy;
    private javax.swing.JTextArea txtA_GhiChu;
    private javax.swing.JTextField txt_DiaChi;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_Mk;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_TenNhanVien;
    private javax.swing.JTextField txt_Tk;
    // End of variables declaration//GEN-END:variables

    private void combobox() {
        cbx_GioiTinh.removeAllItems();
        cbx_GioiTinh.addItem("Nam");
        cbx_GioiTinh.addItem("Nữ");
    }

    private void showForm(int index) {
        listTong = nvr.getAll();

        txt_ID.setText(String.valueOf(listTong.get(index).getId()));
        txt_Tk.setText(listTong.get(index).getTk().getTk());
        txt_Mk.setText(listTong.get(index).getTk().getMk());
        txt_Email.setText(listTong.get(index).getEmail());
        txt_TenNhanVien.setText(listTong.get(index).getTenNV());
        txt_SDT.setText(listTong.get(index).getSdt());
        txt_DiaChi.setText(listTong.get(index).getDiaChi());
        if (listTong.get(index).getCv().getTenCV().equalsIgnoreCase("Quản lý")) {
            rdo_QuanLy.setSelected(true);
        } else {
            rdo_NhanVien.setSelected(true);
        }
        cbx_GioiTinh.setSelectedIndex(listTong.get(index).getGioiTinh());

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(listTong.get(index).getNgaySinh());
            dateCh_NgaySinh.setDate(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private NhanVien getInputNhanVien() {
        NhanVien nv = new NhanVien();
        nv.setId(Integer.parseInt(txt_ID.getText()));
        nv.setTenNV(txt_TenNhanVien.getText());
        nv.setEmail(txt_Email.getText());
        nv.setSdt(txt_SDT.getText());
        nv.setDiaChi(txt_DiaChi.getText());
        if (cbx_GioiTinh.getSelectedItem() == "Nam") {
            nv.setGioiTinh(0);
        } else {
            nv.setGioiTinh(1);
        }

        SimpleDateFormat sdfm = new SimpleDateFormat("yyyy-MM-dd");
        nv.setNgaySinh(sdfm.format(dateCh_NgaySinh.getDate()));

        TaiKhoan tk = new TaiKhoan();
        tk.setTk(txt_Tk.getText());
        tk.setMk(txt_Mk.getText());
        nv.setTk(tk);

        ChucVu cv = new ChucVu();
        if (rdo_QuanLy.isSelected()) {
            cv.setId(1);
        } else {
            cv.setId(2);
        }
        nv.setCv(cv);

        return nv;
    }
    
    private TaiKhoan getTaiKhoan(){
        return new TaiKhoan(listTong.get(index).getTk().getId(),
                txt_Tk.getText(), txt_Mk.getText());
    }

    private boolean checkValidate() {
        if (txt_Tk.getText().isEmpty() || txt_DiaChi.getText().isEmpty() || txt_Email.getText().isEmpty()
                || txt_Mk.getText().isEmpty() || txt_SDT.getText().isEmpty() || txt_TenNhanVien.getText().isEmpty()) {
            return true;
        }
        return false;
    }

    public void clearForm() {
        String t = "";
        txtA_GhiChu.setText(t);
        txt_ID.setText(t);
        txt_DiaChi.setText(t);
        txt_Mk.setText(t);
        txt_Tk.setText(t);
        txt_SDT.setText(t);
        txt_TenNhanVien.setText(t);
    }

    private void mess(String mess) {
        JOptionPane.showMessageDialog(this, mess, "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
    }
}
