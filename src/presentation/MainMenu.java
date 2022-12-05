package presentation;

import javax.swing.*;

import domain.Damas;

import java.awt.*;
import java.io.File;
import java.net.URL;

@SuppressWarnings("FieldCanBeLocal")
public class MainMenu extends JPanel {

    //private final JPanel mainPanel;

    private JPanel titlePanel;

    private JButton solo, vsButton, exit;

    Image image;
    private JLabel textfield;


    public MainMenu() {
        prepareElements();
    }

    public void prepareElements() {
        this.setOpaque(false);;
        prepareElementsMenu();
        image = loadImage("https://www.gifcen.com/wp-content/uploads/2022/01/wallpaper-gif-9.gif");
    }

    public void prepareElementsMenu() {
        GridLayout orden = new GridLayout(4, 1, 70, 80);
        textfield = new JLabel();
        textfield.setFont(new Font("Helvetica",Font.BOLD,69));
        textfield.setText("DAPOOS");
        textfield.setHorizontalAlignment(JLabel.CENTER);
        JPanel menuBotones = new JPanel();
        menuBotones.setBackground(Color.white);
        menuBotones.setLayout(orden);
        solo = new JButton("Un jugador");
        menuBotones.add(textfield);
        menuBotones.add(solo);
        vsButton = new JButton("Dos Jugadores");
        exit = new JButton("Salir");
        menuBotones.add(vsButton);
        menuBotones.add(exit);
        menuBotones.setOpaque(false);
        this.add(menuBotones);
        setVisible(true);
    }

    public void prepareActionsMenu() {
        solo.addActionListener(e -> prepareElementsPlayerConfig1P());
        vsButton.addActionListener(e -> prepareElementsPlayerConfig2P());
        exit.addActionListener(e -> confirmateClose());
    }

    public void prepareElementsPlayerConfig1P(){
        DamasGUI.getGUI().prepareElementsPlayerConfig1P();
    }

    public void prepareElementsPlayerConfig2P(){
        DamasGUI.getGUI().prepareElementsPlayerConfig2P();
    }

    private void confirmateClose() {
        int valor = JOptionPane.showConfirmDialog(this, "Desea cerrar la aplicacion?", "Advertencia",
                JOptionPane.YES_NO_OPTION);
        if (valor == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private Image loadImage(String url){
        try{
            getToolkit();
            final Image img = Toolkit.getDefaultToolkit().createImage("fondo");
            getToolkit();
            Toolkit.getDefaultToolkit().prepareImage(img, -1, -1, null);
            return img;
        }
        catch(Exception e){
            return null;
        }

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    
}
