package org.academiadecodigo.thunderstructs.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Time extends Field{

    private Picture timer = new Picture(Field.MARGIN + 45,Field.MARGIN + 380,"resources/time.png");

    @Override
    public void show() {
        timer.draw();
    }

    @Override
    public void hide() {

    }
}
