package org.academiadecodigo.thunderstructs.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Replay extends Field{

    private Picture restart;
    private long createdTime = System.currentTimeMillis();

    public Replay() {
        this.restart = new Picture(MARGIN + 572, MARGIN + 450, "resources/click_to_replay.png");
    }

    @Override
    public void show() {
        restart.draw();
    }

    @Override
    public void hide() {
        restart.delete();
    }

    public void blink() {

        int seconds;
        long currentTime = System.currentTimeMillis();

        /** time difference between 1970 + when it was created and time every loop in milliseconds. Divide by 1000 gives the seconds. */
        seconds = (int)((currentTime - createdTime) / 1000);

        if(seconds % 2 == 0) {
            show();
        }
        else {
            hide();
        }
    }

}
