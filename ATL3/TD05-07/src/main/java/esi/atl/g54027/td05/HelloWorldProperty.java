package esi.atl.g54027.td05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;

public class HelloWorldProperty
        extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TD05 JavaFX");
        primaryStage.initStyle(StageStyle.UNIFIED);
        BorderPane root = new BorderPane();
        Label helloText = new Label("Hello World");
        helloText.setFont(Font.font("Verdana", 20));
        helloText.setUnderline(true);
        helloText.setTextFill(Color.RED);
        root.setCenter(helloText);

        System.out.println("Le message du Libellé est " + helloText.getText());
        System.out.println("La police du Libellé est " + helloText.getFont());
        System.out.println("La couleur du Libellé est " + helloText.getTextFill());

        Scene scene = new Scene(root, 500, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
