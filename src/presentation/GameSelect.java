package presentation;

import javax.swing.*;
import java.awt.*;

public class GameSelect extends JPanel {
    private final JPanel mainPanel;

    private Board board;

    private JPanel gameModeSelectionPanel;

    private JMenu archivo, settings;

    private JMenuBar menuBar;

    private JMenuItem load, save, start, quit, tamano, colorselect;

    private JButton normal, gottagofast, exit;

    public GameSelect(){
        mainPanel = new JPanel();
        prepareElements();
    }

    public void prepareElements(){
        mainPanel.setLayout(new GridLayout(10,1,1,10));
        mainPanel.setBackground(Color.black);
        mainPanel.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.black));
        prepareElementsGameSelect();
        prepareActionsGameSelect();
    }

    public void prepareActionsGameSelect() {
        normal.addActionListener(e -> prepareElementsBoardNormal());
        gottagofast.addActionListener(e -> prepareElementsBoardQuicktime());
        exit.addActionListener(e -> confirmateClose());
    }

    public void prepareElementsGameSelect() {
        gameModeSelectionPanel = new JPanel();
        add(gameModeSelectionPanel);
        gameModeSelectionPanel.setLayout(new GridLayout(10, 1, 1, 10));
        normal = new JButton("Partida Normal");
        gameModeSelectionPanel.add(normal);
        gottagofast = new JButton("Partida QuickTime");
        gameModeSelectionPanel.add(gottagofast);
        exit = new JButton("Salir");
        gameModeSelectionPanel.add(exit);
        add(gameModeSelectionPanel);
    }

    public void prepareElementsBoardNormal(){
        setVisible(false);
        board = new Board();
        board.prepareElements();
        board.setVisible(true);
    }

    public void prepareElementsBoardQuicktime(){
        setVisible(false);
        board = new Board();
        board.prepareElements();
        board.setVisible(true);
    }

    private void confirmateClose() {
        int valor = JOptionPane.showConfirmDialog(this, "Desea cerrar la aplicacion?", "Advertencia",
                JOptionPane.YES_NO_OPTION);
        if (valor == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

}
