package domain;

import java.awt.*;

public class Ninja extends Ficha {

    public Ninja(Color color, int[] pos, boolean bajando) {

        super(color, pos, bajando);
        lives += 1;

    }

    public Color getColor() {

        return color;
    }

    public int[] getPos() {

        return pos;
    }

    public void setColor(Color color) {

        super.color = color;
    }

    public void setPos(int x, int y) throws DamasException {
        if (x <= 8 || y <= 8) {
            pos[0] = x;
            pos[1] = y;
        } else {

            throw new DamasException("a");

        }

    }

    public void action() {
        // TODO Auto-generated method stub

    }

    public void setLives() {

        lives = 1;
    }

    public boolean bajando() {
        return bajando;

    }

}
