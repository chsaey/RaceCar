package sample;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Images<CarImages> {

    private static final int HEIGHT = 1000;
    private static final int WIDTH = 1366;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    private final static int GAME_BUTTON_START_X = 100;
    private final static int GAME_BUTTON_START_Y = 150;

    List<CarImages> gameButtons;

    public Images()
    {
        //Initialize the game stage
        initializeStage();

        //Initialize the game buttons
        gameButtons = new ArrayList<>();

        //Create background
        createBackground();

    }

    private void initializeStage() {
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
    }

    public Stage getMainStage()
    {
        return mainStage;
    }

    private void addGameButton(CarImages button)
    {

        gameButtons.add(button);
        mainPane.getChildren().add((Node) button);
    }



    private void createBackground()
    {
        Image backgroundImage = new Image("/Users/Dhruvil/Desktop/racecar_images/tesla.jpg");
        BackgroundImage background =  new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));
    }//end createBackground function

//end class

    public Scene drawImageOnScreen(double x, double y, double rotation, String imagePath) throws FileNotFoundException
    {
        //Creating an image
        Image image1 = new Image(new FileInputStream(imagePath));

        //Setting the image view
        ImageView imageView = new ImageView(image1);

        //Setting the position of the image
        imageView.setX(x);
        imageView.setY(y);
        imageView.setRotate(rotation);

        //setting the fit height and width of the image view
        imageView.setFitHeight(x);
        imageView.setFitWidth(y);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        Group root = new Group(imageView);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 500);

        return scene;


    }

}