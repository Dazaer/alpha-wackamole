package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    public static final int MARGIN = 10;
    private Picture picture;
    private Picture beginning;
    private Picture instructions;
    private Picture clickToStart;
    private Picture gameOver;
    private Picture score;
    private int width;
    private int height;


    public Field () {
        this.picture = new Picture(MARGIN,MARGIN,"background_wackamole_Thanos.png");
        this.beginning = new Picture(MARGIN, MARGIN, "layout_beginning.png");
        this.instructions = new Picture(MARGIN, MARGIN, "layout_instructions.png");
        this.clickToStart = new Picture(MARGIN + 586 , MARGIN + 440 , "click_to_start.png");
        this.gameOver = new Picture(MARGIN + 364, MARGIN + 269, "game_over.png");
        this.score = new Picture(MARGIN + 18, MARGIN + 62, "score.png");
        this.width = picture.getWidth();
        this.height = picture.getHeight();
    }

    public void show() {
        picture.draw();
    }

    public void showBegin() {
        beginning.draw();
    }

    public void hideBegin() {
        beginning.delete();
    }

    public void showInstructions() {
        instructions.draw();
    }

    public void hideInstructions() {
        instructions.delete();
    }

    public void showClickToStart() {
        clickToStart.draw();
    }

    public void hideClickToStart() {
        clickToStart.delete();
    }

    public void showGameOver() {
        gameOver.draw();
    }

    public void hideGameOver() {
        gameOver.delete();
    }

    public void showScore() {
        score.draw();
    }

    public void hideScore() {
        score.draw();
    }

}
