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
    private Score scoreImage;
    private Text scoreText;
    private Text time;

    private Music gameTheme;
    private Music deathSfx;
    private Music beginSfx;
    private Music gameOverSfx;

    private Hammer hammer;
    private Mouse mouse;
    private TimerTask timerTask;
    private Timer timer;
    private int timeLimit;
    private int score;
    private Target[] targets = new Target[6];


    public Game() {


        background = new Background();
        background.show();

        this.background = new Background();
        this.begin = new Begin();
        this.instructions = new Instructions();
        this.clickToStart = new ClickToStart();
        this.gameOver = new GameOver();
        this.scoreImage = new Score();

        initializeScore();
        initializeTimer();

    }


    public void init() {

        background.show();
        begin.show();

        this.hammer = new Hammer();
        this.mouse = new Mouse(hammer);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);

        /** Wait for first click to begin the game and blink Click to Start button*/
        while (hammer.isFirstClick()) {
            clickToStart.blink();
            Utility.Wait(200);
        }

        /** Hide beginning image, do 3 second countdown */
        clickToStart.hide();
        begin.hide();
        instructions.show();
        beginSfx = new Music("slow-begin.wav");
        beginSfx.startMusic();
        Utility.Wait(3000);
        instructions.hide();
        scoreImage.show();


        Time timerPicture = new Time();
        timerPicture.show();
        this.time = new Text(Field.MARGIN + 130, Field.MARGIN + 480, String.valueOf(timeLimit));
        time.grow(20,40);
        time.setColor(Color.ORANGE);


        for (int i = 0; i < targets.length; i++) {
            targets[i] = new Target();
        }

        start();
    }


    public void start() {

        int timeBetweenSpawns = 300;
        Target lastTarget = null;

        time.draw();
        scoreText.draw();
        timer.scheduleAtFixedRate(timerTask,1000,1000);
        gameTheme = new Music("LoM-nova.wav");
        gameTheme.startMusic();


        /** Loop to play the game that ends when timer is 0*/
        while (timeLimit != 0) {

            Utility.Wait(timeBetweenSpawns);
            Target target = chooseRandomTarget();
            while (lastTarget == target){
                target = chooseRandomTarget();
            }
            targetShow(target);
            lastTarget = target;

        }
        endGame();
    }


    public void initializeScore() {

        if (scoreText != null) {
            this.scoreText.delete();
        }

        this.score = 0;
        this.scoreText = new Text(Field.MARGIN + 130,Field.MARGIN + 140, String.valueOf(score));
        this.scoreText.grow(20,40);
        this.scoreText.setColor(Color.YELLOW);

    }


    public void initializeTimer() {

        this.timeLimit = 30;
        this.timer = new Timer();
        this.timerTask = new TimerTask() {
            @Override
            public void run() {
                timeLimit -= 1;
                time.setText(String.valueOf(timeLimit));
                System.out.println("Seconds remaining: " + timeLimit);
                if(timeLimit == 0){
                    timerTask.cancel();
                }
            }
        };

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


        /** A loop for the target to stay on screen until counter reaches its stay time limit. Every loop it verifies if
         * the target was clicked on (every 1 ms)
         */
        while (target.getStayTime() > counter) {

            if ((hammer.getClickX() > target.getWidth() && hammer.getClickX() < target.getWidth()+ Target.X) &&
                (hammer.getClickY() > target.getHeight() && hammer.getClickY() < target.getHeight()+ Target.Y) &&
                (!target.isHit())) {

                /** set all the other targets that were not clicked on to not hit (!target.isHit()) so that the above
                 * if condition can verify to true if a target is clicked on. Then set this target to already hit so that
                 * if another target spawns in that place, the click that was registered before doesn't count it and
                 * the score remains the same (random score increase bug fix).
                 */
                for (Target hitTarget : targets) {
                    hitTarget.setHit(false);
                }
                target.setHit(true);

                int randomNumber = (int) (Math.random()*2);
                this.deathSfx = randomNumber % 2 == 0 ? new Music("die-2.wav") : new Music("die-1.wav");
                deathSfx.startMusic();
                target.disappear();
                updateScore();
                break;
            }

            Utility.Wait(1);
            counter++ ;

        }
        target.disappear();
    }


    public void updateScore(){
        if(score == 9){
            scoreText.grow(18 ,0);
        }
        score ++;
        scoreText.setText(String.valueOf(score));
    }


    public void endGame() {

        for (Target target: targets) {
            target.disappear();
        }

        gameTheme.stopMusic();
        gameOverSfx = new Music("game-over.wav");
        gameOverSfx.startMusic();
        gameOver.show();

        Utility.Wait(1000);
        hammer.setReplayClick(true);

        /** Until player clicks game over screen shows */
        while (hammer.isReplayClick()) {
            Utility.Wait(50);
            System.out.println("Waiting for replay click");
        }

        getReplay();
    }

    public void getReplay() {

            initializeScore();
            initializeTimer();
            gameOver.hide();
    }


}
