package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.thunderstructs.Main;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;


// Change this class to your liking, this is just a base example

public class Music {

    private String pathStr;
    private Clip clip;

    public Music (String pathStr) {
        this.pathStr = " resources/music/" + pathStr;
    }

    public void startMusic() {
        //pathStr = "/resources/music/die-1.wav";
        //pathStr = "/resources/music/1090.wav";
        URL soundURL;
        AudioInputStream audioInputStream = null;
        try {
            soundURL = Main.class.getResource(pathStr);
            if (soundURL == null) {
                pathStr = pathStr.substring(1);
                File file = new File(pathStr);
                soundURL = file.toURI().toURL();
            }
            audioInputStream = AudioSystem.getAudioInputStream(soundURL);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            //clip.loop(clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopMusic() {
        clip.stop();
    }
}
