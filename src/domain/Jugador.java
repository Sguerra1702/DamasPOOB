package domain;

import java.awt.*;
import java.util.ArrayList;

public abstract class Jugador {

    /*
     * 
     * realiza una jugada, retorna true si se consume alguna ficha
     * 
     * @param fx int
     * 
     * @param fy int
     * 
     * @param mx int
     * 
     * @param my int
     * 
     * @param fichasJugadorAlt ArrayList
     * 
     */
    public abstract boolean makeAMove(int fx, int fy, int mx, int my, ArrayList<Ficha> fichasJugadorAlt)
            throws DamasException;

    /**
     * retorna el nombre del jugador
     * 
     * @return String
     */
    public abstract String getName();

    /**
     * retorna el numero de fichas totales en el jugador
     * 
     * @return int
     */
    public abstract int getFichasNum();

    /**
     * retorna la ficha dada la ubicacion
     * 
     * @param posx int
     * @param posy int
     * @return
     */
    public abstract Ficha getFicha(int posx, int posy);

    /*
     * retorna un ArrayList de fichas
     */
    public abstract ArrayList<Ficha> getFichas();

    /**
     * retorna retorna el color del jugador
     */
    public abstract Color getColor();

    /*
     * retorna el puntaje del jugador
     */
    public abstract int getPuntaje();

    /*
     * retorna el turno del jugador
     */
    public abstract int getTurn();

    /**
     * come una ficha
     * 
     * @param mx
     * @param my
     */
    public abstract void getEaten(int mx, int my);
}
