package presentation;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("FieldCanBeLocal")
public class MainMenu extends JPanel {

    private final JPanel mainPanel;

    private JButton solo, vsButton, exit;

    private GameSelect gameSelectWindow;

    public MainMenu() {
        mainPanel = new JPanel();
        prepareElements();
    }

    public void prepareElements() {
        mainPanel.setLayout(new GridLayout(10, 1, 1, 10));
        mainPanel.setBackground(Color.white);
        mainPanel.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black));
        prepareElementsMenu();
        prepareActionsMenu();
    }

    public void prepareElementsMenu() {
        //mainPanel botones
        add(mainPanel);
        mainPanel.setLayout(new GridLayout(10, 1, 1, 10));
        solo = new JButton("Un jugador");
        mainPanel.add(solo);
        vsButton = new JButton("Dos Jugadores");
        exit = new JButton("Salir");
        mainPanel.add(vsButton);
        mainPanel.add(exit);
    }

    public void prepareActionsMenu() {
        solo.addActionListener(e -> prepareElementsGameSelect());
        vsButton.addActionListener(e -> prepareElementsGameSelect());
        exit.addActionListener(e -> confirmateClose());
    }

    public void prepareElementsGameSelect(){
        mainPanel.setVisible(false);
        gameSelectWindow = new GameSelect();
        gameSelectWindow.setVisible(true);
        add(gameSelectWindow);
    }

    private void confirmateClose() {
        int valor = JOptionPane.showConfirmDialog(this, "Desea cerrar la aplicacion?", "Advertencia",
                JOptionPane.YES_NO_OPTION);
        if (valor == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

}
