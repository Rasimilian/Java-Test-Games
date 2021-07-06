package com.company;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Audio implements Runnable {

    @Override
    public void run() {
        try {
            Player player1 = new Player(new FileInputStream("music/hotline1.mp3"));
            player1.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
