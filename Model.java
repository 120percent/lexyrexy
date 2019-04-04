import java.util.ArrayList;
public class Model
{
    private ArrayList<ModelListener> listeners;
    private Dino dino;
    private Obstacles Obstacle;
    public Model(){
        listeners = new ArrayList<ModelListener>();
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
        
    }
    
    public void render(){
        informListeners();    
    }
    
    public void jump(){
        dino.jump();    
    }
}
