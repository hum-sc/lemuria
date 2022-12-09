package main.java.model;

public class Sala extends ElementoConNombre{
    private Enemigo enemigo;
    private Item item;
    public Sala(String nombre, Enemigo enemigo, Item item) {
        super(nombre);
        this.enemigo = enemigo;
        this.item = item;
    }
    public Sala(String nombre) {
        super(nombre);
        this.enemigo = null;
        this.item = null;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(Enemigo enemigo) {
        this.enemigo = enemigo;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    /*Mover al controlador de Sala*/
    /*public int pelea(Personaje personaje){
        int ataqueEnemigo = enemigo.atacar(personaje);
        int ataquePersonaje = personaje.atacar(enemigo);
        if (ataquePersonaje>0){
            if (ataqueEnemigo>0){
                personaje.setVida(personaje.getVida()-ataqueEnemigo);
                enemigo.setVida(enemigo.getVida()-ataquePersonaje);
                return Estado.Empate;
            }
            enemigo.setVida(0);
            return Estado.Ganado;
        } else if (ataqueEnemigo < 0){
            return Estado.Empate;
        }
        personaje.setVida(personaje.getVida()-ataquePersonaje);
        return Estado.Perdido;
    }*/
}
