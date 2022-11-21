package domain;

public abstract class Jugador {
    /**
     * 
     * realiza un movimiento
     * 
     */
    public abstract void makeAMove(int fx, int fy, int mx, int my)throws DamasException;
    /**
     * retorna el nombre del jugador
     * @return
     */
    public abstract String getName();
    /**
     * retorna el numero de fichas totales en el jugador
     * @return
     */
    public abstract int getFichasNum();
    
}
