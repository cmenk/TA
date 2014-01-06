/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author auchu
 */
public class connect {
     
    private Connection con;
      private  String driver = "com.mysql.jdbc.Driver";
        private String url =  "jdbc:mysql://localhost:3306/tugasakhir";
      
      private  String user ="root";
       private String pass ="";
 public connect() {
        try {
            Class.forName(driver);
            System.out.println("Koneksi Lancar");
        } catch (ClassNotFoundException ex) {
            System.out.println("Gagal");
        }
    }
    
    public void connect(){
        try {
            this.con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.out.println("Failed");    
        }
        System.out.println(this.con);
    }
    
    public void disconnect(){
        try {
            this.con.close();
        } catch (SQLException ex) {
            System.out.println("Koneksi error");
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    }
 


