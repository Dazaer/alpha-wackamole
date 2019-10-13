package org.academiadecodigo.thunderstructs.Field;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FieldInstructions extends Field{

    private Picture instructions;

    public FieldInstructions() {
        this.instructions = new Picture(MARGIN, MARGIN, "layout_instructions.png");
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

