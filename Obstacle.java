import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.*;

public abstract class Obstacle{
    protected BufferedImage image;
    protected int x;
    protected int y;

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

    public void animation(){
    }
}