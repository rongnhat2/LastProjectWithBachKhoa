/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player.Skill;

import static Map.PhysicalMap.enemy_01;
import static Window.GameLoop.DELTA_TIME;
import static Window.KPanel.map;
import static Window.KPanel.player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author Kirrnguyen
 */
public class BasicAttack extends SkillInterface{
    // thời điểm tấn công
    long current_time;
    boolean attack = true; // có thể tấn công hay không ?
    double timeskill1 = 1; // thoi gian delay skill
    double cooldown = 0; // giam thoi gian danh %
    double realtime ; // thời gian cooldown thực tế
    public static int MonAtking = 0; // vị trí quái vật bị tấn công
    public static boolean atking; // bấm nút tấn công
    
    
    String[] assets_array = {
        "a0",
        "a1",
        "a2",
        "a3",
        "a4",
    };
    Image image;
    int frame = 0;
    int delay = 15;
    long time = 0; // update animation
    
    
    public BasicAttack(){
        
    }
    public void reload(){
        if(DELTA_TIME - current_time >=  realtime * 1000){
            attack = true;
        }
    }
    
    public void update(int direction){
        
        // tính cooldown skill
        realtime = timeskill1 - (cooldown / 100 * timeskill1);
        
        if(atking){
            // render Image
            image = getImageIcon(assets_array[frame]);
            NextFrame();
            // attack
            checkAttack();
        }
    }
    
    
    public void checkAttack(){
        for(int i = 0; i<enemy_01.size(); i++){
            if (getBoundAttack().intersects(enemy_01.get(i).getBoundEnemy())) {
                enemy_01.get(i).hp -= 10;   
            }
            
        }
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
    public void render(Graphics g){
        g.setColor(Color.red);
        
        if(atking){
            g.drawImage(image, (int) player.getX() - 48 + map.xMap,(int)  player.getY() - 48 + map.yMap, 96, 96, null);
        }
        
        g.drawRect((int) player.getX() - 36 + map.xMap,(int)  player.getY() - 36 + map.yMap, 72, 72);
    }

    public long getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(long current_time) {
        this.current_time = current_time;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
    
    public Rectangle getBoundAttack(){
        Rectangle bound = new Rectangle();
        bound.x = (int) player.getX() - 36 + map.xMap;
        bound.y = (int)  player.getY() - 36 + map.yMap;
        bound.width = 72;
        bound.height = 72;
        return bound;
    }
}
