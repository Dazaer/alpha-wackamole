package org.academiadecodigo.thunderstructs.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOverBg extends Field {


    private Picture gameOverBg;

    public GameOverBg() {
        this.gameOverBg = new Picture(MARGIN, MARGIN, "resources/background_simple.png");
    }

    @Override
    public void show() {
        gameOverBg.draw();
    }

    @Override
    public void hide() {
        gameOverBg.delete();
    }

}

