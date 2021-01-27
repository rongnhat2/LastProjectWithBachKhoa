/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Animation.PlayerAttack;
import Animation.PlayerRun;
import Animation.PlayerStand;
import Player.Skill.BasicAttack;
import static Window.KPanel.PanelHeight;
import static Window.KPanel.PanelWidth;
import static Window.KPanel.map;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Kirrnguyen
 */
public class Player extends PlayerInterface{
    
    private boolean topLeft;
    private boolean topRight;
    private boolean botLeft;
    private boolean botRight;
    public boolean isRunning;
    public boolean isAttack;
    public static BasicAttack attack;
    public PlayerRun pr;
    public PlayerStand ps;
    public PlayerAttack pa;
    public int vector = 1;
    int tx,ty;
    public Player(){
        super();
        this.x      = 210;
        this.y      = 210;
        this.width  = 24;
        this.height = 24;
        this.speed  = 3;
        this.direction = 1;
        pr = new PlayerRun();
        ps = new PlayerStand();
        pa = new PlayerAttack();
        attack  = new BasicAttack();
    }
    
    public void calculate(double x,double y){
        int leftTile = map.getColTile((int) (x - width/2));
        int rightTile = map.getColTile((int) (x + width/2)-1);
        int topTile = map.getRowTile((int) (y - height/2));
        int botTile = map.getRowTile((int) (y + height/2)-1);
        
        topLeft = map.getTile(topTile, leftTile) == 1 ;
        topRight = map.getTile(topTile, rightTile) == 1 ;
        botLeft = map.getTile(botTile, leftTile) == 1 ;
        botRight = map.getTile(botTile, rightTile) == 1 ;
    }
    @Override
    public void update(){
        // di chuyển
        if(right){
            dx = speed;
            vector = 1;
            direction = 2;
            pr.update(vector);
        }else if(left){
            dx = -speed;
            vector = 2;
            direction = 4;
            pr.update(vector);
        } else if(up){
            dy = -speed;
            direction = 1;
            pr.update(vector);
        } else if(down){
            dy = speed;
            direction = 3;
            pr.update(vector);
        } else {
            dy = 0;
            dx = 0;
            ps.update(vector);
        }
        
        //////////kiem tra va cham map
        int currCol = map.getColTile((int) x);
        int currRow = map.getRowTile((int) y);
        double tox = x + dx;
        double toy = y + dy;
        double tempx = x;
        double tempy = y;
        // tính toán va chạm y
        calculate(x, toy);
        if(dy < 0){
            if(topLeft || topRight){
                dy = 0;
                tempy = currRow * map.size + height/2;
            }
            else {
                tempy += dy;
            }
        }
        if(dy > 0){
            if(botLeft || botRight){
                dy = 0;
                tempy =(currRow + 1) * map.size - height/2;
            }
            else {
                tempy += dy;
            }
        }
        /////////////////
        //tính toán va chạm x
        calculate(tox, y);
        if(dx < 0){
            if(topLeft || botLeft){
                dx = 0;
                tempx = currCol * map.size + width/2;
            }
            else{
                tempx +=dx;
            }
        }
        if(dx>0){
            if(topRight || botRight){
                dx=0;
                tempx = (currCol + 1) * map.size - width/2;
            }
            else {
                tempx +=dx;
            }
        }
        // set di chuyển
        x = tempx;
        y = tempy;
        ///////////////
        
        // camera
        map.setxMap((int) (PanelWidth/2 - x));
        map.setyMap((int) (PanelHeight/2 - y));
        ////////////
        pa.update(vector);
        attack.update(vector);
    }
    
    @Override
    public void render(Graphics g2){
        g2.setColor(Color.black);
        //g.fillRect((int) x - width/2,(int) y - height/2, width, height);
        // draw theo map
        tx = map.xMap;
        ty = map.yMap;
        if (isRunning) {
            pr.render(g2, (int) (tx+x-width/2), (int) (ty+y-height/2));
        }else if (isAttack) {
            pa.render(g2, (int) (tx+x-width/2), (int) (ty+y-height/2));
        }else{
            ps.render(g2, (int) (tx+x-width/2), (int) (ty+y-height/2));
        }
        
        attack.render(g2);
        g2.drawRect(
                (int) (tx+x-width/2),
                (int) (ty+y-height/2), 
                width, height);
    }
    
    public void reload(){
        attack.reload();
    }
    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isIsAttack() {
        return isAttack;
    }

    public void setIsAttack(boolean isAttack) {
        this.isAttack = isAttack;
    }


    
    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
    
}
