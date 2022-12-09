package main.java.vista;

import main.java.model.Sala;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Ventana extends JFrame {
    private Pantalla pantalla;
    private GameBoy gameBoy;
    public Ventana() throws IOException {
        super();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 732, 517);
        this.gameBoy = new GameBoy();
        this.pantalla = new Pantalla();
        this.pantalla.setLocation(62,54);
        this.getContentPane().add(pantalla);
        this.getContentPane().add(gameBoy);
        this.setVisible(true);
    }

    public void setButtonsListener(ActionListener listener) {
        gameBoy.setActionListener(listener);
    }
    public void removeButtonsListener() {
        gameBoy.removeActionListener();
    }
    public void setPrincipalListener(ActionListener listener) {
        gameBoy.setPrincipalListener(listener);
    }
    public void removePrincipalListener() {
        gameBoy.removePrincipalListener();
    }

    public  void updatePantalla(Pantalla pantalla) {
        if (this.pantalla != null){
            this.getContentPane().remove(this.pantalla);
        }
        this.getContentPane().remove(this.gameBoy);
        this.pantalla = pantalla;
        this.pantalla.setLocation(62,54);
        this.pantalla.setSize(382,292);
        this.getContentPane().add(pantalla);
        this.getContentPane().add(gameBoy);
        this.update(this.getGraphics());
    }
}
