package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    public static final int MARGIN = 10;
    private Picture picture;
    private int width;
    private int height;


    public Field () {
        this.picture = new Picture(MARGIN,MARGIN,"background_wackamole_Thanos.png");
        this.width = picture.getWidth();
        this.height = picture.getHeight();
    }

    public void show() {
        picture.draw();
    }

}
