import java.awt.event.*;
import java.lang.Thread;

public class Controller implements KeyListener, Runnable
{
    private Model model;
    private View view;
    private Thread gp;
    private boolean gameOver = false;
    private int score;

    public Controller(){
        model = new Model();
        view = new View(model);
        view.addKeyListener(this);
        model.addListener(view);
        startGame();
    }

    public void startGame(){
        gp = new Thread(this);
        gp.start();
    }

    public void run() {
        
        while(!gameOver) {
            model.update();
            //gameOver = model.checkCollision();
            gameOver = false;
            model.render();      
            try {
                Thread.sleep(80);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == ' ') {
            if (gameOver) {
                model.reset();
            } else {
                model.getDino().jump();
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
