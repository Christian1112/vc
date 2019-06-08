


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.InputStream;

    public class MyImageViewExperiment extends Application  {


        @Override
        public void start(Stage primaryStage) throws Exception {
            primaryStage.setTitle("ImageView");


            InputStream input = this.getClass().getResourceAsStream("/cheese-salakis.jpg");
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);

            HBox hbox = new HBox(imageView);

            Scene scene = new Scene(hbox, 400, 500);
            primaryStage.setScene(scene);
            primaryStage.show();

        }

        public static void main(String[] args) {
            Application.launch(args);
        }

    }

