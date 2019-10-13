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
    private int timeLimit;


    public Game() {
        timer.scheduleAtFixedRate(task,1000,1000);
        this.timeLimit = 10000;

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

        int timer = 0;
        Utility.Wait(1000);
        int stayTime = 400;

        while (true) {
            Target target = chooseRandomTarget();
            targetShow(target);

            if (timer >= timeLimit) {
                endGame();
                break;
            }

            Utility.Wait(stayTime);
            timer += stayTime;
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

    int secondsPassed;
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondsPassed++;
            System.out.println("Seconds passed: " + secondsPassed);
        }
    };



}
