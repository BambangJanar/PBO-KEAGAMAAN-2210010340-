/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package keagamaan;
import CRUD.database;


/**
 *
 * @author Aldy
 */
//import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        database dbconnect = new database();
       //dbconnect.simpanuji("2210010340", "ANITAMAXWYN", "DrakeSupremacy", "23889875677");
       // dbconnect.hapusuji("07");
       dbconnect.cariuji("2210010340");
       dbconnect.datauji();
    }
}

//    public static void main(String[] args) {
//        // Input data untuk DataMaster
//        try (Scanner scanner = new Scanner(System.in)) {
//            // Input data untuk DataMaster
//            System.out.println("Masukkan ID:");
//            int id = scanner.nextInt();
//            scanner.nextLine();  // Consume newline
//            
//            System.out.println("Masukkan Nama:");
//            String nama = scanner.nextLine();
//            
//            System.out.println("Masukkan Umur:");
//            int umur = scanner.nextInt();
//            scanner.nextLine();  // Consume newline
//            
//            // Input data untuk DataKonsultasi
//            System.out.println("Masukkan Tanggal Konsultasi (yyyy-mm-dd):");
//            String tanggalKonsultasi = scanner.nextLine();
//            
//            System.out.println("Masukkan Diagnosa:");
//            String diagnosa = scanner.nextLine();
//            
//            // Buat objek DataKonsultasi
//            datakonsultasi konsultasi = new datakonsultasi(id, nama, umur, tanggalKonsultasi, diagnosa);
//            
//            // Output
//            System.out.println(konsultasi.toString());
//        }
//    }
//
//    private static class datakonsultasi {
//
//        public datakonsultasi(int id, String nama, int umur, String tanggalKonsultasi, String diagnosa) {
//        }
//    }

