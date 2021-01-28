/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animation;

import static Window.GameLoop.DELTA_TIME;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Kirrnguyen
 */
public class PlayerRun extends AnimationInterface{
    String[] assets_array = {
        "ninja_03",
        "ninja_04",
        "ninja_05",
        "ninja_06",
        "ninja_07",
    };
    Image image;
    int frame = 0;
    int delay = 25;
    long time = 0; // update animation
    public PlayerRun(){
        super();
    }
    public void update(int direction){
        if (direction == 2 ) {
            image = flipImage(getImageIcon(assets_array[frame]));
        } else{
            image = getImageIcon(assets_array[frame]);
        }
        NextFrame();
    }
    public void NextFrame(){
        if(time != 0 && DELTA_TIME - time >= delay){
            if(frame >= assets_array.length - 1){
                frame = 0;
            }
            else frame++;
            time = DELTA_TIME;
        }
    }
    public void render(Graphics g2,int x,int y){
        g2.drawImage(image, x, y, 20, 28, null);
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time_run) {
        this.time = time_run;
    }

    
}
