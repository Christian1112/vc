import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneCool extends Application {


    @Override
    public void start(Stage firstStage) throws Exception {

        firstStage.setTitle("GridPane");


        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");
        Button button6 = new Button("Button 6");

        GridPane gridPane = new GridPane();

        gridPane.add(button1,0,0,2,2);
        gridPane.add(button2,2,4,1,1);
        gridPane.add(button3,2,1,1,1);
        gridPane.add(button4,0,2,1,1);
        gridPane.add(button5,1,2,1,1);
        gridPane.add(button6,2,2,1,1);

        gridPane.setHgap(10);
        gridPane.setVgap(10);



        Scene scene = new Scene(gridPane,240,100);
        firstStage.setScene(scene);
        firstStage.show();
    }

    public static void main (String[] args) {
        Application.launch(args);
    }



}
