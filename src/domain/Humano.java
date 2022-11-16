package domain;
import java.util.*;
import java.awt.*;
public class Humano extends Jugador{

    private String name;
    private Color color;
    private ArrayList<Ficha> fichas;
    private int punt;
    private int turno;
    public Humano(String name, Color color, int i){

        this.name=name;
        this.color = color;
        fichas = new ArrayList<>();
        punt = 0;
        turno = i;
    }
    public void makeAMove(){


    }

    public String getName(){

        return name;
    }

    public int getFichasNum(){

        return fichas.size();
    }

    public Color getColor(){

        return color;

    }
     public int getPuntaje(){

        return punt;
     }
    
}

