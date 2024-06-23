/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement; 
//perintah sql

/**
 *
 * @author Aldy
 */
public class database {
    private String databasename = "2210010340";
    private String username = "root";
    private String password = "";
    public static Connection connectionDB;
    
 
    public database (){
        try {
            String host = "jdbc:mysql://localhost/"+databasename;
            Class.forName("com.mysql.jdbc.Driver");
            connectionDB = DriverManager.getConnection(host, username, password);
            System.out.println("database terkoneksi");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
            
    }
    
    public void simpanuji(String nik, String nama, String telp, String alamat){
        try {
            String sql = "insert into uji (nik, nama,telp, alamat)value (?,?,?,?)";
            PreparedStatement perintah = connectionDB.prepareStatement (sql);
            perintah.setString(1, nik);
            perintah.setString(2, nama);
            perintah.setString(3, telp);
            perintah.setString(4, alamat);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
    public void ubahuji(String  nik, String nama, String telp, String alamat){
        try{ 
            String SQL="UPDATE UJI SET nama =?, telp=?, alamat=? WHERE nik=?";
            
            PreparedStatement perintah = connectionDB.prepareStatement(SQL);
            perintah.setString(1, nama);
            perintah.setString(2, telp);
            perintah.setString(3, alamat);
            perintah.setString(4, nik);
            perintah.executeUpdate();
            System.out.println("Data berhasil diubah");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            }
            
    public void hapusuji(String nik){
        try {
             String SQL="DELETE FROM uji WHERE nik=?";
             PreparedStatement perintah = connectionDB.prepareStatement(SQL);
             perintah.setString(1,nik);
             perintah.executeUpdate();
             System.out.println("Data berhasil dihapus");
            } catch (Exception e) {
                    System.err.println(e.getMessage());
            }
            }
    public void cariuji(String nik){
        try {
            String SQL="SELECT*FROM uji WHERE nik=?";
            PreparedStatement perintah = connectionDB.prepareStatement(SQL);
            perintah.setString(1,nik);
            ResultSet data= perintah.executeQuery();
            while(data.next()){
                System.out.println("NIK :"+data.getString("nik"));
                System.out.println("Nama :"+data.getString("nama"));
                System.out.println("Telp :"+data.getString("telp"));
                System.out.println("Alamat :"+data.getString("alamat"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void datauji(){
        try {
            Statement stmt = connectionDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM uji ORDER BY nik ASC");
            while(baris.next()){
                System.out.println(baris.getString("nik")+" | "+
                        baris.getString("nama")+" | "+ 
                        baris.getString("telp")+" | "+
                        baris.getString("alamat"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    }
