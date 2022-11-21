package domain;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.awt.*;
import org.junit.After;
import org.junit.Before;
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
        jugador2=new Humano("lattetona",Color.RED, 0);
        ficha2 = new Normal(jugador2.getColor(), pos2);
        

    }

    @After
    public void tearDown(){
    }

    
}
