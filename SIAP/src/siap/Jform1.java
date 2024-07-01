/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package siap;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static siap.koneksi.getKoneksi;
import java.awt.image.BufferedImage;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
/**
 *
 * @author LENOVO
 */
public class Jform1 extends javax.swing.JFrame {
     DefaultTableModel TM = new DefaultTableModel();
    

    /**
     * Creates new form Jform1
     */
    public Jform1() throws SQLException{
        initComponents();
       tabel_siap.setModel(TM);
        TM.addColumn("ID_PENGADUAN");
        TM.addColumn("NAMA_PENGADU");
        TM.addColumn("TANGGAL_PENGADUAN");
        TM.addColumn("KATEGORI_PENGADUAN");
        TM.addColumn("DESKRIPSI_PENGADUAN");
        TM.addColumn("STATUS_PENGADUAN");
        this.setTitle("SISTEM INFORMASI ADUAN PENINJOAN");
       ImageIcon IC = new ImageIcon("img/");
       this.setIconImage(IC.getImage());
        
        
//        Object[] dta =  new Object[6];
//        dta[0] = "P01";
//        dta[1] = "I Nyoman Ada";
//        dta[2] = "29 Juni 2024";
//        dta[3] = "Kecelakaan";
//        dta[4] = "saat hujan ada pengendara ngebut ngebutan dan menabrak tumpukan pasir";
//        dta[5] = "Baru Terjadi";
//        TM.addRow(dta);

        List_all();
        kosongkanform();
        loadphoto("");
    }
    private void loadphoto(String idx){
        String aduan = "src/img/P01.png";
        String ph = "src/img/"+idx+".png";
        BufferedImage photoaduan = loadIMG.loadImage(ph);
        if(photoaduan == null){
            photoaduan = loadIMG.loadImage(aduan);
        }
        ImageIcon iconphoto = new ImageIcon(photoaduan);
        photo.setIcon(iconphoto);
    }
    private void List_all () throws SQLException{
        TM.getDataVector().removeAllElements();       
        TM.fireTableDataChanged();
        
        Connection cnn = getKoneksi();
        if(!cnn.isClosed()){
            
            String sql = "SELECT * FROM data_aduan";
            PreparedStatement PS = cnn.prepareStatement(sql);
            ResultSet rs = PS.executeQuery();
            
            while(rs.next()){
                Object[] dta = new Object[6];
                dta [0] = rs.getString("ID_PENGADUAN");
                dta [1] = rs.getString("NAMA_PENGADU");
                dta [2] = rs.getString("TANGGAL_PENGADUAN");
                dta [3] = rs.getString("KATEGORI_PENGADUAN");
                dta [4] = rs.getString("DESKRIPSI_PENGADUAN");
                dta [5] = rs.getString("STATUS_PENGADUAN");
                TM.addRow(dta);
            }
        }
    }
    private  void storeData() throws SQLException{
        Connection cnn = getKoneksi();
        String id_pengaduan = txid.getText();
        String nama_pengadu = txnama.getText();
        String tanggal_pengaduan = txtanggal.getText();
        String kategori_pengaduan = txkategori.getText();
        String deskripsi_pengaduan = txdeskripsi.getText();
        String status_pengaduan = txstatus.getText();
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement(
            "INSERT INTO data_aduan(id_pengaduan,nama_pengadu,tanggal_pengaduan,kategori_pengaduan,deskripsi_pengaduan,status_pengaduan) VALUES (?,?,?,?,?,?);");
            PS.setString(1, id_pengaduan);
            PS.setString(2, nama_pengadu);
            PS.setString(3, tanggal_pengaduan);
            PS.setString(4 ,kategori_pengaduan);
            PS.setString(5, deskripsi_pengaduan);
            PS.setString(6, status_pengaduan);
            PS.executeUpdate();
        }
    }
    private void updateData() throws SQLException{
        Connection cnn = getKoneksi();
        
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement(
            "UPDATE data_aduan SET nama_pengadu=?,tanggal_pengaduan=?,kategori_pengaduan=?,deskripsi_pengaduan=?,status_pengaduan=? WHERE id_pengaduan =?;");
            PS.setString(1, txnama.getText());
            PS.setString(2, txtanggal.getText());
            PS.setString(3 ,txkategori.getText());
            PS.setString(4, txdeskripsi.getText());
            PS.setString(5, txstatus.getText());
            PS.setString(6, txid.getText());
            PS.executeUpdate();
            cnn.close();
        }
    }
    private void destroyData() throws SQLException{
        
        Connection cnn = getKoneksi();
        if(!cnn.isClosed()){
        
            PreparedStatement PS = cnn.prepareStatement(
            "DELETE FROM data_aduan WHERE id_pengaduan =?;");
            PS.setString(1, txid.getText());
            PS.executeUpdate();
            cnn.close();
        }
    }
    private void kosongkanform(){
        txid.setText("");
        txnama.setText("");
        txtanggal.setText("");
        txkategori.setText("");
        txdeskripsi.setText("");
        txstatus.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_siap = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txnama = new javax.swing.JTextField();
        txstatus = new javax.swing.JTextField();
        txdeskripsi = new javax.swing.JTextField();
        txid = new javax.swing.JTextField();
        txkategori = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btninput = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btntutup = new javax.swing.JButton();
        photo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtanggal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("SISTEM INFORMASI ADUAN PENINJOAN");

        tabel_siap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NAMA", "TANGGAL", "KATEGORI", "DESKRIPSI", "BUKTI", "STATUS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabel_siap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_siapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_siap);

        jLabel7.setText("Kategori_Pengaduan");

        txnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnamaActionPerformed(evt);
            }
        });

        txstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txstatusActionPerformed(evt);
            }
        });

        txdeskripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txdeskripsiActionPerformed(evt);
            }
        });

        txid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txidActionPerformed(evt);
            }
        });

        jLabel2.setText("Id_Pengaduan");

        jLabel3.setText("Deskripsi");

        jLabel4.setText("Status_Pengaduan");

        jLabel6.setText("Nama_Pengadu");

        btninput.setText("INPUT");
        btninput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninputActionPerformed(evt);
            }
        });

        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btntutup.setText("TUTUP TABEL");
        btntutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntutupActionPerformed(evt);
            }
        });

        photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("Tanggal_Pengaduan");

        txtanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtanggalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btninput, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btntutup, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txid, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txnama, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txdeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txkategori, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txdeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btninput)
                    .addComponent(btnupdate)
                    .addComponent(btndelete)
                    .addComponent(btntutup))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnamaActionPerformed

    private void txstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txstatusActionPerformed

    private void txdeskripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txdeskripsiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txdeskripsiActionPerformed

    private void txidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txidActionPerformed

    private void btninputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninputActionPerformed
        if(btninput.getText().equals("Input")){
            btninput.setText("Simpan");
            btntutup.setText("Batal");
            kosongkanform();
            tabel_siap.setEnabled(false);
        }else{
            btninput.setText("Input");
            btntutup.setText("Tutup Form");
            tabel_siap.setEnabled(true);
            try {
                storeData();
                List_all();
            } catch (SQLException ex) {
                Logger.getLogger(Jform1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btninputActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        if(btnupdate.getText().equals("update")){
            btnupdate.setText("Simpan");
            btnupdate.setText("Batal");
        }else{
            btnupdate.setText("update");
            btntutup.setText("Tutup Form");
            try {
                updateData();
                List_all();
                JOptionPane.showMessageDialog(this, "Data telah diupdate");
            } catch (SQLException ex) {
                Logger.getLogger(Jform1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        int jwb = JOptionPane.showOptionDialog(
            this,
            "Apakah anda yakin akan menghapus data dengan id : "+ txstatus.getText() + "?" ,
            "Hapus data",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE,
            null,
            null,
            null);
        if(jwb == JOptionPane.YES_OPTION){
            try {
                destroyData();
                List_all();
                JOptionPane.showMessageDialog(this, "Data telah dihapus");
            } catch (SQLException ex) {
                Logger.getLogger(Jform1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btntutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntutupActionPerformed
        if(btntutup.getText().equals("Tutup Form")){
            dispose();
        }else{
            btntutup.setText("Tutup Form");
            btninput.setText("Input");
        }
    }//GEN-LAST:event_btntutupActionPerformed

    private void txtanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtanggalActionPerformed

    private void tabel_siapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_siapMouseClicked
        txid.setText(tabel_siap.getValueAt(tabel_siap.getSelectedRow(),0).toString());
        txnama.setText(tabel_siap.getValueAt(tabel_siap.getSelectedRow(),1).toString());
        txtanggal.setText(tabel_siap.getValueAt(tabel_siap.getSelectedRow(),2).toString());
        txkategori.setText(tabel_siap.getValueAt(tabel_siap.getSelectedRow(),3).toString());
        txdeskripsi.setText(tabel_siap.getValueAt(tabel_siap.getSelectedRow(),4).toString());
        txstatus.setText(tabel_siap.getValueAt(tabel_siap.getSelectedRow(),5).toString());
        loadphoto(txid.getText());
    }//GEN-LAST:event_tabel_siapMouseClicked

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
            java.util.logging.Logger.getLogger(Jform1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jform1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jform1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jform1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
            try{
                new Jform1().setVisible(true);
            }catch (SQLException ex){
            Logger.getLogger(Jform1.class.getName()).log(Level.SEVERE,null,ex);
            }
        }   
     });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btninput;
    private javax.swing.JButton btntutup;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel photo;
    private javax.swing.JTable tabel_siap;
    private javax.swing.JTextField txdeskripsi;
    private javax.swing.JTextField txid;
    private javax.swing.JTextField txkategori;
    private javax.swing.JTextField txnama;
    private javax.swing.JTextField txstatus;
    private javax.swing.JTextField txtanggal;
    // End of variables declaration//GEN-END:variables
}
