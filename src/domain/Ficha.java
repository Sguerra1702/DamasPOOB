package domain;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public abstract class Ficha extends JButton{
    private static final Border EmptyBorder = null;
    protected int pos;
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
    public Ficha(Color color, int pos, boolean bajando) {
        super();
        Dimension dimension = new Dimension(30, 30);
        this.setPreferredSize(dimension);
        this.pos = pos;
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
    public abstract int getPos();

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
    public abstract void setPos(int pos) throws DamasException;

    /**
     * 
     * ejecuta la accion de la ficha
     * 
     */
    public abstract void action();

    public abstract boolean bajando();
}
