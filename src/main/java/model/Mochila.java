package mx.uaemex.fi.paradigmas_i.lemuria.model;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import mx.uaemex.fi.paradigmas_i.lemuria.model.Item;
public class Mochila {
	ArrayList<Item> inventario = new ArrayList<Item>();
	int capacidad;
	

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public void guardar(Item item) {
		if(capacidad>=inventario.size()) {
			//Error
			JOptionPane.showMessageDialog(null, "Error no se guardo el item");
		}else {
			inventario.add(item);
			JOptionPane.showMessageDialog(null, "El item se guardo correctamente");
		}
	}
	
	public void sacar(Item item) {
		if(inventario.size()>0) {
			int indice=inventario.lastIndexOf(item);
			inventario.remove(indice);
			System.out.print("Inventario"+inventario);
		}else {
			//Error
			JOptionPane.showMessageDialog(null, "No hay items");
		}
	}

	public ArrayList<Item> getInventario() {
		return inventario;
	}

	public Item obtenerItem(Item item) {
		int indice=inventario.lastIndexOf(item);
		return inventario.get(indice);
	}
	
	
}
