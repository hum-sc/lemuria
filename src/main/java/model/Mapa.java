package model;

import exceptions.NullSalaException;

import model.Direccion;

public class Mapa {
    private Sala[][] salas;
    private int columnas, renglones;

    private Coordenada posicionActual;
    public  Mapa(int columnas, int renglones){
        this(columnas, renglones, (int) (Math.random()*columnas), (int) (Math.random()*renglones));
    }
    public Mapa(int columnas, int renglones, int x, int y){
        this.columnas = columnas;
        this.renglones = renglones;
        salas = new Sala[renglones][columnas];
        for(int i = 0; i<renglones; i++){
            for ( int j = 0; j<columnas; j++){
                setSala(new Sala(i+" "+j), i, j);
            }
        }
        this.posicionActual = new Coordenada(x,y);
    }

    public Mapa(Sala[][] salas){
        setSalas(salas);
    }

    public void cambiarSala(int direccion){
        int x, y;
        switch (direccion){
            case Direccion.ARRIBA:
                x= posicionActual.getX();
                y= posicionActual.getY()-1;
                x = checkXBounds(x);
                y = checkYBounds(y);
                posicionActual.setX(x);
                posicionActual.setY(y);
                break;
            case Direccion.ABAJO:
                x= posicionActual.getX();
                y= posicionActual.getY()+1;
                x = checkXBounds(x);
                y = checkYBounds(y);
                posicionActual.setX(x);
                posicionActual.setY(y);
                break;
            case Direccion.DERECHA:
                x= posicionActual.getX()+1;
                y= posicionActual.getY();
                x = checkXBounds(x);
                y = checkYBounds(y);
                posicionActual.setX(x);
                posicionActual.setY(y);
                break;
            case Direccion.IZQUIERDA:
                x= posicionActual.getX()-1;
                y= posicionActual.getY();
                x = checkXBounds(x);
                y = checkYBounds(y);
                posicionActual.setX(x);
                posicionActual.setY(y);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + direccion);
        }
    }

    public int checkXBounds(int x){
        if(x<0){
            x = columnas-1;
        }else if(x>=columnas){
            x = 0;
        }
        return x;
    }
    public int checkYBounds(int y){
        if(y<0){
            y = renglones-1;
        }else if(y>=renglones){
            y = 0;
        }
        return y;
    }

    public  void setSalas(Sala[][] salas){
        for(int i = 0; i<salas.length; i++){
            for (int j = 0; j < salas[0].length; j++){
                if(salas[i][j] == null) throw new NullSalaException();
            }
        }
        this.salas = salas;
        this.renglones = salas.length;
        this.columnas = salas[0].length;
    }
    public void setSala(Sala sala, int renglon, int columna){
        if (sala == null) throw new NullSalaException();
        salas[renglon][columna] = sala;
    }
    public Sala[][] getSalas() {
        return salas;
    }
    public Sala getSala(){
        return salas[posicionActual.getX()][posicionActual.getY()];
    }
    public Coordenada getPosicionActual() {
        return posicionActual;
    }
}
