/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aldy
 */
public class datamaster {   private int id;
    private String nama;
    private int umur;

    // Constructor
    public datamaster(int id, String nama, int umur) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    @Override
    public String toString() {
        return "DataMaster{" +
               "id=" + id +
               ", nama='" + nama + '\'' +
               ", umur=" + umur +
               '}';
    }

    
}
