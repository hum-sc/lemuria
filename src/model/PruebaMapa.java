package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PruebaMapa {
	private Mapa mapa;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testMapaIntInt() {
		this.mapa = new Mapa(4, 6);
		assertNull(this.mapa.getSala());  //aserciones (tipo afirmaciones) 
		//yo afirmo que el resultado de esto sera un nulo y si es asi la prueba sera superada 
		assertNotNull(this.mapa);
	}

	@Test
	void testMapaSalaArrayArray() {
		Sala[][] salas;
		salas = new Sala[3][3];
		System.out.println("Este es el salas: " + salas);
		
		this.mapa = new Mapa(salas);
		assertNull(this.mapa.getSala());
		
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				salas [i][j] = new Sala("calabozo");
			}
		}
		
		assertNotNull(this.mapa.getSala());
		assertEquals( this.mapa.getSala(),salas[2][0]);
	}

	@Test
	void testGetSala() {
		Sala[][] salas = new Sala[3][3];
		assertNull(this.mapa);
		this.mapa = new Mapa(3,3);
		assertNull(this.mapa.getSala());
		
		mapa = new Mapa(salas);
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				salas [i][j] = new Sala("calabozo");
			}
		}
		
		assertNotNull(this.mapa.getSala());
		assertEquals( this.mapa.getSala(),salas[2][0]);
		
	}

	@Test
	void testCambiarSala() {
		Sala[][] salas = new Sala[3][3];
		mapa = new Mapa(salas);
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				salas [i][j] = new Sala("calabozo");
			}
		}
		
		assertEquals( this.mapa.getSala(),salas[2][0]);
		mapa.cambiarSala(1);
		assertEquals(this.mapa.getSala(),salas[2][1]);
	}

}
