package sample;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;

import java.util.Random;
//might be used for dynamic car movement

class Race extends Thread implements Runnable {
    Car car;
    boolean paused = false;

    Race(Car car) {
        this.car = car;
    }

    public void start() {
        super.start();
    }

    public void togglePause() {
        paused = !paused;
    }

    public void run() {
        Random behavior = new Random();
        try {
            while (car.getStatus() != Animation.Status.STOPPED) {
                Thread.sleep(500);
                if (!paused) {
                    int x = behavior.nextInt(9) + 1;
                    if (x % 2 == 0) {
                        car.accelerate();
                    } else {
                        car.brake();
                    }
                }
            }
            System.out.println("thread stopped");

        } catch (Exception e) {

        }

    }
}
