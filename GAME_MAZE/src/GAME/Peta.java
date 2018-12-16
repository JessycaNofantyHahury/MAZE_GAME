/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GAME;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author W I N D O W S 1 0
 */
public class Peta extends JPanel {

    private File Alamatpeta;//digunakan untuk merestart level
    private ArrayList Allperintah = new ArrayList();//menyimpan semua perintah yang dimasukkan

    private ArrayList tembok = new ArrayList();
    //private ArrayList bola = new ArrayList();
    private ArrayList gawang = new ArrayList();
    private ArrayList map = new ArrayList();
    private Pemain soko;
    private int lebar = 0;
    private int tinggi = 0;
    private int jarak = 20;

    public Peta(File file) {
        setPeta(file);
    }

    public void setPeta(File file) {

        try {
            if (file != null) {
                FileInputStream input = new FileInputStream(file);
                Alamatpeta = file;
                int posisiX = 0;// posisi awal
                int posisiY = 0;// posisi awal
                Tembok wall;
               // Bola b;
                Pintu a;
                int data;
                while ((data = input.read()) != -1) {//untuk membaca file konfigurasi yang kita buat
                    char item = (char) data;
                    if (item == '\n') {
                        posisiY += jarak;
                        if (this.lebar < posisiX) {
                            this.lebar = posisiX;
                        }
                        posisiX = 0;
                    } else if (item == '#') {
                        wall = new Tembok(posisiX, posisiY);
                        tembok.add(wall);
                        posisiX += jarak;

                    } else if (item == 'o') {
                        a = new Pintu(posisiX, posisiY);
                        gawang.add(a);
                        posisiX += jarak;
                    } else if (item == '@') {
                        soko = new Pemain(posisiX, posisiY);
                        posisiX += jarak;
                    } else if (item == '.') {//nilai xy nambah tetapi tidah di hitung
                        posisiX += jarak;
                    }
                    tinggi = posisiY;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Peta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //tempat gambar
        g.setColor(new Color(255, 255, 255));//set panel warna putih
        g.fillRect(0, 0, this.getLebar(), this.getTinggi());//set  tinggi lebar sesuai ....
        map.addAll(tembok);
        map.addAll(gawang);
       // map.addAll(bola);
        map.add(soko);
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i) != null) {
                Pixel item = (Pixel) map.get(i);
                g.drawImage(item.getImage(), item.getPosisiX(), item.getPosisiY(), this);
            }
        }
    }

    public int getLebar() {
        return this.lebar;
    }

    public int getTinggi() {
        return this.tinggi;
    }

    public void PerintahGerak(String input) {
        String in[] = input.split(" ");
        if (in.length > 2) {
            JOptionPane.showMessageDialog(null, "jumlah kata lebih dari 2");
        } else if (in.length == 2) {
            if (in[0].matches("[udrlz]")) {
                Allperintah.add(input);
                if (in[0].equalsIgnoreCase("u")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekObjekNabrakTembok(soko, "u")) {
                            return;

                        } else {
                            soko.Gerak(0, -jarak);
                            repaint();
                        }
                    }

                } else if (in[0].equalsIgnoreCase("d")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekObjekNabrakTembok(soko, "d")) {
                            return;

                        } else {
                            soko.Gerak(0, jarak);
                            repaint();
                        }
                    }

                } else if (in[0].equalsIgnoreCase("r")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekObjekNabrakTembok(soko, "r")) {
                            return;

                        } else {
                            soko.Gerak(jarak, 0);
                            repaint();
                        }
                    }

                } else if (in[0].equalsIgnoreCase("l")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekObjekNabrakTembok(soko, "l")) {
                            return;

                        } else {
                            soko.Gerak(-jarak, 0);
                            repaint();
                        }
                    }

                } else if (in[0].equalsIgnoreCase("z")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        undo();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "kata tidak dikenal");
                }
            } else {
                JOptionPane.showMessageDialog(null, "kata tidak dikenal");
            }
        } else {
            JOptionPane.showMessageDialog(null, "jumlah kata hanya satu");
        }
    }

    private boolean cekObjekNabrakTembok(Pixel pemain, String input) {
        boolean bantu = false;
        if (input.equalsIgnoreCase("l")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);//ambil posisi tembok
                if (pemain.PosisiKiriObjek(wall)) {
                    bantu = true;
                    break;
                }
            }

        } else if (input.equalsIgnoreCase("r")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);//ambil posisi tembok
                if (pemain.PosisiKananObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("u")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);//ambil posisi tembok
                if (pemain.PosisiAtasObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("d")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);//ambil posisi tembok
                if (pemain.PosisiBawahObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        }
        return bantu;//default return false
    }
    

    public void restartLevel() {
        Allperintah.clear();//hapus semua perintah yang tersimpan
        gawang.clear();//hapus gawang
        //bola.clear();//hapus bola
        tembok.clear();//hapus tembok
        map.clear();//hapus map
        setPeta(Alamatpeta);//set ulang gambar peta
        repaint();//gambar ulang
    }

    public String getTeksPerintah() {
        String bantu = "";
        for (int i = 0; i < Allperintah.size(); i++) {
            bantu = bantu + Allperintah.get(i) + " ";
        }
        return bantu;
    }

    public void undo() {
        for (int i = Allperintah.size() - 1; i >= 0; i--) {
            String input = Allperintah.get(i).toString();
            String[] undo = input.split(" ");
            if (undo[0].equalsIgnoreCase("u")) {
                if (cekObjekNabrakTembok(soko, "d")) {
                    return;

                } else {
                    soko.Gerak(0, jarak);
                    repaint();
                }
                break;
            } else if (undo[0].equalsIgnoreCase("d")) {
                if (cekObjekNabrakTembok(soko, "u")) {
                    return;
            
                } else {
                    soko.Gerak(jarak, 0);
                    repaint();
                }
                break;
            } else if (undo[0].equalsIgnoreCase("r")) {
                if (cekObjekNabrakTembok(soko, "l")) {
                    return;

                } else {
                    soko.Gerak(-jarak, 0);
                    repaint();
                }
                break;
            }
        }
    }
}
