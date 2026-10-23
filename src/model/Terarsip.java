/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public interface Terarsip {
    String nomorRak();
    String lokasiLantai();
    
    default String ringkasanArsip() {
        return "Rak: " + nomorRak() + " di " + lokasiLantai();
    }
}
