package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.swing.JPanel;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

/**
 *
 * @author legol
 */
public class ImagePanel extends JPanel {
    
    private Image copyImg;
    private Mat image;
    
    boolean imageSet = false;
    
    public ImagePanel(){
        super();
    }
    
    public void AddImage(File img){
        image = Imgcodecs.imread(img.getAbsolutePath());
        this.setOpaque(true);
        imageSet = true;
        this.update(this.getGraphics());
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if(imageSet){
            copyImg = HighGui.toBufferedImage(image);
            Image img = copyImg.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
            g.drawImage(img, 0, 0, this);
        }
    }
    
    public Mat GetImage(){
        return image;
    }
    
    public boolean IsImageSet(){
        return imageSet;
    }
}
