package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Player {
    Image img_c = new ImageIcon("images/car1.png").getImage();
    Image img_l = new ImageIcon("images/car1_left.png").getImage();
    Image img_r = new ImageIcon("images/car1_right.png").getImage();
    Image img = img_c;

    int v = 0;
    int dv = 0;
    int s = 0;
    int x = 20;
    int y = 120;
    int dy = 0;

    int layer1 = 0;
    int layer2 = 800;

    public static final int MAX_V = 50;
    public static final int MAX_TOP = 100;
    public static final int MAX_BOTTOM = 280;

    boolean isRight, isLeft, isUp, isDown = false;

    int streak = 0;

    public void move() {
        s += v;
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
        layer2 -= v;

    }

    public Rectangle getRect() {
        return new Rectangle(x, y, 149, 85);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_A) {
            dv = -1;
        }
        if(key == KeyEvent.VK_D) {
            dv = 1;
        }
        if(key == KeyEvent.VK_W) {
            dy = 3;
            img = img_l;
        }
        if(key == KeyEvent.VK_S) {
            dy = -3;
            img = img_r;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A || key == KeyEvent.VK_D) dv = 0;

        if (key == KeyEvent.VK_S || key == KeyEvent.VK_W) {
            dy = 0;
            img = img_c;
        }

    }





}
