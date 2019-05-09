import java.awt.image.BufferedImage;
import java.awt.*;

public class Background
{
    private BufferedImage image;
    
    
    public Background()
    {
        image = ResourceManager.getImage("background_start.png");
    }

    public BufferedImage getImage(){
        return image;
    }
    
    public void setImage(String i){
        image = ResourceManager.getImage(i);
    }
    
    public void create(Graphics g){
        g.drawImage(image, 0, 0,800, 800, null);
    }
    
    public void update(){
        setImage("background.png");
    }
    
    public void reset(){}
    public void stop(){}
}
