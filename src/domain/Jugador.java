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
    public abstract boolean makeAMove(int posf, int posy, ArrayList<Ficha> fichasJugadorAlt)
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
     * @param pos int
     * @return Ficha
     */
    public abstract Ficha getFicha(int pos);

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
     * @param pos
     */
    public abstract void getEaten(int pos);
}
