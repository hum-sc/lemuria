package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import error.DireccionNoValida;
import model.*;
import vista.*;

public class ControlMapa implements ActionListener {
	private Mapa mapa;                       
	private Pantalla pantalla;
	private Ventana ventana;

	private Personaje personaje;
	private String manoNombre;

	private Mochila mochila;
	public ControlMapa(Ventana ventana, Mochila mochila) {
		this.ventana = ventana;
		this.mochila = mochila;
	}

	public void open(){
		generarPantalla(mapa.getSala());
	}
	public Sala getSala(){
		return mapa.getSala();
	}
	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}
	
	
	public void setPantalla(Pantalla pantalla) {
		this.pantalla = pantalla;
	}

	public void despliega(Pantalla p) {
		ventana.updatePantalla(p);
	}
	public void desplazar(int dir ) {
		Sala s;
		String nombre;
		Enemigo e;
		Item coso;
		
		if (dir == Direccion.ABAJO || dir == Direccion.DERECHA || dir == Direccion.IZQUIERDA || dir == Direccion.ARRIBA) {
			this.mapa.cambiarSala(dir);
			s = this.mapa.getSala();
			generarPantalla(s);
			//Obtener informacion de la sala//			
		}else {
			throw new DireccionNoValida();
		}
	}

	public void generarPantalla(Sala s){
		String nombre;
		Enemigo e;
		Item coso;
		nombre = s.getNombre();
		e = s.getEnemigo();

		pantalla = new Pantalla(nombre, manoNombre, personaje.getVida());
		if ( e == null ) {
			coso = s.getItem();
			if(coso != null) {
				System.out.println(coso.getNombre());
				pantalla = new Pantalla(nombre, manoNombre, coso, personaje.getVida());
			}
		}else if (e.getVida() > 0) {
			System.out.println(e.getNombre());
			pantalla = new Pantalla(nombre, manoNombre, e, personaje.getVida());
		} else {
			coso = s.getItem();
			if(coso != null) {
				System.out.println(coso.getNombre());
				pantalla = new Pantalla(nombre, manoNombre, coso, personaje.getVida());
			}
		}
		this.despliega(pantalla);
}
	    
	public void setMapa(Mapa m) {
		this.mapa = m;
	}

	public int pelea() {
		Enemigo enemigo = this.mapa.getSala().getEnemigo();
		int ataqueEnemigo = enemigo.atacar(personaje);
		int ataquePersonaje = personaje.atacar(enemigo);
		if (ataquePersonaje > 0) {
			if (ataqueEnemigo > 0) {
				personaje.setVida(personaje.getVida() - ataqueEnemigo);
				enemigo.setVida(enemigo.getVida() - ataquePersonaje);
				return Estado.Empate;
			}
			enemigo.setVida(0);
			return Estado.Ganado;
		} else if (ataqueEnemigo < 0) {
			return Estado.Empate;
		}
		personaje.setVida(personaje.getVida() - ataqueEnemigo);
		return Estado.Perdido;
	}

	public void recogerItem(){
		Item item = this.mapa.getSala().getItem();
		if(item != null) {
			item = personaje.seleccionarObjeto(item);
			this.mapa.getSala().setItem(item);
			this.manoNombre = personaje.getMano().getNombre();
		}
		pantalla = new Pantalla(this.mapa.getSala().getNombre(), manoNombre, personaje.getVida());
		//Aqui va la validacion
		if(item instanceof Tesoro){
			JOptionPane.showMessageDialog(null, "Has ganado");
			System.exit(0);
		}
		despliega(pantalla);
	}
	public void usarMano(){
		if (personaje.getMano() instanceof Pocion){
			personaje.setVida(personaje.getVida() + personaje.getMano().getNivel());
			personaje.setMano(null);
			this.manoNombre = "";
			pantalla = new Pantalla(this.mapa.getSala().getNombre(), manoNombre, personaje.getVida());
			despliega(pantalla);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando;
		int dir;
		comando = e.getActionCommand();
		dir = Integer.parseInt(comando);
		if(dir == Direccion.ABAJO || dir == Direccion.ARRIBA || dir == Direccion.DERECHA || dir == Direccion.IZQUIERDA) {
			this.desplazar(dir);
		}
		if(dir == Actions.BUTTON_A){
			if (mapa.getSala().getEnemigo().getVida() > 0) {
				int resultado = pelea();
				if (resultado == Estado.Ganado) {
					mapa.getSala().getEnemigo().setVida(0);
					pantalla = new Pantalla(mapa.getSala().getNombre(),manoNombre, mapa.getSala().getItem(), personaje.getVida());
					despliega(pantalla);
				} else if (resultado == Estado.Perdido) {
					pantalla = new Pantalla(mapa.getSala().getNombre(),manoNombre, mapa.getSala().getEnemigo(), personaje.getVida());
					despliega(pantalla);
				} else {
					pantalla = new Pantalla(mapa.getSala().getNombre(),manoNombre, mapa.getSala().getEnemigo(), personaje.getVida());
					despliega(pantalla);
				}
			}
			else {
				if (mapa.getSala().getItem() != null) {
					recogerItem();
				}
			}
		}
		if (dir == Actions.BUTTON_B) {
			if (personaje.getMano() != null) {
				usarMano();
			}
		}
		if (dir == Actions.BUTTON_C){
			if (personaje.getMano() != null){
				boolean status = mochila.guardar(personaje.getMano());
				if (status){
					personaje.setMano(null);
					this.manoNombre = "";
					pantalla = new Pantalla(mapa.getSala().getNombre(),manoNombre, personaje.getVida());
					despliega(pantalla);
				}
			}
		}
	}
}