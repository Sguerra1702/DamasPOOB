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

    private JPanel[][] casillas;

    private Ficha[][] botones;

    private JLabel  textfield;

    private ArrayList<Ficha> fichasJ1;

    private ArrayList<Ficha> fichasJ2;

    private HashMap<String, Jugador> jugadores;


    private Tablero tablero;
    /**
     * Constructor de la clase Board
     */
    public Board(int nJugadores, Color color1, String name1, int turnoJ1){
        this.size = 10;
        try{
            tablero = new Tablero(nJugadores);
            tablero.addJugador(name1, color1, turnoJ1);
        }catch (DamasException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        jugadores = tablero.getJugadores();
        fichasJ1 = jugadores.get(name1).getFichas();
        casillas = new JPanel[size][size];
        botones = new Ficha[size][size];
        board = new JPanel();
        prepareElements();
    }

    public Board(int nJugadores, Color color1, Color color2, String name1, String name2, int turnoJ1, int turnoJ2){
        this.size = 10;
        try{
            tablero = new Tablero(nJugadores);
            tablero.addJugador(name1, color1, turnoJ1);
            tablero.addJugador(name2, color2, turnoJ2);
        }catch (DamasException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        jugadores = tablero.getJugadores();
        for(String key: jugadores.keySet()){
            System.out.println(key);
        }
        fichasJ1 = jugadores.get(name1).getFichas();
        fichasJ2 = jugadores.get(name2).getFichas();
        casillas = new JPanel[size][size];
        botones = new Normal[size][size];
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
        int k = 0;
        int l = 0;
        for(int i=0;i<(10);i++) {
            for (int j = 0; j < (10); j++) {
                casillas[i][j] = new JPanel();
                board.add(casillas[i][j]);
                if((i %2 == 0 && j%2!=0) || (i%2 == 1 && j%2 !=1)){
                    casillas[i][j].setBackground(Color.BLACK);
                    if(i<5){
                        if(k<20){
                            botones[i][j] = fichasJ1.get(k);

                            //botones[i][j].addActionListener(e -> moveChecker(i, j));
                            casillas[i][j].add(botones[i][j]);
                            casillas[i][j].setAlignmentX(JPanel.CENTER_ALIGNMENT);
                            k++;
                        }
                    }
                    
                    
                }
                else{
                    casillas[i][j].setBackground(Color.WHITE);
                }
                casillas[i][j].setFocusable(false);
                
                
            }
        }
        for(int i=0;i<(10);i++) {
            for (int j = 0; j < (10); j++) {
                if((i %2 == 0 && j%2!=0) || (i%2 == 1 && j%2 !=1)){
                    if(i>5){
                        if(l < 20){
                            botones[i][j] = fichasJ2.get(l);
                            //botones[i][j].addActionListener(e -> moveChecker(i, j));
                            casillas[i][j].add(botones[i][j]);
                            l++;
                        }
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
