package sample;
import javafx.concurrent.Service;
import javafx.fxml.FXML;
import java.security.Provider;

class Race extends Thread implements Runnable
{
    boolean race = true;
    public void run()
    {
        try
        {
         while(race){
             System.out.println("yo");
         }
        }
        catch (Exception e)
        {
            System.out.println ("Exception is caught");
        }
    }
}

public class Controller {
        Race race = new Race();

    public javafx.scene.control.Button start;
    public javafx.scene.control.Button speedUp;
    public javafx.scene.control.Button slowDown;
    public javafx.scene.control.Button restart;

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

    public void restartRace() {
        race.race = false;
    }

}
