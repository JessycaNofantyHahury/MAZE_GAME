/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GAME;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author W I N D O W S 1 0
 */
public class Peta extends JPanel {

    private File AlamatPeta;
    private ArrayList AllPerintah = new ArrayList();
    private ArrayList Tembok = new ArrayList();
    private ArrayList Bola = new ArrayList();
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

    public void setPeta(File file) {

        try {
            if (file != null) {
                FileInputStream input = new FileInputStream(file);
                AlamatPeta = file;
                int posisiX = 0;// posisi awal
                int posisiY = 0;// posisi awal
               

            }
        }
    }
}
