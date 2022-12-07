package mx.uaemex.fi.paradigmas_i.lemuria.control;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import mx.uaemex.fi.paradigmas_i.lemuria.model.Item;
import mx.uaemex.fi.paradigmas_i.lemuria.model.Mochila;
import mx.uaemex.fi.paradigmas_i.lemuria.model.Personaje;

public class ControlMochila {
	protected Personaje personaje;
	int indiceSeleccionado;
	int posicion=0;
	protected Mochila mochila;
	//protected VistaMochila vistaMochila;
	
	
	public ArrayList<Item> mostrarVistaMochila() {
		return mochila.getInventario();
	}
	
	private boolean ButtonRightSelected() {
		ArrayList<Item> inventario = mochila.getInventario();
		if(posicion!=inventario.size()) {
			posicion=posicion+1;
			System.out.println("Se ha movido a la derecha correctamente");
			return true;
		}
		return false;
			
		
	}
	
	private boolean ButtonLeftSelected() {
		ArrayList<Item> inventario = mochila.getInventario();
		if(posicion!=0) {
			posicion=posicion-1;
			System.out.println("Se ha movido a la izquierda correctamente");
			return true;
		}
		return false;
	}
	
	public void agregar(Item item) {
		try {
			mochila.guardar(item);	
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error: "+e);
		}
		
	}
	
	private Item buttonASelected(Item item) {
		return mochila.obtenerItem(item);
	}
	
	private void buttonBSelected(Item item) {
		mochila.sacar(item);
	}
	
	public void cerrarVistaMochila() {
		//VistaMochila.setVisible(false);
	}
	
	public boolean capacidadMochila(int capacidad) {
		int nuevaCapacidad=mochila.getCapacidad()+capacidad;
		mochila.setCapacidad(nuevaCapacidad);
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String comando;
			int dir;
			
			comando = e.getActionCommand();
			dir = Integer.parseInt(comando);
			posicion=dir;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error: "+e);
		}
	}
	
	
	
	
}
