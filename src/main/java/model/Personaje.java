package model;

public class Personaje extends Entidad{
    private Mochila mochila;
    private Item mano;
    public Personaje(String nombre) {
        super(nombre, 100, 10, 10);
        this.mochila = new Mochila(10);
        this.mano = null    ;
    }

    public void usarObjeto(Item item){
        mano = item;
    }
    public Item getMano(){
        return mano;
    }

    @Override
    public int getAtaque() {
        int ataqueMax = this.ataque;
        if (mano instanceof Arma){
            ataqueMax+= mano.nivel;
        }
        return (int) (Math.random() * (ataqueMax-1))+1;
    }
    @Override
    public  int getDefensa() {
        int defensaMax = this.defensa;
        if (mano instanceof Pocion) {
            defensaMax += mano.nivel;
        }
        return (int) (Math.random() * (defensaMax - 1)) + 1;
    }

}
