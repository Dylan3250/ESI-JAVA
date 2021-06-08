package esi.atl.g54027.td09;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EventHandlerExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Event Handler Example");
        Button btn = new Button("Say 'Hello World'");
        Label textf = new Label("");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                textf.setText("Hello world!");
//            }
//        });
        btn.setOnAction((ActionEvent event) -> {textf.setText("Hello world!");});  
        btn.setOnAction((event) -> {textf.setText("Hello world!");});  
        // btn.setOnAction(ActionEvent event -> {textf.setText("Hello world!");}); // type + nom ne fonctionne pas sans parenthèses
        btn.setOnAction(event -> {textf.setText("Hello world!");});  
        // btn.setOnAction(event -> textf.setText("Hello world!");); // Fonctionne pas sans les accolades avec ;
        btn.setOnAction(event -> textf.setText("Hello world!"));  

        VBox root = new VBox(btn, textf);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}
