package presentation;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.*;

public class DamasGUI extends JFrame{

    private JPanel mainPanel, gameModeSelectionPanel, gamePanel;

    private JMenu archivo, settings;

    private JMenuBar menuBar;

    private JMenuItem load, save, start, quit, tamano, color;

    private JButton solo, vsButton, exit;

    private JButton[][] board;

    public DamasGUI(){
        prepareElements();

    }

    public static void main(String[] args) {
        DamasGUI theGame = new DamasGUI();
        theGame.setVisible(true);

    }

    public void prepareElements(){
        setTitle("DamasPOOB");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width /2, screenSize.height / 2);
        setLocationRelativeTo(null);
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
        color = new JMenuItem("Color");
        archivo.add(start);
        archivo.add(load);
        archivo.add(save);
        archivo.add(quit);
        settings.add(tamano);
        settings.add(color);
        setJMenuBar(menuBar);
        //mainPanel botones
        mainPanel = new JPanel();
    }

}
