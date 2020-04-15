/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simple;

/**
 *
 * @author AJSta
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SimpleImage extends JPanel {
    
    private static final String urlString =
            "http://nssdc.gsfc.nasa.gov/" +
            "image/planetary/mars.marsglobe1.jpg";
    private static final Logger logger = 
            Logger.getLogger(SimpleImage.class.getName());
    
    public SimpleImage() {
    }// SimpleImage()
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        try{
            URL url = new URL(urlString);
            BufferedImage image = ImageIO.read(url);
            
            double panelWidth = this.getWidth();
            double imageWidth = image.getWidth(this);
            
            double panelHeight = this.getHeight();
            double imageHeight =  image.getHeight();
            
            AffineTransform scale = new AffineTransform();
            scale.setToScale(panelWdth / imageWidth,
                    panelHeight / imageHeight);
            
            int[] color = new int[3];
            WritableRaster raster = image.getRaster();
            for (int j = 0; j < raster.getHeight(); j++) {
                for (int i = 0; i < raster.getWidth(); j++) {
                    raster.getPixel(i, j, color);
                    
                    color[0] = 255 - color[0];
                    color[1] = 255 - color[1];
                    color[2] = 255 - color[2];
                    
                    raster.setPixel(i, j, color);
                }// for
            }// for
            
            g2d.drawImage(image, scale, this);
        }//try
        catch (IOExecption ex) {
            logger.log(Level.SEVER, null, ex);
        }//catch( IOException
        
    }//paintComponent( Graphics )
}// SimpleImage

