package domain;

import java.util.ArrayList;
import java.awt.*;
public class Maquina extends Jugador{
    private String name;
    private Color color;
    private ArrayList<Ficha> fichas;
    private int punt;
    private int turno;
    private boolean bajando;
    public void makeAMove(int fx, int fy, int mx, int my, ArrayList<Ficha> fichasJugadorAlt)throws DamasException{

    }
    public String getName(){

        return "a";
    }
    public int getFichasNum(){

        return 0;
    }
    public Color getColor(){

        return color;

    }
     public int getPuntaje(){

        return punt;
     }
}
