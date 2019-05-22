import java.util.ArrayList;
import java.awt.*;

public class Score
{
    private int score; 
    private int highscore;
    private ArrayList<Image> digits;
    private ArrayList<Image> number;
    private ArrayList<Image> highNumber;
    private ArrayList<Integer> numDigits;
    private ArrayList<Integer> highDigits;
    private boolean run;

    public Score(){
        score = 0;
        run = true;
        digits = new ArrayList<Image>(10);
        number = new ArrayList<Image>(4);
        numDigits = new ArrayList<Integer>(4);
        highNumber = new ArrayList<Image>(4);
        highDigits = new ArrayList<Integer>(4);
        for(int i = 0; i < 10; i++){
            digits.add(ResourceManager.getImage("ziffer"+ i +".png"));
        }
        for(int i = 0; i < 4; i++){
            number.add(ResourceManager.getImage("ziffer0.png"));
        }
        for(int i = 0; i < 4; i++){
            numDigits.add(0);
        }
        for(int i = 0; i < 4; i++){
            highNumber.add(ResourceManager.getImage("ziffer0.png"));
        }
        for(int i = 0; i < 4; i++){
            highDigits.add(0);
        }
    }

    public void update(){
        if(run){

            score++; 
            numDigits.set(0, (numDigits.get(0)+1));
            for(int i = 0; i < 4; i++){
                if(numDigits.get(i) == 10){
                    numDigits.set(i, 0);
                    numDigits.set(i+1, numDigits.get(i+1)+1);
                }
                number.set(i, ResourceManager.getImage("ziffer"+ numDigits.get(i)+".png"));
            }
        }
        else{
            checkHighscore();
        }
        
    }

    public int getScore(){
        return score;
    }

    public void checkHighscore(){
        if(highscore < score){
            highscore = score;
            for(int i = 0; i < 4 ; i++){
                highDigits.set(i, numDigits.get(i));
                highNumber.set(i, number.get(i));
            }
            
        }
    }

    public void reset(){
        for(int i = 0; i < 4; i++){
            number.set(i, ResourceManager.getImage("ziffer0.png"));
        }
        for(int i = 0; i < 4; i++){
            numDigits.set(i, 0);
        }
        score = 0;
        run = true;
    }

    public void create(Graphics g){
        for(int i = 0; i < 4; i++){
            g.drawImage(number.get(i),700-(i*40),10, 30, 30, null);
            g.drawImage(highNumber.get(i), 170-(i*40), 10, 30, 30, null);
        }
    }

    public void stop(){
        run = false;

    }
}