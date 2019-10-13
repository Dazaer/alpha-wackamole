package org.academiadecodigo.thunderstructs;

import jdk.jshell.execution.Util;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.mouse.Mouse;

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
    }


    public void init(){
        field = new Field();
        field.show();
        field.showBegin(keyTest);

        for (int i = 0; i < targets.length; i++) {
            targets[i] = new Target();
        }
    }

    public void start() {

        Utility.Wait(2000);

        while (true) {
            Target target = chooseRandomTarget();
            targetShow(target);
            Utility.Wait(300);
        }

    }

    public Target chooseRandomTarget() {
        int randomNumber = (int) (Math.random()*targets.length);
        return targets[randomNumber];
    }

    public void targetShow(Target target) {
        int counter = 0;
        target.appear();
        while (target.getStayTime() > counter) {
            if (keyTest.isSpacePressed()) {
                target.setHit(true);

            }
            if (target.isHit()) {
                target.die();
                target.setHit(false);
                break;
            }
            Utility.Wait(1);
            counter++ ;

        }
    }



}
