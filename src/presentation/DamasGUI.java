package presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

public class DamasGUI extends JFrame {

    private JPanel mainPanel, gameModeSelectionPanel, gamePanel, midPanel;

    private JMenu archivo, settings;

    private JMenuBar menuBar;

    private JMenuItem load, save, start, quit, tamano, colorselect;

    private JButton solo, vsButton, exit, normal, gottagofast;

    private JButton[][] board;

    private Color color;

    public DamasGUI() {
        prepareElements();
        prepareActions();

    }

    public static void main(String[] args) {
        DamasGUI theGame = new DamasGUI();
        theGame.setVisible(true);

    }

    public void prepareElements() {
        setTitle("DamasPOOB");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width / 2, screenSize.height / 2);
        setLocationRelativeTo(null);
        prepareElementsMenu();
        prepareElementsGameSelect();

    }

    public void prepareElementsMenu() {
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
        // mainPanel botones
        mainPanel = new JPanel();
        add(mainPanel);
        mainPanel.setLayout(new GridLayout(10, 1, 1, 10));
        mainPanel.add(menuBar);
        solo = new JButton("Un jugador");
        mainPanel.add(solo);
        vsButton = new JButton("Dos Jugadores");
        exit = new JButton("Salir");
        mainPanel.add(vsButton);
        mainPanel.add(exit);

    }

    public void prepareElementsGameSelect() {
        gameModeSelectionPanel = new JPanel();
        setJMenuBar(menuBar);
        add(gameModeSelectionPanel);
        gameModeSelectionPanel.add(menuBar);
        gameModeSelectionPanel.setLayout(new GridLayout(10, 1, 1, 10));
        normal = new JButton("Partida Normal");
        gameModeSelectionPanel.add(normal);
        gottagofast = new JButton("Partida QuickTime");
        gameModeSelectionPanel.add(gottagofast);

    }

    public void prepareElementsBoard() {
        board = new JButton[10][10];
        Border blackline = BorderFactory.createLineBorder(Color.black);
        gamePanel = new JPanel();
        gamePanel.setBorder(new CompoundBorder(new EmptyBorder(3, 3, 3, 3), new TitledBorder("Board TantFant")));
        gamePanel.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < (10); i++) {
            for (int j = 0; j < (10); j++) {
                if (i == 0) {
                    board[i][j] = new JButton("X");
                    gamePanel.add(board[i][j]);
                    board[i][j].setFocusable(false);
                    board[i][j].setForeground(Color.red);
                    board[i][j].setBackground(Color.WHITE);
                } else if (i == 10 - 1) {
                    board[i][j] = new JButton("O");
                    gamePanel.add(board[i][j]);
                    board[i][j].setFocusable(false);
                    board[i][j].setForeground(Color.black);
                    board[i][j].setBackground(Color.WHITE);
                } else {
                    board[i][j] = new JButton();
                    gamePanel.add(board[i][j]);
                    board[i][j].setBackground(new Color(255, 255, 255));
                    board[i][j].setFocusable(false);
                }
                board[i][j].setFont(new Font("Monocraft", Font.BOLD, 50));
            }
        }
        add(gamePanel);
        midPanel = new JPanel();
        midPanel.setBorder(new LineBorder(color, 3));
        midPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 4, 4));
        midPanel.setBackground(color);
        JPanel stats = new JPanel();
        stats.setLayout(new GridLayout(2, 1, 5, 5));
        stats.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
        stats.setBackground(Color.LIGHT_GRAY);
        JLabel textMovimientos = new JLabel("MOVIMIENTOS");
        JLabel textFichas = new JLabel("JUGADOR TURNO");
        int movimientos = 0;
        JLabel moves = new JLabel(Integer.toString(movimientos));
        String turnoJugador = "J1";
        JLabel fichasCap = new JLabel(turnoJugador);
        stats.add(textMovimientos);
        stats.add(moves);
        stats.add(textFichas);
        stats.add(fichasCap);
        midPanel.add(stats, BorderLayout.WEST);
        add(midPanel, BorderLayout.WEST);
        setComponentZOrder(gamePanel, 0);
        delButtons();
        refresh();

    }

    private void delButtons() {
        gottagofast.setVisible(false);
        ;
        normal.setVisible(false);

    }

    private void refresh() {
        setVisible(false);
        setVisible(true);

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
        prepareActionsGameSelect();

    }

    /**
     * Metodo que prepara las acciones del menu principal
     */
    private void prepareActionsMenu() {
        exit.addActionListener(e -> salida());
        solo.addActionListener(e -> prepareElementsGameSelect());
        vsButton.addActionListener(e -> prepareElementsGameSelect());
        quit.addActionListener(e -> salida());
    }

    public void prepareActionsGameSelect() {
        normal.addActionListener(e -> prepareElementsBoard());
        gottagofast.addActionListener(e -> prepareElementsBoard());
    }

    /**
     * Metodo que prepara las acciones de la configuracion
     */
    private void prepareActionsConfiguration() {

    }

    private void salida() {
        if (JOptionPane.showConfirmDialog(rootPane, "Seguro que quiere salir", "Salir del sistema",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }
}
