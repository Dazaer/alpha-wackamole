package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Hammer implements MouseHandler {

    private Picture hammer;
    private double clickX;
    private double clickY;

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("I just clicked!");
        clickX = mouseEvent.getX();
        clickY = mouseEvent.getY();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }

    public double getClickX() {
        return this.clickX;
    }

    public double getClickY() {
        return this.clickY;
    }

}

