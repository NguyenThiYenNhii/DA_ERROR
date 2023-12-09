
package poly.edu.view;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;
import javax.swing.JOptionPane;
import poly.edu.service.TaiKhoan_Respository;

public class DoiMatKhau extends javax.swing.JFrame {
    
    private int code = 0;
    private final TaiKhoan_Respository tkr = new TaiKhoan_Respository();
    
    public DoiMatKhau() {
        initComponents();
        setLocationRelativeTo(null);
        this.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_Email = new javax.swing.JTextField();
        jLable5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLable3 = new javax.swing.JLabel();
        pwp_NLMK = new javax.swing.JPasswordField();
        pwp_MKM = new javax.swing.JPasswordField();
        btn_QuenMatKhau = new javax.swing.JButton();
        btn_LayCode = new javax.swing.JButton();
        txt_Code = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(51, 150, 207));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quay lại đăng nhập");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 210, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Email");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txt_Email.setBackground(new java.awt.Color(156, 207, 238));
        txt_Email.setForeground(new java.awt.Color(255, 255, 255));
        txt_Email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel5.add(txt_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 190, 30));

        jLable5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLable5.setForeground(new java.awt.Color(255, 255, 255));
        jLable5.setText("Code");
        jPanel5.add(jLable5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mật khẩu mới");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLable3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLable3.setForeground(new java.awt.Color(255, 255, 255));
        jLable3.setText("Nhập lại mật khẩu");
        jPanel5.add(jLable3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        pwp_NLMK.setBackground(new java.awt.Color(156, 207, 238));
        pwp_NLMK.setForeground(new java.awt.Color(255, 255, 255));
        pwp_NLMK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel5.add(pwp_NLMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 190, 30));

        pwp_MKM.setBackground(new java.awt.Color(156, 207, 238));
        pwp_MKM.setForeground(new java.awt.Color(255, 255, 255));
        pwp_MKM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel5.add(pwp_MKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 190, 30));

        btn_QuenMatKhau.setBackground(new java.awt.Color(156, 207, 238));
        btn_QuenMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btn_QuenMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        btn_QuenMatKhau.setText("Đổi mật khẩu");
        btn_QuenMatKhau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btn_QuenMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QuenMatKhauActionPerformed(evt);
            }
        });
        jPanel5.add(btn_QuenMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 90, 30));

        btn_LayCode.setBackground(new java.awt.Color(156, 207, 238));
        btn_LayCode.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btn_LayCode.setForeground(new java.awt.Color(255, 255, 255));
        btn_LayCode.setText("Lấy Code");
        btn_LayCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btn_LayCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LayCodeActionPerformed(evt);
            }
        });
        jPanel5.add(btn_LayCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 90, 30));

        txt_Code.setBackground(new java.awt.Color(156, 207, 238));
        txt_Code.setForeground(new java.awt.Color(255, 255, 255));
        txt_Code.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel5.add(txt_Code, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 190, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CHANGE PASS");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LayCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LayCodeActionPerformed
        // TODO add your handling code here:
        if(txt_Email.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập email", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        final String username = "emailtestduan1@gmail.com";
        final String password = "frfl slfs kayw yeeg";
        
        Random random = new Random();
        code = random.nextInt(1000000);
        
        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("huyenthoairunetera@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(txt_Email.getText())
            );
            message.setSubject("Code Quên Mật Khẩu");
            message.setText("" + code);

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_LayCodeActionPerformed

    private void btn_QuenMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QuenMatKhauActionPerformed
        // TODO add your handling code here:
        if(checkValidate() == false){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ dữ liệu", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        String pass = new String(pwp_MKM.getPassword()).trim();
        String passReturn = new String(pwp_NLMK.getPassword()).trim();
        
        if(equalsPass(pass,passReturn) == false){
            JOptionPane.showMessageDialog(this, "Mật khẩu không trùng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int codecheck = Integer.parseInt(txt_Code.getText());
        
        if(codecheck != code){
            JOptionPane.showMessageDialog(this, "Code nhập không chính xác","Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(tkr.quenMK(txt_Email.getText(), pass) != null){
            JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            clearFrom();
        }
        else 
            JOptionPane.showMessageDialog(this, "Đổi mật khẩu thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_QuenMatKhauActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        this.dispose();
        new View_Login().setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoiMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LayCode;
    private javax.swing.JButton btn_QuenMatKhau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLable3;
    private javax.swing.JLabel jLable5;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField pwp_MKM;
    private javax.swing.JPasswordField pwp_NLMK;
    private javax.swing.JTextField txt_Code;
    private javax.swing.JTextField txt_Email;
    // End of variables declaration//GEN-END:variables
    
    private boolean checkValidate(){
        if(txt_Email.getText().isEmpty())
            return false;
        if(jLable5.getText().isEmpty())
            return false;
        if(new String(pwp_MKM.getPassword()).trim().equals(""))
            return false;
        if(new String(pwp_NLMK.getPassword()).trim().equals(""))
            return false;
        return true;
    }
    
    private boolean equalsPass(String pass, String passReturn){
        if(!pass.equals(passReturn))
            return false;    
        return true;
    }
    
    private void clearFrom(){
        jLable5.setText("");
        txt_Email.setText("");
        pwp_NLMK.setText("");
        pwp_MKM.setText("");
    }
}
