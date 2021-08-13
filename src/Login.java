import Koneksi.Server;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author XXxxXX
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }
    
    public void masukDatabase(){
        try {
            Connection conn = (Connection) Server.serverData();
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM pegawai WHERE nama_pegawai='"+tfUsername.getText()+"' AND password='"+tfPass.getText()+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(tfUsername.getText().equals(rs.getString("nama_pegawai")) && tfPass.getText().equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "LOGIN BERHASIL");
                    dispose();
                    frameutama fr = new frameutama();
                    fr.setVisible(true);
                }
            }else{
                    JOptionPane.showMessageDialog(null, "USERNAME ATAU PASSWORD SALAH");
                }
            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        gambar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        judul = new javax.swing.JLabel();
        txtUsername = new javax.swing.JLabel();
        txtPassword = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        tfPass = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        gambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/top-view-circular-food-frame.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gambar)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gambar)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        judul.setBackground(new java.awt.Color(255, 255, 255));
        judul.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        judul.setForeground(new java.awt.Color(255, 255, 255));
        judul.setText("xResto ");

        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setText("Username");

        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setText("Password");

        tfUsername.setBackground(new java.awt.Color(255, 255, 255));

        tfPass.setBackground(new java.awt.Color(255, 255, 255));

        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setForeground(new java.awt.Color(0, 0, 0));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Don't have an account?");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sign Up");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername)
                            .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPassword)
                                .addComponent(tfPass)
                                .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(judul)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(judul)
                .addGap(51, 51, 51)
                .addComponent(txtUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 0, 390, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        // TODO add your handling code here:
        
        dispose();
        Registrasi reg = new Registrasi();
        reg.setVisible(true);
    }//GEN-LAST:event_jLabel6MousePressed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        
        if (tfUsername.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "HARAP MASUKKAN USERNAME ANDA");
        }else
            if (tfPass.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "HARAP MASUKKAN PASSWORD ANDA");
            }else{
                masukDatabase();
            }
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      try
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
            SwingUtilities.updateComponentTreeUI(new frameutama());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error karena :"+e);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel gambar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel judul;
    private javax.swing.JPasswordField tfPass;
    private javax.swing.JTextField tfUsername;
    private javax.swing.JLabel txtPassword;
    private javax.swing.JLabel txtUsername;
    // End of variables declaration//GEN-END:variables
}
