package org.academiadecodigo.thunderstructs.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FieldScore extends Field {

    private Picture score;

    public FieldScore() {
        this.score = new Picture(MARGIN + 18, MARGIN + 62, "score.png");
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
