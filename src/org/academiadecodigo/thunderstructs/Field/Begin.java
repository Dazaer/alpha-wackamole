package org.academiadecodigo.thunderstructs.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Begin extends Field {

    private Picture beginning;

    public Begin() {
        this.beginning = new Picture(MARGIN, MARGIN, "layout_beginning_1.png");
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
