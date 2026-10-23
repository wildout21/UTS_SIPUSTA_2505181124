/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

import model.Koleksi;
import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
import eksepsi.PustakaException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KatalogPerpustakaan {
    private List<Koleksi> daftarKoleksi;

    public KatalogPerpustakaan() {
        this.daftarKoleksi = new ArrayList<>();
    }

    public void tambahKoleksi(Koleksi koleksi) {
        daftarKoleksi.add(koleksi);
    }

    public List<Koleksi> getDaftarKoleksi() {
        return daftarKoleksi;
    }

    public void cetakStatus() {
        System.out.println("=== STATUS KATALOG PERPUSTAKAAN ===");
        for (Koleksi k : daftarKoleksi) {
            System.out.println(k.deskripsi());
            System.out.println("-> Status Layak Pinjam: " + (k.cekKelayakanPinjam() ? "LAYAK" : "TIDAK LAYAK"));
            System.out.println("--------------------------------------------------------------------------------");
        }
    }

    public void urut(Comparator<Koleksi> comparator) {
        daftarKoleksi.sort(comparator);
    }

    public void pinjam(String kodeKoleksi) throws PustakaException {
        Koleksi target = null;
        for (Koleksi k : daftarKoleksi) {
            if (k.getKodeKoleksi().equalsIgnoreCase(kodeKoleksi)) {
                target = k;
                break;
            }
        }

        if (target == null) {
            throw new PustakaException("Koleksi dengan kode " + kodeKoleksi + " tidak ditemukan di katalog.");
        }

        if (target.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(target.getJudul());
        }

        if (!target.cekKelayakanPinjam()) {
            throw new KoleksiTidakLayakException(target.getJudul());
        }

        target.setSedangDipinjam(true);
        System.out.println("[SUKSES] Koleksi \"" + target.getJudul() + "\" berhasil dipinjam.");
    }
}