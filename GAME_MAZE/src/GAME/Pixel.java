/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GAME;

import java.awt.Image;

/**
 *
 * @author admin
 */
public class Pixel {

    private int posisix;//horizontal
    private int posisiy;//vertkal
    private Image image;//untuk menset gambar dalam pixel posisi xy
    
    private int Jarak=20;//jarak ukuran x dan y dalam pixel 

    public Pixel(int x, int y) {
        this.posisix = x; //mendatar(horizontal)
        this.posisiy = y; //vertikal
    }
    public Image getImage() {//untuk memanggil gambar
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    

    public int getPosisiX() {//untuk memanggil posisi x
        return posisix;
    }

    public void setPosisix(int posisix) {//untuk menetukan posisi x
        this.posisix = posisix;
    }

    public int getPosisiY() {//memanggil posisi y
        return posisiy;
    }

    public void setPosisiy(int posisiy) {//menentukan posisi y
        this.posisiy = posisiy;
    }
    public boolean PosisiKiriObjek(Pixel Objek) {//menentukan posisi kiri pemain
        if (((this.getPosisiX() - Jarak) == Objek.getPosisiX()) && (this.getPosisiY() == Objek.getPosisiY())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiKananObjek(Pixel Objek) {//menentukan posisi kanan pemain
        if (((this.getPosisiX() + Jarak) == Objek.getPosisiX()) && (this.getPosisiY() == Objek.getPosisiY())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiAtasObjek(Pixel Objek) {//menentukan posisi atas objek
        if (((this.getPosisiY() - Jarak) == Objek.getPosisiY()) && (this.getPosisiX() == Objek.getPosisiX())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiBawahObjek(Pixel Objek) {//menentukan posisi bawah objek
        if (((this.getPosisiY() + Jarak) == Objek.getPosisiY()) && (this.getPosisiX() == Objek.getPosisiX())) {
            return true;
        } else {
            return false;
        }
    }
    
}
