package Form;

import Koneksi.Server;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author XXxxXX
 */
public class FormPembayaran extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormPembayaran
     */
    public FormPembayaran() {
        initComponents();
        selectData();
        setV(false);
    }
    
    public void selectData(){
        try {
            Connection conn = (Connection) Server.serverData();
            Statement st = conn.createStatement();
            
            String sql = "SELECT id_pembeli FROM pesanan ORDER BY id_pembeli ASC";
            ResultSet rs = st.executeQuery(sql);
            
            
            while (rs.next()){
                Object[] ob = new Object[1];
                ob[0] = rs.getString("id_pembeli");
                cbData.addItem((String) ob[0]);
            }
            st.close();
            rs.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void showSelectedData() {
        try {
            DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
            DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
            formatRp.setCurrencySymbol("Rp. ");
            formatRp.setMonetaryDecimalSeparator(',');
            formatRp.setGroupingSeparator('.');
            kursIndonesia.setDecimalFormatSymbols(formatRp);
            Connection conn = (Connection) Server.serverData();
            
            Statement st = conn.createStatement();
            String sql = "SELECT id_pesanan, nama_pembeli, id_menu, nama_menu, harga, total, hargatotal "
                    + "FROM pesanan WHERE id_pembeli='"+cbData.getSelectedItem()+"'";
            
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                Object[] ob = new Object[7];
                ob[0] = rs.getString("nama_pembeli");
                ob[1] = rs.getString("nama_menu");
                ob[2] = rs.getString("harga");
                ob[3] = rs.getString("total");
                ob[4] = rs.getString("hargatotal");
                ob[5] = rs.getString("id_menu");
                ob[6] = rs.getString("id_pesanan");
                
                tfId.setText((String) ob[0]);
                tfPesanan.setText((String) ob[1]);
                tfHarga.setText(kursIndonesia.format(Integer.parseInt((String) ob[2])));
                hargaPesanan.setText((String) ob[2]);
                tfTotal.setText((String) ob[3]);
                tfHargaTotal.setText(kursIndonesia.format(Integer.parseInt((String) ob[4])));
                hargaTotal.setText((String) ob[4]);
                idMenu.setText((String) ob[5]);
                idPesanan.setText((String) ob[6]);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void hapusData(){
        try{
            Connection conn = (Connection) Server.serverData();
            Statement st = conn.createStatement();
            String sql = "DELETE FROM pesanan where id_pembeli='"+cbData.getSelectedItem()+"'";
            st.executeUpdate(sql);
            st.close();
            cbData.removeAllItems();
            cbData.addItem("Pilih Nama Pembeli");
            cbData.setSelectedIndex(0);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void insertLaporan(){
        try{
            Connection conn = (Connection) Server.serverData();
            Statement st = conn.createStatement();
            String sql = "INSERT INTO laporan (id_pesanan, id_menu, nama_menu, harga, total, hargatotal) VALUES"
                    + "('"+idPesanan.getText()+"','"+idMenu.getText()+"', '"+tfPesanan.getText()+"', '"+hargaPesanan.getText()+"',"
                    + "'"+tfTotal.getText()+"', '"+hargaTotal.getText()+"')";
            st.executeUpdate(sql);
            st.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    } 
    
    public void cetakData(){
        try {
            Connection conn = (Connection) Server.serverData();
            HashMap param = new HashMap();
            param.put("id", cbData.getSelectedItem());
            
            InputStream file = getClass().getResourceAsStream("/Form/cetak_bukti.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn);
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void setV(boolean b){
        idMenu.setVisible(b);
        hargaTotal.setVisible(b);
        hargaPesanan.setVisible(b);
        idPesanan.setVisible(b);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtJudul = new javax.swing.JLabel();
        txtIdPemesan = new javax.swing.JLabel();
        cbData = new javax.swing.JComboBox<>();
        txtNamaPembeli = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        txtPesanan = new javax.swing.JLabel();
        txtHargaPesanan = new javax.swing.JLabel();
        txtQty = new javax.swing.JLabel();
        txtTotalHarga = new javax.swing.JLabel();
        tfPesanan = new javax.swing.JTextField();
        tfHarga = new javax.swing.JTextField();
        tfTotal = new javax.swing.JTextField();
        tfHargaTotal = new javax.swing.JTextField();
        btnBayar = new javax.swing.JButton();
        idMenu = new javax.swing.JLabel();
        hargaTotal = new javax.swing.JLabel();
        hargaPesanan = new javax.swing.JLabel();
        idPesanan = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        txtJudul.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        txtJudul.setText("PEMBAYARAN");

        txtIdPemesan.setText("Silahkan Pilih Id");

        cbData.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Id Pembeli" }));
        cbData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDataActionPerformed(evt);
            }
        });

        txtNamaPembeli.setText("Nama Pembeli");

        tfId.setEditable(false);

        txtPesanan.setText("Pesanan");

        txtHargaPesanan.setText("Harga Pesanan");

        txtQty.setText("Total Pesan");

        txtTotalHarga.setText("Total Harga");

        tfPesanan.setEditable(false);

        tfHarga.setEditable(false);

        tfTotal.setEditable(false);

        tfHargaTotal.setEditable(false);

        btnBayar.setText("BAYAR");
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(hargaPesanan)
                        .addGap(105, 105, 105))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdPemesan)
                                    .addComponent(txtNamaPembeli)
                                    .addComponent(txtPesanan)
                                    .addComponent(txtHargaPesanan)
                                    .addComponent(txtQty)
                                    .addComponent(txtTotalHarga)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(idPesanan)))
                        .addGap(33, 33, 33)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbData, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfId, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfHargaTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(tfHarga, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfPesanan, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(197, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBayar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idMenu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hargaTotal)
                        .addGap(106, 106, 106))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtJudul)
                .addGap(224, 224, 224))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtJudul)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdPemesan)
                    .addComponent(cbData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaPembeli)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesanan)
                    .addComponent(tfPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHargaPesanan)
                    .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQty)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalHarga)
                    .addComponent(tfHargaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBayar)
                    .addComponent(idMenu)
                    .addComponent(hargaTotal)
                    .addComponent(hargaPesanan))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(idPesanan)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        // TODO add your handling code here:
        if (cbData.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "PILIH ID PELANGGAN TERLEBIH DULU !");
        }else{
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda Akan Mencetak Bukti Pembayaran ?", "KONFIRMASI", YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION)  {
            insertLaporan();
            cetakData();
            hapusData();
            selectData();
        }else
            if (confirm == JOptionPane.NO_OPTION){
                insertLaporan();
                hapusData();
                selectData();
                JOptionPane.showMessageDialog(null, "Bukti Pembayaran Tidak Dicetak");
            }else{
                JOptionPane.showMessageDialog(null, "Pembayaran Gagal");      
            }
        }
    }//GEN-LAST:event_btnBayarActionPerformed

    private void cbDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDataActionPerformed
        // TODO add your handling code here:
        
        showSelectedData();
        if (cbData.getSelectedIndex() == 0) {
            tfId.setText("");
            tfPesanan.setText("");
            tfHarga.setText("");
            tfTotal.setText("");
            tfHargaTotal.setText("");
            idMenu.setText("");
            hargaTotal.setText("");
            hargaPesanan.setText("");
        }
    }//GEN-LAST:event_cbDataActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBayar;
    private javax.swing.JComboBox<String> cbData;
    private javax.swing.JLabel hargaPesanan;
    private javax.swing.JLabel hargaTotal;
    private javax.swing.JLabel idMenu;
    private javax.swing.JLabel idPesanan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfHargaTotal;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfPesanan;
    private javax.swing.JTextField tfTotal;
    private javax.swing.JLabel txtHargaPesanan;
    private javax.swing.JLabel txtIdPemesan;
    private javax.swing.JLabel txtJudul;
    private javax.swing.JLabel txtNamaPembeli;
    private javax.swing.JLabel txtPesanan;
    private javax.swing.JLabel txtQty;
    private javax.swing.JLabel txtTotalHarga;
    // End of variables declaration//GEN-END:variables
}
