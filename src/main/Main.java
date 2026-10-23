/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import model.BukuCetak;
import model.Majalah;
import model.BerkasDigital;
import layanan.KatalogPerpustakaan;
import layanan.UrutLayakLaluJudul;
import layanan.EksporKatalog;
import eksepsi.PustakaException;

public class Main {
    public static void main(String[] args) {
        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        // Data Uji Wajib Sesuai Soal
        katalog.tambahKoleksi(new BukuCetak("BK-001", "Java How to Program", 2022, 620, "A-12", false));
        katalog.tambahKoleksi(new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "B-04", true));
        katalog.tambahKoleksi(new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, 88, "Agustus", "C-01", true));
        katalog.tambahKoleksi(new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, 87, "Juli", "C-02", false));
        katalog.tambahKoleksi(new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15.0, "unduh.polmed.ac.id/bd001"));
        katalog.tambahKoleksi(new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8.0, "unduh.polmed.ac.id/bd002"));

        System.out.println("================================================================================");
        System.out.println("1 & 3. CETAK STATUS AWAL KATALOG (POLIMORFISME TANPA INSTANCEOF)");
        System.out.println("================================================================================");
        katalog.cetakStatus();

        System.out.println("\n================================================================================");
        System.out.println("4. PENGURUTAN MENGGUNAKAN COMPARATOR (UrutLayakLaluJudul)");
        System.out.println("================================================================================");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        System.out.println("\n================================================================================");
        System.out.println("5. PENGUJIAN METHOD PINJAM & PENANGANAN EKSEPSI");
        System.out.println("================================================================================");
        
        try {
            System.out.println("Mencoba meminjam BK-001...");
            katalog.pinjam("BK-001");
        } catch (PustakaException e) {
            System.out.println("Gagal: " + e.getMessage());
        }

        try {
            System.out.println("\nMencoba meminjam kembali BK-001 yang sedang dipinjam...");
            katalog.pinjam("BK-001");
        } catch (PustakaException e) {
            System.out.println("Pesan Eksepsi: " + e.getMessage());
        }

        try {
            System.out.println("\nMencoba meminjam BK-002 (sedang diperbaiki)...");
            katalog.pinjam("BK-002");
        } catch (PustakaException e) {
            System.out.println("Pesan Eksepsi: " + e.getMessage());
        }

        try {
            System.out.println("\nMencoba meminjam Majalah MJ-001 (edisi terbaru)...");
            katalog.pinjam("MJ-001");
        } catch (PustakaException e) {
            System.out.println("Pesan Eksepsi: " + e.getMessage());
        }

        System.out.println("\n================================================================================");
        System.out.println("6. EKSPOR KATALOG KE BERKAS TEKS (katalog.txt)");
        System.out.println("================================================================================");
        EksporKatalog.tulisKeBerkas("katalog.txt", katalog.getDaftarKoleksi());
    }
}
