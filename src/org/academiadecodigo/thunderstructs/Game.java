package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Field field;
    private Target[] targets = new Target[6];
    private Hammer hammer;
    private Mouse mouse;

    private KeyTest keyTest;
    private Keyboard keyboard;
    private KeyboardEvent spacebarPress;
    private KeyboardEvent spacebarRelease;



    public Game() {
        this.hammer = new Hammer();
        this.mouse = new Mouse(hammer);

        this.keyTest = new KeyTest();
        this.keyboard = new Keyboard(keyTest);
        this.spacebarPress = new KeyboardEvent();
        this.spacebarRelease = new KeyboardEvent();

        spacebarPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spacebarRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        spacebarPress.setKey(KeyboardEvent.KEY_SPACE);
        spacebarRelease.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(spacebarPress);
        keyboard.addEventListener(spacebarRelease);

        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);
    }


    public void init(){

        field = new Field();
        field.show();


        for (int i = 0; i < targets.length; i++) {
            targets[i] = new Target();
        }
    }

    public void start() {

        Utility.Wait(2000);

        while (true) {
            Target target = chooseRandomTarget();
            targetShow(target);
            Utility.Wait(400);
        }

    }

    public Target chooseRandomTarget() {
        int randomNumber = (int) (Math.random()*targets.length);
        return targets[randomNumber];
    }


    /** Takes a target (will be random) and makes it appear on the screen. If there is an input it will disappear */
    public void targetShow(Target target) {
        int counter = 0;
        target.appear();
        while (target.getStayTime() > counter) {

            if ((hammer.getClickX() > target.getWidth() && hammer.getClickX() < target.getWidth()+ Target.X) &&
                    (hammer.getClickY() > target.getHeight() && hammer.getClickY() < target.getHeight()+ Target.Y)) {
                target.die();
                break;
            }

            Utility.Wait(1);
            counter++ ;

        }
        target.die();
    }



}
