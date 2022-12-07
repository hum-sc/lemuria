package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import error.DireccionNoValida;
import model.Direccion;
import model.Enemigo;
import model.Item;
import model.Mapa;
import model.Sala;
import vista.PanelEscenario;
import vista.PanelPrincipal;
import vista.SalaVista;

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
			e = s.getEnemigo();
			
			panel = new PanelEscenario( nombre );
			if ( e == null) {
				coso = s.getItem();
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