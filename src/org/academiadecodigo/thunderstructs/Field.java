package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    public static final int MARGIN = 10;
    private Picture picture;
    private int width;
    private int height;

    private PossibleLocation[] possibleLocations;
    private int cols;
    private int rows;

    public Field () {
        this.picture = new Picture(MARGIN,MARGIN,"background_wackamole_Thanos.png");
        //this.width = picture.getWidth();
        //this.height = picture.getHeight();
        this.possibleLocations = new PossibleLocation[5];


    }

    public void show() {
        picture.draw();
    }

    public PossibleLocation getRandomLocation () {
        return possibleLocations[(int) (Math.random()*possibleLocations.length)];
    }

}
