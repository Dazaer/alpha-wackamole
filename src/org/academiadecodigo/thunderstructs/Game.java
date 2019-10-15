package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.thunderstructs.Field.*;

import java.util.Timer;
import java.util.TimerTask;

public class Game {

    /** Field graphics */
    private Background background;
    private Begin begin;
    private Instructions instructions;
    private ClickToStart clickToStart;
    private GameOver gameOver;
    private Text scoreText;

    private boolean startOfGame;
    private int timeLimit;
    private int score;
    private Target[] targets = new Target[6];
    private Hammer hammer;
    private Mouse mouse;


    public Game() {
        timer.scheduleAtFixedRate(task,1000,1000);

        background = new Background();
        background.show();

        this.background = new Background();
        this.begin = new Begin();
        this.instructions = new Instructions();
        this.clickToStart = new ClickToStart();
        this.gameOver = new GameOver();

        this.timeLimit = 5;
        this.score = 0;
        this.startOfGame = true;
    }


    public void init() {

        background.show();
        begin.show();
        clickToStart.show();

        this.hammer = new Hammer();
        this.mouse = new Mouse(hammer);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);

        this.scoreText = new Text(Field.MARGIN + 130,Field.MARGIN + 140, String.valueOf(score));
        this.scoreText.grow(20,40);
        this.scoreText.setColor(Color.YELLOW);
        this.scoreText.draw();

        while (hammer.getFirstClick()) {
            Utility.Wait(500);
        }
        begin.hide();
        clickToStart.hide();
        instructions.show();
        Utility.Wait(3000);
        instructions.hide();

        for (int i = 0; i < targets.length; i++) {
            targets[i] = new Target();
        }

    }

    public void start() {

        Utility.Wait(2000);
        int stayTime = 1000;

        while (true) {
            Target target = chooseRandomTarget();
            targetShow(target);
            Utility.Wait(stayTime);

            if (secondsRemaining == 0) {
                endGame();
                break;
            }
            Utility.Wait(400);

        }

    }

    public Target chooseRandomTarget() {
        int randomNumber = (int) (Math.random()*targets.length);
        return targets[randomNumber];
    }

    public void updateScore(){
        if(score == 9){
            scoreText.grow(18 ,0);
        }
        score ++;
        scoreText.setText(String.valueOf(score));
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
                updateScore();
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

    public void setBegin(boolean gameBegin) {
        this.startOfGame = gameBegin;
    }

    public boolean getBegin() {
        return startOfGame;
    }

    private int secondsRemaining = 60;
    private Timer timer = new Timer();
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondsRemaining -= 1;
            System.out.println("Seconds remaining: " + secondsRemaining);
            if(secondsRemaining == 0){
                task.cancel();
            }
        }
    };



}
