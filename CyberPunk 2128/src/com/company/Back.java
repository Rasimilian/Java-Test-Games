package com.company;

import javax.swing.*;
import java.awt.*;

public class Back {

    Image img = new ImageIcon("images\\menu.jpg").getImage().getScaledInstance(800,600,Image.SCALE_AREA_AVERAGING);
    Image img1 = new ImageIcon("images\\road.jpg").getImage().getScaledInstance(800,600,Image.SCALE_AREA_AVERAGING);
    Image img2 = new ImageIcon("images\\cyberpunk_main.gif").getImage();//.getScaledInstance(800,600,Image.SCALE_AREA_AVERAGING);

    public void draw(Graphics2D g) {
        if (Panel.state.equals(Panel.STATES.MENU)) {
            g.drawImage(img2,0,0,null);
        }

        if (Panel.state.equals(Panel.STATES.PLAY)) {
            g.drawImage(img1,0,0,null);
        }
    }

}
