package control;

import model.*;
import vista.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlJuego implements ActionListener {
    private ControlMapa controlMapa;
    private Personaje personaje;
    private Mapa mapa;
    private Ventana ventana;
    private ControlMochila controlMochila;
    private Mochila mochila;
    private boolean isMochilaOpen;

    public ControlJuego() throws Exception {
        super();m

        Sala[][] salas =new Sala[3][3];
        salas[0][0] = new Sala("calabozo");
        salas[0][0].setEnemigo(new Enemigo("julien", 100, 5, 10));
        salas[0][0].setItem(new Pocion("pocion",  10));
        salas[0][1] = new Sala("caverna");
        salas[0][1].setEnemigo(new Enemigo("julien", 100, 5, 10));
        salas[0][1].setItem(new Pocion("pocion",  10));
        salas[0][2] = new Sala("castillo");
        salas[1][0] = new Sala("pozo");
        salas[1][1] = new Sala("encrucijada");
        salas[1][2] = new Sala("montana");
        salas[2][0] = new Sala("bahia");
        salas[2][1] = new Sala("torre");
        salas[2][2] = new Sala("cerro");

        mochila = new Mochila(7);
        mapa = new Mapa(salas);
        personaje = new Personaje("chanchito", 100, 10, 10);
        ventana = new Ventana();
        controlMapa = new ControlMapa(ventana, mochila);
        controlMochila = new ControlMochila(ventana, mochila, personaje);

        controlMapa.setPersonaje(personaje);
        controlMapa.setMapa(mapa);
        ventana.setPrincipalListener(this);
        ventana.setButtonsListener(controlMapa);
    }

    public void handleMochilaState(){
        if (isMochilaOpen){
            System.out.println("Cerrando mochila");
            ventana.removeButtonsListener();
            ventana.setButtonsListener(controlMapa);
            controlMapa.open();
            isMochilaOpen = false;
        } else {
            System.out.println("Abriendo mochila");
            ventana.removeButtonsListener();
            ventana.setButtonsListener(controlMochila);
            controlMochila.open(controlMapa.getSala());
            isMochilaOpen = true;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (Integer.parseInt(e.getActionCommand()) == Actions.SELECT){
            handleMochilaState();
        }

    }
}
