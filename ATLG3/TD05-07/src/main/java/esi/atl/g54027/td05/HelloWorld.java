package esi.atl.g54027.td05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;

public class HelloWorld
        extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        System.out.println("Lancement de l'affichage");

    }

    @Override
    public void stop() {
        System.out.println("Arrêt de l'affichage");
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TD05 JavaFX");
        primaryStage.initStyle(StageStyle.UNIFIED);
        BorderPane root = new BorderPane();
        Text helloText = new Text("Hello World");
        helloText.setFont(Font.font("Times New Roman", 20));
        helloText.setFill(Color.RED);
        root.setTop(helloText);
        Scene scene = new Scene(root, 500, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
