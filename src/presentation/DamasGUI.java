package presentation;

import java.awt.*;
import java.net.URL;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

import org.w3c.dom.DOMException;

import domain.*;

public class DamasGUI extends JFrame{

    private JPanel mainPanel, gameModeSelectionPanel, gamePanel, midPanel;

    private JMenu archivo, settings;

    private JMenuBar menuBar;

    private JMenuItem load, save, start, quit, tamano, colorselect;


    private Board board;

    private MainMenu menuPrincipal;

    private GameSelect menuGameSelect;

    private Color color;

    private j12 j12Maquina, j12Jugadores;

    private static DamasGUI nggyu;

    private int nJugadores;

    private Tablero tablero;

    public DamasGUI(){
        prepareElements();
        prepareActions();

    }

    public static DamasGUI getGUI(){
        if(nggyu == null){
            nggyu = new DamasGUI();
        }
        return nggyu;
    }

    public static void main(String[] args) throws DamasException{
        nggyu = new DamasGUI();
        nggyu.setVisible(true);
    }

    public void prepareElements(){
        setTitle("DamasPOOB");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null);
        menuPrincipal = new MainMenu();
        try {
            j12Maquina = new j12(0);
        }
        catch(DamasException e){
            e.printStackTrace();
        }
        try {
            j12Jugadores = new j12();
        }
        catch(DamasException e){
            e.printStackTrace();
        }
        
        prepareElementsMenu();

    }

    public void prepareElementsMenu(){
        menuBar = new JMenuBar();
        archivo = new JMenu("Archivo");
        menuBar.add(archivo);
        settings = new JMenu("Configuración");  
        menuBar.add(settings);
        start = new JMenuItem("Nuevo");
        save = new JMenuItem("Salvar");
        load = new JMenuItem("Abrir");
        quit = new JMenuItem("Salir");
        tamano = new JMenuItem("Tamaño");
        colorselect = new JMenuItem("Color");
        archivo.add(start);
        archivo.add(load);
        archivo.add(save);
        archivo.add(quit);
        settings.add(tamano);
        settings.add(colorselect);
        setJMenuBar(menuBar);
        this.add(menuPrincipal);

    }

    public void prepareElementsPlayerConfig1P(){
        this.remove(menuPrincipal);
        add(j12Maquina);
        validate();
        repaint();
    }

    public void prepareElementsPlayerConfig2P(){
        this.remove(menuPrincipal);
        add(j12Jugadores);
        validate();
        repaint();
    }

    public void prepareElementsGameSelect1P(Color color1, String name1, int turnoJ1){
        menuGameSelect = new GameSelect(color, name1, turnoJ1);
        this.remove(j12Maquina);
        add(menuGameSelect);
        validate();
        repaint();
    }

    public void prepareElementsGameSelect2P(Color color1, Color color2, String name1, String name2, int turnoJ1, int turnoJ2){
        menuGameSelect = new GameSelect(color1, color2, name1, name2, turnoJ1, turnoJ2);
        this.remove(j12Jugadores);
        add(menuGameSelect);
        validate();
        repaint();
    }

    public void prepareElementsBoardNormal1P(Color color1, String name1, int turnoJ1){
        board = new Board(nJugadores, color1, name1, turnoJ1);
        remove(menuGameSelect);
        add(board);
        validate();
        repaint();
    }

    public void prepareElementsBoardNormal2P(Color color1, Color color2, String name1, String name2, int turnoJ1, int turnoJ2){
        board = new Board(nJugadores, color1, color2, name1, name2, turnoJ1, turnoJ2);
        remove(menuGameSelect);
        add(board);
        validate();
        repaint();
    }

    public void prepareElementsBoardQuickT1P(Color color1, String name1, int turnoJ1){
        remove(menuGameSelect);
        add(board);
        validate();
        repaint();
    }

    public void prepareElementsBoardQuickT2P(Color color1, Color color2, String name1, String name2, int turnoJ1, int turnoJ2){
        remove(menuGameSelect);
        add(board);
        validate();
        repaint();
    }

    public void prepareActions() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                salida();
            }
        });
        prepareActionsMenu();
        prepareActionsConfiguration();
    }
    /**
     * Metodo que prepara las acciones del menu principal
     * @throws DamasException
     */
    public void prepareActionsMenu() {
        menuPrincipal.prepareActionsMenu();
    }


    /**
     * Metodo que prepara las acciones de la configuracion
     */
    private void prepareActionsConfiguration(){

    }


    private void salida() {
        if (JOptionPane.showConfirmDialog(rootPane, "Seguro que quiere salir", "Salir del sistema", JOptionPane.YES_NO_OPTION
        ) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }else {
            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }


}