import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class Dino{
    private BufferedImage image;
    private int x;
    private int y;

    Rectangle getDimension() {
      Rectangle dinorect = new Rectangle();
      dinorect.x = x;
      dinorect.y = y;
      dinorect.width = 100;
      dinorect.height = 100;

      return dinorect;
    }
    
    BufferedImage getImage(){
        return image;
    }
    
    void setImage(BufferedImage i){
        image = i;
    }
    
    void setY(int sy){
       x = sy; 
    }
}