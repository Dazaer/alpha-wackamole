package org.academiadecodigo.thunderstructs;

public class Game {

    private Field field;
    private Hammer hammer;

    public Game() {
        this.field = new Field();
        this.hammer = new Hammer();

    }

    public void start() {
       //every few seconds spawnTarget() which disappears after 2 seconds
       //if it is hit make it disappear


    }

    public Target spawnTarget(){
        PossibleLocation spawnLocation = field.getRandomLocation();
        return new Target(spawnLocation);
    }


}
