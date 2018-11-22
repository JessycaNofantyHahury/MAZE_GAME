/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GAME;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.JPanel;
import java.util.logging.Logger;

/**
 *
 * @author W I N D O W S 1 0
 */
public class Peta extends JPanel {

    private File AlamatPeta;
    private ArrayList AllPerintah = new ArrayList();
    private ArrayList Tembok = new ArrayList();
    private ArrayList Bola = new ArrayList();
    private ArrayList Gawang = new ArrayList();
    private ArrayList Map = new ArrayList();
    private Pemain sokoban;
    private int Lebar = 0;
    private int Tinggi = 0;
    private int Jarak = 20;

    public Peta(File file) {
        setPeta(file);
    }

    public int getLebar() {
        return Lebar;
    }

    public int getTinggi() {
        return Tinggi;
    }

    public void setPeta(File file)  {

        try {
            if (file != null) {
                FileInputStream input = new FileInputStream(file);
                AlamatPeta = file;
                int PosisiX = 0;// posisi awal
                int PosisiY = 0;// posisi awal
                Tembok wall;
                Bola b;
                Gawang a;
                int Data;
                while ((Data = input.read()) != -1) { // baca konfirgurasi
                    char elemen = (char) Data;
                    if (elemen == '\n') {
                        PosisiY += Jarak;
                        if (this.Lebar < PosisiX) {
                            this.Lebar = PosisiX;

                        }
                        PosisiX = 0;

                    } else if (elemen == '#') {
                        wall = new Tembok(PosisiX, PosisiY);
                        Tembok.add(wall);
                        PosisiX += Jarak;
                    } else if (elemen == 'X') {
                        b = new Bola(PosisiX, PosisiY);
                        Bola.add(b);
                        PosisiX += Jarak;
                    } else if (elemen == 'O') {
                        a = new Gawang(PosisiX, PosisiY);
                        Gawang.add(a);
                        PosisiX += Jarak;
                    } else if (elemen == '@') {
                        sokoban = new Pemain(PosisiX, PosisiY);
                        PosisiX += Jarak;

                    } else if (elemen == '.') {
                        PosisiX += Jarak;
                    }
                    Tinggi = PosisiY;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Peta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
