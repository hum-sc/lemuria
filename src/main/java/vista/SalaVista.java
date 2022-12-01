package mx.uaemex.fi.paradigmas_i.lemuria.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import mx.uaemex.fi.paradigmas_i.lemuria.control.ControlMapa;
import mx.uaemex.fi.paradigmas_i.lemuria.model.Direccion;
import mx.uaemex.fi.paradigmas_i.lemuria.model.Sala;

public class SalaVista extends JFrame{
	public static final String ATACAR = "Atacar";
	private JButton btnNorte;
	private JButton btnSur;
	private JButton btnEste;
	private JButton btnOeste;
	private JButton btnAtacar;
	private JButton btnMochila;
	private JPanel panelData;
	private PanelEscenario escenario;
	private ControlMapa ctrlMapa;
	//Falta el control mochila y el control ataque
	
	
	public SalaVista(ControlMapa control) {
		
		this.ctrlMapa = control;
		
		JMenu menu = new JMenu("Archivo");
		JMenuItem mItem = new JMenuItem("Este");
		mItem.setActionCommand(Direccion.DERECHA+"");
		mItem.addActionListener(this.ctrlMapa);
		menu.add(mItem);
		JMenuBar barra = new JMenuBar();
		barra.add(menu);
		this.setJMenuBar(barra);
		
		
		
		//Instanciacion
		this.btnAtacar = new JButton(SalaVista.ATACAR);
		this.btnAtacar.setActionCommand(SalaVista.ATACAR);
		//Pendiente el listener de este boton
		
		
		this.btnNorte = new JButton("Norte");
		this.btnNorte.setActionCommand(Direccion.ARRIBA+"");
		this.btnNorte.addActionListener(this.ctrlMapa);
		
		this.btnSur = new JButton("Sur");
		this.btnSur.setActionCommand(Direccion.ABAJO+"");
		this.btnSur.addActionListener(this.ctrlMapa);
		
		this.btnEste = new JButton("Este");
		this.btnEste.setActionCommand(Direccion.DERECHA+"");
		this.btnEste.addActionListener(this.ctrlMapa);
		
		this.btnOeste = new JButton("Oeste");
		this.btnOeste.setActionCommand(Direccion.IZQUIERDA+"");
		this.btnOeste.addActionListener(this.ctrlMapa);
		
	}
	
	public String muestra(Sala s) {
		return s.getNombre();	
	}

	public void setPanel(JPanel p) {
		this.setContentPane(p);
		this.validate();
		
	}
	
	
}
