/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Window;

import Map.PhysicalMap;
import Player.Player;
import Player.Skill.BasicAttack;
import static Window.KFrame.WINDOW_HEIGHT;
import static Window.KFrame.WINDOW_WIDTH;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author KirrNguyen
 */
public class KPanel extends JPanel{
    
    public BufferedImage image;
    private Graphics2D g,g2;
    
    
    public static PhysicalMap map;
    public static Player player;
    public static int PanelHeight = WINDOW_HEIGHT-29;
    public static int PanelWidth = WINDOW_WIDTH-6;
    
    public void init(){
        image = new BufferedImage(WINDOW_WIDTH, WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);
        g2 = (Graphics2D) image.getGraphics();
        
        map = new PhysicalMap();
        player = new Player();
    }
    
    public void draw(){
        g = (Graphics2D) getGraphics();
        if(g!=null){
            g.drawImage(image, 0, 0, null);
            g.dispose();
        }
    }
    public void update(){
        player.update();
    }
    public void render(){
        g2.setColor(Color.white);
        g2.fillRect(0, 0, 1000, 600);
        
        map.render_flat(g2);
        map.render_background(g2);
        map.render_decorate(g2);
        player.render(g2);
        map.render_object(g2);
        
    }
    public void reload(){
        player.reload();
    }
}
