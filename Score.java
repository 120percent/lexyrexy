import java.util.ArrayList;
import java.awt.*;

public class Score
{
    private int score; 
    private ArrayList<Image> digits;
    private ArrayList<Image> number;
    private ArrayList<Integer> digitInts;
    private boolean run;

    public Score(){
        score = 0;
        run = true;
        digits = new ArrayList<Image>(10);
        number = new ArrayList<Image>(4);
        digitInts = new ArrayList<Integer>(4);
        for(int i = 0; i < 10; i++){
            digits.add(ResourceManager.getImage("ziffer"+ i +".png"));
        }
        for(int i = 0; i < 4; i++){
            number.add(ResourceManager.getImage("ziffer0.png"));
        }
        for(int i = 0; i < 4; i++){
            digitInts.add(0);
        }
    }

    public void update(){
        if(run){

            score++;
            digitInts.set(0, (digitInts.get(0)+1));
            for(int i = 0; i < 4; i++){
                if(digitInts.get(i) == 10){
                    digitInts.set(i, 0);
                    digitInts.set(i+1, digitInts.get(i+1)+1);
                }
                number.set(i, ResourceManager.getImage("ziffer"+ digitInts.get(i)+".png"));
            }
        }
        System.out.println(run+"");
    }

    public int getScore(){
        return score;
    }

    public void reset(){
        for(int i = 0; i < 4; i++){
            number.set(i, ResourceManager.getImage("ziffer0.png"));
        }
        for(int i = 0; i < 4; i++){
            digitInts.set(i, 0);
        }
        score = 0;
        run = true;
    }

    public void create(Graphics g){
        for(int i = 0; i < 4; i++){
            g.drawImage(number.get(i),700-(i*40),10, 30, 30, null);
        }
    }

    public void stop(){
        run = false;

        
    }
}