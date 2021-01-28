/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player.Skill;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Kirrnguyen
 */
public class SkillInterface {
    
    public Image getImageIcon(String name) {
        Image image = new ImageIcon(getClass().getResource(
                "/Assets/Skill/" + name + ".png")).getImage();
        Icon icon = new ImageIcon(image);
        return image;
    }
    public Image flipImage(Image img){
            
            BufferedImage image = toBufferedImage(img);
            
            AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
            tx.translate(-image.getWidth(), 0);

            AffineTransformOp op = new AffineTransformOp(tx,
            AffineTransformOp.TYPE_BILINEAR);
            image = op.filter(image, null);
            
            return image;
    }
    
    
    
    
    /**
     * Converts a given Image into a BufferedImage
     *
     * @param img The Image to be converted
     * @return The converted BufferedImage
     */
    public BufferedImage toBufferedImage(Image img){
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }
}
