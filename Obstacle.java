import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class Obstacle{
    private BufferedImage image;
    private int x;
    private int y;

    Rectangle getDimension() {
      Rectangle obstaclerect = new Rectangle();
      obstaclerect.x = x;
      obstaclerect.y = y;
      obstaclerect.width = 100;
      obstaclerect.height = 100;

      return obstaclerect;
    }
    
    BufferedImage getImage(){
        return image;
    }
    
    void setImage(BufferedImage i){
        image = i;
    }
    
    void setX(int sx){
       x = sx; 
    }
    
    void setY(int sy){
       x = sy; 
    }
    
    
}