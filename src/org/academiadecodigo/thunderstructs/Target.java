package org.academiadecodigo.thunderstructs;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Target  {

    public static final int X = 200;
    public static final int Y = 250;
    private static int targetsCreated;

    private Picture target;
    private int width;
    private int height;
    private boolean isHit;
    private int stayTime;


    
    public Target() {

        /**implement a prettier way to do this... */

        stayTime = 900;
        isHit = false;

        switch (targetsCreated) {
            case 0:
                target = new Picture(360,50, "resources/Thanos_head.png");
                this.width = 360;
                this.height = 50;
                break;
            case 1:
                target = new Picture(660,50, "resources/Thanos_head.png");
                this.width = 660;
                this.height = 50;
                break;
            case 2:
                target = new Picture(960,50, "resources/Thanos_head.png");
                this.width = 960;
                this.height = 50;
                break;
            case 3:
                target = new Picture(360,350, "resources/Thanos_head.png");
                this.width = 360;
                this.height = 350;
                break;
            case 4:
                target = new Picture(660,350, "resources/Thanos_head.png");
                this.width = 660;
                this.height = 350;
                break;
            case 5:
                target = new Picture(960,350, "resources/Thanos_head.png");
                this.width = 960;
                this.height = 350;
                break;

            default:
                System.out.println("Something went wrong");
        }

        targetsCreated++;

    }

    public void appear() {
        target.draw();

    }

    public void disappear() {
        target.delete();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean isHit) {
        this.isHit = isHit;
    }

    public int getStayTime() {
        return this.stayTime;
    }

    /** FOR HIGHER DIFFICULTY LEVELS MAKE STAYTIME LOWER
     *
    public void setStayTime(int stayTime) {
        this.stayTime = stayTime;
    }
    */

}
