/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GAME;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author SandraPc
 */
class Bola extends Pixel {

    public Bola(int x, int y) {

        super(x, y);

        URL lokasi = this.getClass().getResource("ball.jpg");
        ImageIcon icon = new ImageIcon(lokasi);
        Image image = icon.getImage();
        this.setImage(image);

    }
    public void Gerak(int X, int Y){
        int NX = this.getPosisix() + X ;
        int NY = this.getPisisiy() + Y;
        this.setPosisix(NX);
        this.setPisisiy(NY);
    }
}
