package org.academiadecodigo.thunderstructs.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background extends Field {

    private Picture background;

    public Background() {
        this.background = new Picture(MARGIN,MARGIN,"background_whackamole_Thanos.png");
    }

    @Override
    public void show() {
        background.draw();
    }

    @Override
    public void hide() {
        background.delete();
    }

}
