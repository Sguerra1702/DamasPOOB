package domain;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.awt.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class DamasTest {
    private Normal ficha1;
    private Normal ficha2;
    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<Jugador> jugadores;
    private int[] pos1 = {25,35};
    private int[] pos2 = {26,36};
    @Before
    public void setUp(){
        jugador1 = new Humano("parralol",Color.DARK_GRAY, 0);
        ficha1 = new Normal(jugador1.getColor(), pos1);
        jugador2=new Humano("lattetona",Color.RED, 1);
        ficha2 = new Normal(jugador2.getColor(), pos2);
        jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

    }

    @After
    public void tearDown(){
    }

    @Test 
    public void shouldGenerate10(){

    if(jugador1.getFichasNum()==10) assertTrue(true);
        else assertFalse(Integer.toString(jugador1.getFichasNum()), true);
    }
    @Test
    public void shouldTeleport(){
        try{
        ficha1.setPos(4, 16);
        assertTrue(true);
        }catch(DamasException e){

            fail();
        }
    }

    @Test 
    public void shouldCreateFichas(){
        if (jugador1.getFichas().get(0).getPos()== pos1){
            assertTrue(true);

        }else{
            assertFalse(Integer.toString(jugador1.getFichas().get(0).getPos()[0]) +"-" + Integer.toString(jugador1.getFichas().get(0).getPos()[1]),true);

        }


    }


    @Test
    public void shouldMove(){
        try{
        jugador1.makeAMove(25, 35, 24, 36, jugadores.get(1).getFichas());
        int[] xd = jugador1.getFicha(25,35).getPos();
        assertTrue(Integer.toString(xd[0]) +"-" + Integer.toString(xd[1]), true);
        }catch(DamasException e){
            int[] xd = jugador1.getFicha(25,35).getPos();
            fail(Integer.toString(xd[0]) +"-" + Integer.toString(xd[1]) +"-"+ e.getMessage());
        }
    }

    
    @Test
    public void shouldPlayFirstTurn(){
        try{
            Jugador j1= jugadores.get(0);
            j1.makeAMove(25, 35, 26, 36, jugadores.get(1).getFichas());
            int[] xd = j1.getFichas().get(0).getPos();
            assertTrue(Integer.toString(xd[0]) +"-" + Integer.toString(xd[1]), false);
        }catch(DamasException e){

            assertFalse(e.getMessage(), true);
        }
    }

}
