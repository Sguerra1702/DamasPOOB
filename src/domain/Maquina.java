package domain;

import java.util.ArrayList;
import java.awt.*;

public class Maquina extends Jugador {
    private Color color;
    private ArrayList<Ficha> fichas;
    private int punt;
    private int turno;

    public boolean makeAMove(int posix,int posiy, int posfx, int posfy, ArrayList<Ficha> fichasJugadorAlt) throws DamasException {
        return true;
    }

    public String getName() {

        return "Maquina";
    }

    public int getFichasNum() {

        return 0;
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

    public ArrayList<Ficha> getFichas() {

        return fichas;

    }

    public Ficha getFicha(int posx, int posy) {

        return null;
    }

    public void getEaten(int posx, int posy) {

        for (int i = 0; i < fichas.size(); i++) {

            if (fichas.get(i).getPosx() == posx && fichas.get(i).getPosy() == posy) {

                fichas.remove(i);

            }

        }

    }
}
