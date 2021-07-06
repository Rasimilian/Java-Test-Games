package com.company;

import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Races");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        //frame.add(new Menu());
        frame.add(new Road());
        frame.setVisible(true);

    }
}
