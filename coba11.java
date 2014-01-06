/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TA;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import oracle.net.aso.r;

/**
 *
 * @author User
 */
public class coba11 extends javax.swing.JFrame {

    
    connect c;

    /**
     * Creates new form coba
     */
    public coba11() {
        c = new connect();
        c.connect();
       
        initComponents();

    }
    
    public void catat_log(){
        String usern = username.getText();
        char[] temp = password.getPassword();
        String pass = "";
        for (Character t : temp) {
            pass += t.toString();
        }
    
        String passwrd = "MD5('" + pass+ "')";

       Date now;
       now = new Date();

       SimpleDateFormat tgl_login;
       tgl_login=new SimpleDateFormat("YY-MM-DD "+" hh:mm:ss");
  
        String sql="update user set log='yes', waktulogin='"+tgl_login.format(now)+"'where username='"+usern+"' AND password="+passwrd+"";
        java.sql.PreparedStatement stmt = null;
        try {
//          PreparedStatement ps = c.getCon().prepareStatement(sql);
            stmt = c.getCon().prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            
        }

//        try{
//            
//        }catch(SQLException se){}
    }

    public void login() {
        String usern = username.getText();
        char[] temp = password.getPassword();
        String pass = "";
        for (Character t : temp) {
            pass += t.toString();
        }
        String leveluser = (String) pilihan.getSelectedItem();
        System.out.println(leveluser);
        String passwrd = "MD5('" + pass+ "')";
        try {
        String sqle = ("SELECT * FROM USER WHERE USERNAME='"+usern+"' AND PASSWORD=" + passwrd + " AND LEVELUSER='" + leveluser+"'") ;
            
            PreparedStatement ps = c.getCon().prepareStatement(sqle);
            ResultSet rs = ps.executeQuery();
//                   System.out.println( rs.getString("username")); 
            
            if(rs.first()){
                if (pilihan.getSelectedItem().toString().equals("admin")) {
                        catat_log();
                        isi i = new isi();
                        i.setVisible(true);
                        this.setVisible(false);
                    } else if (pilihan.getSelectedItem().toString().equals("user")) {
                        catat_log();
                        user isi1 = new user();
                        isi1.setVisible(true);
                        this.setVisible(false);
                    }
            } else {
                JOptionPane.showMessageDialog(null, "User dan password dikerjakan"
                            + " kenapa ?", "SALAH",
                            JOptionPane.ERROR_MESSAGE);
            }
            
//         while(rs.next()){
//                String usernn = rs.getString(usern);
//                String passs = rs.getString(passwrd);
//                String lvl = rs.getString(leveluser);
//                
//                if ((usern.equals(usernn)) && (pass.equals(passs))) {
//                    if (pilihan.getSelectedItem().toString().equals("admin")) {
//                        catat_log();
//                        isi i = new isi();
//                        i.setVisible(true);
//                        this.setVisible(false);
//                    } else if (pilihan.getSelectedItem().toString().equals("user")) {
//                        catat_log();
//                        isi1 isi1 = new isi1();
//                        isi1.setVisible(true);
//                        this.setVisible(false);
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(null, "User dan password dikerjakan"
//                            + " kenapa ?", "SALAH",
//                            JOptionPane.ERROR_MESSAGE);
//                    break;
//                    
//                }
//         }    

//        int count =0;
//        String user = username.getText();
//       char[] temp = password.getPassword();
//        String leveluser = (String)pilihan.getSelectedItem();
//        
//        String pass = "";
//        for(Character t : temp){
//            pass += t.toString();
//            
//        }        
//        
//        if(user.isEmpty()||pass.isEmpty()){
//            JOptionPane.showMessageDialog(this, "username atau password kosong");
//        } else {
//            if(m.Loginn(user, pass,leveluser )){
//                
//                
//                isi ft = new isi();
//                ft.setVisible(true);
//                this.setVisible(false);
//            } else {
//                JOptionPane.showMessageDialog(this, "Gagal Login");
//            }
//        }
//        
//    
//        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        pilihan = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WELCOME TO MY PROGRAM");
        setBackground(new java.awt.Color(204, 102, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("ABSENSI DEPARTEMEN AGAMA");

        jLabel2.setText("Username");

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        login.setText("Login");
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginKeyPressed(evt);
            }
        });

        jLabel3.setText("Password");

        pilihan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "user", "admin" }));
        pilihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihanActionPerformed(evt);
            }
        });

        jLabel4.setText("Kategori");

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poto/logo_uns.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel5.setText("SELAMAT DATANG BAPAK/IBU ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo)
                .addGap(191, 191, 191)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 4, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(login)
                                .addGap(35, 35, 35)
                                .addComponent(cancel))
                            .addComponent(pilihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(pilihan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancel)
                            .addComponent(login))
                        .addGap(22, 22, 22))
                    .addComponent(logo, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        getAccessibleContext().setAccessibleName("PROGRAM ABSENSI BY KELOMPOK PBO NO 7");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed


    }//GEN-LAST:event_loginActionPerformed

    private void pilihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihanActionPerformed
        String textDariCombo = "";
        textDariCombo = (String) pilihan.getSelectedItem().toString();
        if (textDariCombo.equals("")) {
            JOptionPane.showMessageDialog(null, "combo belum terpilih");
        }
    }//GEN-LAST:event_pilihanActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
        login();
    }//GEN-LAST:event_loginMouseClicked

    private void loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginKeyPressed
       login();
    }//GEN-LAST:event_loginKeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        JFrame form = new JFrame();
        form.setSize(400, 400);
        new tengah1(this);
    }//GEN-LAST:event_formWindowActivated

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new coba11().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton login;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField password;
    private javax.swing.JComboBox pilihan;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
