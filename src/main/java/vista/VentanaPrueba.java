package mx.uaemex.fi.paradigmas_i.lemuria.vista;

import javax.swing.JFrame;

import mx.uaemex.fi.paradigmas_i.lemuria.control.ControlMapa;
import mx.uaemex.fi.paradigmas_i.lemuria.model.Item;
import mx.uaemex.fi.paradigmas_i.lemuria.model.Mapa;
import mx.uaemex.fi.paradigmas_i.lemuria.model.Sala;

public class VentanaPrueba extends JFrame {
	public static void main(String[] args) {
		ControlMapa ctrl;
		Mapa mapa;
		Sala[][] salas;
		Item item;
		PanelPrincipal pnlPrincipal;
		PanelEscenario escenario;
		
		item = new Item();
		item.setNombre("pocion");
		
		salas =new Sala[3][3];
		salas[0][0] = new Sala("calabozo");
		salas[0][0].setCoso(item);
		
		salas[0][1] = new Sala("caverna");
		salas[0][2] = new Sala("castillo");
		salas[1][0] = new Sala("pozo");
		salas[1][1] = new Sala("encrucijada");
		salas[1][2] = new Sala("montana");
		salas[2][0] = new Sala("bahia");
		salas[2][1] = new Sala("torre");
		salas[2][2] = new Sala("cerro");
		
		mapa = new Mapa(salas);
		
		ctrl = new ControlMapa();
		ctrl.setMapa(mapa);
		
		pnlPrincipal=new PanelPrincipal(ctrl);
		escenario=new PanelEscenario("calabozo");
		pnlPrincipal.setPanelEscenario(escenario);
		JFrame v=new JFrame();
		v.setContentPane(pnlPrincipal);
		v.setVisible(true);
		/*SalaVista ventanita = new SalaVista(ctrl);
		ctrl.setVista(ventanita);
		
		
		
		ventanita.setBounds(100, 100, 800, 533);
		ventanita.setVisible(true);
		ventanita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	}

}
