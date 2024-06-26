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
public class data_pegawai {
    private String databasename = "2210010340";
    private String username = "root";
    private String password = "";
    public static Connection connectionDB;
    
 
    public data_pegawai (){
        try {
            String host = "jdbc:mysql://localhost/"+databasename;
            Class.forName("com.mysql.jdbc.Driver");
            connectionDB = DriverManager.getConnection(host, username, password);
            System.out.println("database terkoneksi");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
            
    }
    
    public void simpandata_pegawai(int NIP, String nama_pegawai, String jabatan, String alamat, String jeniskelamin){
        try {
            String sql = "insert into data_pegawai (NIP, nama_pegawai,jabatan, alamat, jeniskelamin)value (?,?,?,?,?)";
            PreparedStatement perintah = connectionDB.prepareStatement (sql);
            perintah.setInt(1, NIP);
            perintah.setString(2, nama_pegawai);
            perintah.setString(3, jabatan);
            perintah.setString(4, alamat);
            perintah.setString(5, jeniskelamin);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
    
    public void ubahdata_pegawai(int NIP, String nama_pegawai, String jabatan, String alamat, String jeniskelamin){
        try{ 
            String SQL="UPDATE data_pegawai SET nama_pegawai=?,jabatan=?,alamat=?,jeniskelamin=?, WHERE NIP=?";
            
            PreparedStatement perintah = connectionDB.prepareStatement(SQL);
            perintah.setString(1, nama_pegawai);
            perintah.setString(2, jabatan);
            perintah.setString(3, alamat);
            perintah.setString(4, jeniskelamin);
            perintah.setInt(5, NIP);
            perintah.executeUpdate();
            System.out.println("Data berhasil diubah Mang");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            }
    
    public void hapusdata_pegawai(String nama_pegawai ){
        try {
             String SQL="DELETE FROM data_pegawai WHERE nama_pegawai=?";
             PreparedStatement perintah = connectionDB.prepareStatement(SQL);
             perintah.setString(1,nama_pegawai);
             perintah.executeUpdate();
             System.out.println("Data berhasil dihapus");
            } catch (Exception e) {
                    System.err.println(e.getMessage());
            }
            }
}
