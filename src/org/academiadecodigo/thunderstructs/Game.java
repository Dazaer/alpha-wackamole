package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.thunderstructs.Field.Field;
import org.academiadecodigo.thunderstructs.Field.FieldBackground;

public class Game {

    private FieldBackground background;
    private Target[] targets = new Target[6];
    private Hammer hammer;
    private Mouse mouse;

    private KeyTest keyTest;
    private Keyboard keyboard;
    private KeyboardEvent spacebarPress;
    private KeyboardEvent spacebarRelease;

    private boolean gameBeginning;



    public Game() {

        background = new FieldBackground();
        background.show();
    }


    public void init() {

        for (int i = 0; i < targets.length; i++) {
            targets[i] = new Target();
        }

        this.hammer = new Hammer();
        this.mouse = new Mouse(hammer);

        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);
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

    public void setGameBeginning(boolean gameBeginning) {
        this.gameBeginning = gameBeginning;
    }


    /** Takes a target (will be random) and makes it appear on the screen. If there is an input it will disappear */
    public void targetShow(Target target) {
        int counter = 0;
        target.appear();
        hammer.refresh();
        while (target.getStayTime() > counter) {

            if ((hammer.getClickX() > target.getWidth() && hammer.getClickX() < target.getWidth()+ Target.X) &&
                    (hammer.getClickY() > target.getHeight() && hammer.getClickY() < target.getHeight()+ Target.Y)) {
                target.disappear();
                break;
            }

            Utility.Wait(1);
            counter++ ;

        }
        target.disappear();
    }



}
