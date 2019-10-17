package org.academiadecodigo.thunderstructs.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Instructions extends Field{

    private Picture instructions;

    public Instructions() {
        this.instructions = new Picture(MARGIN, MARGIN, "resources/layout_instructions.png");
    }

    @Override
    public void show() {
        instructions.draw();
    }

    @Override
    public void hide() {
        instructions.delete();
    }

}

