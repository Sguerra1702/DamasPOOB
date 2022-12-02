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
    private int pos1 = 45;
    private int pos2 = 56;

    @Before
    public void setUp() {
        jugador1 = new Humano("parralol", Color.DARK_GRAY, 0);
        ficha1 = new Normal(jugador1.getColor(), pos1, true);
        jugador2 = new Humano("lattetona", Color.RED, 1);
        ficha2 = new Normal(jugador2.getColor(), pos2, false);
        jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void shouldGenerate20J1() {

        if (jugador1.getFichasNum() == 20) {
            assertTrue(true);
        } else {
            ArrayList<Ficha> fichas = jugador1.getFichas();
            ArrayList<String> posiciones = new ArrayList<String>();
            for (Ficha a : fichas) {
                posiciones.add(Integer.toString(a.getPos()));
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
                posiciones.add(Integer.toString(a.getPos()));
            }
            String[] array = posiciones.toArray(new String[0]);
            assertFalse(Arrays.toString(array) + Integer.toString(array.length), true);
        }

    }

    @Test
    public void shouldMove() {
        try {
            ficha1.setPos(5);
            assertTrue(true);
        } catch (DamasException e) {

            fail();
        }
    }

}
