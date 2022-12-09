package main.java.model;


public class Entidad extends ElementoConNombre {

    protected int vida;
    protected int defensa;
    protected int ataque;
    public Entidad(String nombre, int vida, int defensa, int ataque) {
        super(nombre);
        this.vida = vida;
        this.defensa = defensa;
        this.ataque = ataque;
    }

    /**
     * Si la resta entre el ataque y la defensa de la otra entidad es menor o igual a 0, devuelve -1, lo que significa que el ataque no procede.
     * Siempre regresará un número entero.
     * @param enemigo
     * @return damage
     */
    public int atacar( Entidad enemigo){
        int enemigoDefensa = enemigo.getDefensa();
        int thisAtaque = this.getAtaque();
        int damage = thisAtaque - enemigoDefensa;
        if (damage <= 0){
            damage = -1;
        }
        return damage;
    }
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDefensa() {
        return ((int) (Math.random() * (defensa-1) )) + 1;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaque() {
        return ((int) (Math.random() * (ataque-1) ))+1;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }


}
