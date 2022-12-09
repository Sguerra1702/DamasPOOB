package persistence;

import java.io.*;
import domain.*;

public class DamasIO {
    public static void save(File file, Tablero a) throws DamasException {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(a);
            out.close();

        } catch (Exception e) {
            throw new DamasException("Ocurrio un error a     save " + file.getName());
        }
    }

    public static void saveO1(File file, Tablero a) throws DamasException {
        if (file.getName().endsWith(".dat")) {
            save(file, a);
        } else {
            throw new DamasException(DamasException.EXTENSION_ARCHIVO_NO_VALIDO);
        }
    }

    public static Tablero abrir(File file) throws DamasException {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            Tablero a = (Tablero) in.readObject();
            in.close();
            return a;

        } catch (Exception e) {
            System.out.println(e);
            throw new DamasException("Ocurrio un error al Abrir " + file.getName());
        }
    }

    public static Tablero abrirO1(File file) throws DamasException {
        if (file.getName().endsWith(".dat")) {
            return abrir(file);
        } else {
            throw new DamasException(DamasException.EXTENSION_ARCHIVO_NO_VALIDO);
        }
    }

}
