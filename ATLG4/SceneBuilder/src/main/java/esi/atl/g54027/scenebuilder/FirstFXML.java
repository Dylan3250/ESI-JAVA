package esi.atl.g54027.scenebuilder;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class FirstFXML extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // load directement le fichier
        // Parent root = FXMLLoader.load(getClass().getResource("/FirstFXML.fxml"));

        // Crée un loader pour pouvoir insérer des infos dans le controlleur
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FirstFXML.fxml"));

        // Si on veut appeler un autre controlleur que celui par défaut il faut
        // le faire avant le .load et ça permet de ne pas mettre 
        // fx:controller="esi.atl.g54027.scenebuilder.FirstFXMLController" 
        // dans Pane du .fxml
        loader.setController(new FirstFXMLController("valeur"));
        Pane root = loader.load();
        FirstFXMLController ctrl = loader.getController();
        ctrl.setDefaultText("Test text defaut");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
