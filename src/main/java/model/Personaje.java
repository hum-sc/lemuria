package model;

public class Personaje extends Entidad{
    private Mochila mochila;
    private Item mano;
    public Personaje(String nombre,int vida, int defensa, int ataque) {
        super(nombre, vida, defensa, ataque);
        this.mochila = new Mochila(10);
        this.mano = null;
    }
    public void seleccionarObjeto(Item item){
        mano = item;
        if (mano instanceof Pocion) {
            setVida(getVida()+mano.getNivel());
            mochila.sacar(item);
            mano = null;
        }
    }
    public Item getMano(){
        return mano;
    }

    @Override
    public int getAtaque() {
        int ataqueMax = this.ataque;
        if (mano instanceof Arma){
            ataqueMax+= mano.getNivel();
        }
        return (int) (Math.random() * (ataqueMax-1))+1;
    }
    @Override
    public  int getDefensa() {
        int defensaMax = this.defensa;
        if (mano instanceof Escudo) {
            defensaMax += mano.getNivel();
        }
        return (int) (Math.random() * (defensaMax - 1)) + 1;
    }

}
