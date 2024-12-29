/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;


// Tambah fungsi pada kelas TambahPenyewaan
import dao.PenyewaanDAO;
import dao.MobilDAO;
import model.Penyewaan;
import model.Mobil;
import utils.DatabaseConnection;
import utils.PrintPenyewaan;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.print.PrinterJob;
import java.awt.print.PrinterException;
import java.util.List;

public class TambahPenyewaan extends javax.swing.JFrame {
    private PenyewaanDAO penyewaanDAO;
    private MobilDAO mobilDAO;
    private List<Mobil> listMobil;

    public TambahPenyewaan() {
       try {
            Connection connection = DatabaseConnection.getConnection();
            penyewaanDAO = new PenyewaanDAO(connection);
            mobilDAO = new MobilDAO(connection);
            listMobil = mobilDAO.getAllMobil();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi ke database gagal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        initComponents();
        loadTableData();
        loadMobilComboBox();
        addLamaSewaDocumentListener();
        setTableHeaders();
        loadTableData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNamaPenyewa = new javax.swing.JTextField();
        txtLamaSewa = new javax.swing.JTextField();
        txtTotalHarga = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePenyewaan = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jDateSewa = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        cmbMobil = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(488, 575));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("FORM DATA PENYEWAAN");
        getContentPane().add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Nama Penyewa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(28, 20, 7, 20);
        jPanel2.add(jLabel3, gridBagConstraints);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nama Mobil");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 21, 6, 0);
        jPanel2.add(jLabel4, gridBagConstraints);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Tanggal Sewa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 20, 8, 20);
        jPanel2.add(jLabel5, gridBagConstraints);

        txtNamaPenyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPenyewaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(28, 20, 7, 20);
        jPanel2.add(txtNamaPenyewa, gridBagConstraints);

        txtLamaSewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLamaSewaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(11, 20, 7, 20);
        jPanel2.add(txtLamaSewa, gridBagConstraints);

        txtTotalHarga.setEditable(false);
        txtTotalHarga.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 20, 7, 20);
        jPanel2.add(txtTotalHarga, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel3.add(btnTambah, new java.awt.GridBagConstraints());

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel3.add(btnEdit, new java.awt.GridBagConstraints());

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel3.add(btnHapus, new java.awt.GridBagConstraints());

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel3.add(btnClear, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(7, 20, 7, 20);
        jPanel2.add(jPanel3, gridBagConstraints);

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(7, 20, 7, 20);
        jPanel2.add(btnCetak, gridBagConstraints);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(300, 174));
        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 174));

        tablePenyewaan.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePenyewaan.setFocusable(false);
        tablePenyewaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePenyewaanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePenyewaan);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(7, 20, 7, 20);
        jPanel2.add(jScrollPane1, gridBagConstraints);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Total Harga");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(7, 20, 7, 20);
        jPanel2.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 19, 8, 19);
        jPanel2.add(jDateSewa, gridBagConstraints);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Lama Sewa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(7, 20, 7, 20);
        jPanel2.add(jLabel8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 20, 6, 20);
        jPanel2.add(cmbMobil, gridBagConstraints);

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        jPanel2.add(jButton1, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void loadMobilComboBox() {
        cmbMobil.removeAllItems();
        for (Mobil mobil : listMobil) {
            cmbMobil.addItem(mobil.getNamaMobil());
        }
    }
 private void setTableHeaders() {
        DefaultTableModel model = (DefaultTableModel) tablePenyewaan.getModel();
        model.setColumnIdentifiers(new String[]{"ID Penyewaan", "Nama Penyewa", "Lama Sewa", "Total Harga", "Tanggal Sewa"});
    }

    private Mobil getSelectedMobil() {
        int selectedIndex = cmbMobil.getSelectedIndex();
        return listMobil.get(selectedIndex);
    }

  private void loadTableData() {
    // Muat ulang data penyewaan ke tabel
    try {
        List<Penyewaan> listPenyewaan = penyewaanDAO.getAllPenyewaan();

        DefaultTableModel model = (DefaultTableModel) tablePenyewaan.getModel();
        model.setRowCount(0); // Membersihkan tabel

        for (Penyewaan penyewaan : listPenyewaan) {
            model.addRow(new Object[]{
                penyewaan.getIdPenyewaan(),
                penyewaan.getNamaPenyewa(),
                penyewaan.getLamaSewa(),
                penyewaan.getTotalHarga(),
                penyewaan.getTanggalSewa() // Langsung gunakan string tanggal
            });
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal memuat tabel penyewaan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


     
    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
         String namaPenyewa = txtNamaPenyewa.getText();
    String lamaSewaText = txtLamaSewa.getText();
    Date tanggalSewa = jDateSewa.getDate();

    // Validasi input
    if (namaPenyewa.isEmpty() || lamaSewaText.isEmpty() || tanggalSewa == null) {
        JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Validasi", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        // Konversi lama sewa menjadi integer
        int lamaSewa = Integer.parseInt(lamaSewaText);

        // Format tanggal menjadi string
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tanggalSewaFormatted = sdf.format(tanggalSewa);

        // Ambil mobil yang dipilih
        Mobil selectedMobil = getSelectedMobil();
        if (selectedMobil == null) {
            JOptionPane.showMessageDialog(this, "Pilih mobil terlebih dahulu!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Hitung total harga
        double totalHarga = lamaSewa * selectedMobil.getHargaPerHari();

        // Buat objek penyewaan
        Penyewaan penyewaan = new Penyewaan(
            0, 
            selectedMobil.getIdMobil(), 
            namaPenyewa, 
            lamaSewa, 
            totalHarga, 
            tanggalSewaFormatted // Gunakan tanggal yang diformat
        );

        // Simpan ke database
        penyewaanDAO.addPenyewaan(penyewaan);

        // Tampilkan pesan sukses
        JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);

        // Refresh tabel
        loadTableData();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Lama sewa harus berupa angka!", "Validasi", JOptionPane.WARNING_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal menambahkan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnTambahActionPerformed
 private void addLamaSewaDocumentListener() {
        txtLamaSewa.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calculateTotalHarga();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calculateTotalHarga();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                calculateTotalHarga();
            }
        });
    }

    private void calculateTotalHarga() {
        try {
            int lamaSewa = Integer.parseInt(txtLamaSewa.getText());
            Mobil selectedMobil = getSelectedMobil();
            double totalHarga = lamaSewa * selectedMobil.getHargaPerHari();
            txtTotalHarga.setText(String.valueOf(totalHarga));
        } catch (NumberFormatException e) {
            txtTotalHarga.setText("0"); // Reset total harga jika input tidak valid
        } catch (NullPointerException e) {
            txtTotalHarga.setText("0"); // Jika tidak ada mobil yang dipilih
        }
    }


    private void txtNamaPenyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPenyewaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPenyewaActionPerformed

    private void txtLamaSewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLamaSewaActionPerformed
     try {
            int lamaSewa = Integer.parseInt(txtLamaSewa.getText());
            Mobil selectedMobil = getSelectedMobil();
            double totalHarga = lamaSewa * selectedMobil.getHargaPerHari();
            txtTotalHarga.setText(String.valueOf(totalHarga));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Lama sewa harus berupa angka!", "Validasi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtLamaSewaActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
     int selectedRow = tablePenyewaan.getSelectedRow();
if (selectedRow == -1) {
    JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit!", "Validasi", JOptionPane.WARNING_MESSAGE);
    return;
}

String namaPenyewa = txtNamaPenyewa.getText();
String lamaSewaText = txtLamaSewa.getText();
Date tanggalSewa = jDateSewa.getDate();

// Validasi input
if (namaPenyewa.isEmpty() || lamaSewaText.isEmpty() || tanggalSewa == null) {
    JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Validasi", JOptionPane.WARNING_MESSAGE);
    return;
}

try {
    // Konversi lama sewa menjadi integer
    int lamaSewa = Integer.parseInt(lamaSewaText);

    // Format tanggal menjadi string
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String tanggalSewaFormatted = sdf.format(tanggalSewa);

    // Ambil mobil yang dipilih
    Mobil selectedMobil = getSelectedMobil();
    if (selectedMobil == null) {
        JOptionPane.showMessageDialog(this, "Pilih mobil terlebih dahulu!", "Validasi", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Hitung total harga
    double totalHarga = lamaSewa * selectedMobil.getHargaPerHari();

    // Ambil ID Penyewaan dari tabel
    int idPenyewaan = (int) tablePenyewaan.getValueAt(selectedRow, 0);

    // Buat objek penyewaan
    Penyewaan penyewaan = new Penyewaan(
        idPenyewaan, 
        selectedMobil.getIdMobil(), 
        namaPenyewa, 
        lamaSewa, 
        totalHarga, 
        tanggalSewaFormatted // Gunakan tanggal yang diformat
    );

    // Update data penyewaan di database
    penyewaanDAO.updatePenyewaan(penyewaan);

    // Tampilkan pesan sukses
    JOptionPane.showMessageDialog(this, "Data berhasil diperbarui!", "Informasi", JOptionPane.INFORMATION_MESSAGE);

    // Refresh tabel
    loadTableData();
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Lama sewa harus berupa angka!", "Validasi", JOptionPane.WARNING_MESSAGE);
} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Gagal memperbarui data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
       int selectedRow = tablePenyewaan.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idPenyewaan = (int) tablePenyewaan.getValueAt(selectedRow, 0);

        try {
            penyewaanDAO.deletePenyewaan(idPenyewaan);

            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            loadTableData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
     txtNamaPenyewa.setText("");
        txtLamaSewa.setText("");
        txtTotalHarga.setText("");
        jDateSewa.setDate(null);
        cmbMobil.setSelectedIndex(0);        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearActionPerformed

    private void tablePenyewaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePenyewaanMouseClicked
    int selectedRow = tablePenyewaan.getSelectedRow();
            if (selectedRow != -1) {
                txtNamaPenyewa.setText(tablePenyewaan.getValueAt(selectedRow, 1).toString());
                txtLamaSewa.setText(tablePenyewaan.getValueAt(selectedRow, 2).toString());
                txtTotalHarga.setText(tablePenyewaan.getValueAt(selectedRow, 3).toString());

                try {
                    Date tanggalSewa = new SimpleDateFormat("yyyy-MM-dd").parse(tablePenyewaan.getValueAt(selectedRow, 4).toString());
                    jDateSewa.setDate(tanggalSewa);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Gagal memuat tanggal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }        // TODO add your handling code here:
    }//GEN-LAST:event_tablePenyewaanMouseClicked

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
     PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new PrintPenyewaan(tablePenyewaan));
        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(TambahPenyewaan.this, 
                    "Gagal mencetak: " + e.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnCetakActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose(); // Menutup form saat ini
     
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TambahPenyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahPenyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahPenyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahPenyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahPenyewaan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbMobil;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateSewa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePenyewaan;
    private javax.swing.JTextField txtLamaSewa;
    private javax.swing.JTextField txtNamaPenyewa;
    private javax.swing.JTextField txtTotalHarga;
    // End of variables declaration//GEN-END:variables
}