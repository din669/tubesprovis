package Form;

import Koneksi.Server;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author XXxxXX
 */
public class FormPemesanan extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormPemesanan
     */
    public FormPemesanan() {
        initComponents();
        txtIdPelanggan.setVisible(false);
        selectMenu();
        setTotal();
        
    }

    public void inputDataPembeli(){
        try {
            Connection conn = (Connection) Server.serverData();
            Statement st = conn.createStatement();
            
            String sql = "INSERT INTO pembeli (nama_pembeli, no_telp) VALUES ('"+fNama.getText()+"', '"+tfTelp.getText()+"')";
            st.executeUpdate(sql);
            st.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void selectMenu(){
        try {
            Connection conn = (Connection) Server.serverData();
            Statement st = conn.createStatement();
            
            String sql = "SELECT nama_menu FROM menu ORDER BY jenis ASC";
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                Object[] ob = new Object[1];
                ob[0] = rs.getString("nama_menu");
                cbMenu.addItem((String) ob[0]);
            }
            st.close();
            rs.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void showSelectedMenu() {
        try {
            DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
            DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
            formatRp.setCurrencySymbol("Rp. ");
            formatRp.setMonetaryDecimalSeparator(',');
            formatRp.setGroupingSeparator('.');
            kursIndonesia.setDecimalFormatSymbols(formatRp);
            Connection conn = (Connection) Server.serverData();
            
            Statement st = conn.createStatement();
            String sql = "SELECT jenis, harga FROM menu WHERE nama_menu='"+cbMenu.getSelectedItem()+"'";
            
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                Object[] ob = new Object[2];
                ob[0] = rs.getString("jenis");
                ob[1] = rs.getString("harga");
                
                tfJenis.setText((String) ob[0]);
                tfHarga.setText(kursIndonesia.format(Integer.parseInt((String) ob[1])));
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void enterMenuTable(){
        int jumlah;
        int hargaJumlah=0;
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        String hargaMenu = null;
        String jumlahPesan = null;
        DefaultTableModel dataModel =(DefaultTableModel) tabelOutput.getModel();
        try {
            Connection conn = (Connection) Server.serverData();
            
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM menu WHERE nama_menu='"+cbMenu.getSelectedItem()+"'";
            
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                dataModel.addRow(new Object [] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    tfJumlah.getText(),
                });
            }
            int lengthRow = dataModel.getRowCount();
            for (int i=0;i<lengthRow;i++){
                jumlah = (Integer.parseInt(dataModel.getValueAt(i, 3).toString()))*(Integer.parseInt(dataModel.getValueAt(i, 4).toString()));
                hargaJumlah = hargaJumlah + jumlah;
            }
            tfTotal.setText(kursIndonesia.format(hargaJumlah));
            rs.close();
            st.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void setTotal(){
        tfTotal.setText("0");
    }
    
    public void resetAll(){
        DefaultTableModel dataModel =(DefaultTableModel) tabelOutput.getModel();
        int lengthRow = dataModel.getRowCount();
        for (int n=0; n<lengthRow; n++) {
            dataModel.removeRow(0); 
        }
        setTotal();
        fNama.setText("");
        tfTelp.setText("");
        tfJumlah.setText("");
        cbMenu.setSelectedIndex(0);
    }
    
    public void inputPesanan(){
        DefaultTableModel dataModel =(DefaultTableModel) tabelOutput.getModel();
        try {
            Connection conn = (Connection) Server.serverData();
            Statement st = conn.createStatement();
            int lengthRow = dataModel.getRowCount();
            for (int i=0;i<lengthRow;i++){
                int hargaJumlah = (Integer.parseInt(dataModel.getValueAt(i, 3).toString()))*(Integer.parseInt(dataModel.getValueAt(i, 4).toString()));
                String sql = "INSERT INTO pesanan (nama_pembeli, no_telp, id_menu, nama_menu, harga, total, hargatotal, id_pembeli, id_pegawai) VALUES ("
                        + "'"+fNama.getText()+"',"
                        + "'"+tfTelp.getText()+"',"
                        + "'"+dataModel.getValueAt(i, 0)+"',"
                        + "'"+dataModel.getValueAt(i, 1)+"',"
                        + "'"+dataModel.getValueAt(i, 3)+"',"
                        + "'"+dataModel.getValueAt(i, 4)+"',"
                        + "'"+hargaJumlah+"',"
                        + "'"+txtIdPelanggan.getText()+"',"
                        + "'1')";
                st.executeUpdate(sql);
            }
            JOptionPane.showMessageDialog(null, "PESANAN BERHASIL DIBUAT ");
            st.close();
            resetAll();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void showId(){
        try{
            Connection conn = (Connection) Server.serverData();
            
            Statement st = conn.createStatement();
            String sql = "SELECT id_pembeli FROM pembeli WHERE no_telp='"+tfTelp.getText()+"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Object[] ob = new Object[1];
                ob[0] = rs.getString("id_pembeli");
                txtIdPelanggan.setText((String) ob[0]);
            }
            rs.close();
            st.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNamaPesanan = new javax.swing.JLabel();
        txtNamaJenis = new javax.swing.JLabel();
        txtHarga = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JLabel();
        btnPesan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelOutput = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cbMenu = new javax.swing.JComboBox<>();
        tfTotal = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        fNama = new javax.swing.JTextField();
        tfJenis = new javax.swing.JTextField();
        tfHarga = new javax.swing.JTextField();
        tfJumlah = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tfTelp = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txtGambar = new javax.swing.JLabel();
        txtIdPelanggan = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(800, 500));

        txtNamaPesanan.setText("Nama Pesanan");

        txtNamaJenis.setText("Jenis");

        txtHarga.setText("Harga");

        txtJumlah.setText("Jumlah");

        btnPesan.setText("Pesan");
        btnPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesanActionPerformed(evt);
            }
        });

        tabelOutput.setBackground(new java.awt.Color(204, 204, 204));
        tabelOutput.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_Menu", "Nama Pesanan", "Jenis", "Harga", "Jumlah"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelOutput);

        jLabel5.setText("TOTAL  ");

        cbMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Menu" }));
        cbMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMenuActionPerformed(evt);
            }
        });

        tfTotal.setEditable(false);

        jButton2.setText("Buat Pesanan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Nama Pembeli");

        tfJenis.setEditable(false);

        tfHarga.setEditable(false);

        tfJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfJumlahKeyTyped(evt);
            }
        });

        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setText("No. Telp");

        tfTelp.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfTelp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTelpKeyTyped(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        txtGambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/aaaa.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtGambar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtGambar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPesan)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNamaPesanan)
                                    .addComponent(txtNamaJenis)
                                    .addComponent(txtHarga)
                                    .addComponent(txtJumlah))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfJenis, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(tfHarga)
                                    .addComponent(tfJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 99, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jButton2)
                        .addGap(69, 69, 69)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                                .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fNama, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(tfTelp))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdPelanggan)
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaPesanan)
                            .addComponent(cbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaJenis)
                            .addComponent(tfJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtHarga)
                                    .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtJumlah)
                                    .addComponent(tfJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tfTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPesan)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtIdPelanggan)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(fNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if ("0".equals(tfTotal.getText())){
            JOptionPane.showMessageDialog(null, "Pesan Menu Terlebih Dulu !");
        }else
        if (cbMenu.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Pilih Menu Terlebih Dulu !");
        }else
            if(tfJumlah.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Masukkan Jumlah Pesanan !");
            }else
                if (Integer.parseInt(tfJumlah.getText()) == 0 ){
                    JOptionPane.showMessageDialog(null, "Jumlah Pesanan Harus Diatas Nol !");
                }else
                    if (fNama.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Masukkan Nama Pemesan !");
                    }else
                        if (tfTelp.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Masukkan No.Telepon !");
                        }else {
                            inputDataPembeli();
                            showId();
                            inputPesanan();
                        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMenuActionPerformed
        // TODO add your handling code here:
        showSelectedMenu();
        if (cbMenu.getSelectedIndex() == 0) {
            tfJenis.setText("");
            tfHarga.setText("");
        }
    }//GEN-LAST:event_cbMenuActionPerformed

    private void btnPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesanActionPerformed
        // TODO add your handling code here:

        if (cbMenu.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Pilih Menu Terlebih Dulu !");
        }else 
            if(tfJumlah.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Masukkan Jumlah Pesanan !");
            }else{
                if(Integer.parseInt(tfJumlah.getText()) == 0 ){
                    JOptionPane.showMessageDialog(null, "Jumlah Pesanan Harus Diatas Nol !");
                }else
                    enterMenuTable();
            }
    
    }//GEN-LAST:event_btnPesanActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        resetAll();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tfTelpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelpKeyTyped
        // TODO add your handling code here:
        
        char karakter = evt.getKeyChar();
        if(!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE)))){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tfTelpKeyTyped

    private void tfJumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfJumlahKeyTyped
        // TODO add your handling code here:
        
        char karakter = evt.getKeyChar();
        if(!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE)))){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tfJumlahKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesan;
    private javax.swing.JComboBox<String> cbMenu;
    private javax.swing.JTextField fNama;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelOutput;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfJenis;
    private javax.swing.JTextField tfJumlah;
    private javax.swing.JTextField tfTelp;
    private javax.swing.JTextField tfTotal;
    private javax.swing.JLabel txtGambar;
    private javax.swing.JLabel txtHarga;
    private javax.swing.JLabel txtIdPelanggan;
    private javax.swing.JLabel txtJumlah;
    private javax.swing.JLabel txtNamaJenis;
    private javax.swing.JLabel txtNamaPesanan;
    // End of variables declaration//GEN-END:variables
}
