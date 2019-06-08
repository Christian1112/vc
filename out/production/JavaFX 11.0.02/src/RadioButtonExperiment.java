import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class RadioButtonExperiment extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Radio Button Experiment");

        RadioButton radioButton = new RadioButton("Left");
        RadioButton radioButton1 = new RadioButton("right");
        RadioButton radioButton2 = new RadioButton("up");
        RadioButton radioButton3 = new RadioButton("down");

        ToggleGroup toggleGroup = new ToggleGroup();

        radioButton.setToggleGroup(toggleGroup);
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        radioButton3.setToggleGroup(toggleGroup);

        Button button4 = new Button ("ReadSelected Value");

        HBox hBox = new HBox(radioButton,radioButton1,radioButton2,radioButton3, button4);

        Scene scene = new Scene(hBox,200,300);
        primaryStage.setScene(scene);
        primaryStage.show();



        button4.setOnAction(event -> {
            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            System.out.println(selectedRadioButton.getText());
        });

       // boolean isSelected = radioButton.isSelected();

       /* radioButton.setOnAction(event -> {
            System.out.println(isSelected);
        });*/

       /* HBox hBox = new HBox(radioButton);

        Scene scene = new Scene(hBox, 200, 300);
        primaryStage.setScene(scene);
        primaryStage.show();*/




    }
    public static void main (String[] args) {
        Application.launch(args);
    }


}
