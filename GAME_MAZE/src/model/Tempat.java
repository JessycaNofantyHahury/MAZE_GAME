/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user only
 */
public class Tempat {

    private int tinggi; // tinggi tempat Game
    private int lebar;  // lebar tempat Game
    private ArrayList<Sel> daftarSel; // daftar sel

    private String isi; // isi file konfigurasi

    public static int batasKanan;
    public static int batasBawah;

    public Tempat() {
        daftarSel = new ArrayList<Sel>();
    }

    /**
     * Fungsi pembaca file konfigurasi. Hasil pembacaan file akan disimpan di
     * atribut 'isi' dan juga di atribut daftarSel
     *
     * @param file
     */
    public void bacaKonfigurasi(File file) {

        try {
            FileInputStream input = new FileInputStream(file);
            String hasilBaca = "";
            int dataint;
            int baris = 0;
            int kolom = 0;
            int tinggi = 50;
            int lebar = 50;
            while ((dataint = input.read()) != -1) {
                if ((char) dataint != '\n') {
                    if ((char) dataint == '#') {
                        hasilBaca = hasilBaca + (char) dataint;
                        Sel sel = new Sel();
                        sel.setNilai((char) dataint);
                        sel.setWarna(Color.white);
                        sel.setBaris(baris);
                        sel.setKolom(kolom);
                        sel.setTinggi(tinggi);
                        sel.setLebar(lebar);
                        this.tambahSel(sel);
                        kolom++;
                    } else if ((char) dataint == '.') {
                        hasilBaca = hasilBaca + (char) dataint;
                        Sel sel = new Sel();
                        sel.setNilai((char) dataint);
                        sel.setWarna(Color.blue);
                        sel.setBaris(baris);
                        sel.setKolom(kolom);
                        sel.setTinggi(tinggi);
                        sel.setLebar(lebar);
                        this.tambahSel(sel);
                        kolom++;
                    } else if ((char) dataint == '@') {
                        hasilBaca = hasilBaca + (char) dataint;
                        Sel sel = new Sel();
                        sel.setNilai((char) dataint);
                        sel.setWarna(Color.PINK);
                        sel.setBaris(baris);
                        sel.setKolom(kolom);
                        sel.setTinggi(tinggi);
                        sel.setLebar(lebar);
                        this.tambahSel(sel);
                        kolom++;
                    } else if ((char) dataint == 'o') {
                        hasilBaca = hasilBaca + (char) dataint;
                        Sel sel = new Sel();
                        sel.setNilai((char) dataint);
                        sel.setWarna(Color.orange);
                        sel.setBaris(baris);
                        sel.setKolom(kolom);
                        sel.setTinggi(tinggi);
                        sel.setLebar(lebar);
                        this.tambahSel(sel);
                        kolom++;

                    }
                } else {
                    hasilBaca = hasilBaca + (char) dataint;
                    baris++;
                    kolom = 0;
                }

            }
            this.setIsi(hasilBaca);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Fungsi penambah daftar sel.
     *
     * @param sel
     */
    public void tambahSel(Sel sel) {
        daftarSel.add(sel);
    }

    /**
     * Fungsi hapus sel. Sel yang paling akhir diremove dari daftar sel.
     */
    public void hapusSel() {
        if (!daftarSel.isEmpty()) {
            daftarSel.remove(0);
        }
    }

    /**
     * @return the tinggi
     */
    public int getTinggi() {
        return tinggi;
    }

    /**
     * @param tinggi the tinggi to set
     */
    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    /**
     * @return the lebar
     */
    public int getLebar() {
        return lebar;
    }

    /**
     * @param lebar the lebar to set
     */
    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    /**
     * @return the daftarSel
     */
    public ArrayList<Sel> getDaftarSel() {
        return daftarSel;
    }

    /**
     * @param daftarSel the daftarSel to set
     */
    public void setDaftarSel(ArrayList<Sel> daftarSel) {
        this.daftarSel = daftarSel;
    }

    /**
     * @return the isi
     */
    public String getIsi() {
        return isi;
    }

    /**
     * @param isi the isi to set
     */
    public void setIsi(String isi) {
        this.isi = isi;
    }
}
