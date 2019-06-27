import java.awt.Rectangle;
import java.util.Random;

public class Bird extends Obstacle
{
    private int state;
    private Random random;
    public Bird()
    {
        random = new Random();
        if(random.nextInt(2) == 1){
                y = 570;
            }else{
                y = 500;
            }
        x = 1000;
        
        image = ResourceManager.getImage("vogel1.png");
        state = 1;
    }

    public void animation(){
        if(state == 2){
            image = ResourceManager.getImage("vogel1.png");
            state = 1;
        }else if(state == 1){
            image = ResourceManager.getImage("vogel2.png");
            state = 2;
        }
        else{
            System.out.println("Fehler Vogel Animation");
        }

    }
    
    public Rectangle getDimension() {
        Rectangle obstaclerect = new Rectangle();
        obstaclerect.x = x;
        obstaclerect.y = y;
        obstaclerect.width = 60;
        obstaclerect.height = 50;

        return obstaclerect;
    }
}
