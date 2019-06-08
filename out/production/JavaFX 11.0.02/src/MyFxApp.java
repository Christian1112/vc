

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;



public class MyFxApp extends Application {


    @Override
    public void start( Stage primaryStage) throws Exception {
        primaryStage.setTitle("My first JavaFX App");


        Label label = new Label (" Hello World, JavFx !");
        Scene scene = new Scene(label, 400,600);
        primaryStage.setScene(scene);
        primaryStage.show();

        VBox vBox = new VBox (new Label("A JavaFX Laqqqqq"));
        Scene scene1 = new Scene(vBox, 400,600);
        primaryStage.setScene(scene1);
        primaryStage.show();

        scene1.setCursor(Cursor.OPEN_HAND);

        Button button1 = new Button ("Button 1");
        Button button2 = new Button ("Button 2");



        VBox vBox1 = new VBox(button1, button2);

        vBox1.getStylesheets().add("style1/button-styles.css");
        Scene scene2 = new Scene(vBox1, 400,600);
        Stage stage2 = new Stage();
        stage2.setScene(scene2);
        stage2.show();

        Button button = new Button ("Button 2");
        button.setStyle("-fx-border-color: black;" + "-fx-background-color: green;");

        VBox vBox2 = new VBox(button);
        Stage stage3 = new Stage();
        stage3.setScene(new Scene(vBox2, 400,200));
        stage3.show();



    }

    public static void main (String[] args) {
        Application.launch(args);
    }

}
