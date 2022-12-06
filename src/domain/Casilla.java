package domain;

import java.util.ArrayList;


import javax.swing.JPanel;
import java.awt.*;

public class Casilla extends JPanel{
    private int xPos, yPos;

    private Color color;

    ArrayList<Comodin> comodines;

    public Casilla(int xPos, int yPos){
        super();
        this.xPos = xPos;
        this.yPos = yPos;
        
    }
    public int getX(){
        return xPos;
    }

    public int getY(){
        return yPos;

    }
    public void setX(int positionX){
        this.xPos = positionX;
    }

    public void setY(int positionY){
        this.yPos = positionY;

    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color newColor){
        this.color = newColor;
    }
    
}