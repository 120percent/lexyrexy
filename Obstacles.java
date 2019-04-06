import java.util.ArrayList;
import java.awt.*;

public class Obstacles
{
    private ArrayList<Obstacle> obstacles;
    private int state;
    private static final int STILL = 1, RUN = 2;
    private int speed;

    public Obstacles(){
        obstacles = new ArrayList<Obstacle>();
        speed = 30;
        state = RUN;
        initializeObstacles();
    }

    public void create(Graphics g){
        for (Obstacle o : obstacles){
            o.create(g);
        }
    }

    public void reset(){
        state = 2;
        speed = 30;
        for(Obstacle o : obstacles){
            obstacles.remove(o);
        }

    }

    public void update(){
        if(state == RUN){
            if(obstacles.size() != 0){
                for(Obstacle o : obstacles){
                    o.changeX(-speed);
                    if(o.getX() < 0){
                        obstacles.remove(o);
                        initializeObstacles();
                    }
                }
            }else{
                initializeObstacles();
            }
        }
    }

    public ArrayList<Obstacle> getObstacles(){
        return obstacles;
    }

    public void stop(){
        state = STILL;
    }

    public void start(){
        state = RUN;
    }

    public void initializeObstacles(){
        obstacles.add(new Obstacle());
    }

    public void changeSpeed(int s){
        if (speed >70){
            speed = 71;
        }else{
           speed = s/3 +30; 
        }
    }
}
