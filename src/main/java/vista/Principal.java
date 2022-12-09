/*
* Humberto Antonio Salinas Cortes
* Juan Montero Terron
* Estefany Montaño Estrada
* Alexis Eduardo Almanza Ortega
*/
package vista;

import control.ControlJuego;
import control.ControlMapa;
import model.*;

public class Principal {

	public static void main(String[] args) {
		try {
			ControlJuego juego = new ControlJuego();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
