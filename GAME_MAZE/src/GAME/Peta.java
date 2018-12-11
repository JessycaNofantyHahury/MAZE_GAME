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
import javax.swing.JPanel;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author W I N D O W S 1 0
 */
public class Peta extends JPanel {

    private File AlamatPeta;
    private ArrayList AllPerintah = new ArrayList();
    private ArrayList tembok = new ArrayList();
    private ArrayList bola = new ArrayList();
    private ArrayList gawang = new ArrayList();
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
                        tembok.add(wall);
                        PosisiX += Jarak;
                    } else if (elemen == 'X') {
                        b = new Bola(PosisiX, PosisiY);
                        bola.add(b);
                        PosisiX += Jarak;
                    } else if (elemen == 'O') {
                        a = new Gawang(PosisiX, PosisiY);
                        gawang.add(a);
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //tempat gambar
        g.setColor(new Color(255, 255, 255));//set panel warna putih
        g.fillRect(0, 0, this.getLebar(), this.getTinggi());//set  tinggi lebar sesuai ....
        Map.addAll(tembok);
        Map.addAll(gawang);
        Map.addAll(bola);
        Map.add(sokoban);
        for (int i = 0; i < Map.size(); i++) {
            if (Map.get(i) != null) {
                Pixel item = (Pixel) Map.get(i);
                g.drawImage(item.getImage(), item.getPosisix(), item.getPisisiy(), this);
            }
        }
    }

    public void PerintahTukGerak(String input) {
        String inp[] = input.split(" ");
        if (inp.length > 2) {
            JOptionPane.showMessageDialog(null, "junlah kata lebih dari 2");

        } else if (inp.length == 2) {
            if (inp[0].matches("[udrlz]")) {
                AllPerintah.add(input);
                if (inp[0].equalsIgnoreCase("u")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(inp[1])); i++) {
                        if (CekObjekTabrakTembok(sokoban, "u")) {
                            return;

                        } else if (cekBolaPemainTabrakTembok("u")) {
                            return;
                        } else {
                            //sokoban
                            repaint();
                        }

                    }

                }
            }
        }

    }

    private boolean CekObjekTabrakTembok(Pixel pemain, String input) {
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
                Tembok wall = (Tembok) tembok.get(i);
                if (pemain.PosisiKananObjek(wall)) {
                    bantu = false;
                    break;

                }

            }
        } else if (input.equalsIgnoreCase("u")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);
                if (pemain.PosisiAtasObjek(wall)) {
                    bantu = true;
                    break;

                }

            }
        } else if (input.equalsIgnoreCase("d")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);
                if (pemain.PosisiBawahObjek(wall)) {
                    bantu = true;
                    break;

                }
            }
        }
        return bantu;
    }

    private boolean cekBolaTabrakBola(Pixel pemain, String input) {
        boolean bantu = false;
        if (input.equalsIgnoreCase("1")) {
            for (int i = 0; i < bola.size(); i++) {
                Bola wall = (Bola) bola.get(i);
                if (pemain.PosisiKiriObjek(wall)) {
                    bantu = true;
                    break;
                }

            }

        } else if (input.equalsIgnoreCase("r")) {
            for (int i = 0; i < bola.size(); i++) {
                Bola wall = (Bola) bola.get(i);
                if (pemain.PosisiKananObjek(wall)) {
                    bantu = true;
                    break;

                }

            }
        } else if (input.equalsIgnoreCase("d")) {
            for (int i = 0; i < bola.size(); i++) {
                Bola wall = (Bola) bola.get(i);
                if (pemain.PosisiBawahObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        }
        return bantu;
    }

    private boolean cekBolaPemainTabrakTembok(String input) {
        boolean bantu = false;
        if (input.equalsIgnoreCase("1")) {
            for (int i = 0; i < bola.size(); i++) {
                Bola boll = (Bola) bola.get(i);
                if (sokoban.PosisiKiriObjek(boll)) {
                    if (cekBolaTabrakBola(boll, "1")) {
                        bantu = true;
                        break;

                    } else if (CekObjekTabrakTembok(boll, "1")) {
                        bantu = true;
                        break;

                    } else {
                        //    boll.Gerak(-jarak, 0);
                        isCompleted();

                    }
                }

            }

        } else if (input.equalsIgnoreCase("r")) {
            for (int i = 0; i < bola.size(); i++) {
                Bola boll = (Bola) bola.get(i); //ambil posisi bola
                if (sokoban.PosisiKananObjek(boll)) {
                    if (cekBolaTabrakBola(boll, "r")) {
                        bantu = true;
                        break;
                    } else if (CekObjekTabrakTembok(boll, "r")) {
                        bantu = true;
                        break;
                        // } el
                    }

                }

            }
        }
        return false;
    }

    public void isCompleted() {
        int jumlahBola = bola.size();
        int gol = 0;
        for (int i = 0; i < bola.size(); i++) {
            Bola bol = (Bola) bola.get(i);
            for (int j = 0; j < gawang.size(); j++) {
                Gawang gwg = (Gawang) gawang.get(j);
                if (bol.getPosisix() == gwg.getPosisix() && bol.getPisisiy() == gwg.getPisisiy()) {
                    gol += 1;
                }
            }
        }
        if (gol == jumlahBola) {
            JOptionPane.showMessageDialog(null, "Selamat anda berhasil menyelesaikan game ini. ");
        }
    }

    public void restartLevel() {

    }

    public String getPerintah() {
        String bantu = " ";
        for (int i = 0; i < AllPerintah.size(); i++) {
            bantu = bantu + AllPerintah.get(i) + " ";

        }
        return bantu;
    }

    public boolean cekBolaKembali(String input) {
        if (input == "r") {
            for (int i = 0; i < bola.size(); i++) {
                Bola boll = (Bola) bola.get(i);
                if (sokoban.PosisiKiriObjek(boll)) {
                    for (int j = 0; j < bola.size(); j++) {
                        Bola item = (Bola) bola.get(j);
                        if (!boll.equals(item)) {
                            if (boll.PosisiKiriObjek(item)) {
                                return true;
                            }
                        }
                        if (CekObjekTabrakTembok(item, "r")) {
                            return true;

                        }

                    }
                    boll.Gerak(Jarak, 0);
                    isCompleted();
                }

            }
            return false;
        } else if (input == "1") {
            for (int i = 0; i < bola.size(); i++) {
                Bola boll = (Bola) bola.get(i);
                if (sokoban.PosisiKananObjek(boll)) {
                    for (int j = 0; j < bola.size(); j++) {
                        Bola item = (Bola) bola.get(j);
                        if (!boll.equals(item)) {
                            if (boll.PosisiKananObjek(item)) {
                                return true;

                            }
                        }
                        if (CekObjekTabrakTembok(item, "1")) {
                            return true;
                        }
                    }
                    boll.Gerak(-Jarak, 0);
                    isCompleted();
                }
            }
            return false;
        } else if (input == "u") {
            for (int i = 0; i < bola.size(); i++) {
                Bola boll = (Bola) bola.get(i);
                if (sokoban.PosisiBawahObjek(boll)) {
                    for (int j = 0; j < bola.size(); j++) {
                        Bola item = (Bola) bola.get(j);
                        if (!boll.equals(item)) {
                            if (boll.PosisiBawahObjek(item)) {
                                return true;
                            }
                        }
                        if (CekObjekTabrakTembok(item, "u")) {
                            return true;
                        }
                    }
                    boll.Gerak(0, -Jarak);
                    isCompleted();
                }
            }

        } else if (input == "d") {
            for (int i = 0; i < bola.size(); i++) {
                Bola boll = (Bola) bola.get(i);
                if (sokoban.PosisiAtasObjek(boll)) {
                    for (int j = 0; j < bola.size(); j++) {
                        Bola item = (Bola) bola.get(j);
                        if (!boll.equals(item)) {
                            if (boll.PosisiAtasObjek(item)) {
                                return true;
                            }
                        }
                        if (CekObjekTabrakTembok(item, "d")) {
                            return true;
                        }
                    }
                    boll.Gerak(0, Jarak);
                    isCompleted();

                }
            }
        }
        return false;
    }

    public void kembali() {
        for (int i = AllPerintah.size() - 1; i >= 0; i--) {
            String input = AllPerintah.get(i).toString();
            String[] kembali = input.split(" ");
            if (kembali[0].equalsIgnoreCase(" u ")) {
                if (CekObjekTabrakTembok(sokoban, " d")) {
                    return;

                } else if (cekBolaKembali(" d")) {
                    return;
                } else {
                    sokoban.Gerak(0, Jarak);
                    repaint();
                }
                break;

            } else if (kembali[0].equalsIgnoreCase(" d ")) {
                if (CekObjekTabrakTembok(sokoban, " u ")) {
                    return;

                } else if (cekBolaKembali(" u")) {
                    return;
                } else {
                    sokoban.Gerak(0, -Jarak);
                    repaint();
                }
                break;
            } else if (kembali[0].equalsIgnoreCase(" l")) {
                if (CekObjekTabrakTembok(sokoban, " r ")) {
                    return;

                } else if (cekBolaKembali(" r ")) {
                    return;
                } else {
                    sokoban.Gerak(Jarak, 0);
                    repaint();
                }
                break;
            } else if (kembali[0].equalsIgnoreCase(" r ")) {
                if (CekObjekTabrakTembok(sokoban, " l ")) {
                    return;

                } else if (cekBolaKembali(" l ")) {
                    return;
                } else {
                    sokoban.Gerak(-Jarak, 0);
                    repaint();
                }
                break;
            }
        }

    }

}
