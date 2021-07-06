package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gangstar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        Panel panel = new Panel();
        //Cars car = new Cars();
        //Vehicles vehicle = new Vehicles();
       /* JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new GridBagLayout());
        JLayeredPane lp = new JLayeredPane();
        //panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
        //panel2.setLayout(new BorderLayout());
        //panel1.setPreferredSize(new Dimension(100,100));
        panel1.setSize(800,600);
        panel2.setSize(400,400);
        panel2.setLocation(300,50);
        panel1.setBackground(Color.BLUE);
        panel2.setBackground(Color.RED);
        JLabel label = new JLabel();

        ImageIcon img = new ImageIcon("images\\cars.jpg");
        ImageIcon img1 = new ImageIcon("images\\car.png");
        JLabel label1 = new JLabel(img);
        JLabel label2 = new JLabel(img1);
        label1.setSize(400,400);
        label2.setSize(300,300);
        panel1.add(label1);
        panel2.add(label2);*/

        /*CardLayout cardLayout = new CardLayout();
        JPanel panel3 = new JPanel(cardLayout);
        panel3.add(panel,"cars");
        panel3.add(panel2,"car");
        frame.add(panel3);
        //panel.mainTimer.stop();
        cardLayout.show(panel3,"car");*/

        //panel.setSize(800,600);
        //vehicle.setSize(400,400);
        //lp.add(panel,JLayeredPane.DEFAULT_LAYER,-1);
        //lp.add(vehicle,JLayeredPane.MODAL_LAYER,0);
        //lp.moveToFront(vehicle);
        //panel1.add(panel2);

        //panel1.setOpaque(false);
        //frame.add(lp);
        //frame.add(label2);
        //frame.add(vehicle);

       /* panel2.add(panel1);
        panel1.setOpaque(true);
        //frame.add(panel);
        panel1.setLocation(500,400);
        panel2.add(panel);
        frame.add(panel2);
        lp.add(panel,Integer.valueOf(1));
        lp.add(panel1,Integer.valueOf(2));
        frame.add(lp);*/



        //frame.pack();

        frame.add(panel);
        panel.revalidate();


        //frame.add(vehicle);

        frame.setVisible(true);


        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for ( int i = 0; i < fonts.length; i++ ) {
            //System.out.println(fonts[i]);
        }
    }
}
