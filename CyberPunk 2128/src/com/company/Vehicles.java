package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Vehicles extends JPanel {
    Image img = new ImageIcon("images\\cars.jpg").getImage();//.getScaledInstance(400,400,Image.SCALE_AREA_AVERAGING);
    private Graphics2D g;
    //static JLayeredPane EverythingButPlayer;
    //Image img;


    public Vehicles() {
        //Graphics g = this.getGraphics();
        //img = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        //Image img = new ImageIcon("images\\cars.jpg").getImage().getScaledInstance(400,400,Image.SCALE_AREA_AVERAGING);
        //g = (Graphics2D) img.getGraphics();
        //Graphics g2 = this.getGraphics();
        //g.drawImage(img,300,50,null);
        //g.setBackground(Color.BLACK);
        //System.out.println("check");
        /*try {
            img = ImageIO.read(new File("images\\cars.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //img = new ImageIcon("images\\cars.jpg").getImage().getScaledInstance(400,400,Image.SCALE_AREA_AVERAGING);
        //ImageIcon img1 = new ImageIcon(img);

        //paintComponent1(Panel.g);



    }

    //@Override
    /*public void paintComponent1(Graphics g2) {
        super.paintComponent(g2);
        //Graphics2D g2 = (Graphics2D) g2;
        g2.drawImage(img,0,0,null);

    }*/




}
