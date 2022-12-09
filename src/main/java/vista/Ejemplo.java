/*
* Humberto Antonio Salinas Cortes
* Juan Montero Terron
* Estefany Montaño Estrada
* Alexis Eduardo Almanza Ortega
*/
package vista;

import javax.swing.*;

public class Ejemplo extends JFrame {
    private JButton boton1;
    public Ejemplo() {
        super("Ejemplo");
        boton1 = new JButton("Boton 1");
        add(boton1);

        setSize(300, 200);
        setVisible(true);
    }
}
