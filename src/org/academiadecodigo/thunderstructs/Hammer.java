package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Hammer implements MouseHandler {

    private Picture hammer;
    private double clickX;
    private double clickY;

    public Hammer(){
        hammer = new Picture(5,5,"hammer.png");
        hammer.draw();
    }



    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        clickX = mouseEvent.getX();
        clickY = mouseEvent.getY();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        double xinicial = hammer.getX();
        double yinicial = hammer.getY();
        hammer.translate(mouseEvent.getX() - xinicial-20, mouseEvent.getY() - yinicial-50);

    }

    public double getClickX() {
        return this.clickX;
    }

    public double getClickY() {
        return this.clickY;
    }

    public void refresh() {
        hammer.delete();
        hammer.draw();
    }

}

