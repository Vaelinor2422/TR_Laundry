/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package laundry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class Transaksi extends javax.swing.JFrame {
 Connection con;
 Statement stat;
 ResultSet rs;
 String sql;
    /**
     * Creates new form Customer
     */
    public Transaksi() {
        initComponents();
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        tampilkan();
         cmblayanan();
         cmbbarang();
         cmbadmin();
         tampilkan();
         GetDataBarang();
         GetDataLayanan();
    }

    public void cmblayanan(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/tbs_laundry", "root", "");
            stat = con.createStatement();
            String sql = "SELECT * FROM tb_laundry";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                cmblayanan.addItem(rs.getString("nama_layanan"));
            }
        }catch(Exception e){
            
        }
    
    }
    
    public void cmbbarang(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/tbs_laundry", "root", "");
            stat = con.createStatement();
            String sql = "SELECT * FROM tb_barang";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                cmbbarang.addItem(rs.getString("nama_barang"));
            }
        }catch(Exception e){
            
        }
    }
    
    public void cmbadmin(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/tbs_laundry", "root", "");
            stat = con.createStatement();
            String sql = "SELECT * FROM tb_admin";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                cmbadmin.addItem(rs.getString("id_admin"));
            }
        }catch(Exception e){
            
        }
    }
    
    public void kosong(){
         txtIdTransaksi.setText("");
         txtIdCustomer.setText("");
         cmbadmin.setSelectedItem("PILIH ADMIN");
         cmbbarang.setSelectedItem("PILIH BARANG");
         cmblayanan.setSelectedItem("PILIH LAYANAN");
         txtTanggalKeluar.setText("");
         txtTanggalMasuk.setText("");
         txtKuantitasBarang.setText("");
         txtTotalBeratBarang.setText("");
         txtTotalBiaya.setText("");
         
     }
    
     /*Setiap metode yang dibuat untuk  melakukan koneksi ke database, 
     melakukan query untuk mengambil data, dan memasukkan data ke dalam combobox menggunakan perulangan while.*/
     public void GetDataBarang(){
         DefaultTableModel model = new DefaultTableModel();
         
         try {
             stat = con.createStatement();
             rs = stat.executeQuery("SELECT * FROM tb_barang");
             
             
             model.addColumn("Nama Barang");
             model.addColumn("Harga Barang");
            
             
             
             model.getDataVector().removeAllElements();
             model.fireTableDataChanged();
             model.setRowCount(0);
             
             while (rs.next()) {
                 Object[] data = {
                  rs.getString("nama_barang"),
                  rs.getString("harga_barang"),
                  
                 };
                 model.addRow(data);
                 tbbarang.setModel(model);
             }
         } catch (Exception e) {
         }
     
     }
    
    
    
    
    
    
     public void GetDataLayanan(){
         DefaultTableModel model = new DefaultTableModel();
         
         try {
             stat = con.createStatement();
             rs = stat.executeQuery("SELECT * FROM tb_laundry");
             
             
             model.addColumn("Nama Layanan");
             model.addColumn("Biaya Layanan Per Kg");
            
             
             
             model.getDataVector().removeAllElements();
             model.fireTableDataChanged();
             model.setRowCount(0);
             
             while (rs.next()) {
                 Object[] data = {
                     rs.getString("nama_layanan"),
                  rs.getString("biaya_layanan_perkg"),
                                   };
                 model.addRow(data);
                 tb_layanan.setModel(model);
             }
         } catch (Exception e) {
         }
     
     }
    public void tampilkan(){
         DefaultTableModel model = new DefaultTableModel();
         
         try {
             stat = con.createStatement();
             rs = stat.executeQuery("SELECT * FROM tb_transaksi");
             
             
             model.addColumn("Id Transaksi");
             model.addColumn("Tanggal Masuk");
             model.addColumn("Tanggal Keluar");
             model.addColumn("Total Berat Barang");
             model.addColumn("Total Kuantitas Barang");
             model.addColumn("Total Biaya");
             model.addColumn("Id Admin");
             model.addColumn("Id Customer");
             model.addColumn("Nama Layanan");
             model.addColumn("Nama Barang");
             
             
             model.getDataVector().removeAllElements();
             model.fireTableDataChanged();
             model.setRowCount(0);
             
             while (rs.next()) {
                 Object[] data = {
                  rs.getString("id_Transaksi"),
                  rs.getString("tanggal_masuk"),
                  rs.getString("tanggal_keluar"),
                  rs.getString("total_berat_barang"),
                  rs.getString("total_kuantitas_barang"),
                  rs.getString("total_biaya"),
                  rs.getString("id_admin"),
                  rs.getString("id_customer"),
                  rs.getString("nama_layanan"),
                  rs.getString("nama_barang"),
                 };
                 model.addRow(data);
                 tbTransaksi.setModel(model);
             }
         } catch (Exception e) {
         }
     
     }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel27 = new javax.swing.JLabel();
        txtTanggalKeluar1 = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jLabel4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtIdTransaksi = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        txtTanggalMasuk = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        txtTanggalKeluar = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTransaksi = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txtIdCustomer = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        txtTotalBiaya = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        txtTotalBeratBarang = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        cmblayanan = new javax.swing.JComboBox<>();
        cmbbarang = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        cmbadmin = new javax.swing.JComboBox<>();
        txtKuantitasBarang = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_layanan = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbbarang = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnLog = new javax.swing.JButton();

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel27.setText("Tanggal Keluar");

        txtTanggalKeluar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTanggalKeluar1.setForeground(new java.awt.Color(51, 51, 51));
        txtTanggalKeluar1.setBorder(null);

        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(8, 155, 171));
        jPanel1.setInheritsPopupMenu(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(8, 155, 171));
        jLabel4.setText("Transaksi");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel17.setText("Id Transaksi");

        txtIdTransaksi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtIdTransaksi.setForeground(new java.awt.Color(51, 51, 51));
        txtIdTransaksi.setBorder(null);
        txtIdTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdTransaksiActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel18.setText("Tanggal Masuk");

        txtTanggalMasuk.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTanggalMasuk.setForeground(new java.awt.Color(51, 51, 51));
        txtTanggalMasuk.setBorder(null);

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel21.setText("Tanggal Keluar");

        txtTanggalKeluar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTanggalKeluar.setForeground(new java.awt.Color(51, 51, 51));
        txtTanggalKeluar.setBorder(null);

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel19.setText("Nama Layanan");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCari.setForeground(new java.awt.Color(51, 51, 51));
        txtCari.setBorder(null);

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel22.setText("Cari");

        btnSearch.setText("Search");

        tbTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTransaksi);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel20.setText("Id Admin");

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtIdCustomer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtIdCustomer.setForeground(new java.awt.Color(51, 51, 51));
        txtIdCustomer.setBorder(null);
        txtIdCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCustomerActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel23.setText("Id Customer");

        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtTotalBiaya.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTotalBiaya.setForeground(new java.awt.Color(51, 51, 51));
        txtTotalBiaya.setBorder(null);
        txtTotalBiaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalBiayaActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel24.setText("Total Biaya");

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtTotalBeratBarang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTotalBeratBarang.setForeground(new java.awt.Color(51, 51, 51));
        txtTotalBeratBarang.setBorder(null);
        txtTotalBeratBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalBeratBarangActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel25.setText("Total Berat Barang");

        cmblayanan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH LAYANAN" }));
        cmblayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmblayananActionPerformed(evt);
            }
        });

        cmbbarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH BARANG" }));
        cmbbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbarangActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel26.setText("Nama Barang");

        cmbadmin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH ADMIN" }));

        txtKuantitasBarang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtKuantitasBarang.setForeground(new java.awt.Color(51, 51, 51));
        txtKuantitasBarang.setBorder(null);
        txtKuantitasBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKuantitasBarangActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel28.setText("Kuantitas Barang");

        jSeparator12.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        tb_layanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tb_layanan);

        tbbarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tbbarang);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 204, 255));
        jLabel6.setText("Daftar Barang");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 204, 255));
        jLabel7.setText("Daftar Layanan");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmblayanan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(42, 42, 42)
                        .addComponent(btnUpdate)
                        .addGap(41, 41, 41)
                        .addComponent(btnDelete))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel22)
                            .addComponent(txtCari)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(btnSearch))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                .addComponent(txtTotalBeratBarang, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24)
                            .addComponent(txtTotalBiaya, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(jSeparator9)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtIdTransaksi, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel26)
                                        .addComponent(cmbbarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTanggalKeluar)
                                        .addComponent(jSeparator6))
                                    .addComponent(jLabel23)
                                    .addComponent(txtIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel18)
                            .addComponent(txtTanggalMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(cmbadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtKuantitasBarang)
                                    .addComponent(jSeparator12))
                                .addGap(25, 25, 25)))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 348, Short.MAX_VALUE)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(275, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(50, 50, 50))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(419, 419, 419)
                                .addComponent(jLabel1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(495, 495, 495)
                                .addComponent(jLabel5)))
                        .addGap(0, 707, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(96, 96, 96)
                                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel4)
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIdTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(32, 32, 32)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel26)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmblayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel21))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTanggalMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTanggalKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTotalBeratBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTotalBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(16, 16, 16)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208)
                        .addComponent(jLabel5)
                        .addGap(725, 725, 725)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(8, 8, 8)
                        .addComponent(txtKuantitasBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_home.png"))); // NOI18N
        jLabel2.setText(" Dashboard");
        jLabel2.setToolTipText("");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_laundry.png"))); // NOI18N

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/customer_icon.png"))); // NOI18N
        jLabel9.setText(" Customer");
        jLabel9.setToolTipText("");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transaksi_icon.png"))); // NOI18N
        jLabel10.setText("Transaksi");
        jLabel10.setToolTipText("");

        jSeparator2.setBackground(new java.awt.Color(102, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(102, 255, 255));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barang_icon.png"))); // NOI18N
        jLabel8.setText("Report");
        jLabel8.setToolTipText("");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barang_icon.png"))); // NOI18N
        jLabel11.setText("Report");
        jLabel11.setToolTipText("");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        btnLog.setText("Log Out");
        btnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnLog)
                .addContainerGap(1273, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(637, 637, 637)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(637, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLog)
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(400, 400, 400)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(389, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        new Dasboard().show();
        this.dispose();  
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        new Customer().show();
        this.dispose();  
    }//GEN-LAST:event_jLabel9MouseClicked

    private void cmbbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbarangActionPerformed

    private void cmblayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmblayananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmblayananActionPerformed

    private void txtTotalBeratBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalBeratBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalBeratBarangActionPerformed

    private void txtTotalBiayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalBiayaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalBiayaActionPerformed

    private void txtIdCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCustomerActionPerformed

    private void txtIdTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdTransaksiActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        try {
            stat = con.createStatement();
            //Notifikasi bila data kosong 
            if (txtIdCustomer.getText().equals("") ||
                    txtIdTransaksi.getText().equals("") ||
                    cmbadmin.getSelectedItem().equals("") ||
                    cmblayanan.getSelectedItem().equals("") ||
                    cmbbarang.getSelectedItem().equals("") ||
                     txtTanggalMasuk.getText().equals("") ||
                     txtTanggalKeluar.getText().equals("") ||
                     txtKuantitasBarang.getText().equals("") ||
                     txtTotalBeratBarang.getText().equals("") ||
                     txtTotalBiaya.getText().equals(""))  {
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");                   
            } 
            if (btnSave.getText() == "Save") {
                String cek = "SELECT * FROM tb_transaksi WHERE id_transaksi= '" + txtIdTransaksi.getText() + "'";
                rs = stat.executeQuery(cek);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "ID Transaksi Sudah Ada");
                }else{
                    String sql = "INSERT INTO tb_transaksi VALUES ('" + txtIdTransaksi.getText() + 
                            "','" + txtTanggalMasuk.getText() +
                            "','" + txtTanggalKeluar.getText()+
                            "','" + txtTotalBeratBarang.getText()+
                            "','" + txtKuantitasBarang.getText()+
                            "','" + txtTotalBiaya.getText()+
                            "','" + cmbadmin.getSelectedItem()+
                            "','" + txtIdCustomer.getText()+
                            "','" + cmblayanan.getSelectedItem()+
                            "','" + cmbbarang.getSelectedItem()+ "')";
                    stat.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Simpan Data Berhasil");
                    tampilkan();
                    kosong();
                }
            }
        } catch (Exception e) {
            kosong();
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtKuantitasBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKuantitasBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKuantitasBarangActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            String sql = "UPDATE tb_transaksi SET tanggal_masuk = '" + txtTanggalMasuk.getText() +
                            "', tanggal_keluar ='" + txtTanggalKeluar.getText()+
                            "', total_berat_barang = '" + txtTotalBeratBarang.getText()+
                            "', total_kuantitas_barang = '" + txtKuantitasBarang.getText()+
                            "', total_biaya = '" + txtTotalBiaya.getText()+
                            "', id_admin = '" + cmbadmin.getSelectedItem()+
                            "', id_customer = '" + txtIdCustomer.getText()+
                            "', nama_layanan = '" + cmblayanan.getSelectedItem()+
                            "', nama_barang = '" + cmbbarang.getSelectedItem()+ 
                            "' WHERE id_transaksi = '" + txtIdTransaksi.getText() + "'";
            stat.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Update Transaksi Berhasil");
            kosong();
            tampilkan();
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
    if (txtIdTransaksi.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Silahkan Pilih Data !");
        }else{
            int jawab = JOptionPane.showConfirmDialog(null, "Apakah Yakin Data Ini Dihapus ?");
            if (jawab == 0) {
                try {
                    stat = con.createStatement();
                    String sql = "DELETE FROM tb_transaksi WHERE id_transaksi = '" + txtIdTransaksi.getText()+"'";
                    stat.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data Terhapus");
                    tampilkan();
                    kosong();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTransaksiMouseClicked
        // TODO add your handling code here:
        txtIdTransaksi.setText(tbTransaksi.getValueAt(tbTransaksi.getSelectedRow(),0).toString());
        txtTanggalMasuk.setText(tbTransaksi.getValueAt(tbTransaksi.getSelectedRow(),1).toString());
        txtTanggalKeluar.setText(tbTransaksi.getValueAt(tbTransaksi.getSelectedRow(),2).toString());
        txtTotalBeratBarang.setText(tbTransaksi.getValueAt(tbTransaksi.getSelectedRow(),3).toString());
        txtKuantitasBarang.setText(tbTransaksi.getValueAt(tbTransaksi.getSelectedRow(),4).toString());
        txtTotalBiaya.setText(tbTransaksi.getValueAt(tbTransaksi.getSelectedRow(),5).toString());
        cmbadmin.setSelectedItem(tbTransaksi.getValueAt(tbTransaksi.getSelectedRow(),6).toString());
        txtIdCustomer.setText(tbTransaksi.getValueAt(tbTransaksi.getSelectedRow(),7).toString());
        cmblayanan.setSelectedItem(tbTransaksi.getValueAt(tbTransaksi.getSelectedRow(),8).toString());
        cmbbarang.setSelectedItem(tbTransaksi.getValueAt(tbTransaksi.getSelectedRow(),9).toString());
    }//GEN-LAST:event_tbTransaksiMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        new Report().show();
        this.dispose();  
    }//GEN-LAST:event_jLabel11MouseClicked

    private void btnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogActionPerformed
        // TODO add your handling code here:
        new Login().show();
        this.dispose();
    }//GEN-LAST:event_btnLogActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLog;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbadmin;
    private javax.swing.JComboBox<String> cmbbarang;
    private javax.swing.JComboBox<String> cmblayanan;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable tbTransaksi;
    private javax.swing.JTable tb_layanan;
    private javax.swing.JTable tbbarang;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdCustomer;
    private javax.swing.JTextField txtIdTransaksi;
    private javax.swing.JTextField txtKuantitasBarang;
    private javax.swing.JTextField txtTanggalKeluar;
    private javax.swing.JTextField txtTanggalKeluar1;
    private javax.swing.JTextField txtTanggalMasuk;
    private javax.swing.JTextField txtTotalBeratBarang;
    private javax.swing.JTextField txtTotalBiaya;
    // End of variables declaration//GEN-END:variables
}
