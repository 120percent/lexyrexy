import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.event.*;

public class View extends JComponent implements ModelListener
{
    // drawImage:
    // https://stackoverflow.com/questions/17865465/how-do-i-draw-an-image-to-a-jpanel-or-jframe

    private Model model;
    private JFrame frame;
    JLabel scoreLabel;

    public View(Model m){
        model = m;
        model.addListener(this);
        frame = buildFrame();
        setFocusable(true);
        scoreLabel = new JLabel("Score");
    }

    private JFrame buildFrame() {
        frame = new JFrame();
        frame.add(this);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setVisible(true);
        return frame;
    }

    public void modelChanged(){
        repaint();
    }

    public void paint(Graphics g){

        // BACKGROUND IMAGE
        model.getBackground().create(g);
        model.getObstacles().create(g);
        model.getDino().create(g);
        model.getScore().create(g);
    }
}
