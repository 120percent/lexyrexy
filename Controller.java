import java.awt.event.*;
import java.lang.Thread;

public class Controller implements KeyListener, Runnable
{
    private Model model;
    private View view;
    private Thread gp;
    private boolean gameOver = false;
    public boolean gamestarted;

    public static void main(String Args[]){
    Controller c = new Controller();    
    }
    
    public Controller(){
        model = new Model();
        view = new View(model);
        view.addKeyListener(this);
        model.addListener(view);
        //startGame();
    }

    public void startGame(){
        if(!gamestarted){
            gp = new Thread(this);
            gp.start();
            gamestarted = true;
        }
    }

    public void run() {

        while(true) {
            model.update();
            if(gameOver){
                model.stop();
            }else{
                gameOver = model.checkCollision();
                model.getObstacles().changeSpeed(model.getScore().getScore());
            }
            model.render();
            try {
                Thread.sleep(90);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void keyTyped(KeyEvent e) {
        
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            if(!gameOver){
                model.getDino().jump();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(!gameOver){
                model.getDino().cower();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if (gameOver) {
                gameOver = false;
                model.reset();
            }else if(!gamestarted){
                startGame();
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        // System.out.println("keyReleased: "+e);
    }

}
