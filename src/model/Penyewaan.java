package model;

import java.util.Date;

public class Penyewaan {
    private int idPenyewaan;
    private int idMobil;
    private String namaPenyewa;
    private int lamaSewa;
    private double totalHarga;
    private String tanggalSewa;

    public Penyewaan(int idPenyewaan, int idMobil, String namaPenyewa, int lamaSewa, double totalHarga, String tanggalSewa) {
        this.idPenyewaan = idPenyewaan;
        this.idMobil = idMobil;
        this.namaPenyewa = namaPenyewa;
        this.lamaSewa = lamaSewa;
        this.totalHarga = totalHarga;
        this.tanggalSewa = tanggalSewa;
    }

    public int getIdPenyewaan() {
        return idPenyewaan;
    }

    public void setIdPenyewaan(int idPenyewaan) {
        this.idPenyewaan = idPenyewaan;
    }

    public int getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(int idMobil) {
        this.idMobil = idMobil;
    }

    public String getNamaPenyewa() {
        return namaPenyewa;
    }

    public void setNamaPenyewa(String namaPenyewa) {
        this.namaPenyewa = namaPenyewa;
    }

    public int getLamaSewa() {
        return lamaSewa;
    }

    public void setLamaSewa(int lamaSewa) {
        this.lamaSewa = lamaSewa;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getTanggalSewa() {
        return tanggalSewa;
    }

    public void setTanggalSewa(String tanggalSewa) {
        this.tanggalSewa = tanggalSewa;
    }
}
