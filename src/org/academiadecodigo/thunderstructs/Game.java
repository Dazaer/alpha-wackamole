package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;

public class Game {

    private Field field;
    private Target[] targets = new Target[6];
    private Hammer hammer;
    private Mouse mouse;

    private KeyTest keyTest;
    private Keyboard keyboard;
    private KeyboardEvent spacebar;



    public Game() {
        this.hammer = new Hammer();
        this.mouse = new Mouse(hammer);

        this.keyTest = new KeyTest();
        this.keyboard = new Keyboard(keyTest);
        this.spacebar = new KeyboardEvent();
        spacebar.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spacebar.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(spacebar);
    }


    public void init(){
        field = new Field();
        field.show();

        for (int i = 0; i < targets.length; i++) {
            targets[i] = new Target();
        }
    }

    public void start() {


        while (true) {
            Target target = chooseRandomTarget();
            targetShow(target);
        }

    }

    public Target chooseRandomTarget() {
        int randomNumber = (int) (Math.random()*targets.length);
        return targets[randomNumber];
    }

    public void targetShow(Target target) {
        Utility.Wait(target.getStayTime());
        target.appear();
        Utility.Wait(target.getStayTime());
        target.die();

    }



}
