package domain;
import java.awt.*;
public class Normal extends Ficha{
    
    public Normal(Color color, int[] pos){

        super(color, pos);

    }

    public Color getColor() {
        
        return color;
    }

    public int[] getPos() {


        return pos;
    }

    public void setColor(Color color) {
        super.color = color;
    }

    public void setPos(int x, int y) {
        pos[0] = x;
        pos[1] = y;
        
    }

    public void action() {
        // TODO Auto-generated method stub
        
    }
    public void setLives(){

        lives = 1;
    }
}
