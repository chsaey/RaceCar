package sample;

import javafx.animation.*;
import javafx.concurrent.Service;
import javafx.fxml.FXML;
import java.security.Provider;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

//class Race extends Thread implements Runnable {
//    boolean race = true;
//    boolean pause = false;
//    int x = 1;
//    public void run() {
//        try {
//            while (race) {
//                System.out.println(x);
//                x++;
//            }
//        } catch (Exception e) {
//            System.out.println("Exception is caught");
//        }
//    }
//}





public class Controller {
    @FXML
    private Rectangle rec;

    @FXML
    private Rectangle rec1;

    @FXML
    private Rectangle rec2;

    @FXML
    private Rectangle rec3;

    @FXML
    private Rectangle rec4;

    TranslateTransition tt;
    TranslateTransition tt1;
    TranslateTransition tt2;
    TranslateTransition tt3;
    TranslateTransition tt4;

    static ArrayList<String> store = new ArrayList<>();



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
        tt1.setRate(1.0);
        tt1.playFromStart();
        tt2.setRate(1.0);
        tt2.playFromStart();
        tt3.setRate(1.0);
        tt3.playFromStart();
        tt4.setRate(1.0);
        tt4.playFromStart();
    }

    @FXML
    void slowDown(ActionEvent event) {
        tt.setRate(tt.getCurrentRate() - 1.0);
        tt1.setRate(tt1.getCurrentRate() - 1.0);
        tt2.setRate(tt2.getCurrentRate() - 1.0);
        tt3.setRate(tt3.getCurrentRate() - 1.0);
        tt4.setRate(tt4.getCurrentRate() - 1.0);
    }


    @FXML
    void startRace(ActionEvent event) {

        tt = new TranslateTransition(Duration.seconds(20), rec);
        tt.setFromX(0f);
        tt.setToX(900f);
        tt.play();
        tt.setOnFinished(e -> {
            store.add(rec.toString());
            if (store.size() == 1) {
                System.out.println(store.get(0));
            } else if (store.size() == 2) {
                System.out.println(store.get(1));
            } else if (store.size() == 3) {
                System.out.println(store.get(2));
            } else if (store.size() == 4) {
                System.out.println(store.get(3));
            } else if (store.size() == 5) {
                System.out.println(store.get(4));
            }
        });
        tt1 = new TranslateTransition(Duration.seconds(10), rec1);
        tt1.setFromX(0f);
        tt1.setToX(900f);
        tt1.play();
        tt1.setOnFinished(e -> {
            store.add(rec1.toString());
            if (store.size() == 1) {
                System.out.println(store.get(0));
            } else if (store.size() == 2) {
                System.out.println(store.get(1));
            } else if (store.size() == 3) {
                System.out.println(store.get(2));
            } else if (store.size() == 4) {
                System.out.println(store.get(3));
            } else if (store.size() == 5) {
                System.out.println(store.get(4));
            }

        });
        tt2 = new TranslateTransition(Duration.seconds(15), rec2);
        tt2.setFromX(0f);
        tt2.setToX(900f);
        tt2.play();
        tt2.setOnFinished(e -> {
            store.add(rec2.toString());
            if (store.size() == 1) {
                System.out.println(store.get(0));
            } else if (store.size() == 2) {
                System.out.println(store.get(1));
            } else if (store.size() == 3) {
                System.out.println(store.get(2));
            } else if (store.size() == 4) {
                System.out.println(store.get(3));
            } else if (store.size() == 5) {
                System.out.println(store.get(4));
            }
        });
        tt3 = new TranslateTransition(Duration.seconds(12), rec3);
        tt3.setFromX(0f);
        tt3.setToX(900f);
        tt3.play();
        tt3.setOnFinished(e -> {
            store.add(rec3.toString());
            if (store.size() == 1) {
                System.out.println(store.get(0));
            } else if (store.size() == 2) {
                System.out.println(store.get(1));
            } else if (store.size() == 3) {
                System.out.println(store.get(2));
            } else if (store.size() == 4) {
                System.out.println(store.get(3));
            } else if (store.size() == 5) {
                System.out.println(store.get(4));
            }
        });
        tt4 = new TranslateTransition(Duration.seconds(17), rec4);
        tt4.setFromX(0f);
        tt4.setToX(900f);
        tt4.play();
        tt4.setOnFinished(e -> {
            store.add(rec4.toString());
            if (store.size() == 1) {
                System.out.println(store.get(0));
            } else if (store.size() == 2) {
                System.out.println(store.get(1));
            } else if (store.size() == 3) {
                System.out.println(store.get(2));
            } else if (store.size() == 4) {
                System.out.println(store.get(3));
            } else if (store.size() == 5) {
                System.out.println(store.get(4));
            }
        });
    }


    @FXML
    void speedUp(ActionEvent event) {

        tt.setRate(tt.getCurrentRate() + 1.0);
        tt1.setRate(tt1.getCurrentRate() + 1.0);
        tt2.setRate(tt2.getCurrentRate() + 1.0);
        tt3.setRate(tt3.getCurrentRate() + 1.0);
        tt4.setRate(tt4.getCurrentRate() + 1.0);

    }

    @FXML
    void pause(ActionEvent actionEvent) {
        tt.pause();
        tt1.pause();
        tt2.pause();
        tt3.pause();
        tt4.pause();
    }

    @FXML
    void resume(ActionEvent actionEvent) {
        tt.play();
        tt1.play();
        tt2.play();
        tt3.play();
        tt4.play();
    }
}
