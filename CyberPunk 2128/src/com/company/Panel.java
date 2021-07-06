package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Panel extends JPanel implements ActionListener {



    Timer mainTimer = new Timer(20,this);

    public enum STATES {MENU,PLAY};
    public static STATES state = STATES.MENU;

    public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static int mouseX;
    public static int mouseY;

    private BufferedImage image;
    private Graphics2D g;

    Back back = new Back();
    Player player = new Player();
    Menu menu = new Menu();

    //Vehicles vehicle = new Vehicles();


    public Panel() {
        super();

        setFocusable(true);
        requestFocus();

        mainTimer.start();

        //System.out.println(WIDTH);
        //System.out.println(HEIGHT);
        image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();


        addKeyListener(new MyKeyAdapter());
        addMouseMotionListener(new MyMouseMotionAdapter());
        addMouseListener(new MyMouseAdapter());



    }


    public void gameRender() {
        back.draw(g);

        player.draw(g);
    }

    public void gameDraw() {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image,0,0,null);
        g2.dispose();
    }

    public void gameUpdate() {
        player.move();

    }

    public void actionPerformed(ActionEvent e) {

        if (state.equals(STATES.MENU)) {
            back.draw(g);
            //vehicle.paintComponent(g);
            menu.draw(g);
            gameDraw();








        }

        if (state.equals(STATES.PLAY)) {
            gameUpdate();
            gameRender();
            gameDraw();
        }

    }

    public class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            if (state == STATES.PLAY) {
                player.keyPressed(e);
            }
            if (state == STATES.MENU) {
                menu.keyPressed(e);
            }

        }

        public void keyReleased (KeyEvent e) {
            player.keyReleased(e);
        }

        public void mouseMoved (MouseEvent e) {
            player.mouseMoved(e);
        }
    }

    public class MyMouseMotionAdapter extends MouseMotionAdapter {
        public void mouseMoved (MouseEvent e) {
            player.mouseMoved(e);
        }
    }

    public class MyMouseAdapter extends MouseAdapter {


        public void mouseClicked (MouseEvent e) {
            menu.mouseClicked(e);
        }
        public void mousePressed (MouseEvent e) {
            menu.mousePressed(e);
        }
        public void mouseReleased (MouseEvent e) {
            menu.mouseReleased(e);
        }

    }





}
