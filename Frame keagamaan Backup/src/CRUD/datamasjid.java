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
public class datamasjid {
    private String databasename = "2210010340";
    private String username = "root";
    private String password = "";
    public static Connection connectionDB;
    
    public datamasjid (){
        try {
            String host = "jdbc:mysql://localhost/"+databasename;
            Class.forName("com.mysql.jdbc.Driver");
            connectionDB = DriverManager.getConnection(host, username, password);
            System.out.println("database terkoneksi wak");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
            
    }
    
    public void simpandata_masjid(String id, String nama, String alamat, String status, 
            String kecamatan, int no_telp, String nama_marbot){
        try {
            String sql = "insert into data_mesjid (id, nama,alamat,status,kecamatan,no_telp,nama_marbot)value (?,?,?,?,?,?,?)";
            PreparedStatement perintah = connectionDB.prepareStatement (sql);
            perintah.setString(1, id);
            perintah.setString(2, nama);
            perintah.setString(3, alamat);
            perintah.setString(4, status);
            perintah.setString(5, kecamatan);
            perintah.setInt(6, no_telp);
            perintah.setString(7, nama_marbot);
            
            perintah.executeUpdate();
            System.out.println("Alhamdulillah Guru data masjid berhasil disimpan");
            
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
}

    
