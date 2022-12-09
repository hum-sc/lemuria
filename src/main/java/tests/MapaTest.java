/*
* Humberto Antonio Salinas Cortes
* Juan Montero Terron
* Estefany Montaño Estrada
* Alexis Eduardo Almanza Ortega
*/
package tests;

import model.Direccion;
import model.Mapa;
import model.Sala;
import exceptions.NullSalaException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapaTest {
    Mapa mapa;
    @BeforeAll
    static void setInit(){
        System.out.println("Iniciando las pruebas de MapaTest");
    }
    @BeforeEach
    void setUp() {
        System.out.println("Iniciando nuevo test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finalizando el test");
    }

    @Test
    void crearMapaSalasAleatorias(){
        mapa = new Mapa(4,4);
        Boolean hasEmpty=false;
        Sala salasMapa[][] = mapa.getSalas();
        for(int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                hasEmpty = (salasMapa[i][j] == null) ? true: hasEmpty;
            }
        }
        assertEquals(false, hasEmpty);
    }

    @Test
    void setSalasNull(){
        assertAll(()->{
            assertThrows(NullSalaException.class, ()->{
                mapa = new Mapa(4,4);
                mapa.setSala(null, 2,3);
            });
            assertThrows(NullSalaException.class, ()->{
               Sala[][] salas = new Sala[4][4];
               mapa = new Mapa(salas);
            });
        });
    }

    @Test
    void movimientos(){
        mapa = new Mapa(4,4);
        try {
            mapa.cambiarSala(Direccion.ARRIBA);
            mapa.cambiarSala(Direccion.ABAJO);
            mapa.cambiarSala(Direccion.DERECHA);
            mapa.cambiarSala(Direccion.IZQUIERDA);
        } catch (Exception e){
        }
    }
    @Test
    void salirDelMapa(){
        mapa = new Mapa(4,4, 0, 0);
        mapa.cambiarSala(Direccion.ARRIBA);
        System.out.println(mapa.getPosicionActual().getX() + " " + mapa.getPosicionActual().getY());
        mapa.cambiarSala(Direccion.ABAJO);
        System.out.println(mapa.getPosicionActual().getX() + " " + mapa.getPosicionActual().getY());
        mapa.cambiarSala(Direccion.IZQUIERDA);
        System.out.println(mapa.getPosicionActual().getX() + " " + mapa.getPosicionActual().getY());
        mapa.cambiarSala(Direccion.DERECHA);
        System.out.println(mapa.getPosicionActual().getX() + " " + mapa.getPosicionActual().getY());
    }
}