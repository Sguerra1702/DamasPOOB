package domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
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
    private int posx1 = 4;
    private int posx2 = 8;
    private int posy1 = 7;
    private int posy2 = 6;

    @Before
    public void setUp() {
        jugador1 = new Humano("parralol", Color.DARK_GRAY, 0);
        ficha1 = new Normal(jugador1.getColor(), posx1, posy1, true);
        jugador2 = new Humano("lattetona", Color.RED, 1);
        ficha2 = new Normal(jugador2.getColor(), posx2, posy2, false);
        jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void shouldGenerate20J1() {

        if (jugador1.getFichasNum() == 21) {
            assertTrue(true);
        } else {
            ArrayList<Ficha> fichas = jugador1.getFichas();
            ArrayList<String> posiciones = new ArrayList<String>();
            for (Ficha a : fichas) {
                posiciones.add(Integer.toString(a.getPosx()));
                posiciones.add(Integer.toString(a.getPosy()));
                posiciones.add("-");
            }
            String[] array = posiciones.toArray(new String[0]);
            assertFalse(Arrays.toString(array) + Integer.toString(array.length), true);
        }

    }

    @Test
    public void shouldGenerate20J2() {

        if (jugador2.getFichasNum() == 20) {
            assertTrue(true);
        } else {
            ArrayList<Ficha> fichas = jugador2.getFichas();
            ArrayList<String> posiciones = new ArrayList<String>();
            for (Ficha a : fichas) {
                posiciones.add(Integer.toString(a.getPosy()));
            }
            String[] array = posiciones.toArray(new String[0]);
            assertFalse(Arrays.toString(array) + Integer.toString(array.length), true);
        }

    }

    @Test
    public void shouldMove() {
        try {
            ficha1.setPosx(5);
            ficha1.setPosy(7);
            assertTrue(true);
        } catch (DamasException e) {

            fail();
        }
    }

}
