package sample;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Label;

//multithread race by lane, does not work

public class LaneTask extends Task {

    boolean play = true;
    boolean pause = false;
    float speed=1f;
    Label label;
    Car car;
    long time = 0;

    public LaneTask(Label label) {
        this.label = label;
    }

    @Override
    protected Object call() throws Exception {
        try {
            while (label.getLayoutX() < 900) {
                if(!pause){
                    long startTime = System.nanoTime();
                    System.out.println(label.getLayoutX());
                    label.setLayoutX(label.getLayoutX() + speed);
                    long endTime = System.nanoTime();
                    time += endTime-startTime;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception is caught");
        }
        return null;
    }
}
