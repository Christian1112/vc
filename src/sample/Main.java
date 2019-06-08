

import javafx.application.Application;

import javafx.beans.value.ChangeListener;

import javafx.beans.value.ObservableValue;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;

import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.Cursor;

import javafx.scene.Scene;

import javafx.scene.control.*;

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;

import javafx.scene.text.Text;

import javafx.stage.Stage;



import java.io.BufferedWriter;

import java.io.FileWriter;

import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Path;

import java.nio.file.Paths;

import java.util.ArrayList;



public class Main extends Application {

    @Override

    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Set action prices");



        ObservableList<Product> items = FXCollections.observableArrayList (

                new Product("Pfeffer", "1 Stück", 3.49, 2.79, "/ressources/Pfeffer.jpg", "Schwarzer Pfeffer verleiht Ihren Speisen eine pikante Schärfe, " + "besonders\nwenn er länger mitgekocht wird."),

                new Product("Schafmilchkäse", "200 Gramm Packung", 2.59, 1.99, "/ressources/Salakis.jpg", "Hier gibt es keine Beschreibung, weil unsere " + "Handelskette kennt sich nur\nbedingt damit aus, wie man eine Werbebeschreibung schreibt."),

                new Product("Vöslauer", "1.5 Liter Flasche", 0.75, 0.49, "/ressources/voslauer.jpg", "Spritziges Vöslauer Mineralwasser."),

                new Product("Zucker", "500 Gramm Paket", 1.39, 0.89, "/ressources/zucker.jpg", "Natürliches Gelieren wird durch Apfelpektin unterstützt," + " welches im\nrichtigen Verhältnis mit Zitronensäure und Kristallzucker abgemischt wurde."));





        ListView<Product> productList = new ListView<>();

        productList.setItems(items);



        Label label1 = new Label("Prod. Name");

        TextField textfield1 = new TextField();

        textfield1.setEditable(false);

        textfield1.setCursor(Cursor.OPEN_HAND);


        HBox hBox = new HBox(label1, textfield1);

        hBox.setAlignment(Pos.CENTER_LEFT);

        hBox.setSpacing(20);

        hBox.setPadding(new Insets(20,20,0,20));



        Label label2 = new Label("Quantity");

        TextField textfield2 = new TextField();

        textfield2.setEditable(false);

        textfield2.setCursor(Cursor.OPEN_HAND);

        Button button1 = new Button("Update");


        HBox hBox1= new HBox(label2, textfield2);

        hBox1.setAlignment(Pos.CENTER_LEFT);

        hBox1.setSpacing(20);

        hBox1.setPadding(new Insets(20,20,0,20));



        Label label3 = new Label("Old Price");

        label3.setPadding(new Insets(0,20,0,0));

        TextField textfield3 = new TextField();

        button1.setPrefWidth(90);


        HBox hBoxUpdate = new HBox(button1);

        hBoxUpdate.setPadding(new Insets(0,0,0,30));


        Label label4 = new Label("EUR");


        HBox hBox2 = new HBox(label3, textfield3, label4, hBoxUpdate);

        hBox2.setAlignment(Pos.CENTER_LEFT);

        hBox2.setPadding(new Insets(20,20,0,20));



        Label label5 = new Label("New Price");

        label5.setPadding(new Insets(0,20,0,0));

        TextField textfield4 = new TextField();

        Button button2 = new Button("Save");


        HBox hBox3 = new HBox(button2);

        hBox3.setPadding(new Insets(0,0,0,30));

        button2.setPrefWidth(90);


        Label label6 = new Label("EUR");


        HBox hBox4 = new HBox(label4, textfield4, label6, hBox3);

        hBox3.setAlignment(Pos.CENTER_LEFT);

        hBox3.setSpacing(0);

        hBox3.setPadding(new Insets(20,20,10,20));



        ImageView imageView = new ImageView();

        imageView.setFitHeight(200);

        imageView.setFitWidth(200);

        HBox hBox5 = new HBox(imageView);

        hBox4.setPadding(new Insets(0,0,0,20));



        Label label7 = new Label("Description");

        label6.setStyle("-fx-font-size: 2em;");

        label6.setPadding(new Insets(0,0,0,20));

        Text text = new Text();


        HBox hBox6 = new HBox(text);

        hBox6.setPadding(new Insets(0,0,0,20));





        productList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {

            public void changed(ObservableValue<? extends Product> ov,

                                Product old_val, Product new_val) {

                textfield1.setText(new_val.getName());

                textfield2.setText(new_val.getQuantity());

                textfield3.setText(new_val.getOldPrice());

                textfield4.setText(new_val.getnewPrice());

                imageView.setImage(new Image(this.getClass().getResourceAsStream(new_val.getImage())));

                text.setText(new_val.getDescription());

            }

        });

        button1.setOnAction(event -> {

            int selectIndex = productList.getSelectionModel().getSelectedIndex();

            if (selectIndex != -1) {

                String oldPrice = textfield3.getText();

                String newPrice = textfield4.getText();

                productList.getItems().get(selectIndex).setOldPrice(oldPrice);

                productList.getItems().get(selectIndex).setNewPrice(newPrice);

                productList.refresh();

            }

        });

        button2.setOnAction(event -> {

            saveInFile(items);

        });




        VBox all = new VBox(hBox1, hBox2, hBox3, hBox4, label7, hBox5);

        all.setPrefSize(400, 500);

        HBox alltogether = new HBox(all, productList);

        alltogether.setSpacing(40);



        Scene scene = new Scene(alltogether, 700, 500);

        primaryStage.setScene(scene);

        primaryStage.show();

    }



    public static void main(String[] args) {

        Application.launch(args);

    }}