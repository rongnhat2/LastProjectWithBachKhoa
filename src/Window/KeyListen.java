/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Window;

import static Player.Player.attack;
import static Window.KPanel.player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author KirrNguyen
 */
public class KeyListen implements KeyListener{
    
    @Override
    public void keyTyped(KeyEvent e) {

    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                player.setLeft(true);
                player.pr.setTime(System.currentTimeMillis());
                player.setIsRunning(true);
                break;
            case KeyEvent.VK_RIGHT:
                player.setRight(true);
                player.pr.setTime(System.currentTimeMillis());
                player.setIsRunning(true);
                break;
            case KeyEvent.VK_UP:
                player.setUp(true);
                player.pr.setTime(System.currentTimeMillis());
                player.setIsRunning(true);
                break;
            case KeyEvent.VK_DOWN:
                player.setDown(true);
                player.pr.setTime(System.currentTimeMillis());
                player.setIsRunning(true);
                break;
            case KeyEvent.VK_A:
                attack.atking = true;
                if(attack.atking){
                    player.pa.setTime(System.currentTimeMillis());
                    player.attack.setTime(System.currentTimeMillis());
                    player.setIsAttack(true);
                    attack.setCurrent_time(System.currentTimeMillis());
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                player.setLeft(false);
                player.setIsRunning(false);
                break;
            case KeyEvent.VK_RIGHT:
                player.setRight(false);
                player.setIsRunning(false);
                break;
            case KeyEvent.VK_UP:
                player.setUp(false);
                player.setIsRunning(false);
                break;
            case KeyEvent.VK_DOWN:
                player.setDown(false);
                player.setIsRunning(false);
                break;
            case KeyEvent.VK_A:
                player.setIsAttack(false);
                attack.atking = false;
                break;
            default:
                break;
        }
        
        player.setX((int) player.getX()/12 * 12);
        player.setY((int) player.getY()/12 * 12);
    }
    
}
