package domain;

import java.awt.*;

public class Ninja extends Ficha {

    public Ninja(Color color, int posx, int posy, boolean bajando) {

        super(color, posx, posy, bajando);
        lives += 1;

    }

    public Color getColor() {

        return color;
    }

    public int getPosx() {

        return posx;
    }

    public int getPosy(){
        return posy;
    }

    public void setColor(Color color) {

        super.color = color;
    }

    public void setPosx(int posx) throws DamasException {
        if (posx >= 0 || posx <= 10) {
            this.posx = posx;
        } else {

            throw new DamasException(DamasException.FUERA_DE_RANGO);

        }

    }

    public void setPosy(int posy) throws DamasException {
        if (posy >= 0 || posy <= 10) {
            this.posy = posy;
        } else {

            throw new DamasException(DamasException.FUERA_DE_RANGO);

        }

    }

    public void setTamano(Dimension dimension){
        this.setPreferredSize(dimension);
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

