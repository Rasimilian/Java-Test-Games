package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.security.Key;

public class Menu implements MouseListener, KeyListener {
    /*private int n;
    private Color color1;
    private double x;
    private double y;
    private double w;
    private double h;*/
    Image img = new ImageIcon("images\\button.png").getImage();

    public static boolean mouseIn1 = false;
    public static boolean mouseIn2 = false;
    public boolean mouseIn3 = false;
    public boolean mouseIn4 = false;

    public static boolean wasMouseClick = false;

    public boolean isMainMenu = true;
    public boolean isSettMenu = false;
    public boolean isHelpMenu = false;

    MenuButtons button1 = new MenuButtons(0,"Play");
    MenuButtons button2 = new MenuButtons(1,"Settings");
    MenuButtons button3 = new MenuButtons(2,"Help");
    MenuButtons button4 = new MenuButtons(3,"Exit");

    Settings setting = new Settings();



    public enum MENU_STATES {MainMenu, SettMenu, HelpMenu};
    public static MENU_STATES state1 = MENU_STATES.MainMenu;


    String[] list = new String[4];



    public Menu() {
        /*x = 20;
        y = 100;
        w = 200;
        h = 100;
        n = 4;

        color1 = Color.BLACK;



        list[0] = "Play";
        list[1] = "Settings";
        list[2] = "Help";
        list[3] = "Exit";*/




    }


    public void draw (Graphics2D g) {

        if (state1 == MENU_STATES.MainMenu) {
            button1.drawButton(g);
            button2.drawButton(g);
            button3.drawButton(g);
            button4.drawButton(g);

        }
        if (state1 == MENU_STATES.SettMenu) {
            setting.draw(g);


        }

        if (Panel.mouseX > getX() && Panel.mouseX < getX() + getW()
                && Panel.mouseY > getY() && Panel.mouseY < getY() + getH()) {
            //menu.list[0] = "Playing";

            mouseIn1 = true;
            changeStyle(0.1f,g);
            g.fillRect((int)getX(),(int)getY(),(int)(getW()),(int)(getH()));

            if (state1 == MENU_STATES.MainMenu) {
                if (wasMouseClick) {
                    Panel.state = Panel.STATES.PLAY;
                }
            }

        } else {
            //menu.list[0] = "Play";
            //menu.changeStyle(1.0f,g);
            mouseIn1 = false;
        }

        if (Panel.mouseX > getX() && Panel.mouseX < getX() + getW()
                && Panel.mouseY > getY()+getH() && Panel.mouseY < getY() + getH()*2) {
            //menu.list[1] = "Options";
            //g.drawImage(menu.img,(int)menu.getX(),(int) (menu.getY()),null);
            //g.drawRect((int)menu.getX(),(int)(menu.getY()+menu.getH()),(int)(menu.getW()),(int)(menu.getH()));
            mouseIn2 = true;
            changeStyle(0.1f,g);
            g.fillRect((int)getX(),(int)(getY()+getH()),(int)(getW()),(int)(getH()));
            if (state1 == MENU_STATES.MainMenu){
                if (wasMouseClick) {
                    state1 = MENU_STATES.SettMenu;

                }
            }

        } else {
            //menu.list[1] = "Settings";
            //menu.changeStyle(1.0f,g);
            mouseIn2 = false;
        }

        if (Panel.mouseX > getX() && Panel.mouseX < getX() + getW()
                && Panel.mouseY > getY()+getH()*2 && Panel.mouseY < getY() + getH()*3) {
            //menu.list[2] = "Rules";
            //g.drawImage(menu.img,(int)menu.getX(),(int) (menu.getY()),null);
            //g.drawRect((int)menu.getX(),(int)(menu.getY()+menu.getH()*2),(int)(menu.getW()),(int)(menu.getH()));
            mouseIn3 = true;
            changeStyle(0.1f,g);
            g.fillRect((int)getX(),(int)(getY()+getH()*2),(int)(getW()),(int)(getH()));
        } else {
            //menu.list[2] = "Help";
            //menu.changeStyle(1.0f,g);
            mouseIn3 = false;
        }

        if (Panel.mouseX > getX() && Panel.mouseX < getX() + getW()
                && Panel.mouseY > getY()+getH()*3 && Panel.mouseY < getY() + getH()*4) {
            //menu.list[3] = "Quit";
            //g.drawImage(menu.img,(int)menu.getX(),(int) (menu.getY()),null);
            //g.drawRect((int)menu.getX(),(int)(menu.getY()+menu.getH()*3),(int)(menu.getW()),(int)(menu.getH()));
            mouseIn4 = true;
            changeStyle(0.1f,g);
            g.fillRect((int)getX(),(int)(getY()+getH()*3),(int)(getW()),(int)(getH()));
            if (state1 == MENU_STATES.MainMenu){
                if (wasMouseClick) {
                    System.exit(0);
                    wasMouseClick = false;
                }
            }
        } else {
            //menu.list[3] = "Exit";
            //menu.changeStyle(0.3f,g);
            mouseIn4 = false;
        }

    }


    public double getX() {
        return MenuButtons.x;
    }

    public double getY() {
        return button1.y;
    }

    public double getW() {
        return button1.w;
    }

    public double getH() {
        return button1.h;
    }

    public static void changeStyle(float alpha, Graphics2D g) {
        AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        g.setComposite(alcom);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            wasMouseClick = true;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            wasMouseClick = false;
        }


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {



    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (state1 == MENU_STATES.SettMenu) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                state1 = MENU_STATES.MainMenu;

            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}

class MenuButtons {
    public int n;
    private Color color1;
    public static double x = 20;
    public double y = 100;
    public double w = 200;
    public double h = 100;
    public String name;

    public double x1 = 20;
    public double y1 = 30;

    public double w1 = 100;
    public double h1 = 50;

    public MenuButtons(int n, String name) {
        this.name = name;
        this.n = n;
        color1 = Color.BLACK;

    }


    public void drawButton (Graphics2D g) {
        Menu.changeStyle(1.0f,g);
        g.setColor(color1);
        Font font = new Font("Serif",Font.BOLD,30);
        g.setFont(font);
        int length_w = (int) g.getFontMetrics().getStringBounds(name,g).getWidth();
        int length_h = (int) g.getFontMetrics().getStringBounds(name,g).getHeight();
        g.drawString(name,(int) (x+w/2) - (int)(length_w/2), (int) ((y+h/2+(int)(length_h/4))+h*n));

    }

    public void drawButtonBack (Graphics2D g) {
        Menu.changeStyle(1.0f,g);
        Font font = new Font("Serif",Font.BOLD,20);
        g.setFont(font);
        g.setColor(color1);
        int length_w = (int) g.getFontMetrics().getStringBounds(name,g).getWidth();
        int length_h = (int) g.getFontMetrics().getStringBounds(name,g).getHeight();
        g.drawString(name,(int)w1/2-length_w/2,(int)y1+(int)h1/2);

        if (Panel.mouseX > 0 && Panel.mouseX < x1 + w1-length_w/2
                && Panel.mouseY > y1 - length_h/4 && Panel.mouseY < y1 + h1-length_h/4) {
            Menu.changeStyle(0.1f,g);
            g.fillRect((int)0,(int)y1-length_h/4,(int)(w1),(int)(h1));
        }



    }

}

class Settings {

    MenuButtons button1 = new MenuButtons(0,"Difficulty");
    MenuButtons button2 = new MenuButtons(1,"Car");
    MenuButtons button3 = new MenuButtons(2,"Sound");
    MenuButtons button4 = new MenuButtons(3,"Display");
    MenuButtons button5 = new MenuButtons(4,"Back");



    //Image img = new ImageIcon("images\\road.png").getImage().getScaledInstance(800,600,Image.SCALE_AREA_AVERAGING);


    public void draw (Graphics2D g) {
        button1.drawButton(g);
        button2.drawButton(g);
        button3.drawButton(g);
        button4.drawButton(g);

        //button2.drawButtonBack(g);
        //drawCar(g);

        button5.drawButtonBack(g);
        if (Menu.wasMouseClick) {
            Menu.state1 = Menu.MENU_STATES.MainMenu;
        }



    }

    public void drawCar (Graphics2D g) {
        if (Menu.mouseIn2 && Menu.wasMouseClick) {
            //car.draw(g);
            //Сars.setVisible(true);

        }
    }


}

class Cars extends JPanel {
    private Image img = new ImageIcon("images\\cars.jpg").getImage();//.getScaledInstance(400,400,Image.SCALE_AREA_AVERAGING);
    //private Graphics2D g;

    public Cars() {
        /*img = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) img.getGraphics();
        //Graphics g2 = this.getGraphics();
        g.drawImage(img,300,50,null);
        g.setBackground(Color.BLACK);
        System.out.println("check");*/
        System.out.println("privet");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img,0,0,null);
    }

}

