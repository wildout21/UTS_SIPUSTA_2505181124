/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eksepsi;

/**
 *
 * @author LENOVO
 */
public class KoleksiTidakLayakException extends PustakaException {
    public KoleksiTidakLayakException(String judul) {
        super("Maaf, koleksi \"" + judul + "\" saat ini tidak memenuhi syarat untuk dipinjam (sedang dalam perbaikan atau merupakan edisi terbaru).");
    }
}

