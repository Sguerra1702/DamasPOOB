package domain;
import java.awt.*;
public abstract class Ficha {
    protected int pos[];
    protected Color color;
    protected int lives;

    public Ficha(Color color, int[] pos){

        this.pos = pos;
        this.color = color;
        lives += 1; 
        
    }
    public abstract Color getColor();

    public abstract int[] getPos();

    public abstract void setColor(Color color);

    public abstract void setPos(int x, int y);

    public abstract void action();
}
