
/**
 * Beschreiben Sie hier die Klasse Bird.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Bird extends Obstacle
{
    private int state;
    public Bird()
    {
        x = 1000;
        y = 450;
        image = ResourceManager.getImage("vogel1.png");
        state = 1;
    }

    public void animation(){
        if(state == 2){
            image = ResourceManager.getImage("vogel1.png");
            state = 1;
        }else if(state == 1){
            image = ResourceManager.getImage("vogel2.png");
            state = 2;
        }
        else{
            System.out.println("Fehler Vogel Animation");
        }

    }
}
