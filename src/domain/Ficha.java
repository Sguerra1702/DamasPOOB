package domain;
import java.awt.*;
public abstract class Ficha {
    protected int pos[];
    protected Color color;
    protected int lives;
    /**
     *
     * Constructor de la clase Ficha 
     * 
     * @param color color
     * @param pos   pos 
     */
    public Ficha(Color color, int[] pos){

        this.pos = pos;
        this.color = color;
        lives += 1; 
        
    }

    /**
     * Retorna el color de la ficha
     * 
     * @return
     */
    public abstract Color getColor();

    /**
     * retorna las posiciones
     * 
     * @return
     */
    public abstract int[] getPos();

    /**
     * define el color de la ficha
     * 
     * @param color
     */
    public abstract void setColor(Color color);
    /**
     * 
     * coloca una nueva posicion de la dama
     * 
     * @param x
     * @param y
     */
    public abstract void setPos(int x, int y);
    /**
     * 
     * ejecuta la accion de la ficha
     * 
     */
    public abstract void action();
}
