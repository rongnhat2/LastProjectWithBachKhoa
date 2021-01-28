/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemy;

import Animation.Enemy1Run;
import static Window.KPanel.map;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Kirrnguyen
 */
public class Enemy1 extends EnemyInterface{
    public Enemy1Run run;
    public Enemy1(int x,int y,int maxmove,int positon, int vector, int hp){
        this.x = x*24;
        this.y = y*24;
        this.X = x;
        this.Y = y;
        this.maxmove = maxmove;
        this.positon = positon;
        this.vector = vector;
        this.hp = hp;
        this.speed *= vector;
        run = new Enemy1Run();
    }
    public void update(){
        // di chuyển sang phải, trái phải
        if(!atk){
            if(move1){
                if(move >= maxmove || move <= -maxmove){
                    sumoftime++;
                    if(sumoftime == timeback * 100){
                        sumoftime=0;
                        speed *= -1;
                        vector *= -1;
                        move = 0;
                    }      
                }else{
                    if(positon == 0)
                        X += speed;
                    else
                        Y += speed;
                    move += speed;
                }
            }else{
                // di chuyển về tọa độ chuẩn ban đầu
//                if((int)  x + map.xMap < X*24 + map.xMap){
//                    if(speed < 0) speed *= -1;
//                    if(vector < 0) vector *= -1;
//                    x += speed * 2;
//                }
//                if((int)  x + map.xMap > X*24  + map.xMap){
//                    if(speed > 0) speed *= -1;
//                    if(vector > 0) vector *= -1;
//                    x -= speed* 2;
//                }
//                if((int)  y + map.yMap < Y*24  + map.yMap){
//                    if(speed < 0) speed *= -1;
//                    y += speed* 2;
//                }
//                if((int)  y + map.yMap > Y*24  + map.yMap){
//                    if(speed > 0) speed *= -1;
//                    y -= speed* 2;
//                }
//                
//                if((int) x >= X*24 && (int) y >= Y*24){
//                    move1 = true;
//                    if(speed < 0) speed *= -1;
//                }
            }
            
        }else{
            // nếu thấy trong phạm vi tấn công thì di chuyển
//            if(speed < 0) speed *= -1; // đéo hiểu dòng này để làm cl gì 
//            if(x + map.xMap <= player.x + map.xMap - 24/2){
//                if(speed < 0) speed *= -1;
//                if(vector < 0) vector *= -1;
//                x += speed*2;
//            }
//            if(x + map.xMap >= player.x + map.xMap - 24/2){
//                if(speed > 0) speed *= -1;
//                if(vector > 0) vector *= -1;
//                x += speed*2;
//            }
//            if(y + map.yMap <= player.y + map.yMap - 24/2){
//                if(speed < 0) speed *= -1;
//                y += speed*2;
//            }
//            if(y + map.yMap >= player.y + map.yMap - 24/2){
//                if(speed > 0) speed *= -1;
//                y += speed*2;
//            }
        }
        
        if(hp <= 0){
            alive = false;
        }
        run.update(vector);
    }
    public int percenHP(int Hp,int hp){
        double percel = (double) (10000 / Hp  * hp) /400;
        return (int) percel;
    }
    public void render(Graphics g){
        /// draw hp
        g.setColor(Color.black);
        g.fillRect((int) X + map.xMap,(int) Y + map.yMap - 7, size , 5);
        g.setColor(Color.green);
        g.fillRect((int) X + map.xMap,(int) Y + map.yMap - 7, percenHP(HP, hp) , 5);
        ///
        run.render(g, (int) X + map.xMap,(int) Y + map.yMap);
        
//        if(vector > 0){
//            g.drawImage(i1,(int) (x + map.xMap + 12 - i1.getWidth(null)/2),
//                    (int) (y + map.yMap + 24 - i1.getHeight(null)), null);
//        }else{
//            g.drawImage(i2,(int) (x + map.xMap + 12 - i2.getWidth(null)/2),
//                    (int) (y + map.yMap + 24 - i2.getHeight(null)), null);
//        }
        
        //////////////////////////
        
        /////////////////////////
        //phạm vi tấn công
        g.setColor(Color.red);
        g.drawRect((int) (X + map.xMap - 24 * 4),
                (int) (Y + map.yMap - 24 * 4)
                , 24 * 8, 24 * 8);
        
        // enemy area
        g.drawRect((int) (X + map.xMap), (int) (Y + map.yMap), 24, 24);
        
    }
    public Rectangle getBoundAttack(){
        Rectangle bound = new Rectangle();
        bound.x =(int) (X + map.xMap - 24 * 4);
        bound.y =(int) (Y + map.yMap - 24 * 4);
        bound.width = 24 * 8;
        bound.height = 24 * 8;
        return bound;
    }
    public Rectangle getBoundEnemy(){
        Rectangle bound = new Rectangle();
        bound.x =(int) (X + map.xMap);
        bound.y =(int) (Y + map.yMap);
        bound.width = 24;
        bound.height = 24;
        return bound;
    }
}
