package esi.atl.g54027.tableview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLSceneTableController {

    @FXML
    private TableColumn<Etudiant, Integer> numCol;

    @FXML
    private TableColumn<Etudiant, Integer> prenomCol;

    @FXML
    private TableColumn<Etudiant, Integer> nomCol;

    @FXML
    private TableView table;

    @FXML
    private TextField id;

    @FXML
    private TextField prenom;

    @FXML
    private TextField nom;

    private ObservableList<Etudiant> list;

    @FXML
    void add(ActionEvent event) {
        try {
            list.add(new Etudiant(Integer.parseInt(id.getText()), prenom.getText(), nom.getText()));
        } catch (NumberFormatException e) {
            id.setText("Erreur : nombre");
        }
    }

    public void initialize() {
        list = FXCollections.observableArrayList();
        numCol.setCellValueFactory(new PropertyValueFactory<>("num"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        table.setItems(list);
    }

}
