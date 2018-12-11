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
 * @author W I N D O W S 1 0
 */
public class Pemain extends Pixel{
    public Pemain (int x, int y){
        super (x,y);
        
        URL lokasi = this.getClass().getResource("pemain.png");
        ImageIcon icon = new ImageIcon(lokasi);
        Image image = icon.getImage();
        this.setImage(image);
      }
    public void Gerak(int x, int y){
        int NX = this.getPosisix()+x;
        int NY = this.getPisisiy()+y;
        this.setPosisix(NX);
        this.setPisisiy(NY);
    }
    
}
