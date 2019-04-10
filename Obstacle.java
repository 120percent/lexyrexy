import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.*;

public class Obstacle{
    private BufferedImage image;
    private int x;
    private int y;

    public Obstacle(){
        x = 1000;
        y = 600;
        image = ResourceManager.getImage("obstacle_gros.png");
    }
    
    public Rectangle getDimension() {
      Rectangle obstaclerect = new Rectangle();
      obstaclerect.x = x;
      obstaclerect.y = y;
      obstaclerect.width = 75;
      obstaclerect.height = 75;

      return obstaclerect;
    }
    
    public void setImage(String i){
        image = ResourceManager.getImage(i);
    }
    
    public void changeX(int deltax){
       x = x + deltax; 
    }
    
    public int getX(){
        return x;
    }
    
    public void create(Graphics g){
        g.drawImage(image, x, y,100, 100, null);
    }
    
}