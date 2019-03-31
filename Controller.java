import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Controller implements KeyListener, Runnable{

    private Thread gp;
    private boolean running = false;
    private boolean gameOver = false;
    private int score;

    public Controller(){

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