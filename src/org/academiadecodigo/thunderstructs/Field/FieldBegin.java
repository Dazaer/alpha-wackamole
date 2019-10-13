package org.academiadecodigo.thunderstructs.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FieldBegin extends Field{

    private Picture beginning;

    public FieldBegin() {
        this.beginning = new Picture(MARGIN, MARGIN, "layout_beginning.png");
    }

    @Override
    public void show() {
        beginning.draw();
    }

    @Override
    public void hide() {
        beginning.delete();
    }
}
