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
        super();

        Sala[][] salas =new Sala[3][3];
        String[] nombreSalas = {"calabozo", "campobatalla", "castillo", "caverna", "cerro", "encrucijada", "montana", "pozo", "torre"};
        String[] nombreEnemigos = {"julien", "joker", "chavez"};
        String[] armas = {"aka", "espada", "sarten"};
        String[] pociones= {"pocion", "muffin"};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Enemigo enemigo = new Enemigo(nombreEnemigos[(int) (Math.random() * nombreEnemigos.length)], 100, 10, 10);
                Item item;
                if((int)(Math.random()*2 +1) == 1){
                    item = new Pocion(pociones[(int)(Math.random()*2)], (int) (Math.random() * 30));
                }else{
                    item = new Arma(armas[(int) (Math.random() * armas.length)], (int) (Math.random() * 30));
                }
                salas[i][j] = new Sala(nombreSalas[(int)(Math.random()* nombreSalas.length)], enemigo,item);
            }
        }

        salas[(int) (Math.random() * 3)][(int) (Math.random() * 3)].setItem(new Tesoro("tesoro"));

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
