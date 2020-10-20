package sample;

import javafx.scene.paint.Color;

public class Car {
    private Color color;
    private String make;
    private String carNumber;
    private double distance = 0;
    private int speed;
    private int year;
    private int maxSpeed;


    public Car(Color color, String make, int year, int speed, int maxSpeed, String carNumber) {
        this.color = color;
        this.make = make;
        this.year = year;
        this.speed = speed;
        this.maxSpeed = maxSpeed;
        this.carNumber = carNumber;
    }

    public void brake() {
        if (year >= 2015)
            speed = Math.max(speed - 15, 0);
        else if (year >= 2010)
            speed = Math.max(speed - 10, 0);
        else speed = Math.max(speed - 5, 0);
    }

    public void accelerate() {
        if (distance < 100) {
            if (year >= 2015)
                speed = Math.min(speed + 15, maxSpeed);
            else if (year >= 2010)
                speed = Math.min(speed + 10, maxSpeed);
            else speed = Math.min(speed + 5, maxSpeed);
        }
    }

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
