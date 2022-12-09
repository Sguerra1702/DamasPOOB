package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.*;

public class Tablero {

    private HashMap<String, Jugador> jugadores;
    private ArrayList<Casilla> casillas;
    private int turno;

    /**
     * contructor de la clase tablero, su input es determinado en
     * (cantidad_jugadores <= 2), de lo contrario lanzara una excepcion
     * 
     * 
     * @param cantidad_jugadores
     * @throws DamasException
     */
    public Tablero(int cantidad_jugadores) throws DamasException {
        jugadores = new HashMap<String, Jugador>();
        if (cantidad_jugadores == 1) {
            jugadores.put("Maquina", new Maquina());
        }
        if (cantidad_jugadores > 2) {
            throw new DamasException(DamasException.NO_MAS_JUGADORES);
        }
    }

    public HashMap<String, Jugador> getJugadores() {
        return jugadores;
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
            if (jugadores.size() == 2) {
                checkNamesColor();
            }
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
        public void makeAMove(int posix, int posiy, int posfx, int posfy, ArrayList<Ficha> fichasJugadorAlt) throws DamasException {
        Ficha ficha = null;
        boolean come = false;
        for (Jugador dato : jugadores.values()) {
            ficha = dato.getFicha(posix, posiy);
        }
        if (ficha == null) {
            throw new DamasException(DamasException.FICHA_NO_EXISTE);
        }

        for (Jugador dato : jugadores.values()) {
            if (dato.getColor() == ficha.getColor() && jugadorEnTurno(dato.getTurn())) {

                come = dato.makeAMove(posix, posiy, posfx, posfy, fichasJugadorAlt);

            }
        }
        if (come == true) {
            jugadores.get(nombreJugadorEnNoTurno()).getEaten(posix, posiy);
        }
        if (turno == 1) {
            turno = 0;
        } else {
            turno += 1;
        }
    }

    /*
     * metodo retorna el nombre del jugador en turno
     */
    public String nombreJugadorEnTurno() {
        String name = null;
        for (Jugador dato : jugadores.values()) {
            if (dato.getTurn() == turno)
                name = dato.getName();
        }
        return name;
    }

    /*
     * obtiene las fichas del jugador en cierto turno
     * 
     * @param turno int
     */
    public ArrayList<Ficha> fichasJugador(int turno) {

        ArrayList<Ficha> fichas = null;
        for (Jugador dato : jugadores.values()) {
            if (dato.getTurn() == turno)
                fichas = dato.getFichas();
        }
        return fichas;
    }

    /**
     * obtienes todas las fichas de los jugadores en un solo arreglo
     * 
     * @return
     */
    public ArrayList<Ficha> getAllFichas() {
        ArrayList<ArrayList<Ficha>> fichas = new ArrayList<ArrayList<Ficha>>();
        ArrayList<Ficha> res = new ArrayList<Ficha>();
        for (Jugador dato : jugadores.values()) {
            fichas.add(dato.getFichas());
        }
        for (ArrayList<Ficha> ficha : fichas) {
            for (Ficha xd : ficha) {
                res.add(xd);
            }

        }
        return res;

    }

    public void doNothing() {
        if (turno == 1) {
            turno = 0;
        } else {
            turno += 1;
        }
    }

    public ArrayList<Jugador> getAllJugadores() {

        ArrayList<Jugador> fichas = new ArrayList<Jugador>();
        for (Jugador dato : jugadores.values()) {
            fichas.add(dato);
        }
        return fichas;
    }

    public String nombreJugadorEnNoTurno() {
        String name = null;
        for (Jugador dato : jugadores.values()) {
            if (dato.getTurn() != turno)
                name = dato.getName();
        }
        return name;
    }

    public ArrayList<Ficha> fichasJugAlt(){
        return jugadores.get(nombreJugadorEnNoTurno()). getFichas();
    }

    // METODOS PRIVADOS
    private void checkNamesColor() throws DamasException {
        String[] nombres = new String[2];
        int x = 0;
        for (String key : jugadores.keySet()) {

            nombres[x] = key;
            x++;
        }
        if (jugadores.get(nombres[0]).getName() == jugadores.get(nombres[1]).getName()
                && jugadores.get(nombres[0]).getColor() == jugadores.get(nombres[1]).getColor()) {
            throw new DamasException(DamasException.NO_MISMO_COLOR_Y_NOMBRE);

        }
        if (jugadores.get(nombres[0]).getColor() == jugadores.get(nombres[1]).getColor()) {
            throw new DamasException(DamasException.NO_MISMO_COLOR);

        }
        if (jugadores.get(nombres[0]).getName() == jugadores.get(nombres[1]).getName()) {
            throw new DamasException(DamasException.NO_MISMO_NOMBRE);

        }

    }

    private boolean jugadorEnTurno(int i) {
        boolean value = false;
        if (turno == i) {
            value = true;

        }
        return value;
    }

    

}
