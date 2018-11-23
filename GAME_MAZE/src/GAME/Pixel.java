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
class Pixel {
    
    private int posisix;
    private int pisisiy;
    private Image image;
    private int Jarak =20;

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

    public int getJarak() {
        return Jarak;
    }

    public void setJarak(int Jarak) {
        this.Jarak = Jarak;
    }
    
    
    
    
    
}
