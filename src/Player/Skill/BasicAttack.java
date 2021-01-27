/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player.Skill;

import Animation.PlayerAttack;
import static Window.GameLoop.DELTA_TIME;
import static Window.KPanel.map;
import static Window.KPanel.player;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Kirrnguyen
 */
public class BasicAttack {
    // thời điểm tấn công
    long current_time;
    boolean attack = true; // có thể tấn công hay không ?
    double timeskill1 = 1; // thoi gian delay skill
    double cooldown = 0; // giam thoi gian danh %
    double realtime ; // thời gian cooldown thực tế
    public static int MonAtking = 0; // vị trí quái vật bị tấn công
    public static boolean atking; // bấm nút tấn công
    
    
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
            
        }
    }
    
    public void render(Graphics g){
        g.setColor(Color.red);
        if(player.getDirection() == 1){
            g.drawRect((int) player.getX() - 12 - 12 + map.xMap,(int)  player.getY() - 12 - 24 + map.yMap, 48, 24);
        }else if(player.getDirection() == 2){
            g.drawRect((int) player.getX() + map.xMap,(int)  player.getY() - 12 - 12 + map.yMap, 24, 48);
        }else if(player.getDirection() == 3){
            g.drawRect((int) player.getX() - 12 - 12 + map.xMap,(int)  player.getY() + map.yMap, 48, 24);
        }else{
            g.drawRect((int) player.getX() - 12 - 12 + map.xMap,(int)  player.getY() - 12 - 12 + map.yMap, 24, 48);
        }
    }

    public long getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(long current_time) {
        this.current_time = current_time;
    }
    
}
