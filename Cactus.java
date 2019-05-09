import java.awt.Rectangle;

public class Cactus extends Obstacle
{ 
    public Cactus(){
        x = 1000;
        y = 610;
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
}
