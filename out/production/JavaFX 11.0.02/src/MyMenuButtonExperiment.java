import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class MyMenuButtonExperiment extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My Menu Button Experiment");

        MenuItem menuItem1 = new MenuItem("Option 1");
        MenuItem menuItem2 = new MenuItem("Option 2");
        MenuItem menuItem3 = new MenuItem("Option 3");


        menuItem3.setOnAction(displayOption3 -> {
            System.out.println("Option 3 selected");

        });



        InputStream input = this.getClass().getResourceAsStream("/coffee-icon.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        MenuButton menuButton = new MenuButton ("Options", imageView, menuItem1, menuItem2, menuItem3);

        VBox hBox = new VBox(menuButton);

        Scene scene = new Scene (hBox, 200,300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main (String[] args) {
        Application.launch(args);
    }
}