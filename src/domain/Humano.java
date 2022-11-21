package domain;
import java.util.*;
import java.awt.*;
public class Humano extends Jugador{

    private String name;
    private Color color;
    private ArrayList<Ficha> fichas;
    private int punt;
    private int turno;
    private boolean bajando;

    public Humano(String name, Color color, int i){

        this.name=name;
        this.color = color;
        fichas = new ArrayList<Ficha>();
        punt = 0;
        turno = i;
        generateFichas();
        if(turno == 1){
            bajando= true;
        }else{
            bajando= false;
        }
    }
    private void generateFichas(){
        for(int y= 1; y<=2; y++){
            for(int x= 0; x<=10; x++){
                int[] pos= {x,y};
                Normal ficha = new Normal(color, pos);
                fichas.add(ficha);
            }
        }

    }
    public void makeAMove(int fx, int fy, int mx, int my, ArrayList<Ficha> fichasJugadorAlt) throws DamasException{
        for(Ficha a: fichas){
            if(a.getPos()[0] == fx && a.getPos()[1] == fy){

               int movx =fx-mx;
               int movy =fy-my;
               if(my < 0 && bajando || my>0 && !bajando){
                a.setPos(movx, movy);

               }else{

                throw new DamasException(DamasException.NO_PUEDE_MOVER);

               }
            }

        }

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

