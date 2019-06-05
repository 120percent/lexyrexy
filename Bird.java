import java.awt.Rectangle;

public class Bird extends Obstacle
{
    private int state;
    public Bird()
    {
        x = 1000;
        y = 500;
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
