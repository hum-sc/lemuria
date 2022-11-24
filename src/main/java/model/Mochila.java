package model;

import java.util.ArrayList;
import java.util.List;

public class Mochila {
    private int capacidad;
    private List<Item> inventario;
    public Mochila(int capacidad) {
        this.capacidad = capacidad;
        this.inventario = new ArrayList<Item>();
    }
    public void sacar (Item item){
        inventario.remove(item);
    }
    public boolean guardar (Item item){
        if (inventario.size() < capacidad){
            inventario.add(item);
            return true;
        }
        return false;
    }
    public void ampliar (int capacidad){
        this.capacidad += capacidad;
    }
    public void reducir (int capacidad){
        this.capacidad -= capacidad;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public List<Item> getInventario() {
        return inventario;
    }
}
