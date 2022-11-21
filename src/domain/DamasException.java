package domain;

public class DamasException extends Exception{

    static protected String NO_PUEDE_MOVER = "No puedes mover la ficha ahi, puerco";

    public DamasException(String message){

        super(message);
    }
}
