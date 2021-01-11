package esi.atl.g54027.td05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class HelloWorldTextArea
        extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("My First JavaFX App");
        BorderPane root = new BorderPane();

        TextArea txaUserName = new TextArea();
        txaUserName.setPrefColumnCount(12);
        txaUserName.setPrefRowCount(5);
        txaUserName.setWrapText(true);

        Button btnPrint = new Button("Print");
        btnPrint.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println(txaUserName.getText());
            }
        });

        root.setTop(txaUserName);
        BorderPane.setAlignment(txaUserName, Pos.CENTER);
        root.setCenter(btnPrint);

        Scene scene = new Scene(root, 250, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
