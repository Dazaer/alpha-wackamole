package org.academiadecodigo.thunderstructs.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Begin extends Field {

    private Picture beginning;

    public Begin() {
        this.beginning = new Picture(MARGIN, MARGIN, "resources/layout_beginning.png");
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
