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
public class Pintu extends Pixel{
    public Pintu (int x, int y){
        super (x,y);
 
        
               
        URL loc = this.getClass().getResource("gawang.jpg");
        ImageIcon g = new ImageIcon(loc);
        Image image = g.getImage();
        this.setImage(image);
    }
}
