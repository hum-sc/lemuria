package main.java.vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelEscenario extends JPanel {
	
	/**
	 * Imagen para el fondo
	 */
	private BufferedImage fondo;
	
	/**Imagen del guerrero
	 * 
	 */
	private BufferedImage guerrero;
	
	/**
	 * Imagen del item
	 */
	private BufferedImage item;
	
	/**
	 * Imagen del enemigo
	 */
	private BufferedImage enemigo;                                                                  
	
	/**
	 * Constructora que dibuja el escenario.
	 * @param fondoImg Nombre de la imagen de fondo
	*/
	public void setEnemigo(String enemigo) {
		try {
			this.enemigo = ImageIO.read(getClass().getResource("/imagenes/" + enemigo + ".png"));
		}catch (IOException ie) {
			JOptionPane.showMessageDialog(null, "Juego atrofiado por favor, restaurar version");
		}
	}
	
	public void setItem(String item) {
		try {
			this.item = ImageIO.read(getClass().getResource("/imagenes/" + item + ".png"));
		}catch (IOException ie) {
			JOptionPane.showMessageDialog(null, "Juego atrofiado por favor, restaurar version");
		}
	}
	
	public PanelEscenario(String fondoImg) {
		try {
			File file =new File("src/imagenes/" + fondoImg + ".png");
			System.out.println(file.getAbsolutePath());
			this.fondo = ImageIO.read(file);
		}catch (IOException ie) {
			JOptionPane.showMessageDialog(null, "Juego atrofiado por favor, restaurar version");
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(fondo, 0, 0, null);
		if(this.enemigo != null) {
			g.drawImage(this.enemigo, 550, 300, null);
		} else {
			if(this.item != null) {
				g.drawImage(this.item, 580, 350, null);
			}
		}
	}
}
