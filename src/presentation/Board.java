package presentation;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Board extends JPanel {
    private JMenu archivo, settings;

    private JMenuBar menuBar;

    private JMenuItem load, save, start, quit, tamano, colorselect;
    private JPanel menuPrincipal, board;

    private JPanel midPanel,titlePanel;

    private int size;

    private Color colorFondo = Color.white;

    private Color colorFicha;

    private JButton[][] buttons;

    private JLabel  textfield;

    public Board(){
        this.size = 10;
        buttons = new JButton[size][size];
        board = new JPanel();
        menuPrincipal = new JPanel();
        prepareElements();
    }

    public void prepareElements(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        this.setLayout(new BorderLayout(size, size));
        this.setBackground(colorFondo);
        board.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.black));
        prepareElementsBoard();
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
        buttons = new JButton[10][10];
        Border blackline = BorderFactory.createLineBorder(Color.black);
        board = new JPanel();
        board.setBorder(new CompoundBorder(new EmptyBorder(3, 3, 3, 3), new TitledBorder("Board DaPOOs")));
        board.setLayout(new GridLayout(10, 10));
        for(int i=0;i<(10);i++) {
            for (int j = 0; j < (10); j++) {
                if((i %2 == 0 && j%2!=0) || (i%2 == 1 && j%2 !=1)){
                    colorFicha = Color.BLACK;
                }
                else{
                    colorFicha = Color.WHITE;
                }
                buttons[i][j] = new JButton();
                board.add(buttons[i][j]);
                buttons[i][j].setBackground(colorFicha);
                buttons[i][j].setFocusable(false);
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
        midPanel.add(stats, BorderLayout.WEST);
        add(midPanel, BorderLayout.WEST);
    }

    public void refresh(){
        this.setBackground(colorFondo);
        textfield.setBackground(colorFondo);
        titlePanel.setBackground(colorFondo);
        midPanel.setBackground(colorFondo);
        board.setBackground(colorFondo);

    }

    public void setColorFondo(Color color){

        this.colorFondo = color;
    }

    private void regresarAlMenu() {
        if (JOptionPane.showConfirmDialog(this.getRootPane(), "¿Desea regresar al menú? Perderá los datos de esta partida",
                "Regresar al menú", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            menuPrincipal.setVisible(true);
            refresh();
        }
    }
}
