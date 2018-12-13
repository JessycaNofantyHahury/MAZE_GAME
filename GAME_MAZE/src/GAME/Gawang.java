/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GAME;

/**
 *
 * @author SandraPc
 */


import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

 class Gawang extends Pixel{
    public Gawang (int x, int y){
        super (x,y);
        
        URL lokasi = this.getClass().getResource("gawang.jpg");
        ImageIcon icon = new ImageIcon(lokasi);
        Image image = icon.getImage();
        this.setImage(image);
}}
