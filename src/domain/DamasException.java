package domain;

public class DamasException extends Exception {

    static protected String NO_PUEDE_MOVER = "No puedes mover la ficha ahi, puerco";
    static protected String NO_MAS_JUGADORES = "No se admiten mas de 2 jugadores";
    static protected String JUGADOR_NO_EN_TURNO = "Jugador no en turno";
    static protected String FICHA_NO_EXISTE = "Ficha no existe";
    static protected String FUERA_DE_RANGO = "Sale del rango de accion";

    public DamasException(String message) {

        super(message);
    }
}
