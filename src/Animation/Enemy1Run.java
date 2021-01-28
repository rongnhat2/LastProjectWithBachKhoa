/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animation;

import Enemy.EnemyInterface;
import static Window.GameLoop.DELTA_TIME;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Kirrnguyen
 */
public class Enemy1Run extends EnemyInterface{
    String[] assets_array = {
        "m410",
        "m410",
        "m411",
        "m410",
        "m410",
    };
    Image image;
    int frame = 0;
    int delay = 100;
    long time = 0; // update animation
    public Enemy1Run(){
        super();
    }
    public void update(int direction){
        if (direction == 1 ) {
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
        g2.drawImage(image, x, y, 20, 20, null);
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time_run) {
        this.time = time_run;
    }
}
