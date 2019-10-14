package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.thunderstructs.Field.Background;

import java.util.Timer;
import java.util.TimerTask;

public class Game {

    private Background background;
    private Target[] targets = new Target[6];
    private Hammer hammer;
    private Mouse mouse;


    public Game() {
        timer.scheduleAtFixedRate(task,1000,1000);

        background = new Background();
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

        int timeru = 30000;

        Utility.Wait(3000);
        int stayTime = 500;

        while (true) {
            Target target = chooseRandomTarget();
            targetShow(target);
            //Utility.Wait(stayTime);

            if (timeru == secondsPassed) {
                endGame();
                break;
            }

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

    public void endGame() {

        for (Target target: targets) {
            target.disappear();
        }

        System.out.println("The game has ended!");
        //show image of game over
    }

    private int secondsPassed;
    private Timer timer = new Timer();
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondsPassed += 1000;
            System.out.println("Seconds passed: " + secondsPassed);
        }
    };



}
