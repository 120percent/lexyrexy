import java.awt.image.BufferedImage;
import java.awt.*;

public class Background
{
    private BufferedImage image;
    private int state;
    
    public Background()
    {
        state = 1;
        image = ResourceManager.getImage("hiGrNeueWolkenStart.png");
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
        if (state > 25){state = 1;}
        setImage("hiGrNeueWolken2."+ state+".png");
        state++;
    }
    
    public void reset(){state = 1;setImage("hiGrNeueWolken2.1.png");}
    public void stop(){setImage("hiGrNeueWolkenStart.png");}
}
