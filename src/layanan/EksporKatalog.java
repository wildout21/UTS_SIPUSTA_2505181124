/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

import model.Koleksi;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EksporKatalog {
    public static void tulisKeBerkas(String namaFile, List<Koleksi> daftarKoleksi) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile))) {
            writer.write(String.format("%-10s | %-32s | %-12s | %-15s", "KODE", "JUDUL", "TAHUN", "STATUS LAYAK"));
            writer.newLine();
            writer.write("--------------------------------------------------------------------------------");
            writer.newLine();

            for (Koleksi k : daftarKoleksi) {
                String statusLayak = k.cekKelayakanPinjam() ? "Layak" : "Tidak Layak";
                writer.write(String.format("%-10s | %-32s | %-12d | %-15s", 
                        k.getKodeKoleksi(), 
                        k.getJudul(), 
                        k.getTahunTerbit(), 
                        statusLayak));
                writer.newLine();
            }
            System.out.println("[INFO] Katalog berhasil diekspor ke berkas: " + namaFile);
        } catch (IOException e) {
            System.err.println("[ERROR] Terjadi kesalahan saat menulis berkas: " + e.getMessage());
        }
    }
}