import java.awt.Rectangle;

public class Cactus extends Obstacle
{ 
    public Cactus(){
        x = 1000;
        y = 600;
        image = ResourceManager.getImage("obstacle_gros.png");
    }
    
    public Rectangle getDimension() {
        Rectangle obstaclerect = new Rectangle();
        obstaclerect.x = x;
        obstaclerect.y = y;
        obstaclerect.width = 85;
        obstaclerect.height = 75;

        return obstaclerect;
    }
}
