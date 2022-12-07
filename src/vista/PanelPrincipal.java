package vista;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.ControlMapa;
import model.Direccion;

public class PanelPrincipal extends JPanel{
	private BufferedImage fondo;
	private Image fondo1;
	private PanelEscenario escenario;
	private ControlMapa ctrlMapa;
	//1482x800 Gameboy
	//800x573 Panel donde va el escenario
	//783X489
	public PanelPrincipal(ControlMapa ctrl) {
		super(null); //sin content manager
		JButton btn;
		try {
			this.ctrlMapa=ctrl;
			this.fondo=ImageIO.read(getClass().getResource("/imagenes/gameboy.png"));
			
			fondo1=this.fondo.getScaledInstance(720, 480, Image.SCALE_DEFAULT);
			
			//Botones de direccion
			btn=new JButton();
			btn.setOpaque(false);
			btn.setContentAreaFilled(false);
			btn.setBorderPainted(false);
			btn.setBounds(730,490,100,70);
			btn.setActionCommand(Direccion.ARRIBA+"");
			btn.addActionListener(this.ctrlMapa);
			this.add(btn);
			btn=new JButton();
			btn.setOpaque(false);
			btn.setContentAreaFilled(false);
			btn.setBorderPainted(false);
			btn.setBounds(1174,664, 100, 70);
			btn.setActionCommand(Direccion.ABAJO+"");
			btn.addActionListener(this.ctrlMapa);
			this.add(btn);
			btn=new JButton();
			btn.setOpaque(false);
			btn.setContentAreaFilled(false);
			btn.setBorderPainted(false);
			btn.setBounds(1174,590, 100, 70);
			btn.setActionCommand(Direccion.DERECHA+"");
			btn.addActionListener(this.ctrlMapa);
			this.add(btn);
			btn=new JButton();
			btn.setOpaque(false);
			btn.setContentAreaFilled(false);
			btn.setBorderPainted(false);
			btn.setBounds(1174,664, 100, 70);
			btn.setActionCommand(Direccion.IZQUIERDA+"");
			btn.addActionListener(this.ctrlMapa);
			this.add(btn);
		}catch(IOException ie) {
			JOptionPane.showMessageDialog(null, "Juego atrofiado por favor, restaurar version");
		}
}
	public void setPanelEscenario(PanelEscenario p) {
	this.escenario=p;
	this.escenario.setBounds(63,56,800,533);
	this.add(escenario);
	
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(this.fondo1, 0, 0, null);
		g.drawImage(this.fondo1, 0, 0, null);
	}
}