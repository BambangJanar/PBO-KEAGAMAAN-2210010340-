/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aldy
 */
public class DataKonsultasi extends datamaster {
    private String tanggalKonsultasi;
    private String diagnosa;

    // Constructor
    public DataKonsultasi(int id, String nama, int umur, String tanggalKonsultasi, String diagnosa) {
        super(id, nama, umur);
        this.tanggalKonsultasi = tanggalKonsultasi;
        this.diagnosa = diagnosa;
    }

    // Getters and Setters
    public String getTanggalKonsultasi() {
        return tanggalKonsultasi;
    }

    public void setTanggalKonsultasi(String tanggalKonsultasi) {
        this.tanggalKonsultasi = tanggalKonsultasi;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }

    @Override
    public String toString() {
        return "DataKonsultasi{" +
               "id=" + getId() +
               ", nama='" + getNama() + '\'' +
               ", umur=" + getUmur() +
               ", tanggalKonsultasi='" + tanggalKonsultasi + '\'' +
               ", diagnosa='" + diagnosa + '\'' +
               '}';
    }
}

