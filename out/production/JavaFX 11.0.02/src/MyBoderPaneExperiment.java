import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MyBoderPaneExperiment extends Application {

    @Override
    public void start(Stage firstStage) throws Exception{
        BorderPane root = new BorderPane();

        root.setPadding(new Insets(15,20,10,10));
        Button btnTop = new Button("Top");
        btnTop.setPadding(new Insets(10,10,10,10));
        root.setTop(btnTop);

        Scene scene = new Scene(root,500,250);

        firstStage.setTitle("You Beast");
        firstStage.setScene(scene);
        firstStage.show();
    }


}
