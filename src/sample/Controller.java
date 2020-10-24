package sample;
import javafx.fxml.FXML;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


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

    static String[] suf = {"st", "nd", "rd", "th", "th"};
    static ArrayList<String> store = new ArrayList<>();
    double pauseTimer = 0;
    double pausedTime = 0;
    double startTime = 0;
    boolean started = false;
    boolean isPaused = false;
    String press = "-fx-background-color: linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%), #9d4024, #d86e3a, radial-gradient(center 50% 50%, radius 100%, #ea7f4b, #c54e2c);";
    String release = "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0; -fx-background-color: linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%), #9d4024, #d86e3a, " +
            "radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c); -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 ); " +
            "-fx-font-weight: bold; -fx-font-size: 1.1em; -fx-cursor: hand;";


    @FXML
    void restartRace(ActionEvent event) {
        store.removeAll(store);
        getBanner();
        startTime = System.nanoTime();
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
    public void initialize() {
        Image image1 = new Image("/sample/racecar_images/fiat.png", false);
        rec.setFill(new ImagePattern(image1));
        Image image2 = new Image("/sample/racecar_images/mustang.png", false);
        rec1.setFill(new ImagePattern(image2));
        Image image3 = new Image("/sample/racecar_images/sportscar1.png", false);
        rec2.setFill(new ImagePattern(image3));
        Image image4 = new Image("/sample/racecar_images/sportscar2.jpg", false);
        rec3.setFill(new ImagePattern(image4));
        Image image5 = new Image("/sample/racecar_images/tesla.jpg", false);
        rec4.setFill(new ImagePattern(image5));


        start.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent -> start.setStyle(press));
        start.addEventHandler(MouseEvent.MOUSE_RELEASED, mouseEvent -> start.setStyle(release));
        pause.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent -> pause.setStyle(press));
        pause.addEventHandler(MouseEvent.MOUSE_RELEASED, mouseEvent -> pause.setStyle(release));
        resume.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent -> resume.setStyle(press));
        resume.addEventHandler(MouseEvent.MOUSE_RELEASED, mouseEvent -> resume.setStyle(release));
        restart.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent -> restart.setStyle(press));
        restart.addEventHandler(MouseEvent.MOUSE_RELEASED, mouseEvent -> restart.setStyle(release));
        speedUp.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent -> speedUp.setStyle(press));
        speedUp.addEventHandler(MouseEvent.MOUSE_RELEASED, mouseEvent -> speedUp.setStyle(release));
        slowDown.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent -> slowDown.setStyle(press));
        slowDown.addEventHandler(MouseEvent.MOUSE_RELEASED, mouseEvent -> slowDown.setStyle(release));
    }

    @FXML
    void startRace(ActionEvent event) { //start
        if (!started) {
            started = true;
            startTime = System.nanoTime();
            getBanner();
            car1 = new Car(rec, "Fiat", 2005, 9, "1");
            go(car1);

            car2 = new Car(rec1, "Mustang", 2008, 10, "2");
            go(car2);

            car3 = new Car(rec2, "Ferrari", 2015, 18, "3");
            go(car3);

            car4 = new Car(rec3, "Lamborghini", 2018, 17, "4");
            go(car4);

            car5 = new Car(rec4, "Tesla", 2020, 20, "5");
            go(car5);
        }
    }

    @FXML
    void speedUp(ActionEvent event) {//yo it speeds up
        if (!isPaused) {
            car1.speedUp();
            car2.speedUp();
            car3.speedUp();
            car4.speedUp();
            car5.speedUp();
        }
    }

    @FXML
    void pause(ActionEvent actionEvent) {//pause
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

    void place() {
        System.out.println(store.size() + suf[store.size() - 1] + ": " + store.get(store.size() - 1) + " Finished in " + calcTime() + " seconds");
    }

    double calcTime() {
        return (System.nanoTime() - startTime - pausedTime) / 1_000_000_000;
    }

    void getBanner(){
        System.out.println("\n" + "+----------------------------------------------------+");
        System.out.println("+-----------------R A N K I N G----------------------+");
        System.out.println("+----------------------------------------------------+\n");
    }

    void go(Car car){
        car.play();
        car.getT().setOnFinished(e -> {
            store.add(car.getMake());
            place();
        });
    }



}
