package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Hammer implements MouseHandler {

    private Picture hammer;
    private double clickX;
    private double clickY;
    private boolean firstClick;

    public Hammer(){
        hammer = new Picture(5,5,"hammer.png");
        hammer.draw();
        this.firstClick = true;
    }



    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if(firstClick) {
            firstClick = false;
            return;
        }

        System.out.println("I just clicked!");
        clickX = mouseEvent.getX();
        clickY = mouseEvent.getY();

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

        double xinicial = hammer.getX();
        double yinicial = hammer.getY();
        hammer.translate(mouseEvent.getX() - xinicial-20, mouseEvent.getY() - yinicial-50);

        double xInicial = hammer.getX();
        double yInicial = hammer.getY();
        if (mouseEvent.getX() < 1050.0 && mouseEvent.getY() < 510) {
            hammer.translate(mouseEvent.getX() - xInicial - 30, mouseEvent.getY() - yInicial - 60);
        }
        /*
        if(mouseEvent.getX() >= 1055.0){
            hammer.translate( 0,mouseEvent.getY()-yInicial-60);
        }
        if(mouseEvent.getY() >= 510){
           hammer.translate(mouseEvent.getX() - xInicial -30,0);
        }
         */
    }


    public void refresh() {
        hammer.delete();
        hammer.draw();
    }

    public boolean getFirstClick() {
        return this.firstClick;
    }

    public double getClickX() {
        return this.clickX;
    }

    public double getClickY() {
        return this.clickY;
    }

}

