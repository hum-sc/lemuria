package control;

import model.*;
import vista.Pantalla;
import vista.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ControlMochila implements ActionListener {
    private Personaje personaje;
    private int indiceSeleccionado;
    private Mochila mochila;
    private Ventana ventana;
    private Pantalla pantalla;
    private Sala sala;

    public ControlMochila(Ventana ventana, Mochila mochila, Personaje personaje){
        this.ventana = ventana;
        this.mochila = mochila;
        this.personaje = personaje;
    }
    public void buttonLeft(){
        if (indiceSeleccionado > 0){
            indiceSeleccionado--;
            ventana.updatePantalla(generatePantalla());
        }
    }
    public void buttonRight(){
        if (indiceSeleccionado < mochila.getCapacidad()){
            indiceSeleccionado++;
            ventana.updatePantalla(generatePantalla());
        }
    }

    public Pantalla generatePantalla() {
        return new Pantalla(mochila.getInventario(), indiceSeleccionado, personaje.getMano() == null? "": personaje.getMano().getNombre());
    }

    public void open(Sala sala){
        ventana.updatePantalla(generatePantalla());
        this.sala = sala;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int dir = Integer.parseInt(e.getActionCommand());
        if (dir == Actions.IZQUIERDA){
            buttonLeft();
        }
        if (dir == Actions.DERECHA){
            buttonRight();
        }

        if (dir == Actions.BUTTON_A){
            Item item = mochila.getItem(indiceSeleccionado);
            Item mano = personaje.seleccionarObjeto(item);
            if (mano != null) mochila.guardar(mano);
            mochila.sacar(item);
            ventana.updatePantalla(generatePantalla());
        }
        if(dir == Actions.BUTTON_B){
            Item item = mochila.getItem(indiceSeleccionado);
            mochila.sacar(item);
            sala.setItem(item);
            ventana.updatePantalla(generatePantalla());
        }
    }
}
