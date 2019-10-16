package org.academiadecodigo.thunderstructs;

public class Utility {

    public static void Wait(int stayTime) {
        try {
            Thread.sleep(stayTime);
        } catch (Exception e){
                Thread.currentThread().interrupt();
        }
    }
}
