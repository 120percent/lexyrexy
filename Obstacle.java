import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.*;

public class Obstacle{
    private BufferedImage image;
    private int x;
    private int y;

    public Obstacle(){
        x = 1000;
        y = 450;
        image = ResourceManager.getImage("obstacle_gros.png");
    }
    
    Rectangle getDimension() {
      Rectangle obstaclerect = new Rectangle();
      obstaclerect.x = x;
      obstaclerect.y = y;
      obstaclerect.width = 100;
      obstaclerect.height = 100;

      return obstaclerect;
    }
    
    void setImage(String i){
        image = ResourceManager.getImage(i);
    }
    
    void chageX(int deltax){
       x = x + deltax; 
    }
    
    public void create(Graphics g){
        g.drawImage(image, x, y,100, 100, null);
    }
    
}