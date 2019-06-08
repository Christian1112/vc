import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.InputStream;

public class ImageTest extends Application {


        public void start (Stage primaryStage) throws Exception {

            primaryStage.setTitle("Hey whats up");

            InputStream input = this.getClass().getResourceAsStream("/coffee-icon.png");
            Image pic = new Image (input);
            ImageView imageV = new ImageView(pic);

            Label label = new Label("Christian Simic");


            Button button = new Button("button is cool hahahahahahahahahhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
            button.setStyle("-fx-background-color:Green");
            //button.setText("Click me please");
            button.setWrapText(true);

            button.setPrefSize(200,200);

            /*button.setOnAction(changeColor -> {
                label.setTextFill(Color.RED);
            });*/

            TextField textField = new TextField();

            textField.setText("Initial Value");

            button.setOnAction(action -> {
                label.setText("Benjamin Schneider");
                System.out.println(textField.getText());

            });

           // textField.setText("Initial Value");

            ListView listView = new ListView();

            listView.getItems().add ("Christian Schubert");
            listView.getItems().add ("Benjamin Beethoven");
            listView.getItems().add ("Roman Schneider");

            Button button1 = new Button("Read Selected Value");

            button1.setOnAction(event -> {
                ObservableList selectedIn = listView.getSelectionModel().getSelectedIndices();

                for (Object ok : selectedIn) {
                    System.out.println(ok);
                }

            });

            //ComboBox

            ComboBox comboBox = new ComboBox();

            comboBox.getItems().add("Selection 1");
            comboBox.getItems().add("Selection 2");
            comboBox.getItems().add("Selection 3");



            comboBox.setEditable(true);

            Button button2 = new Button("Read Selected Value");

            button2.setOnAction(action -> {
                String value = (String) comboBox.getValue();
                System.out.println(value);
            });



                listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

                HBox box = new HBox(imageV, label, button, textField, listView,button1,comboBox,button2);
                Scene scene = new Scene(box, 400, 800);




                scene.setCursor(Cursor.DEFAULT);


                primaryStage.setScene(scene);
                primaryStage.show();


            }
        }