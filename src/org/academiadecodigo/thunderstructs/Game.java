package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;

public class Game {

    private Field field;
    private Target[] targets = new Target[6];
    private Hammer hammer;
    private Mouse mouse;
    private int score = 0;
    private Text scoreText;

    private KeyTest keyTest;
    private Keyboard keyboard;
    private KeyboardEvent spacebarPress;
    private KeyboardEvent spacebarRelease;



    public Game() {
        field = new Field();
        field.show();
    }


    public void init(){

        for (int i = 0; i < targets.length; i++) {
            targets[i] = new Target();
        }
        this.hammer = new Hammer();
        this.mouse = new Mouse(hammer);

        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);

        this.scoreText = new Text(Field.MARGIN + 130,Field.MARGIN + 140, String.valueOf(score));
        this.scoreText.grow(20,40);
        this.scoreText.setColor(Color.YELLOW);
        this.scoreText.draw();
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

            Utility.Wait(2);
            counter+= 2 ;

        }
        target.disappear();
    }



}
