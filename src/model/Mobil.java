package model;

public class Mobil {
    private int idMobil;
    private String namaMobil;
    private String jenisMobil;
    private double hargaPerHari;

    public Mobil(int idMobil, String namaMobil, String jenisMobil, double hargaPerHari) {
        this.idMobil = idMobil;
        this.namaMobil = namaMobil;
        this.jenisMobil = jenisMobil;
        this.hargaPerHari = hargaPerHari;
    }

    public int getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(int idMobil) {
        this.idMobil = idMobil;
    }

    public String getNamaMobil() {
        return namaMobil;
    }

    public void setNamaMobil(String namaMobil) {
        this.namaMobil = namaMobil;
    }

    public String getJenisMobil() {
        return jenisMobil;
    }

    public void setJenisMobil(String jenisMobil) {
        this.jenisMobil = jenisMobil;
    }

    public double getHargaPerHari() {
        return hargaPerHari;
    }

    public void setHargaPerHari(double hargaPerHari) {
        this.hargaPerHari = hargaPerHari;
    }
}

