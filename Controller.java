import java.awt.event.*;
import java.lang.Thread;

public class Controller implements KeyListener, Runnable
{
    private Model model;
    private View view;
     private Thread gp;
    private boolean running = false;
    private boolean gameOver = false;
    private int score;

    public Controller(){
        model = new Model();
        view = new View(model);
        view.addKeyListener(this);
        model.addListener(view);
        //startGame();
    }

   public void startGame(){

    }

    public void stopGame(){

    }

    public void run() {
        running = true;

        while(running) {
            updateGame();
            model.render();      
            try {
                Thread.sleep(20);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void updateGame() {
        score += 1;
        model.update();
        boolean collision = model.hasCollided();
        if(collision){}else{}
    }

    public void keyTyped(KeyEvent e) {
        // System.out.println(e);
        if(e.getKeyChar() == ' ') {    
            if(gameOver) reset();
            if (gp == null || !running) {
                System.out.println("Game starts");        
                gp = new Thread(this);
                gp.start();     
                model.startRunning();   
            } else {
                model.jump();
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        // System.out.println("keyPressed: "+e);
    }

    public void keyReleased(KeyEvent e) {
        // System.out.println("keyReleased: "+e);
    }

}
