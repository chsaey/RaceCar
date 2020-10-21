package sample;

import javafx.animation.*;
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
    private Rectangle rec = new Rectangle();
    TranslateTransition tt;



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
        tt.setRate(1.0);
        tt.playFromStart();
    }

    @FXML
    void slowDown(ActionEvent event) {
        tt.setRate(tt.getCurrentRate() - 1.0);
    }


    @FXML
    void startRace(ActionEvent event) {

        tt = new TranslateTransition(Duration.seconds(20), rec);
        tt.setFromX(0f);
        tt.setToX(900f);
        tt.play();
    }

    @FXML
    void speedUp(ActionEvent event) {

        tt.setRate(tt.getCurrentRate() + 1.0);
    }

    @FXML
    void pause(ActionEvent actionEvent) {
        tt.pause();
    }

    @FXML
    void resume(ActionEvent actionEvent) {
        tt.play();
    }
}
