/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GAME;

import java.awt.Image;

/**
 *
 * @author W I N D O W S 1 0
 */
public class Pixel {
    
    private int posisix; // untuk horizontal
    private int pisisiy; // untuk vertikal
    private Image image; // untuk menset gambar dalam pixel
    private int Jarak =20; // jarak uk x dan y dalam pixel

    public Pixel(int x, int y) {
        this.posisix = x;
        this.pisisiy = y;
    }

    public int getPosisix() {
        return posisix;
    }

    public void setPosisix(int posisix) {
        this.posisix = posisix;
    }

    public int getPisisiy() {
        return pisisiy;
    }

    public void setPisisiy(int pisisiy) {
        this.pisisiy = pisisiy;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


    public boolean PosisiKiriObjek(Pixel Objek) {//menentukan posisi kiri pemain
        if (((this.getPosisix()- Jarak) == Objek.getPosisix()) && (this.getPisisiy()== Objek.getPisisiy())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiKananObjek(Pixel Objek) {//menentukan posisi kanan pemain
        if (((this.getPosisix()+ Jarak) == Objek.getPosisix()) && (this.getPisisiy()== Objek.getPisisiy())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiAtasObjek(Pixel Objek) {//menentukan posisi atas objek
        if (((this.getPisisiy()- Jarak) == Objek.getPisisiy()) && (this.getPosisix()== Objek.getPosisix())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiBawahObjek(Pixel Objek) {//menentukan posisi bawah objek
        if (((this.getPisisiy()+ Jarak) == Objek.getPisisiy()) && (this.getPosisix()== Objek.getPosisix())) {
            return true;
        } else {
            return false;
        }
    }
    
}
