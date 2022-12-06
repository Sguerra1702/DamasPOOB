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
    public boolean makeAMove(int posix, int posiy, int posfx,int posfy, ArrayList<Ficha> fichasJugadorAlt) throws DamasException {
        boolean res = false;
        for (Ficha a : fichas) {
            if (a.getPosx() == posix && a.getPosy() == posiy) {
                int movx = posfx - posix;
                int movy = posfy - posiy;
                for (int i = 0; i<movx; i++){
                    a.setPosx(posfx);
                    a.setPosy(posfy);
                    if (doesEat(posfx, posfy, fichasJugadorAlt)
                            && friendlyFire(posfx, posfy)) {
                        res = true;
                    }
                }
                
            } else {

                throw new DamasException(DamasException.FICHA_NO_EXISTE);
            }
        }
        return res;
    }

    public void getEaten(int posx, int posy) {

        for (int i = 0; i < fichas.size(); i++) {

            if (fichas.get(i).getPosx() == posx && fichas.get(i).getPosy() == posy) {

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
        Ficha ficha = null;
        for (Ficha a : fichas) {
            if (a.getPosx() == posx && a.getPosy() == posy) {

                ficha = a;

            }
        }
        return ficha;
    }

    // METODOS PRIVADOS

    private boolean friendlyFire(int posx, int posy) {
        boolean res = true;
        if (getFicha(posx, posy) != null) {

            res = false;
        }
        return res;
    }

    private void generateFichasj1() {
        for(int i=0;i<(10);i++) {
            for (int j = 0; j < (10); j++) {
                if((i %2 == 0 && j%2!=0) || (i%2 == 1 && j%2 !=1)){
                    fichas.add(new Normal(color, i, j, false));    
                }
            }
        }
    }

    private boolean doesEat(int posx, int posy, ArrayList<Ficha> fichasJugadorAlt) {
        boolean res = false;
        for (Ficha a : fichasJugadorAlt) {
            if (a.getPosx() == posx && a.getPosy() == posy) {
                punt += 10;
                res = true;
            }
        }
        return res;
    }

    private void generateFichasj2() {
        for(int i=0;i<(10);i++) {
            for (int j = 0; j < (10); j++) {
                if((i %2 == 0 && j%2!=0) || (i%2 == 1 && j%2 !=1)){
                    fichas.add(new Normal(color, i, j, false));    
                }
            }
        }
    }
}