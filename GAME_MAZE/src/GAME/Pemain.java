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
 * @author admin
 */
public class Pemain extends Pixel{

   
    public Pemain (int x, int y){
        super (x,y);
        
        URL loc = this.getClass().getResource("ball.jpg");
        ImageIcon g = new ImageIcon(loc);
        Image image = g.getImage();
        this.setImage(image);
    }
    public void Gerak(int x, int y){
        int nx = this.getPosisiX()+ x;//tergantung langkah yang kita masukkan
        int ny = this.getPosisiY()+ y;
        this.setPosisix(nx);
        this.setPosisiy(ny);
    }

   
}
