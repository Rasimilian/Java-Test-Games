package com.company;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;


public class Road extends JPanel implements ActionListener, Runnable {
    Timer timer = new Timer(20,this);

    TimerTask timerTask = new TimerTask()
    {
        @Override
        public void run() {
            enemy_count.changeBossState();
        }
    };

    Image img = new ImageIcon("images/road.png").getImage();

    Menu menu = new Menu();

    Player player = new Player();

    Enemy enemy_count = new Enemy(100,20,1,this);

    Thread enemiesFactory = new Thread(this);

    Thread audioPlay = new Thread(new Audio());

    List<Enemy> enemies = new ArrayList<Enemy>();

    public enum STATES {MENU,PLAY};
    public static STATES state = STATES.PLAY;

    public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static int mouseX;
    public static int mouseY;

    private BufferedImage image_fon;
    private Graphics2D g_fon;


    int num = 1;

    public void paint (Graphics g)
    {
        g = (Graphics2D) g;
        g.drawImage(img,player.layer1,100,null);
        g.drawImage(img,player.layer2,100,null);
        g.drawImage(player.img,player.x,player.y,null);

        double v = player.v;

        g.drawRect(0,50,800,50);
        g.fillRect(0,50,800,50);
        //g.setColor(Color.white);
        Font font = new Font("Arial", Font.ITALIC,20);
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString("Speed: " + v + " km/h", 10,80);
        g.drawString("Streak: " + player.streak + " Alenas", 190,80);


        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()) {
            Enemy e = i.next();
            if (e.x >=2200 || e.x <= -2200) {
                i.remove();
            } else {
                e.move();
                g.drawImage(e.img,e.x,e.y,null);
            }

        }

        if (player.streak < 30)
        {
            g.drawImage(enemy_count.img_1, 350 + player.streak*100/10,50,null);
            g.drawImage(enemy_count.img_2, 350 + player.streak*100/10,90, 60,10,null);
            g.drawImage(enemy_count.img_3,710,50,60,50,null);
        } else
        {
            enemy_count.isBossHere = true;
            g.drawImage(enemy_count.img_boss3, 600,enemy_count.getY(),null);

        }

    }

    /*public void gameRender() {
        menu.draw(g_fon);
    }

    public void gameDraw() {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image_fon,0,0,null);
        g2.dispose();
    }*/


    public Road() {
        timer.start();
        enemiesFactory.start();
        addKeyListener(new MyKeyAdapter());
        audioPlay.start();
        setFocusable(true);

       // image_fon = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        //g_fon = (Graphics2D) image_fon.getGraphics();


    }

    public void actionPerformed (ActionEvent e) {

        if (state.equals(STATES.MENU)) {
//            timer.start();
//            repaint();
//            gameRender();
//            gameDraw();
//            repaint();






        }

        if (state.equals(STATES.PLAY)) {
            player.move();
            enemy_count.bossMove();
            repaint();
            testCollisionWithEnemies();
            timerTask.run();

        }
    }

    public void testCollisionWithEnemies() {
        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()) {
            Enemy e = i.next();
            if (player.getRect().intersects(e.getRect())) {
                i.remove();
                //player.v=0;
                //player.dv=0;
                //e.v=0;


                if (enemies.contains((i))==false) {
                    player.streak += num;
                    //System.out.println(player.streak);
                }

                //JOptionPane.showMessageDialog(null, "Defeated!");
                //System.exit(1);
                //System.out.println(e);
            }



        }

    }

    @Override
    public void run() {
        while (enemy_count.isBossHere == false) {
            Random rand = new Random();
            try {
                Thread.sleep(rand.nextInt(2000));
                enemies.add(new Enemy(800,100+rand.nextInt(200),5+rand.nextInt(20),this));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private class MyKeyAdapter extends KeyAdapter {
        public void keyPressed (KeyEvent e) {
            player.keyPressed(e);
        }

        public void keyReleased (KeyEvent e) {
            player.keyReleased(e);
        }
    }


}
