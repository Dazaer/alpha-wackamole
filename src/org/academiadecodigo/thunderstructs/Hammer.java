package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Hammer implements MouseHandler {

    private Picture hammer;
    private double clickX;
    private double clickY;
    private boolean firstClick;
    private boolean replayClick;

    public Hammer(){
        hammer = new Picture(5,5,"hammer.png");
        hammer.draw();
        this.firstClick = true;
        this.replayClick = false;
    }



    @Override
    public void mouseClicked(MouseEvent mouseEvent) {


        /** If it's the first click make first click true to continue through init() and start game */
        if(firstClick) {
            firstClick = false;
            return;
        }

        /** If the game has ended or is beginning then it should change to false and replay game or start it */

        if (replayClick) {
            replayClick = false;
            return;
        }

        System.out.println("I just clicked!");
        clickX = mouseEvent.getX();
        clickY = mouseEvent.getY();

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        double xInicial = hammer.getX();
        double yInicial = hammer.getY();

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


    public void refresh() {
        hammer.delete();
        hammer.draw();
    }

    public boolean isFirstClick() {
        return this.firstClick;
    }

    public boolean isReplayClick() {
        return replayClick;
    }

    public void setReplayClick(boolean replayClick) {
        this.replayClick = replayClick;
    }

    public double getClickX() {
        return this.clickX;
    }

    public double getClickY() {
        return this.clickY;
    }

}

