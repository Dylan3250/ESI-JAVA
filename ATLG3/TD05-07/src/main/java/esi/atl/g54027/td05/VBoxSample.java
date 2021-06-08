package esi.atl.g54027.td05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

public class VBoxSample
        extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("My First JavaFX App");
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER_LEFT);

        CheckBox checkBox1 = new CheckBox();
        checkBox1.setText("First");
        checkBox1.setSelected(true);

        CheckBox checkBox2 = new CheckBox("Second");
        checkBox2.setIndeterminate(true);

        CheckBox checkBox3 = new CheckBox("Third");
        checkBox3.setAllowIndeterminate(true);

        root.getChildren().addAll(checkBox1, checkBox3, checkBox2);

        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
