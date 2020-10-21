package sample;
import javafx.application.Platform;
import javafx.scene.control.*;
import java.util.concurrent.*;

//multithread race by lane, will not work correctly as we need to update gui from javafx thread

class Lane extends Thread implements Runnable {
    boolean play = true;
    boolean pause = false;
    float speed=1f;
    Label label;
    Car car;
    long time = 0;

    public Lane(Label label) {
        this.label = label;
    }

    public void run() {
        try {
            while (play) {
                System.out.println(label.getLayoutX());
                if(!pause){
                    long startTime = System.nanoTime();
                    Platform.runLater(() -> label.setLayoutX(label.getLayoutX() + speed));
                    long endTime = System.nanoTime();
                    time += endTime-startTime;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }
}
