package domain;

import java.awt.*;

import javax.swing.*;

public abstract class Ficha extends JButton{
    protected int posx, posy;
    protected Color color;
    protected int lives;
    protected boolean bajando;

    /**
     *
     * Constructor de la clase Ficha
     * 
     * @param color   color
     * @param pos     pos
     * @param bajando boolean
     */
    public Ficha(Color color, int posx, int posy, boolean bajando) {
        super();
        Dimension dimension = new Dimension(30, 30);
        this.setPreferredSize(dimension);
        this.posx = posx;
        this.posy = posy;
        this.color = color;
        this.setBackground(color);
        lives += 1;
        this.bajando = bajando;

    }

    /**
     * Retorna el color de la ficha
     * 
     * @return Color
     */
    public abstract Color getColor();

    /**
     * retorna las posiciones
     * 
     * @return int
     */
    public abstract int getPosx();

    /**
     * retorna las posiciones
     * 
     * @return int
     */
    public abstract int getPosy();

    public abstract void setTamano(Dimension dimension);



    /**
     * define el color de la ficha
     * 
     * @param color Color
     */
    public abstract void setColor(Color color);

    /**
     * 
     * coloca una nueva posicion de la dama
     * 
     * @param x int
     * @param y int
     */
    public abstract void setPosx(int posx) throws DamasException;

    /**
     * 
     * coloca una nueva posicion de la dama
     * 
     * @param x int
     * @param y int
     */
    public abstract void setPosy(int posy) throws DamasException;

    /**
     * 
     * ejecuta la accion de la ficha
     * 
     */
    public abstract void action();

    public abstract boolean bajando();
}
