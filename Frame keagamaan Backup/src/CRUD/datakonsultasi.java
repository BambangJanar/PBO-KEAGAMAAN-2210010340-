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

/**
 *
 * @author Aldy
 */
public class datakonsultasi {
    private String databasename = "2210010340";
    private String username = "root";
    private String password = "";
    public static Connection connectionDB;
    
 
    public datakonsultasi (){
        try {
            String host = "jdbc:mysql://localhost/"+databasename;
            Class.forName("com.mysql.jdbc.Driver");
            connectionDB = DriverManager.getConnection(host, username, password);
            System.out.println("database terkoneksi");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
            
    }
    
    public void simpandata_konsultasi(String Nomor, String Konsultasi_pernikahan, String Konsultasi_hakwaris, String Konsultasi_masukislam){
        try {
            String sql = "insert into data_konsultasi (Nomor, Konsultasi_pernikahan,Konsultasi_hakwaris,Konsultasi_masukislam)value (?,?,?,?)";
            PreparedStatement perintah = connectionDB.prepareStatement (sql);
            perintah.setString(1, Nomor);
            perintah.setString(2, Konsultasi_pernikahan);
            perintah.setString(3, Konsultasi_hakwaris);
            perintah.setString(4, Konsultasi_masukislam);
            
            perintah.executeUpdate();
            System.out.println("data konsultasi berhasil disimpan");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
    public void ubahdata_konsultasi(String Nomor, String Konsultasi_pernikahan, String Konsultasi_hakwaris, String Konsultasi_masukislam){
        try{ 
            String SQL="UPDATE data_konsultasi SET Konsultasi_pernikahan =?, Konsultasi_hakwaris=?, Konsultasi_masukislam=? WHERE Nomor=?";
            
            PreparedStatement perintah = connectionDB.prepareStatement(SQL);
            perintah.setString(1, Konsultasi_pernikahan);
            perintah.setString(2, Konsultasi_hakwaris);
            perintah.setString(3, Konsultasi_masukislam);
            perintah.setString(4, Nomor);
            perintah.executeUpdate();
            System.out.println("Data berhasil diubah");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            }
            
    public void hapusdata_konsultasi(String Nomor){
        try {
             String SQL="DELETE FROM data_konsultasi WHERE nomor=?";
             PreparedStatement perintah = connectionDB.prepareStatement(SQL);
             perintah.setString(1,Nomor);
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
