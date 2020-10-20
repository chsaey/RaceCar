package sample;

import javafx.concurrent.Service;
import javafx.fxml.FXML;
import java.security.Provider;

class Race extends Thread implements Runnable {
    boolean race = true;
    boolean pause = false;
    int x = 1;
    public void run() {
        try {
            while (race) {
                System.out.println(x);
                x++;
            }
        } catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }
}

public class Controller {
    Race race = new Race();

    public javafx.scene.control.Button start;
    public javafx.scene.control.Button speedUp;
    public javafx.scene.control.Button slowDown;
    public javafx.scene.control.Button restart;
    public javafx.scene.control.Button pause;
    public javafx.scene.control.Button resume;

    public void startRace() {
        race = new Race();
        race.start();
    }

    public void speedUp() {
        System.out.println("speed");
    }

    public void slowDown() {
        System.out.println("slow");
    }

    public void pause() {
        System.out.println("pause");
        try{
            race.wait();
        } catch (Exception e){
            System.out.println("lol thread broke on pause");
        }
    }

    public void resume() {
        System.out.println("resume");
        try{
            race.notify();
        }
        catch (Exception e){
            System.out.println("Lol thread broke on resume");
        }
    }

    public void restartRace() {
        race.race = false;
    }

}
