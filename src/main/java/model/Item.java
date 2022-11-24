package model;

public class Item  extends ElementoConNombre{
    protected   int nivel;
    protected String descripcion;

    public Item(String nombre) {
        super(nombre);
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
