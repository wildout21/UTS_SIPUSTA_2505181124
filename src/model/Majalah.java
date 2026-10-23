/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Majalah extends Koleksi implements Terarsip {
    private int edisi;
    private String bulanTerbit;
    private String nomorRak;
    private boolean edisiTerbaru;

    public Majalah(String kodeKoleksi, String judul, int tahunTerbit, int edisi, String bulanTerbit, String nomorRak, boolean edisiTerbaru) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.nomorRak = nomorRak;
        this.edisiTerbaru = edisiTerbaru;
    }

    public int getEdisi() {
        return edisi;
    }

    public String getBulanTerbit() {
        return bulanTerbit;
    }

    public boolean isEdisiTerbaru() {
        return edisiTerbaru;
    }

    @Override
    public boolean cekKelayakanPinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public String lokasiLantai() {
        return "Lantai 2 - Ruang Referensi & Berkala";
    }

    @Override
    public String ringkasanArsip() {
        return "Rak: " + nomorRak + " (" + lokasiLantai() + ")";
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Majalah - Edisi: " + edisi + " (" + bulanTerbit + "), " + ringkasanArsip() + ", Terbaru: " + (edisiTerbaru ? "Ya" : "Tidak");
    }
}