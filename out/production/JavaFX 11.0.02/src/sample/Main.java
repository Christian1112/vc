/*
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.InputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("set action prices");

        Label label1 = new Label("Prod. Name");
        Label label2 = new Label ("Quantity");
        Label label3 = new Label ("Old price:");
        Label label4 = new Label ("new price:");

        TextField textField1 = new TextField();
        textField1.setPrefWidth(200.00);
        TextField textField2 = new TextField();
        textField2.setPrefWidth(200.00);
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();

        InputStream input = this.getClass().getResourceAsStream ("/Coffee-icon.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        Label label5 = new Label ("Description");

        Label label6 = new Label("Hier gibt es keine Beschreibung, weil unsere Handelskette kennst sich nur bedingt damit aus, wie man eine Werbebeschreibung schreibt.", imageView);

         HBox tilePan= new HBox(label1,textField1);
        HBox hBox2 = new HBox(label2,textField2);

        //primaryStage.setScene(new Scene(root, 300, 275));
        Scene scene = new Scene(tilePan,hBox2);
        Pane

        primaryStage.setScene(scene);
        primaryStage.show();
        //primaryStage.setScene(scene1);
       //primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
*/


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



        // Product Objects in ObservableList constructor

        ObservableList<Product> items = FXCollections.observableArrayList (

                new Product("Pfeffer", "1 Stück", 3.49, 2.79, "/ressources/Pfeffer.jpg",

                        "Schwarzer Pfeffer verleiht Ihren Speisen eine pikante Schärfe, " +

                                "besonders\nwenn er länger mitgekocht wird."),

                new Product("Schafmilchkäse", "200 Gramm Packung", 2.59, 1.99,

                        "/ressources/Salakis.jpg", "Hier gibt es keine Beschreibung, weil unsere " +

                        "Handelskette kennt sich nur\nbedingt damit aus, wie man eine Werbebeschreibung schreibt."),

                new Product("Vöslauer", "1.5 Liter Flasche", 0.75, 0.49,

                        "/ressources/Voslauer.jpg", "Spritziges Vöslauer Mineralwasser."),

                new Product("Zucker", "500 Gramm Paket", 1.39, 0.89,

                        "/ressources/Zucker.jpg", "Natürliches Gelieren wird durch Apfelpektin unterstützt," +

                        " welches im\nrichtigen Verhältnis mit Zitronensäure und Kristallzucker abgemischt wurde."));



        // VIEW



        ListView<Product> productList = new ListView<>();

        productList.setItems(items);



        Label lbName = new Label("Prod.Name");

        TextField tfName = new TextField();

        tfName.setEditable(false);

        tfName.setCursor(Cursor.DEFAULT);

        HBox boxName = new HBox(lbName, tfName);

        boxName.setAlignment(Pos.CENTER_LEFT);

        boxName.setSpacing(20);

        boxName.setPadding(new Insets(20,20,0,20));



        Label lbQuantity = new Label("Quantity    ");

        TextField tfQuantity = new TextField();

        tfQuantity.setEditable(false);

        tfQuantity.setCursor(Cursor.DEFAULT);

        Button btnUpdate = new Button("Update");

        HBox boxQuantity = new HBox(lbQuantity, tfQuantity);

        boxQuantity.setAlignment(Pos.CENTER_LEFT);

        boxQuantity.setSpacing(20);

        boxQuantity.setPadding(new Insets(20,20,0,20));



        Label lbOldP = new Label("Old Price   ");

        lbOldP.setPadding(new Insets(0,20,0,0));

        TextField tfOldP = new TextField();

        btnUpdate.setPrefWidth(80);

        HBox updateBox = new HBox(btnUpdate);

        updateBox.setPadding(new Insets(0,0,0,30));

        Label eur1 = new Label("EUR");

        HBox boxOldP = new HBox(lbOldP, tfOldP, eur1, updateBox);

        boxOldP.setAlignment(Pos.CENTER_LEFT);

        boxOldP.setPadding(new Insets(20,20,0,20));



        Label lbNewP = new Label("New Price  ");

        lbNewP.setPadding(new Insets(0,20,0,0));

        TextField tfNewP = new TextField();

        Button btnSave = new Button("Save");

        HBox saveBox = new HBox(btnSave);

        saveBox.setPadding(new Insets(0,0,0,30));

        btnSave.setPrefWidth(80);

        Label eur2 = new Label("EUR");

        HBox boxNewP = new HBox(lbNewP, tfNewP, eur2, saveBox);

        boxNewP.setAlignment(Pos.CENTER_LEFT);

        boxNewP.setSpacing(0);

        boxNewP.setPadding(new Insets(20,20,10,20));



        ImageView imageView = new ImageView();

        imageView.setFitHeight(200);

        imageView.setFitWidth(200);

        HBox boxImage = new HBox(imageView);

        boxImage.setPadding(new Insets(0,0,0,20));



        Label lbDescription = new Label("Description");

        lbDescription.setStyle("-fx-font-size: 2em;");

        lbDescription.setPadding(new Insets(0,0,0,20));



        Text description = new Text();

        HBox boxText = new HBox(description);

        boxText.setPadding(new Insets(0,0,0,20));





        // CONTROL



        productList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {

            public void changed(ObservableValue<? extends Product> ov,

                                Product old_val, Product new_val) {

                tfName.setText(new_val.getName());

                tfQuantity.setText(new_val.getQuantity());

                tfOldP.setText(new_val.getOldPrice());

                tfNewP.setText(new_val.getNewPrice());

                imageView.setImage(new Image(this.getClass().getResourceAsStream(new_val.getImage())));

                description.setText(new_val.getDescription());

            }

        });

        btnUpdate.setOnAction(event -> {

            int selIdx = productList.getSelectionModel().getSelectedIndex();

            if (selIdx != -1) {

                String oldPrice = tfOldP.getText();

                String newPrice = tfNewP.getText();

                productList.getItems().get(selIdx).setOldPrice(oldPrice);

                productList.getItems().get(selIdx).setNewPrice(newPrice);

                productList.refresh();

            }

        });

        btnSave.setOnAction(event -> {

            saveInFile(items);

        });





        // SHOW IT

        VBox general = new VBox(boxName, boxQuantity, boxOldP, boxNewP, boxImage, lbDescription, boxText);

        general.setPrefSize(400, 500);

        HBox allOver = new HBox(general, productList);

        allOver.setSpacing(35);



        Scene scene = new Scene(allOver, 700, 500);

        primaryStage.setScene(scene);

        primaryStage.show();

    }



    public static void main(String[] args) {

        Application.launch(args);

    }