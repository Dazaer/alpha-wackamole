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

    private boolean startOfGame;
    private int timeLimit;
    private Timer timer;
    private TimerTask timerTask;
    private int score;
    private Target[] targets = new Target[6];
    private Hammer hammer;
    private Mouse mouse;


    public Game() {


        background = new Background();
        background.show();


        this.background = new Background();
        this.begin = new Begin();
        this.instructions = new Instructions();
        this.clickToStart = new ClickToStart();
        this.gameOver = new GameOver();
        this.scoreImage = new Score();

        this.scoreText = new Text(Field.MARGIN + 130,Field.MARGIN + 140, String.valueOf(score));
        scoreText.grow(20,40);
        scoreText.setColor(Color.YELLOW);

        this.startOfGame = true;
        this.score = 0;
        this.timeLimit = 20;
        this.timer = new Timer();
        this.timerTask = new TimerTask() {
            @Override
            public void run() {
                timeLimit -= 1;
                System.out.println("Seconds remaining: " + timeLimit);
                if(timeLimit == 0){
                    timerTask.cancel();
                }
            }
        };
    }


    public void init() {

        background.show();
        begin.show();

        this.hammer = new Hammer();
        this.mouse = new Mouse(hammer);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);

        /** Wait for first click to begin the game */
        while (hammer.getFirstClick()) {
            clickToStart.blink();
            Utility.Wait(200);
        }

        clickToStart.hide();
        begin.hide();
        instructions.show();
        Utility.Wait(3000);
        instructions.hide();
        this.scoreText.draw();
        this.scoreImage.show();

        scoreText.draw();
        for (int i = 0; i < targets.length; i++) {
            targets[i] = new Target();
        }

    }


    public void start() {

        timer.scheduleAtFixedRate(timerTask,1000,1000);

        /** Time to wait between each head */
        int stayTime = 500;

        while (true) {
            Utility.Wait(stayTime);
            Target target = chooseRandomTarget();
            targetShow(target);

            if (timeLimit == 0) {
                endGame();
                break;
            }
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

        gameOver.show();

        System.out.println("The game has ended!");
        //show image of game over
    }

}
