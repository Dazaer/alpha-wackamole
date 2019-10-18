package org.academiadecodigo.thunderstructs.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class HighScore extends Field {

    private Picture highScore;

    public HighScore() {
        this.highScore = new Picture(MARGIN + 632, MARGIN + 280, "resources/high_score.png");
    }

    @Override
    public void show() {
        highScore.draw();
    }

    @Override
    public void hide() {
        highScore.delete();
    }
}
