package main.java.vista;

import javax.swing.*;
import java.awt.*;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER;

public class Texto extends JPanel {
    private JTextArea vida;
    public Texto(String texto, int width, int height){
        super();
        this.setLayout(null);
        this.vida = new JTextArea(texto);
        this.vida.setEditable(false);
        this.vida.setLineWrap(true);
        this.vida.setBounds(0,0,width,height);
        JScrollPane scroll = new JScrollPane(vida, VERTICAL_SCROLLBAR_NEVER, HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(0,0,width,height);
        setSize(width, height);
        setBorder(BorderFactory.createLineBorder(Color.black, 2));
        setBackground(null);
        add(scroll);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
