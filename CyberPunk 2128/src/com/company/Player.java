package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Player implements KeyListener, MouseMotionListener {

    private double v;
    private double dv;
    private double s;
    private double x;
    private double y;
    private double dy;
    private double w;
    private double h;

    private double layer1 = 0;
    private double layer2 = 800;

    public static boolean up = false;
    public static boolean down = false;
    public static boolean left = false;
    public static boolean right = false;

    public static final int MAX_V = 50;
    public static final int MAX_TOP = 100;
    public static final int MAX_BOTTOM = 280;

    Image img = new ImageIcon("images\\car.png").getImage();

    public Player() {
        x = 100;
        y = 100;
        w = 200;
        h = 200;
        v = 5;

        up = false;
        down = false;
        left = false;
        right = false;

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }

    public void draw (Graphics2D g) {
        AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
        g.setComposite(alcom);
        g.drawImage(img,(int)x,(int)y,null);
    }

    public void move() {
        /*s += v;
        v += dv;
        y -= dy;

        //Limitations
        if (v <= 0) v = 0;
        if (v >= MAX_V) v = MAX_V;
        if (y <= MAX_TOP) y = MAX_TOP;
        if (y >= MAX_BOTTOM) y = MAX_BOTTOM;

        if (layer2 - v <= 0) {
            layer1 = 0;
            layer2 = 800;
        }
        layer1 -= v;
        layer2 -= v;*/

        if (up && y>20) {
            y-=v;
        }

        if (down && y<Panel.HEIGHT-h) {
            y+=v;
        }

        if (left && x>0) {
            x-=v;
        }

        if (right && x<Panel.WIDTH-w) {
            x+=v;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_A) {
            //dv = -1;
            left = true;
        }
        if(key == KeyEvent.VK_D) {
            //dv = 1;
            right = true;

        }
        if(key == KeyEvent.VK_W) {
            //dy = 3;
            //img = img_l;
            up = true;
        }
        if(key == KeyEvent.VK_S) {
            //dy = -3;
            //img = img_r;
            down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            //dv = -1;
            left = false;
        }
        if (key == KeyEvent.VK_D) {
            //dv = 1;
            right = false;
        }
        if (key == KeyEvent.VK_W) {
            //dy = 3;
            //img = img_l;
            up = false;
        }
        if (key == KeyEvent.VK_S) {
            //dy = -3;
            //img = img_r;
            down = false;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            if (Panel.state == Panel.STATES.PLAY) {
                Panel.state = Panel.STATES.MENU;
            }
        }

    }


    /*public Rectangle getRect() {
        return new Rectangle(x, y, 149, 85);
    }*/


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Panel.mouseX = e.getX();
        Panel.mouseY = e.getY();
    }
}
