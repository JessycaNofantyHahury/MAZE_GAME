/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GAME;

/**
 *
 * @author W I N D O W S 1 0
 */
public class Maze {//class untuk mengoutputkan langkah yang kita masukkan
    public static String terjemah(String input) {
        String in[] = input.split(" ");
        if (in.length > 2) { // di gunakan untuk menginputkan huruf langkah pemain
            return "kalimat kepanjangan";
        } else {
            if (in.length == 2) {
                if (in[0].matches("[udrlz]")) {
                    if (in[0].equalsIgnoreCase("u")) {
                        return "naik";
                    }
                    else if (in[0].equalsIgnoreCase("u")) {
                        return "naik";
                    }
                    else if (in[0].equalsIgnoreCase("d")) {
                        return "turun";
                    }
                    else if (in[0].equalsIgnoreCase("r")) {
                        return "kanan";
                    }
                    else if (in[0].equalsIgnoreCase("l")) {
                        return "kiri";
                    }
                    else if (in[0].equalsIgnoreCase("z")) {
                        return "undo";
                    }
                    else {
                        return "bukan naik, turun, kanan, kiri";
                    }
                } else {
                    return "kata tidak dikenal";
                }
            } else {
                return "jumlah kata 1";
            }
        }
    }
}
