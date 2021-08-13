import Data.DataMenu;
import Data.DataPegawai;
import Data.DataPelanggan;
import Data.DataPesanan;
import Data.LaporanKeuangan;
import Form.FormPembayaran;
import Form.FormPemesanan;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;


public class frameutama extends javax.swing.JFrame {

    /**
     * Creates new form frameutama
     */
    public frameutama() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("Image/Resto.jpg"));
        Image img = icon.getImage();
        panelUtama = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g) {
                g.drawImage(img ,0 ,0 ,getWidth(), getHeight(), this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        menuService = new javax.swing.JMenu();
        menuPemesanan = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuPembayaran = new javax.swing.JMenuItem();
        menuData = new javax.swing.JMenu();
        kelolaMenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        kelolaPelanggan = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        kelolaPegawai = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        kelolaPesanan = new javax.swing.JMenuItem();
        menuKeuangan = new javax.swing.JMenu();
        menuLaporan = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelUtama.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelUtama.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panelUtamaLayout = new javax.swing.GroupLayout(panelUtama);
        panelUtama.setLayout(panelUtamaLayout);
        panelUtamaLayout.setHorizontalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1151, Short.MAX_VALUE)
        );
        panelUtamaLayout.setVerticalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1266, Short.MAX_VALUE)
        );

        menuService.setText("Our Service");
        menuService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuServiceActionPerformed(evt);
            }
        });

        menuPemesanan.setText("Pemesanan");
        menuPemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPemesananActionPerformed(evt);
            }
        });
        menuService.add(menuPemesanan);
        menuService.add(jSeparator1);

        menuPembayaran.setText("Pembayaran");
        menuPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPembayaranActionPerformed(evt);
            }
        });
        menuService.add(menuPembayaran);

        jMenuBar1.add(menuService);

        menuData.setText("Data");

        kelolaMenu.setText("Data Menu");
        kelolaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelolaMenuActionPerformed(evt);
            }
        });
        menuData.add(kelolaMenu);
        menuData.add(jSeparator2);

        kelolaPelanggan.setText("Data Pembeli");
        kelolaPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelolaPelangganActionPerformed(evt);
            }
        });
        menuData.add(kelolaPelanggan);
        menuData.add(jSeparator3);

        kelolaPegawai.setText("Data Pegawai");
        kelolaPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelolaPegawaiActionPerformed(evt);
            }
        });
        menuData.add(kelolaPegawai);
        menuData.add(jSeparator4);

        kelolaPesanan.setText("Data Pesanan");
        kelolaPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelolaPesananActionPerformed(evt);
            }
        });
        menuData.add(kelolaPesanan);

        jMenuBar1.add(menuData);

        menuKeuangan.setText("Keuangan");
        menuKeuangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKeuanganActionPerformed(evt);
            }
        });

        menuLaporan.setText("Laporan");
        menuLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLaporanActionPerformed(evt);
            }
        });
        menuKeuangan.add(menuLaporan);

        jMenuBar1.add(menuKeuangan);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUtama)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUtama)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuPemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPemesananActionPerformed
        // TODO add your handling code here:
        
        panelUtama.removeAll();
        panelUtama.repaint();
        
        FormPemesanan formPemesanan = new FormPemesanan();
        Dimension layarUtama = this.getSize();
        Dimension layarFormPemesanan = formPemesanan.getSize();
        formPemesanan.setLocation(layarUtama.width/2-layarFormPemesanan.width/2, layarUtama.height/2-layarFormPemesanan.height/2);
        
        panelUtama.add(formPemesanan);
        formPemesanan.setVisible(true);
        formPemesanan.setClosable(true);
        
    }//GEN-LAST:event_menuPemesananActionPerformed

    private void menuPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPembayaranActionPerformed
        // TODO add your handling code here:
        
        panelUtama.removeAll();
        panelUtama.repaint();
        
        FormPembayaran formPembayaran = new FormPembayaran();
        Dimension layarUtama = this.getSize();
        Dimension layarFormPembayaran = formPembayaran.getSize();
        formPembayaran.setLocation(layarUtama.width/2-layarFormPembayaran.width/2, layarUtama.height/2-layarFormPembayaran.height/2);
        
        panelUtama.add(formPembayaran);
        formPembayaran.setVisible(true);
        formPembayaran.setClosable(true);
    }//GEN-LAST:event_menuPembayaranActionPerformed

    private void menuServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuServiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuServiceActionPerformed

    private void kelolaPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelolaPesananActionPerformed
        // TODO add your handling code here:
        
        panelUtama.removeAll();
        panelUtama.repaint();
        
        DataPesanan dataPesan = new DataPesanan();
        Dimension layarUtama = this.getSize();
        Dimension layarFormPembayaran = dataPesan.getSize();
        dataPesan.setLocation(layarUtama.width/2-layarFormPembayaran.width/2, layarUtama.height/2-layarFormPembayaran.height/2);
        
        panelUtama.add(dataPesan);
        dataPesan.setVisible(true);
        dataPesan.setClosable(true);
    }//GEN-LAST:event_kelolaPesananActionPerformed

    private void kelolaPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelolaPegawaiActionPerformed
        // TODO add your handling code here:
        
        panelUtama.removeAll();
        panelUtama.repaint();
        
        DataPegawai dataPegawai = new DataPegawai();
        Dimension layarUtama = this.getSize();
        Dimension layarFormPembayaran = dataPegawai.getSize();
        dataPegawai.setLocation(layarUtama.width/2-layarFormPembayaran.width/2, layarUtama.height/2-layarFormPembayaran.height/2);
        
        panelUtama.add(dataPegawai);
        dataPegawai.setVisible(true);
        dataPegawai.setClosable(true);
    }//GEN-LAST:event_kelolaPegawaiActionPerformed

    private void kelolaPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelolaPelangganActionPerformed
        // TODO add your handling code here:
        
        panelUtama.removeAll();
        panelUtama.repaint();
        
        DataPelanggan dataPelanggan = new DataPelanggan();
        Dimension layarUtama = this.getSize();
        Dimension layarFormPembayaran = dataPelanggan.getSize();
        dataPelanggan.setLocation(layarUtama.width/2-layarFormPembayaran.width/2, layarUtama.height/2-layarFormPembayaran.height/2);
        
        panelUtama.add(dataPelanggan);
        dataPelanggan.setVisible(true);
        dataPelanggan.setClosable(true);
    }//GEN-LAST:event_kelolaPelangganActionPerformed

    private void kelolaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelolaMenuActionPerformed
        // TODO add your handling code here:
        
        panelUtama.removeAll();
        panelUtama.repaint();
        
        DataMenu dataMenu = new DataMenu();
        Dimension layarUtama = this.getSize();
        Dimension layarFormPembayaran = dataMenu.getSize();
        dataMenu.setLocation(layarUtama.width/2-layarFormPembayaran.width/2, layarUtama.height/2-layarFormPembayaran.height/2);
        
        panelUtama.add(dataMenu);
        dataMenu.setVisible(true);
        dataMenu.setClosable(true);
    }//GEN-LAST:event_kelolaMenuActionPerformed

    private void menuLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLaporanActionPerformed
        // TODO add your handling code here:
        
        panelUtama.removeAll();
        panelUtama.repaint();
        
        LaporanKeuangan laporanKeuangan = new LaporanKeuangan();
        Dimension layarUtama = this.getSize();
        Dimension layarFormPembayaran = laporanKeuangan.getSize();
        laporanKeuangan.setLocation(layarUtama.width/2-layarFormPembayaran.width/2, layarUtama.height/2-layarFormPembayaran.height/2);
        
        panelUtama.add(laporanKeuangan);
        laporanKeuangan.setVisible(true);
        laporanKeuangan.setClosable(true);
    }//GEN-LAST:event_menuLaporanActionPerformed

    private void menuKeuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKeuanganActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_menuKeuanganActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JMenuItem kelolaMenu;
    private javax.swing.JMenuItem kelolaPegawai;
    private javax.swing.JMenuItem kelolaPelanggan;
    private javax.swing.JMenuItem kelolaPesanan;
    private javax.swing.JMenu menuData;
    private javax.swing.JMenu menuKeuangan;
    private javax.swing.JMenuItem menuLaporan;
    private javax.swing.JMenuItem menuPembayaran;
    private javax.swing.JMenuItem menuPemesanan;
    private javax.swing.JMenu menuService;
    private javax.swing.JDesktopPane panelUtama;
    // End of variables declaration//GEN-END:variables
}
