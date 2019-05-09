import java.awt.image.BufferedImage;
import java.awt.*;

public class Background
{
    private BufferedImage image;
    private int state = 1;
    
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
        if(state == 1){
            setImage("background1.png");
            state = 2;
        }else if(state == 2){
            setImage("background2.png");
            state = 3;
        }else if(state == 3){
            setImage("background3.png");
            state = 1;
        }else{
            System.out.println("Fehler Background Animation");
        }
    }
    
    public void reset(){state = 1; setImage("background1.png");}
    public void stop(){}
}
