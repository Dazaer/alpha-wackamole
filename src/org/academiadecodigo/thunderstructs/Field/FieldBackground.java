package org.academiadecodigo.thunderstructs.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.thunderstructs.Field.Field;

public class FieldBackground extends Field {

    private Picture backGround;

    public FieldBackground() {
        this.backGround = new Picture(MARGIN,MARGIN,"background_wackamole_Thanos.png");
    }

    @Override
    public void show() {
        backGround.draw();
    }

}
