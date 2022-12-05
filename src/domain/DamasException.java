package domain;

public class DamasException extends Exception {

    public static final String NO_PUEDE_MOVER = "No puedes mover la ficha ahi, puerco";
    public static final String NO_MAS_JUGADORES = "No se admiten mas de 2 jugadores";
    public static final String JUGADOR_NO_EN_TURNO = "Jugador no en turno";
    public static final String FICHA_NO_EXISTE = "Ficha no existe";
    public static final String FUERA_DE_RANGO = "Sale del rango de accion";
    public static final String NO_ELIGIO_NADA = "Usted no ha elegido ninguna opción, intente de nuevo";
    public static final String J1_NOMBRE_INCORRECTO = "El nombre para el jugador 1 es invalido, non puede ser vacío";
    public static final String J2_NOMBRE_INCORRECTO = "El nombre para el jugador 2 es invalido, non puede ser vacío";

    public DamasException(String message) {

        super(message);
    }
}
