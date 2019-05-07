import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.*;

public abstract class Obstacle{
    protected BufferedImage image;
    protected int x;
    protected int y;

    public abstract Rectangle getDimension();    

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

    public void animation(){
    }
}