package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Hammer implements MouseHandler {

    private Picture hammer;
    private Mouse mouse;

    public Hammer () {
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        hammer.draw();
        System.out.println("I just cliked!");
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        hammer = new Picture(mouseEvent.getX()/2 - 20,mouseEvent.getY()/2 - 50, "hammerPicture.png");
        System.out.println(mouseEvent.toString());
        hammer.translate(mouseEvent.getX()/2,mouseEvent.getY()/2);
        System.out.println(hammer.getX() + " " + hammer.getY());
        System.out.println("I'm moving");
    }

    /*Hammer hammer = new Hammer();
    Mouse mouse = new Mouse(hammer);
        hammer.init();


        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED); */
}
