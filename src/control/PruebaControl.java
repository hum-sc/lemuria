package control;

import javax.swing.JFrame;

import model.Direccion;
import model.Item;
import model.Mapa;
import model.Sala;
import vista.SalaVista;


public class PruebaControl {

	public static void main(String[] args) {
		ControlMapa ctrl;
		Mapa mapa;
		Sala[][] salas;
		Item item;
		
		item = new Item("muffin");
		item.setNombre("muffin");
		
		salas =new Sala[3][3];
		salas[0][0] = new Sala("calabozo");
		salas[0][0].setItem(item);
		
		salas[0][1] = new Sala("caverna");
		salas[0][2] = new Sala("castillo");
		salas[1][0] = new Sala("pozo");
		salas[1][1] = new Sala("encrucijada");
		salas[1][2] = new Sala("montana");
		salas[2][0] = new Sala("bahia");
		salas[2][1] = new Sala("torre");
		salas[2][2] = new Sala("campobatalla");
		
		mapa = new Mapa(salas);
		
		ctrl = new ControlMapa();
		ctrl.setMapa(mapa);
		
		SalaVista ventanita = new SalaVista(ctrl);
		ctrl.setVista(ventanita);
		
		
		
		ventanita.setBounds(100, 100, 800, 533);
		ventanita.setVisible(true);
		ventanita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
