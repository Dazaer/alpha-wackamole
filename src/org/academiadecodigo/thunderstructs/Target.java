package org.academiadecodigo.thunderstructs;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Target  {

    private static int targetsCreated;

    //private Picture[] targets = new Picture[6];       UNNECESSARY??
    private Picture target;
    private int width;
    private int height;
    private boolean isHit;
    private int stayTime;


    
    public Target() {

        /**implement a prettier way to do this... */

        switch (targetsCreated) {
            case 0:
                target = new Picture(360,50, "Thanos_head.png");
                this.width = 360;
                this.height = 50;
                this.isHit = false;
                stayTime = 1500;
                break;
            case 1:
                target = new Picture(660,50, "Thanos_head.png");
                this.width = 660;
                this.height = 50;
                this.isHit = false;
                stayTime = 1500;
                break;
            case 2:
                target = new Picture(960,50, "Thanos_head.png");
                this.width = 960;
                this.height = 50;
                this.isHit = false;
                stayTime = 1500;
                break;
            case 3:
                target = new Picture(360,350, "Thanos_head.png");
                this.width = 360;
                this.height = 350;
                this.isHit = false;
                stayTime = 1500;
                break;
            case 4:
                target = new Picture(660,350, "Thanos_head.png");
                this.width = 660;
                this.height = 350;
                this.isHit = false;
                stayTime = 1500;
                break;
            case 5:
                target = new Picture(960,350, "Thanos_head.png");
                this.width = 960;
                this.height = 350;
                this.isHit = false;
                stayTime = 1500;
                break;

            default:
                System.out.println("Something went wrong");
        }

        targetsCreated++;

    }

    public void appear() {
        target.draw();

    }

    public void die() {
        target.delete();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setHit(boolean isHit) {
        this.isHit = isHit;
    }

    public int getStayTime() {
        return this.stayTime;
    }

    /** FOR HIGHER DIFFICULTY MAKE STAYTIME LOWER
     *
    public void setStayTime(int stayTime) {
        this.stayTime = stayTime;
    }
    */

}
