package tests;

import model.Arma;
import model.Entidad;
import model.Personaje;
import model.Pocion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonajeTest{

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void usarObjeto() {
        Personaje personaje = new Personaje("Ejemplo");
        int ataque = personaje.getAtaque();
        int defensa = personaje.getDefensa();


        assertAll(()->{
            int ataqueMax = 10;
            int defensaMax = 10;

            if(personaje.getMano() != null){
                if (personaje.getMano() instanceof Arma) ataqueMax+= personaje.getMano().getNivel();
                if (personaje.getMano() instanceof Pocion) defensaMax+= personaje.getMano().getNivel();
            }

            assertTrue((0<ataque && ataque <= ataqueMax));
            assertTrue((0<defensa && defensa <= defensaMax));
        });
    }

    @Test
    void testGetAtaque() {
    }

    @Test
    void testGetDefensa() {
    }
}