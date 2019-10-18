package org.academiadecodigo.thunderstructs.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOver extends Field {

    private Picture gameOver;

    public GameOver() {
        this.gameOver = new Picture(MARGIN + 364, MARGIN + 62, "resources/game_over.png");
    }

    @Override
    public void show() {
        gameOver.draw();
    }

    @Override
    public void hide() {
        gameOver.delete();
    }
}
