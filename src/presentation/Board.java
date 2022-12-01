package presentation;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;

import domain.*;

public class Board extends JPanel {

    private JButton salir, backMainMenu;

    private JPanel board;

    private JPanel midPanel,titlePanel;

    private int size;

    private Color colorFondo = Color.white;

    private Color colorFicha;

    private Casilla[][] casillas;

    private JButton[][] botones;

    private JLabel  textfield;

    private ArrayList<Ficha> fichasJ1;

    private ArrayList<Ficha> fichasJ2;

    private Tablero tablero;
    /**
     * Constructor de la clase Board
     */
    public Board(Tablero tablero){
        this.size = 10;
        this.tablero = tablero;
        this.casillas = new Casilla[size][size];
        botones = new JButton[10][10];
        board = new JPanel();
        prepareElements();
    }

    /**
     * Define los parámetros del tamaño del tablero, 
     */
    public void prepareElements(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        this.setLayout(new BorderLayout(size, size));
        this.setBackground(colorFondo);
        board.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.black));
        prepareElementsBoard();
        prepareActionsBoard();
    }

    public void prepareElementsBoard(){
        textfield = new JLabel();
        textfield.setBackground(Color.white);
        textfield.setForeground(Color.black);
        textfield.setFont(new Font("Helvetica",Font.BOLD,20));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("DAPOOS");
        textfield.setOpaque(true);
        titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,getWidth(),30);
        titlePanel.add(textfield);
        add(titlePanel,BorderLayout.NORTH);
        board = new JPanel();
        board.setBorder(new CompoundBorder(new EmptyBorder(3, 3, 3, 3), new TitledBorder("Board DaPOOs")));
        board.setLayout(new GridLayout(10, 10));
        for(int i=0;i<(10);i++) {
            for (int j = 0; j < (10); j++) {
                //casillas[i][j] = new Casilla();
                board.add(casillas[i][j]);
                if((i %2 == 0 && j%2!=0) || (i%2 == 1 && j%2 !=1)){
                    casillas[i][j].setBackground(Color.BLACK);
                    if(i<3){
                        botones[i][j] = new Fichaa();
                        botones[i][j].setBackground(Color.DARK_GRAY);
                        //botones[i][j].addActionListener(e -> moveChecker(i, j));
                        casillas[i][j].add(botones[i][j]);
                    }
                    else if(i>6){
                        botones[i][j] = new Fichaa();
                        botones[i][j].setBackground(Color.RED);
                        //botones[i][j].addActionListener(e -> moveChecker(i, j));
                        casillas[i][j].add(botones[i][j]);
                    }
                    else{
                        botones[i][j] = new Fichaa();
                        botones[i][j].setBackground(Color.BLACK);
                        //botones[i][j].addActionListener(e -> moveChecker(i, j));
                        casillas[i][j].add(botones[i][j]);
                    }
                }
                else{
                    casillas[i][j].setBackground(Color.WHITE);
                }
                casillas[i][j].setFocusable(false);
                
            }
        }
        add(board);
        midPanel = new JPanel();
        midPanel.setBorder(new LineBorder(colorFondo, 3));
        midPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 4, 4));
        midPanel.setBackground(colorFondo);
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
        salir = new JButton("Finalizar");
        backMainMenu = new JButton("Volver al menu principal");
        midPanel.add(stats, BorderLayout.EAST);
        midPanel.add(salir);
        midPanel.add(backMainMenu);
        add(midPanel, BorderLayout.EAST);
    }

    public HashMap<String, Jugador> getFichas() throws DamasException{
        Tablero e = new Tablero(2);
        return e.getJugadores();
    }

    public void refresh(){
        this.setBackground(colorFondo);
        textfield.setBackground(colorFondo);
        titlePanel.setBackground(colorFondo);
        midPanel.setBackground(colorFondo);
        board.setBackground(colorFondo);

    }

    public void moveChecker(int i, int j){
        //domain.Humano.makeAMove(i, j , i , j, fichasJ2);
    }

    public void prepareActionsBoard(){
        salir.addActionListener(e -> salida());
        backMainMenu.addActionListener(e -> regresarAlMenu());
    }

    public void setColorFondo(Color color){

        this.colorFondo = color;
    }

    private void salida(){
        int valor = JOptionPane.showConfirmDialog(this, "Desea cerrar la aplicacion?", "Advertencia",
                JOptionPane.YES_NO_OPTION);
        if (valor == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void regresarAlMenu() {
        if (JOptionPane.showConfirmDialog(this.getRootPane(), "¿Desea regresar al menú? Perderá los datos de esta partida",
                "Regresar al menú", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            DamasGUI.getGUI().setVisible(true);;
            refresh();
        }
    }
}
