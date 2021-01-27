/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Window;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author KirrNguyen
 */
public class MouseListen implements MouseListener,MouseMotionListener{
    int xM;
    int yM;
    public Rectangle getClick(int x,int y){
        Rectangle bound = new Rectangle();
            bound.x = x;
            bound.y = y;
            bound.width = 2;
            bound.height = 2;
        return bound;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        xM = e.getX();
        yM = e.getY() - 24;
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
}
