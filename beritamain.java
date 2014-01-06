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
public class beritamain {

    connect c;
    


    public beritamain() {
        c = new connect();
        c.connect();
     
        

    }


    public boolean simpan(String judul, String isi) {
       Date now;
       now = new Date();
       SimpleDateFormat tgl_login;
       tgl_login=new SimpleDateFormat("YY-MM-DD");
        
        String sql = "insert into berita (id,judul,isi,hari)values (0,'"+judul+"','"+isi+"','"+tgl_login.format(now)+"')";
        try {
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil disimpan dengan "+judul);
            ps.close();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

            return false;
//    statement.executeUpdate(sql);
//    statement.exit();

        }
    }

    public boolean update(String id, String judul,String isi) {
        String value = "update berita set judul ='" + judul + "'," + "isi='" + isi + "',where id ='" + id + "';";
        try {

            PreparedStatement stm = c.getCon().prepareStatement(value);
            stm.executeUpdate(value);

            JOptionPane.showMessageDialog(null, "Berhasil diedit");
            stm.close();

        } catch (Exception ex) {

        }
        return false;
    }

    public boolean hapus(String id) {
        String sql = "delete from berita where id='" + id + "';";
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
