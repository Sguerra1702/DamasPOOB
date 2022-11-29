package domain;

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
    private int[] pos1 = { 25, 35 };
    private int[] pos2 = { 26, 36 };

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
    public void shouldGenerate20() {

        if (jugador1.getFichasNum() == 22)
            assertTrue(true);
        else
            assertFalse(Integer.toString(jugador1.getFichasNum()), true);
    }

    @Test
    public void shouldMove() {
        try {
            ficha1.setPos(4, 16);
            assertTrue(true);
        } catch (DamasException e) {

            fail();
        }
    }

}
