/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TA;

import responsi.*;
import java.lang.invoke.MethodHandles;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author auchu
 */
public class isi extends javax.swing.JFrame {
    main m;
    connect c;
    coba1 j ;
    ChatClient chatc;
    ChatServer chats;

    /**
     * Creates new form isi
     */
    public isi() {
        m = new main();
        initComponents();
        c = new connect();
        c.connect();
        j = new coba1();
        chats = new ChatServer();
        chatc = new ChatClient();
                
    }
     public void ubah_log(){
       Date now;
       now = new Date();

       SimpleDateFormat tgl_login;
       tgl_login=new SimpleDateFormat("YY-MM-DD "+" hh:mm:ss");
  
        String sql="update user set log='no', waktulogin='"+tgl_login.format(now)+"'";
         System.out.println(sql);
        java.sql.PreparedStatement stmt = null;
        try {
//        PreparedStatement ps = c.getCon().prepareStatement(sql);
            stmt = c.getCon().prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
    public void datatable(){
        
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("id");
        tbl.addColumn("username");
        tbl.addColumn("password");
        tbl.addColumn("tanggal login");
        tbl.addColumn("waktu login");
        tbl.addColumn("online");
        data.setModel(tbl);
        
        try{
            String sql = "SELECT * FROM USER ORDER BY ID";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                tbl.addRow(new Object[]{
                   rs.getString("id"),rs.getString("username"),rs.getString("password"),rs.getDate("waktulogin"),rs.getTime("waktulogin"),rs.getString("log")
                   
                });
                data.setModel(tbl);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this,"Maap Tidak Bisa ditampilkan");
        
        }
    }
    public boolean datasearch(String username){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("id");
        tbl.addColumn("username");
        tbl.addColumn("password");
        tbl.addColumn("tanggal login");
        tbl.addColumn("waktu login");
        tbl.addColumn("online");
        data.setModel(tbl);
        
        try{
            String sql = "SELECT * FROM user where  ='"+username+"';";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                tbl.addRow(new Object[]{
                  rs.getString("id"),rs.getString("username"),rs.getString("password"),rs.getDate("waktulogin"),rs.getTime("waktulogin"),rs.getString("log")
                });
                data.setModel(tbl);
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
           
        
        }
        return false;
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu1 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        insert = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        data = new javax.swing.JTable();
        view = new javax.swing.JButton();
        search = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();
        logout = new javax.swing.JToggleButton();
        options = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        aktif = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        berita = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HALAMAN ADMIN");
        setBackground(new java.awt.Color(255, 0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        insert.setText("Create");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Username", "Password", "Waktu Login", "Online"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(data);

        view.setText("View");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel4.setText("Untuk Update,Delete,Search Gunakanlah User");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("MENU PILIHAN");

        jLabel6.setBackground(new java.awt.Color(255, 51, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tabel User");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 255)));
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        logout.setText("Logout");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        options.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "user", "admin" }));
        options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsActionPerformed(evt);
            }
        });

        jLabel3.setText("Kategori");

        aktif.setText("aktifkan chat");
        aktif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktifActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poto/login-welcome.png"))); // NOI18N

        berita.setText("Berita");
        berita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beritaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(logout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(insert)
                        .addGap(28, 28, 28)
                        .addComponent(update)
                        .addGap(29, 29, 29)
                        .addComponent(delete)
                        .addGap(32, 32, 32)
                        .addComponent(search)
                        .addGap(27, 27, 27)
                        .addComponent(view)
                        .addGap(33, 33, 33)
                        .addComponent(aktif)
                        .addGap(38, 38, 38)
                        .addComponent(berita)
                        .addContainerGap(80, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                .addComponent(password)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(80, 80, 80))))
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)))
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(update)
                    .addComponent(view)
                    .addComponent(search)
                    .addComponent(aktif)
                    .addComponent(insert)
                    .addComponent(berita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        
        String user= username.getText();
        String pass = password.getText();
        String leveluser = (String)options.getSelectedItem();
        
        
        
        if(user.isEmpty() || pass.isEmpty()||leveluser.isEmpty()){
            JOptionPane.showMessageDialog(this, "Data tidak lengkap");
        } else {
            if(user.length()>32){
                JOptionPane.showMessageDialog(this, "maksimum 32 karakter");
                 username.setText("cmenk(contoh)");
            } else if(m.simpan(user, pass,leveluser)){
                username.setText("");
                password.setText("");
                
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal dimasukkan");
                
            }
        }
        datatable();
    }//GEN-LAST:event_insertActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
       datatable();
        
    }//GEN-LAST:event_viewActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
     String user = username.getText();
     String pass =password.getText();
     String leveluser = (String)options.getSelectedItem();
     
      if(user.isEmpty() || pass.isEmpty()||leveluser.isEmpty()){
            JOptionPane.showMessageDialog(this, "Ada data yang belum diisi");
        } else {
            if(user.length()<32){
                JOptionPane.showMessageDialog(this, "batas username 32 karakter");
                 username.setText("");
            
            } else if(m.update(user, pass,leveluser)){
               username.setText("");
                password.setText("");
              
               
                
            }else{
                System.out.println("Tidak dapat diedit");
            }
     
     datatable();
    }//GEN-LAST:event_updateActionPerformed
    }
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        String user = username.getText();
        if(user.isEmpty() ){
            JOptionPane.showMessageDialog(this, "NIM belum dimasukkan");
        }else{if(user.length()> 32){
                JOptionPane.showMessageDialog(this, "batas username 32 karakter");
                 username.setText("");
        }else if(m.hapus(user)){
            username.setText("");
                password.setText("");
                
        }else{ System.out.println("Belum kehapus");
            
        }datatable();
    }//GEN-LAST:event_deleteActionPerformed
    }
    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String user = username.getText();
        if(user.isEmpty() ){
            JOptionPane.showMessageDialog(this, "NIM belum dimasukkan");
            
        }else{if(user.length()>32){
                JOptionPane.showMessageDialog(this, "batas username 32 karakter");
                username.setText("");
        }else if(datasearch(user)){
            username.setText("");
                password.setText("");
            
        }else{ JOptionPane.showMessageDialog(this, "Tidak dapat mencari");
            
        }// TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed
    }
    private void dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataMouseClicked
        JOptionPane.showMessageDialog(this, "Jangan Sentuh Table ya ,(baru perbaikan) ! ");
    }//GEN-LAST:event_dataMouseClicked

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        ubah_log();
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_logoutMouseClicked

    private void optionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsActionPerformed
      String textDariCombo = "";
        textDariCombo = (String) options.getSelectedItem().toString();
        if (textDariCombo.equals("")) {
            JOptionPane.showMessageDialog(null, "combo belum terpilih");}
    }//GEN-LAST:event_optionsActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        JFrame form = new JFrame();
        form.setSize(400, 400);
        new tengah1(this);
    }//GEN-LAST:event_formWindowActivated

    private void aktifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktifActionPerformed
        new ChatClient().setVisible(true);
    }//GEN-LAST:event_aktifActionPerformed

    private void beritaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beritaActionPerformed
        new berita().setVisible(true);
    }//GEN-LAST:event_beritaActionPerformed
    
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
            java.util.logging.Logger.getLogger(isi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(isi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(isi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(isi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new isi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aktif;
    private javax.swing.JButton berita;
    private javax.swing.JTable data;
    private javax.swing.JButton delete;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton logout;
    private javax.swing.JComboBox options;
    private javax.swing.JTextField password;
    private javax.swing.JButton search;
    private javax.swing.JButton update;
    private javax.swing.JTextField username;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
