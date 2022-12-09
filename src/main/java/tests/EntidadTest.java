package main.java.tests;

import main.java.model.Enemigo;
import main.java.model.Entidad;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntidadTest {
    private Entidad entidad;
    @BeforeEach
    void setUp() {
        entidad = new Entidad("Entidad de prueba", ((int)(Math.random()*99)+1), ((int)(Math.random()*9)+1), ((int)(Math.random()*9))+1);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Entidad: "+entidad.getNombre()+" Texto: "+entidad.getVida()+" Defensa: "+entidad.getDefensa()+" Ataque: "+entidad.getAtaque());
        entidad = null;
    }

    @Test
    void getAtaqueAndDefensa(){
        int ataque = entidad.getAtaque();
        int defensa = entidad.getDefensa();
        assertAll(()->{
            assertTrue(ataque > 0 && ataque <= 10);
            assertTrue(defensa > 0 && defensa <= 10);
        });
    }
}