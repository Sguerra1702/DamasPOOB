package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.*;

public class Tablero {

    private HashMap<String, Jugador> jugadores;
    private int turno;
/**
 * contructor de la clase tablero, su input es determinado en (cantidad_jugadores <= 2), de lo contrario lanzara una excepcion
 * 
 * 
 * @param cantidad_jugadores
 * @throws DamasException
 */
    public Tablero(int cantidad_jugadores) throws DamasException {
        jugadores = new HashMap<String, Jugador>();
        if (cantidad_jugadores > 1) {
            jugadores.put("Maquina", new Maquina());
        }
        if(cantidad_jugadores>2){
            throw new DamasException(DamasException.NO_MAS_JUGADORES);
        }
    }
    /**
     * agrega un jugador por cada llamada al metodo
     * 
     * @param name
     * @param color
     * @param turno
     * @throws DamasException
     */
    public void addJugador(String name, Color color, int turno) throws DamasException {

        if (jugadores.size() < 2) {

            jugadores.put(name, new Humano(name, color, turno));
        } else {

            throw new DamasException(DamasException.NO_MAS_JUGADORES);
        }

    }

    /**
     * 
     * retorna true si se consume alguna ficha, recibe como parametro la posicion de
     * la ficha, la posicion donde desea moverse y las fichas del otro jugador
     * 
     * @param fx
     * @param fy
     * @param mx
     * @param my
     * @param fichasJugadorAlt
     * @return
     * @throws DamasException
     */
    public void makeAMove(int fx, int fy, int mx, int my, ArrayList<Ficha> fichasJugadorAlt) throws DamasException {
        Ficha ficha = null;
        for (Jugador dato : jugadores.values()) {
            ficha = dato.getFicha(fx, fy);
        }
        if (ficha == null) {
            throw new DamasException(DamasException.FICHA_NO_EXISTE);
        }

        for (Jugador dato : jugadores.values()) {
            if (dato.getColor() == ficha.getColor() && jugadorEnTurno(dato.getTurn())) {

                dato.makeAMove(fx, fy, mx, my, fichasJugadorAlt);

            }
        }
        if(turno == 1){
            turno = 0;
        }
        turno +=1;
    }



    
    // METODOS PRIVADOS
    private boolean jugadorEnTurno(int i) throws DamasException {
        if (turno == i) {
            return true;

        } else {
            throw new DamasException(null);

        }

    }

}
