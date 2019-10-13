package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyTest implements KeyboardHandler {

    private boolean spacePressed;

    public KeyTest() {
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == keyboardEvent.KEY_SPACE) {
            System.out.println("Spacebar pressed");
            spacePressed = true;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == keyboardEvent.KEY_SPACE) {
            System.out.println("RELEASED");
            spacePressed = false;
        }

    }

    public boolean isSpacePressed() {
        return spacePressed;
    }


}
