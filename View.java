import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class View extends javax.swing.JComponent implements ModelListener
{
    // drawImage:
    // https://stackoverflow.com/questions/17865465/how-do-i-draw-an-image-to-a-jpanel-or-jframe

    private Model model;
    private JFrame frame;
    private BufferedImage background, trex, trexjump = null;

    public View(Model m){
        model = m;
        model.addListener(this);
        loadImages();
        frame = buildFrame();
    }

    private JFrame buildFrame() {
        frame = new JFrame();
        frame.add(this);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.setVisible(true);
        return frame;
    }

    public void modelChanged(){
        repaint();
    }

    public void loadImages(){
        try {
            background = ImageIO.read(new File("../LexyRexy/graphics/background.png"));
            trex = ImageIO.read(new File("../LexyRexy/graphics/dino.png"));
            trexjump = ImageIO.read(new File("../LexyRexy/graphics/dinoSpringen.png"));
        } catch (IOException e) {}
    }

    public void paint(Graphics g){
        // ZU PAINTENDE OBJEKTE
        // --> TREX, OBSTACLES, (BACKGROUND)
        g.setColor(Color.BLACK);
        Dimension size = getSize();
        g.fillRect(0,0,size.width,size.height);

        // BACKGROUND IMAGE
        g.drawImage(background, 0, 0,getWidth(), getHeight(), null);
        if(model.getTrexState() == 0){
            g.drawImage(trex, 250, model.getTrexY(),150, 150, null);
        }else if (model.getTrexState() == 1){
            g.drawImage(trexjump, 250, model.getTrexY(),150, 150, null);
        }
    }
}
