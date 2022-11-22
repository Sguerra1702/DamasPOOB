package domain;

import java.awt.*;
import java.util.ArrayList;

public abstract class Jugador {
    /**
     * 
     * realiza un movimiento
     * 
     */
    public abstract boolean makeAMove(int fx, int fy, int mx, int my, ArrayList<Ficha> fichasJugadorAlt)
            throws DamasException;

    /**
     * retorna el nombre del jugador
     * 
     * @return
     */
    public abstract String getName();

    /**
     * retorna el numero de fichas totales en el jugador
     * 
     * @return
     */
    public abstract int getFichasNum();

    public abstract Color getColor();

    public abstract int getPuntaje();
}
