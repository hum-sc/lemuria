package vista;

import model.Enemigo;
import model.Item;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public class Pantalla extends JPanel {
    private Image fondo;
    private Image enemigo;
    private Image item;
    private Image personaje;
    private Slot mano;
    private Texto indicaciones;
    Texto vidaPersonaje;
    Texto vidaEnemigo;

    public Pantalla(){
        setSize(382,292);
        setPreferredSize(new Dimension(382,292));

        this.setLayout(null);
        JLabel label = new JLabel("Preciona cualquier parte de la cruzeta para iniciar");
        label.setSize(this.getSize());
        label.setLocation(0, 15);
        this.add(label);
    }

    public Pantalla(ArrayList<Item> inventario, int indiceSeleccionado, String mano){
        super();
        setSize(382,292);
        setPreferredSize(new Dimension(382,292));

        setLayout(null);
        this.mano = new Slot(mano, false);
        this.mano.setBounds(20, 200, 50, 50);
        fondo = getImage("inventario", 382, 292);
        this.add(this.mano);

    }
    public Pantalla(Item tesoro){

    }
    public Pantalla(String fondo, String manoItem, int vida) {
        super();
        setSize(382,292);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(382,292));
        this.fondo = getImage(fondo, 382, 292);
        this.personaje = getImage("chanchito", 100, 200);
        this.mano = new Slot(manoItem, false);
        this.mano.setBounds(20,200,50,50);
        vidaPersonaje = new Texto("Vida: "+vida, 100, 30);
        vidaPersonaje.setLocation(20, 20);
        indicaciones = new Texto("presione SELECT para abrir la mochila o muevete con la cruzeta", 362, 40);
        if (manoItem != null)if (manoItem.equals("pocion")) indicaciones = new Texto("presione B para usar la pocion, SELECT para abrir la mochila o muevete con la cruzeta", 362, 40);
        indicaciones.setLocation(10, 250);

        this.add(vidaPersonaje);
        this.add(mano);

        this.add(indicaciones);

    }

    public Pantalla(String fondo,String manoItem, Item item, int vida){
        this(fondo, manoItem, vida);
        if (item != null) this.item = getImage(item.getNombre() , 50, 50);
        this.remove(indicaciones);
        this.indicaciones = new Texto("presiona A para tomar el item, SELECT para abrir la mochila o muevete con la cruzeta", 362, 40);
        if(manoItem != null)if (manoItem.equals("pocion")) this.indicaciones = new Texto("presiona A para agarrar el item, B para usar la pocion,\n  SELECT para abrir la mochila o muevete con la cruzeta", 362, 40);
        indicaciones.setLocation(10, 250);
        this.add(indicaciones);
    }

    public Pantalla(String fondo, String manoItem, Enemigo enemigo, int vida){
        this(fondo, manoItem, vida);
        this.enemigo = getImage(enemigo.getNombre(), 100, 200);

        vidaEnemigo = new Texto("Vida de "+enemigo.getNombre()+": "+enemigo.getVida(), 110,30);

        vidaEnemigo.setLocation(200, 20);
        this.remove(indicaciones);
        indicaciones = new Texto("Presiona A para atacar, presiona SELECT para abrir la mochila, o muevete con la cruzeta", 362, 40);
        if(manoItem != null)if (manoItem.equals("pocion")) indicaciones = new Texto("Presiona A para pelear, B para usar la pocion,\n presiona SELECT para abrir la mochila, o muevete con la cruzeta", 362, 40);
        indicaciones.setLocation(10, 250);
        this.add(vidaEnemigo);
        this.add(indicaciones);

    }

    public Image getImage(String name, int width, int height) {
        try{
            File file = new File("src/imagenes/" + name + ".png");
            BufferedImage bufferedImage = ImageIO.read(file);
            return bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        } catch (Exception e){
            System.out.println("Error al cargar la imagen");
            return null;
        }
    }

    public void setItem(String item) {
        this.item = getImage(item, 100, 100);
    }

    public void setEnemigo(String enemigo) {
        this.enemigo = getImage(enemigo, 100, 200);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (fondo != null) {
            g.drawImage(fondo, 0, 0, null);
        }
        if (enemigo != null) {
            g.drawImage(enemigo, 200, 92, null);
        }
        if (personaje != null) {
            g.drawImage(personaje, 50, 92, null);
        }
        if (item != null) {
            g.drawImage(item,250,100, null);
        }
        if(vidaPersonaje != null) {
            this.validate();
            vidaPersonaje.repaint();
        }
        if(vidaEnemigo != null) vidaEnemigo.repaint();
        if (mano != null)mano.repaint();
    }
}
