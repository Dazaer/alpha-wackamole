package org.academiadecodigo.thunderstructs.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Score extends Field {

    private Picture score;

    public Score() {
        this.score = new Picture(MARGIN + 18, MARGIN + 62, "resources/score.png");
    }

    @Override
    public void show() {
        score.draw();
    }

    @Override
    public void hide() {
        score.draw();
    }
}
