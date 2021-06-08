package esi.atl.g54027.sortingrace;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/viewSort.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Algorithmes de tri");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass()
                .getClassLoader().getResourceAsStream("logo.jpg"))));
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        Platform.exit();
        System.exit(0);
    }
}
