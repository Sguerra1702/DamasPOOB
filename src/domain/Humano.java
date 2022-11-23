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
        if (turno == 1) {
            bajando = true;
        } else {
            bajando = false;
        }
    }

    private void generateFichasj1() {
        int y = 0;
        for (int x = 0; x <= 9; x++) {
            if (y == 0) {
                int[] pos1 = { x, 0 };
                int[] pos2 = { x, 2 };
                Normal ficha1 = new Normal(color, pos1);
                Normal ficha2 = new Normal(color, pos2);
                fichas.add(ficha1);
                fichas.add(ficha2);
                y += 1;

            }
            if (y == 1) {
                int[] pos1 = { x, 1 };
                Normal ficha1 = new Normal(color, pos1);
                fichas.add(ficha1);
                y = 0;
            }
        }
    }

    private void generateFichasj2() {
        int y = 0;
        for (int x = 0; x <= 9; x++) {
            if (y == 1) {
                int[] pos1 = { x, 0 };
                int[] pos2 = { x, 2 };
                Normal ficha1 = new Normal(color, pos1);
                Normal ficha2 = new Normal(color, pos2);
                fichas.add(ficha1);
                fichas.add(ficha2);
                y += 1;

            }
            if (y == 0) {
                int[] pos1 = { x, 1 };
                Normal ficha1 = new Normal(color, pos1);
                fichas.add(ficha1);
                y = 0;
            }

        }
    }

    /*
     * 
     * realiza una juagada, retorna true si se consume alguna ficha
     * 
     * @Param fx
     * 
     * @Param fy
     * 
     * @Param mx
     * 
     * @Param my
     * 
     * @Param fichasJugadorAlt
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
                    if (doesEat(movx + a.getPos()[0], movy + a.getPos()[1], mx, my, fichasJugadorAlt)) {
                        res = true;
                    }
                } else {

                    throw new DamasException(DamasException.NO_PUEDE_MOVER);
                }
            } else {

                throw new DamasException(DamasException.NO_PUEDE_MOVER);
            }
        }
        return res;
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

    public void getEaten(int mx, int my) {

        for (int i = 0; i < fichas.size(); i++) {

            if (fichas.get(i).getPos()[0] == mx && fichas.get(i).getPos()[1] == my) {

                fichas.remove(i);

            }

        }

    }

    public String getName() {

        return name;
    }

    public int getFichasNum() {

        return fichas.size();
    }

    public Color getColor() {

        return color;

    }

    public int getPuntaje() {

        return punt;
    }

    public int getTurn() {

        return turno;
    }

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
}
