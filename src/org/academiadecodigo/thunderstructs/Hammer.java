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
        System.out.println("I just clicked!");
        clickX = mouseEvent.getX();
        clickY = mouseEvent.getY();
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

