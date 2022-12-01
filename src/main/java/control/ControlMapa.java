package mx.uaemex.fi.paradigmas_i.lemuria.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import mx.uaemex.fi.paradigmas_i.lemuria.error.DireccionNoValida;
import mx.uaemex.fi.paradigmas_i.lemuria.model.Direccion;
import mx.uaemex.fi.paradigmas_i.lemuria.model.Enemigo;
import mx.uaemex.fi.paradigmas_i.lemuria.model.Item;
import mx.uaemex.fi.paradigmas_i.lemuria.model.Mapa;
import mx.uaemex.fi.paradigmas_i.lemuria.model.Sala;
import mx.uaemex.fi.paradigmas_i.lemuria.vista.PanelEscenario;
import mx.uaemex.fi.paradigmas_i.lemuria.vista.PanelPrincipal;
import mx.uaemex.fi.paradigmas_i.lemuria.vista.SalaVista;

public class ControlMapa implements ActionListener {
	private Mapa mapa;                       
	private SalaVista v;
	private JFrame ventanaPrincipal;
	public ControlMapa() {
		this.ventanaPrincipal=new JFrame("Lemuria");
		this.ventanaPrincipal.setBounds(10,50,1492,848);
		this.ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void setVista(SalaVista v) {
		this.v = v;
	}

	public void despliega(PanelEscenario p) {
		PanelPrincipal vista;
		vista=new PanelPrincipal(this);
		vista.setPanelEscenario(p);
		this.ventanaPrincipal.setContentPane(vista);
		this.ventanaPrincipal.setVisible(true);
	}
	public void desplazar(int dir ) {
		Sala s;
		String nombre;
		Enemigo e;
		Item coso;
		PanelEscenario panel;
		
		if (dir == Direccion.ABAJO || dir == Direccion.DERECHA || dir == Direccion.IZQUIERDA || dir == Direccion.ARRIBA) {
			this.mapa.cambiarSala(dir);
			s = this.mapa.getSala();
			
			//Obtener informacion de la sala//			
			nombre = s.getNombre();
			e = s.getMasSiOsare();
			
			panel = new PanelEscenario( nombre );
			if ( e == null) {
				coso = s.getCoso();
				if(coso != null) {
					panel.setItem(coso.getNombre());
				}
			}else {
				panel.setEnemigo(nombre);		
			}
			this.despliega(panel);
			}else {
				throw new DireccionNoValida();
		} 
	}
	    
	public void setMapa(Mapa m) {
		this.mapa = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando;
		int dir;
		
		comando = e.getActionCommand();
		dir = Integer.parseInt(comando);
		this.desplazar(dir);
		
	}
}