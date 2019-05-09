import java.util.ArrayList;
public class Model
{
    private ArrayList<ModelListener> listeners;
    private Dino dino;
    private Obstacles obstacles;
    private Background background;
    private Score score;
    
    public Model(){
        listeners = new ArrayList<ModelListener>();
        dino = new Dino();
        obstacles = new Obstacles();
        background = new Background();
        score = new Score();
        //trexY = 550; //400jump
    }

    public void addListener(ModelListener ml){
        listeners.add(ml);    
    }

    public void remListener(ModelListener ml){
        listeners.remove(ml);    
    }

    private void informListeners(){
        for(ModelListener ml : listeners){
            ml.modelChanged();    
        }
    }

    public void update(){
        System.out.println("update");
        getBackground().update();
        getDino().update();
        getObstacles().update();
        getScore().update();
    }
    
    public void render(){
        System.out.println("render");
        informListeners();    
    }
    
    public Dino getDino(){
        return dino;
    }
    
    public Background getBackground(){
        return background;
    }
    
    public Obstacles getObstacles(){
        return obstacles;
    }
    
    public Score getScore(){
        return score;
    }
    
    public void reset(){
        getBackground().reset();
        getDino().reset();
        getObstacles().reset();
        getScore().reset();
    }
    
    public boolean checkCollision(){
        System.out.println("check");
        Boolean collision = false;
        for(Obstacle o : getObstacles().getObstacles()){
            collision = o.getDimension().intersects(getDino().getDimension());
        }
        return collision;
    }
    
    public void stop(){
        getBackground().stop();
        getDino().die();
        getObstacles().stop();
        getScore().stop();
    }
    
    
}
