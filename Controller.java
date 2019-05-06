import java.awt.event.*;
import java.lang.Thread;

public class Controller implements KeyListener, Runnable
{
    private Model model;
    private View view;
    private Thread gp;
    private boolean gameOver = true;
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

        while(true) {
            model.update();
            gameOver = model.checkCollision();
            if(gameOver){
                model.stop();
                model.getBackground().setImage("background_start.png");
                score = 0;
            }else{
                score++; 
                model.getObstacles().changeSpeed(score);
            }
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
            if(!gameOver){
                model.getDino().jump();
            }
        }
        if(e.getKeyChar() == '0'){
            if(!gameOver){
                model.getDino().cower();
            }
        }
        if(e.getKeyChar() == '\n'){
            if (gameOver) {
                gameOver = false;
                model.reset();
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
