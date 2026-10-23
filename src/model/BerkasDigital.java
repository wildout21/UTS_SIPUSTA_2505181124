/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class BerkasDigital extends KoleksiPustaka {
    private double ukuranMB;
    private String tautanUnduh;

    public BerkasDigital(String kodeKoleksi, String judul, int tahunTerbit, double ukuranMB, String tautanUnduh) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    public double getUkuranMB() {
        return ukuranMB;
    }

    public String getTautanUnduh() {
        return tautanUnduh;
    }

    @Override
    public boolean cekKelayakanPinjam() {
        return true;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Berkas Digital - Ukuran: " + ukuranMB + " MB, Tautan: " + tautanUnduh;
    }
}
