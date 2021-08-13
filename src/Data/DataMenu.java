package Data;

import Koneksi.Server;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author XXxxXX
 */
public class DataMenu extends javax.swing.JInternalFrame {

    /**
     * Creates new form DataMenu
     */
    public DataMenu() {
        initComponents();
        showMenu();
        idMenu.setVisible(false);
    }
    
    public void showMenu(){
        DefaultTableModel dataModel =(DefaultTableModel) tabelMenu.getModel();
        int lengthRow = dataModel.getRowCount();
        for (int n=0; n<lengthRow; n++) {
            dataModel.removeRow(0); 
        }
        try{
            Connection conn = (Connection) Server.serverData();
            Statement st = conn.createStatement();
            String sql = "SELECT id_menu, nama_menu, harga from menu ORDER BY id_menu ASC";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                dataModel.addRow(new Object [] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)
                });
            }
            rs.close();
            st.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void cariMenu(){
        DefaultTableModel dataModel =(DefaultTableModel) tabelMenu.getModel();
        int lengthRow = dataModel.getRowCount();
        for (int n=0; n<lengthRow; n++) {
            dataModel.removeRow(0); 
        }
        try{
            Connection conn = (Connection) Server.serverData();
            Statement st = conn.createStatement();
            String sql = "SELECT id_menu, nama_menu, harga from menu where nama_menu like '%"+tfCari.getText()+"%'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                dataModel.addRow(new Object [] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)
                });
            }
            rs.close();
            st.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    
    public void editMenu(){
        try{
            Connection conn = (Connection) Server.serverData();
            Statement st = conn.createStatement();
            String sql = "UPDATE menu SET nama_menu='"+tfNama.getText()+"', harga='"+tfHarga.getText()+"'"
                    + "WHERE id_menu='"+idMenu.getText()+"'";
            st.executeUpdate(sql);
            showMenu();
            JOptionPane.showMessageDialog(null, "EDIT MENU BERHASIL ");
            st.close();
        }catch ( Exception e){
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void hapusData(){
        try{
            Connection conn = (Connection) Server.serverData();
            Statement st = conn.createStatement();
            String sql = "DELETE FROM menu where id_menu='"+idMenu.getText()+"'";
            st.executeUpdate(sql);
            showMenu();
            JOptionPane.showMessageDialog(null, "MENU BERHASIL DIHAPUS");
            st.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void insertMenu(){
        try{
            Connection conn = (Connection) Server.serverData();
            Statement st = conn.createStatement();
            String sql = "INSERT INTO menu VALUES ('"+tfIdMenu.getText()+"','"+tfNamaMenu.getText()+"',"
                    + "'"+cbJenis.getSelectedItem()+"','"+tfHargaMenu.getText()+"')";
            st.executeUpdate(sql);
            st.close();
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DITAMBAHKAN");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    
    public void setClear(){
        tfIdMenu.setText("");
        tfNamaMenu.setText("");
        cbJenis.setSelectedIndex(0);
        tfHargaMenu.setText("");
    }
    
    public void clearField(){
        idMenu.setText("");
        tfNama.setText("");
        tfHarga.setText("");
        tfCari.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBody = new javax.swing.JPanel();
        panelSideMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JLabel();
        btnTambah = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        panelUtama = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        txtJudul = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMenu = new javax.swing.JTable();
        idMenu = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        tfNama = new javax.swing.JTextField();
        tfHarga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfCari = new javax.swing.JTextField();
        panelTambah = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfIdMenu = new javax.swing.JTextField();
        tfHargaMenu = new javax.swing.JTextField();
        tfNamaMenu = new javax.swing.JTextField();
        cbJenis = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        panelBody.setBackground(new java.awt.Color(204, 204, 204));

        panelSideMenu.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("xResto ");

        btnMenu.setBackground(new java.awt.Color(255, 255, 255));
        btnMenu.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Daftar Menu");
        btnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMenuMousePressed(evt);
            }
        });

        btnTambah.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah Menu");
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTambahMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelSideMenuLayout = new javax.swing.GroupLayout(panelSideMenu);
        panelSideMenu.setLayout(panelSideMenuLayout);
        panelSideMenuLayout.setHorizontalGroup(
            panelSideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSideMenuLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelSideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(panelSideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTambah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(44, Short.MAX_VALUE))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelSideMenuLayout.setVerticalGroup(
            panelSideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSideMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnMenu)
                .addGap(28, 28, 28)
                .addComponent(btnTambah)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelUtama.setBackground(new java.awt.Color(204, 204, 204));
        panelUtama.setLayout(new java.awt.CardLayout());

        panelMenu.setBackground(new java.awt.Color(204, 204, 204));

        txtJudul.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtJudul.setForeground(new java.awt.Color(51, 51, 51));
        txtJudul.setText("DAFTAR MENU ");

        tabelMenu.setBackground(new java.awt.Color(204, 204, 204));
        tabelMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Menu", "Nama Menu", "Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelMenuMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelMenu);

        idMenu.setForeground(new java.awt.Color(0, 0, 0));

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        tfNama.setBackground(new java.awt.Color(255, 255, 255));

        tfHarga.setBackground(new java.awt.Color(255, 255, 255));
        tfHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfHargaKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nama Menu");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Harga");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Masukkan Nama Menu Untuk Mencari");

        tfCari.setBackground(new java.awt.Color(255, 255, 255));
        tfCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCariActionPerformed(evt);
            }
        });
        tfCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCariKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMenuLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(54, 54, 54)
                                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4)
                            .addComponent(idMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit)
                        .addGap(36, 36, 36)
                        .addComponent(btnHapus)
                        .addGap(35, 35, 35))))
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(txtJudul))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfCari, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtJudul)
                .addGap(20, 20, 20)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit)
                            .addComponent(btnHapus))
                        .addGap(19, 19, 19))))
        );

        panelUtama.add(panelMenu, "card2");

        panelTambah.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("TAMBAH MENU");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Id Menu");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Nama Menu");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Jenis");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Harga");

        tfIdMenu.setBackground(new java.awt.Color(255, 255, 255));

        tfHargaMenu.setBackground(new java.awt.Color(255, 255, 255));
        tfHargaMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfHargaMenuKeyPressed(evt);
            }
        });

        tfNamaMenu.setBackground(new java.awt.Color(255, 255, 255));

        cbJenis.setBackground(new java.awt.Color(255, 255, 255));
        cbJenis.setForeground(new java.awt.Color(0, 0, 0));
        cbJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jenis", "Makanan", "Minuman" }));

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTambahLayout = new javax.swing.GroupLayout(panelTambah);
        panelTambah.setLayout(panelTambahLayout);
        panelTambahLayout.setHorizontalGroup(
            panelTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTambahLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(36, 36, 36)
                .addGroup(panelTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTambahLayout.createSequentialGroup()
                        .addComponent(tfIdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTambahLayout.createSequentialGroup()
                        .addComponent(tfNamaMenu)
                        .addGap(254, 254, 254))
                    .addGroup(panelTambahLayout.createSequentialGroup()
                        .addGroup(panelTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfHargaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panelTambahLayout.createSequentialGroup()
                .addGroup(panelTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTambahLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel5))
                    .addGroup(panelTambahLayout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jButton1)
                        .addGap(48, 48, 48)
                        .addComponent(jButton2)))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        panelTambahLayout.setVerticalGroup(
            panelTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTambahLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel5)
                .addGap(74, 74, 74)
                .addGroup(panelTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfIdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(tfNamaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfHargaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panelTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(212, Short.MAX_VALUE))
        );

        panelUtama.add(panelTambah, "card3");

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addComponent(panelSideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        
        if (idMenu.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harap Pilih Menu Yang Akan Diubah !");
        }else{
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Akan Mengubah Menu Ini ?", "KONFIRMASI", YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION)  {
                editMenu();
                clearField();
            }else{
                clearField();
                JOptionPane.showMessageDialog(null, "Menu Tidak Jadi Diubah");
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void tabelMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMenuMousePressed
        // TODO add your handling code here:
        
        int row = tabelMenu.rowAtPoint(evt.getPoint());
        idMenu.setText(tabelMenu.getValueAt(row, 0).toString());
        tfNama.setText(tabelMenu.getValueAt(row, 1).toString());
        tfHarga.setText(tabelMenu.getValueAt(row, 2).toString());
    }//GEN-LAST:event_tabelMenuMousePressed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        
        if (idMenu.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harap Pilih Menu Yang Akan Diubah !");
        }else{
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Akan Menghapus Menu Ini ?", "KONFIRMASI", YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION)  {
                hapusData();
                clearField();
            }else{
                clearField();
                JOptionPane.showMessageDialog(null, "Menu Tidak Jadi Dihapus");
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if (tfIdMenu.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Isi ID Terlebih Dulu !");
        }else 
            if (tfNamaMenu.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Isi Nama Menu Terlebih Dulu !");
            }else 
                if (cbJenis.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null, "Pilih Jenis Terlebih Dulu !");
                }else
                    if (tfHargaMenu.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Isi Harga Terlebih Dulu !");
                    }else{
                        insertMenu();
                        setClear();
                    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfHargaMenuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfHargaMenuKeyPressed
        // TODO add your handling code here:
        
        char karakter = evt.getKeyChar();
        if(!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE)))){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tfHargaMenuKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        setClear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMousePressed
        // TODO add your handling code here:
        
        panelUtama.removeAll();
        panelUtama.repaint();
        panelUtama.revalidate();
        panelUtama.add(panelMenu);
        showMenu();
        clearField();
    }//GEN-LAST:event_btnMenuMousePressed

    private void btnTambahMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMousePressed
        // TODO add your handling code here:
        
        panelUtama.removeAll();
        panelUtama.repaint();
        panelUtama.revalidate();
        panelUtama.add(panelTambah);
        setClear();
    }//GEN-LAST:event_btnTambahMousePressed

    private void tfHargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfHargaKeyPressed
        // TODO add your handling code here:
        
        char karakter = evt.getKeyChar();
        if(!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE)))){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tfHargaKeyPressed

    private void tfCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCariActionPerformed

    private void tfCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCariKeyPressed
        // TODO add your handling code here:
        
        
        if (!"".equals(tfCari.getText())) {
            cariMenu();
        } else {
            showMenu();
        }
    }//GEN-LAST:event_tfCariKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JLabel btnMenu;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JComboBox<String> cbJenis;
    private javax.swing.JLabel idMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelSideMenu;
    private javax.swing.JPanel panelTambah;
    private javax.swing.JPanel panelUtama;
    private javax.swing.JTable tabelMenu;
    private javax.swing.JTextField tfCari;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfHargaMenu;
    private javax.swing.JTextField tfIdMenu;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfNamaMenu;
    private javax.swing.JLabel txtJudul;
    // End of variables declaration//GEN-END:variables
}