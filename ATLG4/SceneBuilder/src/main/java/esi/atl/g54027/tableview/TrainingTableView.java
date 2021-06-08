package esi.atl.g54027.tableview;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TrainingTableView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        TableView table = new TableView();

        TableColumn<Etudiant, Integer> numCol = new TableColumn<>("Numéro");
        TableColumn<Etudiant, String> prenomCol = new TableColumn<>("Prénom");
        TableColumn<Etudiant, String> nomCol = new TableColumn<>("Nom");
        table.getColumns().setAll(numCol, prenomCol, nomCol);

        numCol.setCellValueFactory(new PropertyValueFactory<>("num"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        Etudiant std1 = new Etudiant(1,"Arthur","Paquot");
        Etudiant std2 = new Etudiant(2,"Israe","Serokh");
        table.getItems().add(std1);
        table.getItems().add(std2);
        
        root.getChildren().add(table);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
