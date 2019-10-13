package org.academiadecodigo.thunderstructs.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FieldClickToStart extends Field {

    private Picture clickToStart;

    public FieldClickToStart() {
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
}
