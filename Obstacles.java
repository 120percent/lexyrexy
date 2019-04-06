import java.util.ArrayList;
import java.awt.*;

public class Obstacles
{
    private ArrayList<Obstacle> obstacles;
    private int state;
    public static final int STILL = 1, RUN = 2;
    
    public Obstacles(){
        obstacles = new ArrayList<Obstacle>();
        state = RUN;
    }
    
    public void create(Graphics g){
        for (Obstacle o : obstacles){
            o.create(g);
        }
    }
    
    public void reset(){
        initializeObstacles();
        state = RUN;
    }
    
    public void update(){
        if(state == RUN){
            
        }
    }
    
    public ArrayList<Obstacle> getObstacles(){
        return obstacles;
    }
    
    public void stop(){
        state = STILL;
    }
    
    public void initializeObstacles(){
        
    }
}
