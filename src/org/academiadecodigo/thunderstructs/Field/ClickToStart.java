package org.academiadecodigo.thunderstructs.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ClickToStart extends Field {

    private Picture clickToStart;
    private long createdTime = System.currentTimeMillis();


    public ClickToStart() {
        this.clickToStart = new Picture(MARGIN + 586 , MARGIN + 440 , "resources/click_to_start.png");
    }

    @Override
    public void show() {
        clickToStart.draw();
    }

    @Override
    public void hide() {
        clickToStart.delete();
    }

    public void blink() {

        int seconds;
        long currentTime = System.currentTimeMillis();

        /** time difference between 1970 + when it was created and time every loop in milliseconds. Divide by 1000 gives the seconds. */
        seconds = (int)((currentTime - createdTime) / 500);

        if(seconds % 2 == 0) {

            show();
        }
        else {
            hide();
        }
    }

}
