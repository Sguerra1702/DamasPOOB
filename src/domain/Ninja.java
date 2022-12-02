package domain;

import java.awt.*;

public class Ninja extends Ficha {

    public Ninja(Color color, int pos, boolean bajando) {

        super(color, pos, bajando);
        lives += 1;

    }

    public Color getColor() {

        return color;
    }

    public int getPos() {

        return pos;
    }

    public void setColor(Color color) {

        super.color = color;
    }

    public void setPos(int pos) throws DamasException {
        if (pos >= 0 || pos <= 10) {
            this.pos = pos;
        } else {

            throw new DamasException(DamasException.FUERA_DE_RANGO);

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
