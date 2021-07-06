package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel implements ActionListener, Runnable {
    Image img = new ImageIcon("images/menu.jpg").getImage();

    Timer timer = new Timer(20,this);

    //public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    //public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;


    public Menu() {

        //System.out.print(WIDTH);
        //System.out.print(HEIGHT);
        timer.start();
        //setFocusable(true);
//        draw(Graphics g);

    }

    public void paint (Graphics g) {
        g = (Graphics2D) g;
        g.drawImage(img, 0,0,null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
        //int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
        repaint();

    }

    @Override
    public void run() {

    }
}
