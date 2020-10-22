package sample;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.w3c.dom.css.Rect;

import javafx.scene.shape.Rectangle;

public class Car {
    private Color color;
    private String make;
    private String carNumber;
    private double distance = 0;
    private int speed = 1;
    private int year;
    private int maxSpeed;
    private TranslateTransition t;
    private Rectangle rectangle;
    private Race lane;


    public Car(Rectangle rec, String make, int year, int maxSpeed, String carNumber) {
        this.t = new TranslateTransition(Duration.seconds(20), rec);
        this.t.setFromX(0f);
        this.t.setToX(1900f);
        this.rectangle = rec;
        this.make = make;
        this.year = year;
        this.maxSpeed = maxSpeed;
        this.carNumber = carNumber;

    }

    public void play() {
        t.play();
        lane = new Race(this);
        lane.start();
    }

    public void pause() {
        lane.togglePause();
        t.pause();
    }

    public void resume() {
        t.play();
        lane.togglePause();
    }

    public void restart() {
        lane.interrupt();
        t.setRate(1);
        t.playFromStart();
        lane = new Race(this);
        lane.start();
    }

    public Animation.Status getStatus() {
        return t.getStatus();
    }

    public void speedUp() {
        if (t.getStatus() == Animation.Status.PAUSED) {
            t.play();
        } else {
            t.setRate(t.getCurrentRate() + 1.0);
        }
    }

    public void slowDown() {
        if (t.getCurrentRate() <= 1.0){
            t.pause();
        }
        else if (t.getStatus() == Animation.Status.RUNNING)
            t.setRate(t.getCurrentRate() - 1.0);
    }

    public void brake() {
        if(t.getStatus() == Animation.Status.RUNNING){
        if (year >= 2015)
            t.setRate(Math.max(t.getCurrentRate() - 1, 1));
        else if (year >= 2010)
            t.setRate(Math.max(t.getCurrentRate() - .75, 1));
        else t.setRate(Math.max(t.getCurrentRate() - .50, 1));
        }
    }

    public void accelerate() {
        if(t.getStatus() == Animation.Status.RUNNING){
        if (year >= 2015)
            t.setRate(Math.min(t.getCurrentRate() + 1, maxSpeed));
        else if (year >= 2010)
            t.setRate(Math.min(t.getCurrentRate() + .75, maxSpeed));
        else t.setRate(Math.min(t.getCurrentRate() + .50, maxSpeed));
        }
        if(t.getStatus() == Animation.Status.PAUSED){
            t.play();
            t.setRate(1);
        }
    }

    public void setRectangle(Rectangle rectangle) { this.rectangle = rectangle; }

    public Rectangle getRectangle() { return rectangle; }

    public void setT(TranslateTransition t) { this.t = t; }

    public TranslateTransition getT() { return t; }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
