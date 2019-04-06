import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.*;

public class Dino{
    private BufferedImage image;
    private int x;
    private int y;
    private int state;
    private int running;
    private boolean topReached;
    private int jumpFactor;
    private int top, bottom;

    public int STILL = 1,
    RUN = 2,
    JUMP = 3;

    private int LEFT_FOOT = 1,
    RIGHT_FOOT = 2;

    public Dino(){
        x = 200;
        y = 520;
        state = RUN;
        running = LEFT_FOOT;
        topReached = false;
        jumpFactor = 40;
        top = 300;
        bottom = 520;
        image = ResourceManager.getImage("dino_leftfoot.png");
    }

    public Rectangle getDimension() {
        Rectangle dinorect = new Rectangle();
        dinorect.x = x;
        dinorect.y = y;
        dinorect.width = 200;
        dinorect.height = 200;

        return dinorect;
    }

    public void setImage(String i){
        image = ResourceManager.getImage(i);
    }

    public void changeY(int deltay){
        y = y + deltay; 
    }

    public void create(Graphics g){
        g.drawImage(image, x, y,200, 200, null);
    }

    public void jump(){
        state = JUMP;
    }

    public void die(){
        state = STILL;
    }

    public void reset(){
        state = RUN;
    }

    public void update(){
        if(state == RUN){
            if(running == LEFT_FOOT){
                running = RIGHT_FOOT;
                setImage("dino_leftfoot.png");
            }else{
                running = LEFT_FOOT;
                setImage("dino_rightfoot.png");
            }
        }
        if(state == JUMP){
            setImage("dino_jumping.png");
            if(!topReached && !(y <= top) ){
                changeY(-jumpFactor);
            }else if(y <= top){
                topReached = true;
                changeY(jumpFactor);
            }else if(topReached && !(y >= bottom) ){
                changeY(jumpFactor);
            }else if(y >= bottom){
                topReached = false;
                state = RUN;
                running = LEFT_FOOT;
                setImage("dino_leftfoot");
            }
        }
        if(state == STILL){
            setImage("dino_dead.png");
        }

    }

}