package org.academiadecodigo.thunderstructs;

import com.sun.jdi.event.ExceptionEvent;

public class Game {

    private Field field;
    private Target[] targets = new Target[6];
    private Hammer hammer;


    public void init(){
        field = new Field();
        field.show();

        for (int i=0; i<targets.length; i++) {
            targets[i] = new Target();
        }
    }

    public void start() {

        int randomNumber = (int) (Math.random()*targets.length);

        /**
        while(true) {
        for (int i = 0; i < targets.length; i++) {
            targets[i].appear();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("appear");
            }
        }

        for (int i = 0; i < targets.length; i++) {
            targets[i].die();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("disappear");
            }
        }
        }
         */

       //every few seconds spawnTarget() which disappears after 2 seconds
       //if it is hit make it disappear


    }

   // public Target spawnTarget(){
     //   PossibleLocation spawnLocation = field.getRandomLocation();
       // return new Target(spawnLocation);
    //}


}
