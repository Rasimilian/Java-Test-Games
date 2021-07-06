package com.company;

import javax.swing.*;
import java.awt.*;

public class Enemy {
    int x,y,v;
    Image img = new ImageIcon("images/enemy1.png").getImage();
    Image img_1 = new ImageIcon("images/enemy_count.png").getImage();
    Image img_2 = new ImageIcon("images/fire.gif").getImage();
    Image img_3 = new ImageIcon("images/boss_3.jpg").getImage();
    Image img_boss1 = new ImageIcon("images/boss_1.png").getImage();
    Image img_boss2 = new ImageIcon("images/boss_2.png").getImage();
    Image img_boss3 = img_boss1;
    Image img_boss4 = img_boss2;

    int bossY = 230;
    int bossV = 2;

    Road road;
    boolean isBossHere = false;

    public Rectangle getRect() {
        return new Rectangle(x, y, 146, 86);
    }

    public Enemy(int x,int y, int v, Road road) {
        this.x = x;
        this.y = y;
        this.v = v;
        this.road = road;
    }

    public void move() {
        x = x - road.player.v - v;
    }

    public void bossMove()
    {
        if (isBossHere == true)
        {
            bossY = bossY + bossV;
            if (bossY == 270) bossV = -2;
            if (bossY == 100) bossV = 2;

        }

    }

    public int getY()
    {
        return bossY;
    }

    public void changeBossState()
    {
        Image img_in = img_boss3;
        img_boss3 = img_boss4;
        img_boss4 = img_in;

    }
}
