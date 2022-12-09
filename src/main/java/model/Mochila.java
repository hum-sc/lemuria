package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Mochila {
    private int capacidad;
    private ArrayList<Item> inventario;
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
    public ArrayList<Item> getInventario() {
        return inventario;
    }

    public Item getItem(int i){
        return inventario.get(i);
    }
}
