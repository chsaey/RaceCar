package sample;

import javafx.animation.*;
import javafx.fxml.FXML;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
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

    Car car1;
    Car car2;
    Car car3;
    Car car4;
    Car car5;

    static ArrayList<String> store = new ArrayList<>();
    double pauseTimer = 0;
    double pausedTime = 0;
    double startTime = 0;
    boolean started = false;
    boolean isPaused = false;

    @FXML
    void restartRace(ActionEvent event) {
        store.removeAll(store);
        System.out.println("\n" +  "+----------------------------------------------------+");
        System.out.println("+-----------------R A N K I N G----------------------+");
        System.out.println("+----------------------------------------------------+\n");

        startTime=System.nanoTime();
        car1.restart();
        car2.restart();
        car3.restart();
        car4.restart();
        car5.restart();
        pauseTimer = 0;
        pausedTime = 0;
    }

    @FXML
    void slowDown(ActionEvent event) {
        car1.slowDown();
        car2.slowDown();
        car3.slowDown();
        car4.slowDown();
        car5.slowDown();
    }

    @FXML
    void startRace(ActionEvent event) {
        System.out.println("\n" +  "+----------------------------------------------------+");
        System.out.println("+-----------------R A N K I N G----------------------+");
        System.out.println("+----------------------------------------------------+\n");
        if (!started) {
            started = true;
            startTime = System.nanoTime();

            car1 = new Car(rec, "Mazda", 2018, 9, "1");
            car1.play();
            car1.getT().setOnFinished(e -> {
                store.add(car1.getMake());
                if (store.size() == 1) {
                    System.out.println("1st: " + store.get(0) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 2) {
                    System.out.println("2nd: " + store.get(1) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 3) {
                    System.out.println("3rd: " + store.get(2) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 4) {
                    System.out.println("4th: " + store.get(3) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 5) {
                    System.out.println("5th: " + store.get(4) + " Finished in " + calcTime() + " seconds");
                }
            });

            car2 = new Car(rec1, "BMW", 2020, 10, "2");
            car2.play();
            car2.getT().setOnFinished(e -> {
                store.add(car2.getMake());
                if (store.size() == 1) {
                    System.out.println("1st: " + store.get(0) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 2) {
                    System.out.println("2nd: " + store.get(1) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 3) {
                    System.out.println("3rd: " + store.get(2) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 4) {
                    System.out.println("4th: " + store.get(3) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 5) {
                    System.out.println("5th: " + store.get(4) + " Finished in " + calcTime() + " seconds");
                }
            });

            car3 = new Car(rec2, "Toyota", 2010, 12, "3");
            car3.play();
            car3.getT().setOnFinished(e -> {
                store.add(car3.getMake());
                if (store.size() == 1) {
                    System.out.println("1st: " + store.get(0) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 2) {
                    System.out.println("2nd: " + store.get(1) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 3) {
                    System.out.println("3rd: " + store.get(2) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 4) {
                    System.out.println("4th: " + store.get(3) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 5) {
                    System.out.println("5th: " + store.get(4) + " Finished in " + calcTime() + " seconds");
                }
            });

            car4 = new Car(rec3, "Volvo", 2005, 8, "4");
            car4.play();
            car4.getT().setOnFinished(e -> {
                store.add(car4.getMake());
                if (store.size() == 1) {
                    System.out.println("1st: " + store.get(0) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 2) {
                    System.out.println("2nd: " + store.get(1) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 3) {
                    System.out.println("3rd: " + store.get(2) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 4) {
                    System.out.println("4th: " + store.get(3) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 5) {
                    System.out.println("5th: " + store.get(4) + " Finished in " + calcTime() + " seconds");
                }
            });
            car5 = new Car(rec4, "Ferrari", 2020, 15, "5");
            car5.play();
            car5.getT().setOnFinished(e -> {
                store.add(car5.getMake());
                if (store.size() == 1) {
                    System.out.println("1st: " + store.get(0) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 2) {
                    System.out.println("2nd: " + store.get(1) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 3) {
                    System.out.println("3rd: " + store.get(2) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 4) {
                    System.out.println("4th: " + store.get(3) + " Finished in " + calcTime() + " seconds");
                } else if (store.size() == 5) {
                    System.out.println("5th: " + store.get(4) + " Finished in " + calcTime() + " seconds");
                }
            });
        }
    }


    @FXML
    void speedUp(ActionEvent event) {
        if (!isPaused) {
            car1.speedUp();
            car2.speedUp();
            car3.speedUp();
            car4.speedUp();
            car5.speedUp();
        }
    }

    @FXML
    void pause(ActionEvent actionEvent) {
        if (!isPaused) {
            isPaused = true;
            car1.pause();
            car2.pause();
            car3.pause();
            car4.pause();
            car5.pause();
            pauseTimer = System.nanoTime();
        }
    }

    @FXML
    void resume(ActionEvent actionEvent) {
        if (isPaused) {
            isPaused = false;
            car1.resume();
            car2.resume();
            car3.resume();
            car4.resume();
            car5.resume();
            pausedTime += System.nanoTime() - pauseTimer;
        }
    }

    double calcTime() {
        return (System.nanoTime() - startTime - pausedTime) / 1_000_000_000;
    }
}
