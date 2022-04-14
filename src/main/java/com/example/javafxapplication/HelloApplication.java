package com.example.javafxapplication;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Matiére");

        BorderPane BorderPaneRoot = new BorderPane();

        Scene scene = new Scene(BorderPaneRoot,800,600);

        stage.setScene(scene);

        HBox hbox = new HBox();

        Label labelName = new Label("Nom de la matiére");

        TextField txtFName = new TextField();

        Button add = new Button("Ajouter");
        Button Supp = new Button("Supprimer");

        hbox.getChildren().addAll(labelName,txtFName,add,Supp);

        VBox vBox = new VBox();

        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Linux","Probablite","JEE");
        vBox.getChildren().add(listView);
        BorderPaneRoot.setCenter(vBox);

        BorderPaneRoot.setTop(hbox);
        stage.show();

        add.setOnAction((event)->{
          String name = txtFName.getText();
          listView.getItems().add(name);
        });

        Supp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int indice = listView.getSelectionModel().getSelectedIndex();
                if (indice>=0){
                    listView.getItems().remove(indice);

                }else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Sélectioner un element");
                    alert.show();
                }
            }
        });


    }

    public static void main(String[] args) {
        launch(args);
    }
}