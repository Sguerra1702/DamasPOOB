package domain;

import java.util.*;
import java.awt.*;

public class Humano extends Jugador {

    private String name;
    private Color color;
    private ArrayList<Ficha> fichas;
    private int punt;
    private int turno;
    private boolean bajando;

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

        if (i == 1)
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
    public boolean makeAMove(int fx, int fy, int mx, int my, ArrayList<Ficha> fichasJugadorAlt) throws DamasException {
        boolean res = false;
        for (Ficha a : fichas) {
            if (a.getPos()[0] == fx && a.getPos()[1] == fy) {
                int movx = fx - mx;
                int movy = fy - my;
                if (my < 0 && bajando || my > 0 && !bajando) {
                    a.setPos(movx + a.getPos()[0], movy + a.getPos()[1]);
                    if (doesEat(movx + a.getPos()[0], movy + a.getPos()[1], mx, my, fichasJugadorAlt)
                            && friendlyFire(mx, my)) {
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

    /**
     * una ficha es comida
     * 
     * @param mx
     * @param my
     */
    public void getEaten(int mx, int my) {

        for (int i = 0; i < fichas.size(); i++) {

            if (fichas.get(i).getPos()[0] == mx && fichas.get(i).getPos()[1] == my) {

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
    public Ficha getFicha(int posx, int posy) {
        int[] pos = { posx, posy };
        Ficha ficha = null;
        for (Ficha a : fichas) {
            if (a.getPos() == pos) {

                ficha = a;

            }
        }
        return ficha;
    }

    // METODOS PRIVADOS

    private boolean friendlyFire(int mx, int my) {
        boolean res = true;
        if (getFicha(mx, my) != null) {

            res = false;
        }
        return res;
    }

    private void generateFichasj1() {
        int y = 0;
        for (int x = 0; x <= 9; x++) {
            if (y == 0) {
                int[] pos1 = { x, 0 };
                int[] pos2 = { x, 2 };
                Normal ficha1 = new Normal(color, pos1, true);
                Normal ficha2 = new Normal(color, pos2, true);
                fichas.add(ficha1);
                fichas.add(ficha2);
                y += 1;

            }
            if (y == 1) {
                int[] pos1 = { x, 1 };
                Normal ficha1 = new Normal(color, pos1, true);
                fichas.add(ficha1);
                y = 0;
            }
        }
    }

    private boolean doesEat(int movx, int movy, int mx, int my, ArrayList<Ficha> fichasJugadorAlt) {
        boolean res = false;
        for (Ficha a : fichasJugadorAlt) {
            if (a.getPos()[0] == movx && a.getPos()[1] == movy) {
                punt += 10;
                res = true;
            }
        }
        return res;
    }

    private void generateFichasj2() {
        int y = 0;
        for (int x = 0; x <= 9; x++) {
            if (y == 1) {
                int[] pos1 = { x, 0 };
                int[] pos2 = { x, 2 };
                Normal ficha1 = new Normal(color, pos1, false);
                Normal ficha2 = new Normal(color, pos2, false);
                fichas.add(ficha1);
                fichas.add(ficha2);
                y += 1;

            }
            if (y == 0) {
                int[] pos1 = { x, 1 };
                Normal ficha1 = new Normal(color, pos1, false);
                fichas.add(ficha1);
                y = 0;
            }

        }
    }
}
