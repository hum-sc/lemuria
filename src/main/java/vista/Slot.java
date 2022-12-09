package main.java.vista;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Slot extends JPanel {
    private Image thing;
    public Slot(String nombre, Boolean isSelected){
        super();
        setSize(50, 50);
        setBorder(BorderFactory.createLineBorder(Color.black, 2));
        setBackground(Color.gray);
        thing = getImage(nombre);
        if(isSelected){
            setBorder(BorderFactory.createLineBorder(Color.red, 5));
            setBackground(Color.black);
        }
    }

    public Image getImage(String name) {
        try{
            File file = new File("src/imagenes/" + name + ".png");
            BufferedImage bufferedImage = ImageIO.read(file);
            return bufferedImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        } catch (Exception e){
            System.out.println("Error al cargar la imagen");
            return null;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(thing,0,0,null);
    }
}
