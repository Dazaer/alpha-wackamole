package org.academiadecodigo.thunderstructs;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Target  {

    private Picture[] targets = new Picture[6];
    private Picture target;
    private int width;
    private int height;
    private boolean isHit;
    private int stayTime;

    private static int targetNumber;



    public Target() {

        for(int i=0; i<targets.length; i++){

        }

        switch (targetNumber) {
            case 0:
                target = new Picture(360,50, "Thanos_head.png");
                this.width = 360;
                this.height = 50;
                break;
            case 1:
                target = new Picture(660,50, "Thanos_head.png");
                this.width = 660;
                this.height = 50;
                break;
            case 2:
                target = new Picture(960,50, "Thanos_head.png");
                this.width = 960;
                this.height = 50;
                break;
            case 3:
                target = new Picture(360,350, "Thanos_head.png");
                this.width = 360;
                this.height = 350;
                break;
            case 4:
                target = new Picture(660,350, "Thanos_head.png");
                this.width = 660;
                this.height = 350;
                break;
            case 5:
                target = new Picture(960,350, "Thanos_head.png");
                this.width = 960;
                this.height = 350;
                break;

            default:
                System.out.println("Something went wrong");
        }

        targetNumber++;

    }

    public void appear() {
        target.draw();

    }

    public void die() {
        target.delete();
    }





}
