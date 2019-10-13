package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Hammer implements MouseHandler {

    private Picture hammer;

    public Hammer(){
        hammer = new Picture(5,5,"hammer.png");
        hammer.draw();
    }



    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        hammer.draw();
        System.out.println("I just clicked!");
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.toString());
        double xinicial = hammer.getX();
        double yinicial = hammer.getY();
        hammer.translate(mouseEvent.getX() - xinicial-20, mouseEvent.getY() - yinicial-50);
        System.out.println(hammer.getX() + " " + hammer.getY());
        System.out.println("I'm moving");
        }
    }


