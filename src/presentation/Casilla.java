package presentation;

import javax.swing.JPanel;
import java.awt.*;

public abstract class Casilla extends JPanel{
    private int xPos, yPos;

    private Color color;

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
