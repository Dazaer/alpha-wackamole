package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Hammer implements MouseHandler {

    private Picture hammer;
    private double clickX;
    private double clickY;
    private double x;
    private double y;
    private boolean firstClick;

    public Hammer(){
        hammer = new Picture(5,5,"hammer.png");
        hammer.draw();
        this.firstClick = true;
    }



    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if(firstClick) {
            System.out.println("not yet clicked");
            firstClick = false;
            System.out.println(firstClick);
        }

        System.out.println("I just clicked!");
        clickX = mouseEvent.getX();
        clickY = mouseEvent.getY();

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        double xInicial = hammer.getX();
        double yInicial = hammer.getY();
        this.x = xInicial;
        this.y = yInicial;

        if(mouseEvent.getX() <= 50){
            hammer.translate(0,mouseEvent.getY() - yInicial-60);
        }
        if(mouseEvent.getY() <= 75){
            hammer.translate(mouseEvent.getX()-xInicial-30,0);
        }
        if (mouseEvent.getX() < 1050 && mouseEvent.getX() > 50 &&
                mouseEvent.getY() < 510 && mouseEvent.getY() > 75) {
            hammer.translate(mouseEvent.getX() - xInicial - 30, mouseEvent.getY() - yInicial - 60);
        }
        if (mouseEvent.getX() >= 1050) {
            hammer.translate(0, mouseEvent.getY() - yInicial-60);
        }
        if(mouseEvent.getY() >= 510){
            hammer.translate(mouseEvent.getX() -xInicial-30, 0);
        }


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

    public void refresh() {
        hammer.delete();
        hammer.draw();
    }

}

