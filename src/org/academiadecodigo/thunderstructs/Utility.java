package org.academiadecodigo.thunderstructs;

public class Utility {

    public static void Wait(int stayTime) {
        try {
            Thread.sleep(stayTime);
        } catch (Exception e){

            //if (keyTest.isSpacePressed()) {
                System.out.println("Interrupted.");
                Thread.currentThread().interrupt();
            //}
        }
    }
}
