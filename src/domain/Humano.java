package domain;

import java.util.*;
import java.awt.*;

public class Humano extends Jugador {

    private String name;
    private Color color;
    private ArrayList<Ficha> fichas;
    private int punt;
    private int turno;

    /**
     * 
     * constructor de la clase humano
     * 
     * @param name  String
     * @param color Color
     * @param i     int
     */
    public Humano(String name, Color color, int i) {

        this.name = name;
        this.color = color;
        fichas = new ArrayList<Ficha>();
        punt = 0;
        turno = i;

        if (i == 0)
            generateFichasj1();
        else
            generateFichasj2();

    }

    /*
     * 
     * realiza una juagada, retorna true si se consume alguna ficha
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
    public boolean makeAMove(int posf, int posm, ArrayList<Ficha> fichasJugadorAlt) throws DamasException {
        boolean res = false;
        for (Ficha a : fichas) {
            if (a.getPos() == posf) {
                int movy = posf - posm;
                if (movy < 0 && getFicha(posf).bajando() || movy > 0 && !getFicha(posf).bajando()) {
                    a.setPos(posm);
                    if (doesEat(posm, fichasJugadorAlt)
                            && friendlyFire(posm)) {
                        res = true;
                    }
                } else {

                    throw new DamasException(DamasException.NO_PUEDE_MOVER);
                }
            } else {

                throw new DamasException(DamasException.FICHA_NO_EXISTE);
            }
        }
        return res;
    }

    public void getEaten(int pos) {

        for (int i = 0; i < fichas.size(); i++) {

            if (fichas.get(i).getPos() == pos) {

                fichas.remove(i);

            }

        }

    }

    /*
     * retorna el nombre del jugador
     */
    public String getName() {

        return name;
    }

    /*
     * retorna el numero de fichas
     */
    public int getFichasNum() {

        return fichas.size();
    }

    /*
     * retorna el color del jugador
     */
    public Color getColor() {

        return color;

    }

    /*
     * retorna el puntaje del jugador
     */
    public int getPuntaje() {

        return punt;
    }

    /*
     * retorna el turno del jugador
     */
    public int getTurn() {

        return turno;
    }

    /*
     * 
     * retorna las fichas del jugador
     */
    public ArrayList<Ficha> getFichas() {
        return fichas;

    }

    /*
     * retorna la ficha del jugador
     *
     * @param posx int
     * 
     * @param posy int
     */
    public Ficha getFicha(int pos) {
        Ficha ficha = null;
        for (Ficha a : fichas) {
            if (a.getPos() == pos) {

                ficha = a;

            }
        }
        return ficha;
    }

    // METODOS PRIVADOS

    private boolean friendlyFire(int posm) {
        boolean res = true;
        if (getFicha(posm) != null) {

            res = false;
        }
        return res;
    }

    private void generateFichasj1() {

        int fact = 0;
        for (int i = 0; i <= 3; i++) {
            if (i != 0) {

                fact = i * 10;

            }
            if (!(i % 2 == 0)) {
                for (int j = 1; j <= 5; j++) {

                    Normal ficha1 = new Normal(color, 2 * j + fact, true);
                    fichas.add(ficha1);

                }
            } else {
                for (int j = 0; j < 5; j++) {
                    Normal ficha1 = new Normal(color, 2 * j + 1 + fact, true);
                    fichas.add(ficha1);

                }

            }

        }
    }

    private boolean doesEat(int pos, ArrayList<Ficha> fichasJugadorAlt) {
        boolean res = false;
        for (Ficha a : fichasJugadorAlt) {
            if (a.getPos() == pos && a.getPos() == pos) {
                punt += 10;
                res = true;
            }
        }
        return res;
    }

    private void generateFichasj2() {
        int fact = 0;
        for (int i = 6; i <= 9; i++) {
            if (i != 0) {

                fact = i * 10;

            }
            if (!(i % 2 == 0)) {
                for (int j = 1; j <= 5; j++) {

                    Normal ficha1 = new Normal(color, 2 * j + fact, false);
                    fichas.add(ficha1);

                }
            } else {
                for (int j = 0; j < 5; j++) {
                    Normal ficha1 = new Normal(color, 2 * j + 1 + fact, false);
                    fichas.add(ficha1);

                }

            }

        }
    }
}