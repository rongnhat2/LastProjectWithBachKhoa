/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animation;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Kirrnguyen
 */
public class PlayerStand extends AnimationInterface{
    String[] assets_array = {
        "ninja_01",
        "ninja_02",
    };
    Image image;
    public PlayerStand(){
        super();
        image = getImageIcon("ninja_01");
    }
    public void update(int direction){
        if (direction == 2) {
            image = flipImage(getImageIcon("ninja_01"));
        } else{
            image = getImageIcon("ninja_01");
        }
    }
    public void render(Graphics g2,int x,int y){
        g2.drawImage(image, x, y, 20, 28, null);
    }
}
