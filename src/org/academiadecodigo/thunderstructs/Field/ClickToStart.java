package org.academiadecodigo.thunderstructs.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thunderstructs.Utility;

public class ClickToStart extends Field {

    private Picture clickToStart;
    private long createdTime = System.currentTimeMillis();

    public ClickToStart() {
        this.clickToStart = new Picture(MARGIN + 586 , MARGIN + 440 , "click_to_start.png");
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
        System.out.println(currentTime + " is current and created is: " + createdTime);

        seconds = (int)((currentTime - this.createdTime) / 1000);

        if(seconds % 2 == 0) {
            show();
        }
        else {
            hide();
        }
    }

}
