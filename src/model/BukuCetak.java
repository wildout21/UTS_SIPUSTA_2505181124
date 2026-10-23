/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class BukuCetak extends KoleksiPustaka implements Terarsip {
    private int jumlahHalaman;
    private String nomorRak;
    private boolean sedangDiperbaiki;

    public BukuCetak(String kodeKoleksi, String judul, int tahunTerbit, int jumlahHalaman, String nomorRak, boolean sedangDiperbaiki) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.nomorRak = nomorRak;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    public int getJumlahHalaman() {
        return jumlahHalaman;
    }

    public boolean isSedangDiperbaiki() {
        return sedangDiperbaiki;
    }

    @Override
    public boolean cekKelayakanPinjam() {
        return !sedangDiperbaiki;
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public String lokasiLantai() {
        return "Lantai 1 - Gedung Perpustakaan Utama";
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Buku Cetak - Halaman: " + jumlahHalaman + ", " + ringkasanArsip() + ", Perbaikan: " + (sedangDiperbaiki ? "Ya" : "Tidak");
    }
}
}
