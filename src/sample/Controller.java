package sample;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.concurrent.Service;
import javafx.fxml.FXML;
import java.security.Provider;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

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
    @FXML
    private Rectangle rec;

//    Race race = new Race();
//
//    public javafx.scene.control.Button start;
//    public javafx.scene.control.Button speedUp;
//    public javafx.scene.control.Button slowDown;
//    public javafx.scene.control.Button restart;
//    public javafx.scene.control.Button pause;
//    public javafx.scene.control.Button resume;
//
//    public void startRace() {
//        race = new Race();
//        race.start();
//    }
//
//    public void speedUp() {
//        System.out.println("speed");
//    }
//
//    public void slowDown() {
//        System.out.println("slow");
//    }
//
//    public void pause() {
//        System.out.println("pause");
//        try{
//            race.wait();
//        } catch (Exception e){
//            System.out.println("lol thread broke on pause");
//        }
//    }
//
//    public void resume() {
//        System.out.println("resume");
//        try{
//            race.notify();
//        }
//        catch (Exception e){
//            System.out.println("Lol thread broke on resume");
//        }
//    }
//
//    public void restartRace() {
//        race.race = false;
    //int timer;

    //public Controller (int timer) { this.timer = timer;}

    Race race = new Race();



    @FXML
    private Button pause;

    @FXML
    private Button resume;

    @FXML
    private Button start;

    @FXML
    private Button speedUp;

    @FXML
    private Button slowDown;

    @FXML
    private Button restart;

    @FXML
    void restartRace(ActionEvent event) {
        race.race = false;
    }

    @FXML
    void slowDown(ActionEvent event) {
        System.out.println("slow");
    }


    TranslateTransition tt;
    @FXML
    void startRace(ActionEvent event) {

        tt = new TranslateTransition(Duration.seconds(6), rec);
        tt.setByX(900f);
        //tt.setCycleCount(4);
        //tt.setAutoReverse(true);

        tt.play();



        //race = new Race();
       // race.start();
    }

    @FXML
    void speedUp(ActionEvent event) {
        double duration = tt.getCycleDuration().toSeconds();
        if (duration > 1) {
            duration--;
            tt.setRate(tt.getCycleDuration().toSeconds() / duration);
        }

//        timer -= 20;
//        if (timer <= 0) {
//            timer += 20;
//        } else {
//            timer += 20;
//        }
//        System.out.println("speed");
    }

    @FXML
    void pause(ActionEvent actionEvent) {
//        System.out.println("pause");
        tt.pause();
//        try{
//            race.wait();
//        } catch (Exception e){
//            System.out.println("lol thread broke on pause");
//        }
    }

    @FXML
    void resume(ActionEvent actionEvent) {
        System.out.println("resume");
        try{
            race.notify();
        }
        catch (Exception e){
            System.out.println("Lol thread broke on resume");
        }
    }
}
