/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TA;

import responsi.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author auchu
 */
public class main {

    connect c;
    


    public main() {
        c = new connect();
        c.connect();
     
        

    }


    public boolean simpan(String user, String pass,String leveluser) {
       Date now;
       now = new Date();

       SimpleDateFormat tgl_login;
       tgl_login=new SimpleDateFormat("YY-MM-DD "+" hh:mm:ss");
        String passwrd = "MD5('" + pass+ "')";
        String sql = "insert into user (id,username,password,leveluser,waktulogin,log)values (0,'" + user + "'," + passwrd + ",'"+leveluser+"','"+tgl_login.format(now)+"','no')";
        try {

            PreparedStatement ps = c.getCon().prepareStatement(sql);

//         ps.setString(1, nim);
//         ps.setString(2, nama);
//         ps.setString(3, alamat);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil disimpan dengan "+user);
            ps.close();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

            return false;
//    statement.executeUpdate(sql);
//    statement.exit();

        }
    }

    public boolean update(String user, String pass,String leveluser) {
        String value = "update user set username='" + user + "'," + "password='" + pass + "',leveluser='"+leveluser+"'where username='" + user + "';";
        try {

            PreparedStatement stm = c.getCon().prepareStatement(value);
            stm.executeUpdate(value);

            JOptionPane.showMessageDialog(null, "Berhasil diedit");
            stm.close();

        } catch (Exception ex) {

        }
        return false;
    }

    public boolean hapus(String user) {
        String sql = "delete from user where username='" + user + "';";
        try {
            PreparedStatement statement = c.getCon().prepareStatement(sql);
            statement.executeUpdate(sql);
            statement.close();
            JOptionPane.showMessageDialog(null, "Data telah di Hapus");
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex);
            return false;
        }
    }



public static void main(String[] args) throws ClassNotFoundException{
        
        
       
        }
    

}
