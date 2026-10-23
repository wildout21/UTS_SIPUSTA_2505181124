/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

import model.KoleksiPustaka;
import java.util.Comparator;

public class UrutLayakLaluJudul implements Comparator<KoleksiPustaka> {
    @Override
    public int compare(KoleksiPustaka k1, KoleksiPustaka k2) {
        Boolean layak1 = k1.cekKelayakanPinjam();
        Boolean layak2 = k2.cekKelayakanPinjam();
        
        int hasilBandingLayak = layak2.compareTo(layak1);
        if (hasilBandingLayak != 0) {
            return hasilBandingLayak;
        }
        return k1.getJudul().compareTo(k2.getJudul());
    }
}