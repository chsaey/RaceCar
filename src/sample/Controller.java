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


public class Controller {
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
    double pauseTimer = 0;
    double pausedTime = 0;
    double startTime = 0;
    boolean started = false;
    boolean isPaused = false;

    @FXML
    void restartRace(ActionEvent event) {
        started = false;
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

        if (tt.getCurrentRate() == 1.0)
            tt.pause();
        else if (tt.getStatus() == Animation.Status.RUNNING)
            tt.setRate(tt.getCurrentRate() - 1.0);

        if (tt1.getCurrentRate() == 1.0)
            tt1.pause();
        else if (tt.getStatus() == Animation.Status.RUNNING)
            tt1.setRate(tt1.getCurrentRate() - 1.0);

        if (tt2.getCurrentRate() == 1.0)
            tt2.pause();
        else if (tt.getStatus() == Animation.Status.RUNNING)
            tt2.setRate(tt2.getCurrentRate() - 1.0);

        if (tt3.getCurrentRate() == 1.0)
            tt3.pause();
        else if (tt3.getStatus() == Animation.Status.RUNNING)
            tt3.setRate(tt3.getCurrentRate() - 1.0);

        if (tt4.getCurrentRate() == 1.0)
            tt4.pause();
        else if (tt.getStatus() == Animation.Status.RUNNING)
            tt4.setRate(tt4.getCurrentRate() - 1.0);
    }


    @FXML
    void startRace(ActionEvent event) {
        if (!started) {
            started = true;
            startTime = System.nanoTime();
            tt = new TranslateTransition(Duration.seconds(20), rec);
            tt.setFromX(0f);
            tt.setToX(900f);
            tt.play();
            tt.setOnFinished(e -> {
                store.add(rec.toString());
                System.out.println(store.get(store.size() - 1) + "Finished in " + calcTime() + " seconds");
/*            if (store.size() == 1) {
                System.out.println(store.get(0));
            } else if (store.size() == 2) {
                System.out.println(store.get(1));
            } else if (store.size() == 3) {
                System.out.println(store.get(2));
            } else if (store.size() == 4) {
                System.out.println(store.get(3));
            } else if (store.size() == 5) {
                System.out.println(store.get(4));
            }*/
            });
            tt1 = new TranslateTransition(Duration.seconds(10), rec1);
            tt1.setFromX(0f);
            tt1.setToX(900f);
            tt1.play();
            tt1.setOnFinished(e -> {
                store.add(rec1.toString());
                System.out.println(store.get(store.size() - 1) + "Finished in " + calcTime() + " seconds");
/*            if (store.size() == 1) {
                System.out.println(store.get(0));
            } else if (store.size() == 2) {
                System.out.println(store.get(1));
            } else if (store.size() == 3) {
                System.out.println(store.get(2));
            } else if (store.size() == 4) {
                System.out.println(store.get(3));
            } else if (store.size() == 5) {
                System.out.println(store.get(4));
            }*/

            });
            tt2 = new TranslateTransition(Duration.seconds(15), rec2);
            tt2.setFromX(0f);
            tt2.setToX(900f);
            tt2.play();
            tt2.setOnFinished(e -> {
                store.add(rec2.toString());
                System.out.println(store.get(store.size() - 1) + "Finished in " + calcTime() + " seconds");
/*            if (store.size() == 1) {
                System.out.println(store.get(0));
            } else if (store.size() == 2) {
                System.out.println(store.get(1));
            } else if (store.size() == 3) {
                System.out.println(store.get(2));
            } else if (store.size() == 4) {
                System.out.println(store.get(3));
            } else if (store.size() == 5) {
                System.out.println(store.get(4));
            }*/
            });
            tt3 = new TranslateTransition(Duration.seconds(12), rec3);
            tt3.setFromX(0f);
            tt3.setToX(900f);
            tt3.play();
            tt3.setOnFinished(e -> {
                store.add(rec3.toString());
                System.out.println(store.get(store.size() - 1) + "Finished in " + calcTime() + " seconds");
/*            if (store.size() == 1) {
                System.out.println(store.get(0));
            } else if (store.size() == 2) {
                System.out.println(store.get(1));
            } else if (store.size() == 3) {
                System.out.println(store.get(2));
            } else if (store.size() == 4) {
                System.out.println(store.get(3));
            } else if (store.size() == 5) {
                System.out.println(store.get(4));
            }*/
            });
            tt4 = new TranslateTransition(Duration.seconds(17), rec4);
            tt4.setFromX(0f);
            tt4.setToX(900f);
            tt4.play();
            tt4.setOnFinished(e -> {
                store.add(rec4.toString());
                System.out.println(store.get(store.size() - 1) + "Finished in " + calcTime() + " seconds");
/*            if (store.size() == 1) {
                System.out.println(store.get(0));
            } else if (store.size() == 2) {
                System.out.println(store.get(1));
            } else if (store.size() == 3) {
                System.out.println(store.get(2));
            } else if (store.size() == 4) {
                System.out.println(store.get(3));
            } else if (store.size() == 5) {
                System.out.println(store.get(4));
            }*/
            });
        }
    }


    @FXML
    void speedUp(ActionEvent event) {
        if (!isPaused) {
            if (tt.getStatus() == Animation.Status.PAUSED) {
                tt.play();
            } else {
                tt.setRate(tt.getCurrentRate() + 1.0);
            }

            if (tt1.getStatus() == Animation.Status.PAUSED) {
                tt1.play();
            } else {
                tt1.setRate(tt1.getCurrentRate() + 1.0);
            }
            if (tt2.getStatus() == Animation.Status.PAUSED) {
                tt2.play();

            } else {
                tt2.setRate(tt2.getCurrentRate() + 1.0);
            }
            if (tt3.getStatus() == Animation.Status.PAUSED) {
                tt3.play();

            } else {
                tt3.setRate(tt3.getCurrentRate() + 1.0);
            }
            if (tt4.getStatus() == Animation.Status.PAUSED) {
                tt4.play();
            } else {
                tt4.setRate(tt4.getCurrentRate() + 1.0);
            }
        }


    }

    @FXML
    void pause(ActionEvent actionEvent) {
        if (!isPaused) {
            isPaused = true;
            tt.pause();
            tt1.pause();
            tt2.pause();
            tt3.pause();
            tt4.pause();
            pauseTimer = System.nanoTime();
        }
    }

    @FXML
    void resume(ActionEvent actionEvent) {
        if (isPaused) {
            isPaused = false;
            tt.play();
            tt1.play();
            tt2.play();
            tt3.play();
            tt4.play();
            pausedTime += System.nanoTime() - pauseTimer;
        }
    }

    double calcTime() {
        return (System.nanoTime() - startTime - pausedTime) / 1_000_000_000;
    }
}
