package main.java.vista;

import main.java.control.*;
import main.java.model.*;

public class Principal {

	public static void main(String[] args) {
		try {
			ControlJuego juego = new ControlJuego();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
