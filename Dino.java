import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.*;

public class Dino{
    private BufferedImage image;
    private int x;
    private int y;
    private int high;
    private int state;
    private int cowerTick;
    private int running;
    private boolean topReached;
    private int jumpFactor;
    private int top, bottom;

    private int STILL = 1,
    RUN = 2,
    JUMP = 3,
    COWER = 4;

    private int LEFT_FOOT = 1,
    RIGHT_FOOT = 2;
    
    /**
     * Konstruktor.
     * Setzt Standard-Werte fuer Dino-Objekt
     */
    public Dino(){
        x = 200;
        y = 525; //525
        high = 0;
        state = RUN;
        running = LEFT_FOOT;
        topReached = false;
        jumpFactor = 50;
        top = 350;
        bottom = 525;
        image = ResourceManager.getImage("dino_leftfoot.png");
    }
   
    /**
     * Erzeugen eines Hitbox-Rechtecks; Setzen der korrekten Werte;
     * @return Hitbox-Rechteck
     */
    public Rectangle getDimension() {
        Rectangle dinorect = new Rectangle();
        dinorect.x = x; 
        dinorect.y = y+high; //hitbox ducken
        dinorect.width = 140;
        dinorect.height = 120-high;

        return dinorect;
    }
    
    /**
     * Setzt das im Pfad angegebene Bild;
     * @param i Pfadangabe als String
     */
    public void setImage(String i){
        image = ResourceManager.getImage(i);
    }
    
    /**
     * Veraendert y um Wert;
     * @param deltay Veraenderung von y
     */
    public void changeY(int deltay){
        y = y + deltay; 
    }

    /**
     * @param g Grafik-Objekt zum Zeichnen
     */
    public void create(Graphics g){
        g.drawImage(image, x, y,200, 200, null);
    }

    /**
     *  Setzt den State auf JUMP; indirekte Initiation des Sprungs
     */
    public void jump(){
        state = JUMP;
        high = 0;
        cowerTick = 0;
    }
    
    /**
     * Sofern der Dino sich nicht im Sprung befindet; Setzt State auf COWER;
     * indirekte Initiation des Duckens
     */
    public void cower(){
        if(state != JUMP){
            state = COWER;   
        }
    }

    /**
     * Setzt die Hoehe des Dinos zurueck; Setzt den State auf STILL;
     * indirekte Iniotiation des Stillstehens
     */
    public void die(){
        y = bottom;
        state = STILL;
    }

    /**
     * Setzt alles noetige auf die Ausgangsstellung zurueck
     */
    public void reset(){
        state = RUN;
        y = bottom;
        cowerTick = 0;
    }
    
    /**
     * Aktualisiert den Dino je nach State, indem er sich befindet;
     * Wechselt ggf. zwischen den moeglichen States
     */
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
                changeY(jumpFactor-10);
            }else if(topReached && !(y >= bottom) ){
                changeY(jumpFactor-10);
            }else if(y >= bottom){
                y = bottom;
                topReached = false;
                state = RUN;
                running = LEFT_FOOT;
                setImage("dino_leftfoot");
            }
        }
        if(state == STILL){
            setImage("dino_dead.png");
        }
        if(state == COWER){
            if (running == LEFT_FOOT){
                setImage("dinoDuckenNeu1.png");
                running = RIGHT_FOOT;
            }else{
                setImage("dinoDuckenNeu2.png");
                running = LEFT_FOOT;
            }
            
            if(cowerTick == 0)high = 30;
            cowerTick++;
            if(cowerTick > 9){
                high = 0;
                state = RUN;
                running = LEFT_FOOT;
                setImage("dino_leftfoot");;
                cowerTick = 0;
            }
        }
        System.out.println(high+"");
    }

}