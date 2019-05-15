import java.util.ArrayList;
import java.awt.*;
import java.util.Random;

public class Obstacles
{
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Obstacle> removeObstacles;
    private int state;
    private static final int STILL = 1, RUN = 2;
    private int speed;
    private Random random;

    public Obstacles(){
        obstacles = new ArrayList<Obstacle>();
        removeObstacles = new ArrayList<Obstacle>();
        speed = 30;
        state = RUN;
        random = new Random();
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
            removeObstacles.add(o);
        }
        for(Obstacle o : removeObstacles){
                obstacles.remove(o);
        }

    }

    public void update(){
        if(state == RUN){
            if(obstacles.size() != 0){
                ArrayList<Obstacle> removeObstacles = new ArrayList<Obstacle>();
                for(Obstacle o : obstacles){
                    o.changeX(-speed);
                    o.animation();
                    removeObstacles.add(o);
                }
                for(Obstacle o : removeObstacles){
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
        if(random.nextInt(2) == 1){
            if(random.nextInt(2) == 1){
                obstacles.add(new Bird());
            }else{
                obstacles.add(new Cactus());
            }
        }
    }

    public void changeSpeed(int s){
        if (speed >70){
            speed = 71;
        }else{
            speed = s/3 +30; 
        }
    }
}
