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
        generateFichas();
        if (turno == 1) {
            bajando = true;
        } else {
            bajando = false;
        }
    }

    private void generateFichas() {
        for (int y = 1; y <= 2; y++) {
            for (int x = 0; x <= 10; x++) {
                int[] pos = { x, y };
                Normal ficha = new Normal(color, pos);
                fichas.add(ficha);
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

}
