/*
* Humberto Antonio Salinas Cortes
* Juan Montero Terron
* Estefany Montaño Estrada
* Alexis Eduardo Almanza Ortega
*/
package vista;

import control.ControlMapa;
import model.Actions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameBoy extends JPanel {
    private BufferedImage bufferedFondo;
    private Image fondo;
    private JButton btnArriba;
    private JButton btnAbajo;
    private JButton btnDerecha;
    private JButton btnIzquierda;
    private JButton btnA;
    private JButton btnB;
    private JButton btnC;
    private JButton btnStart;
    private JButton btnSelect;
    //Panel Escenario se colocará en 60,53
    public GameBoy() throws IOException {
        super(null);
        File file = new File("src/imagenes/gameboy.png");
        bufferedFondo = ImageIO.read(file);
        fondo = bufferedFondo.getScaledInstance(720, 480, Image.SCALE_SMOOTH);

        btnA = new JButton();
        btnA.setOpaque(false);
        btnA.setContentAreaFilled(false);
        btnA.setBorderPainted(false);
        btnA.setBounds(539, 107, 70, 70);
        btnA.setActionCommand(Actions.BUTTON_A + "");

        btnB = new JButton();
        btnB.setOpaque(false);
        btnB.setContentAreaFilled(false);
        btnB.setBorderPainted(false);
        btnB.setBounds(615, 150, 70, 70);
        btnB.setActionCommand(Actions.BUTTON_B + "");

        btnC = new JButton();
        btnC.setOpaque(false);
        btnC.setContentAreaFilled(false);
        btnC.setBorderPainted(false);
        btnC.setBounds(539, 205, 70, 70);
        btnC.setActionCommand(Actions.BUTTON_C + "");

        btnStart = new JButton();
        btnStart.setOpaque(false);
        btnStart.setContentAreaFilled(false);
        btnStart.setBorderPainted(false);
        btnStart.setBounds(268, 416, 44, 19);
        btnStart.setActionCommand(Actions.START + "");

        btnSelect = new JButton();
        btnSelect.setOpaque(false);
        btnSelect.setContentAreaFilled(false);
        btnSelect.setBorderPainted(false);
        btnSelect.setBounds(198, 416, 44, 19);
        btnSelect.setActionCommand(Actions.SELECT + "");

        btnArriba = new JButton();
        btnArriba.setOpaque(false);
        btnArriba.setContentAreaFilled(false);
        btnArriba.setBorderPainted(false);
        btnArriba.setBounds(568, 305, 53, 53);
        btnArriba.setActionCommand(Actions.ARRIBA + "");

        btnAbajo = new JButton();
        btnAbajo.setOpaque(false);
        btnAbajo.setContentAreaFilled(false);
        btnAbajo.setBorderPainted(false);
        btnAbajo.setBounds(568, 400, 53, 53);
        btnAbajo.setActionCommand(Actions.ABAJO + "");

        btnDerecha = new JButton();
        btnDerecha.setOpaque(false);
        btnDerecha.setContentAreaFilled(false);
        btnDerecha.setBorderPainted(false);
        btnDerecha.setBounds(621, 350, 53, 53);
        btnDerecha.setActionCommand(Actions.DERECHA + "");

        btnIzquierda = new JButton();
        btnIzquierda.setOpaque(false);
        btnIzquierda.setContentAreaFilled(false);
        btnIzquierda.setBorderPainted(false);
        btnIzquierda.setBounds(525, 350, 53, 53);
        btnIzquierda.setActionCommand(Actions.IZQUIERDA + "");




        this.add(btnA);
        this.add(btnB);
        this.add(btnC);
        this.add(btnStart);
        this.add(btnSelect);
        this.add(btnArriba);
        this.add(btnAbajo);
        this.add(btnDerecha);
        this.add(btnIzquierda);


    }

    public void setActionListener(ActionListener actionListener) {
        btnA.addActionListener(actionListener);
        btnB.addActionListener(actionListener);
        btnC.addActionListener(actionListener);
        btnSelect.addActionListener(actionListener);
        btnStart.addActionListener(actionListener);
        btnArriba.addActionListener(actionListener);
        btnAbajo.addActionListener(actionListener);
        btnDerecha.addActionListener(actionListener);
        btnIzquierda.addActionListener(actionListener);

    }

    public void removeActionListener(){
        for(ActionListener al : btnA.getActionListeners()){
            btnA.removeActionListener(al);
        }
        for(ActionListener al : btnB.getActionListeners()){
            btnB.removeActionListener(al);
        }
        for(ActionListener al : btnC.getActionListeners()){
            btnC.removeActionListener(al);
        }

        for(ActionListener al : btnArriba.getActionListeners()){
            btnArriba.removeActionListener(al);
        }
        for(ActionListener al : btnAbajo.getActionListeners()){
            btnAbajo.removeActionListener(al);
        }
        for(ActionListener al : btnDerecha.getActionListeners()){
            btnDerecha.removeActionListener(al);
        }
        for(ActionListener al : btnIzquierda.getActionListeners()){
            btnIzquierda.removeActionListener(al);
        }
    }

    public void setPrincipalListener(ActionListener actionListener){
        btnSelect.addActionListener(actionListener);
        btnStart.addActionListener(actionListener);
    }

    public void removePrincipalListener(){
        for(ActionListener al : btnSelect.getActionListeners()){
            btnSelect.removeActionListener(al);
        }
        for(ActionListener al : btnStart.getActionListeners()){
            btnStart.removeActionListener(al);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(this.fondo, 0, 0, null);
    }
}
