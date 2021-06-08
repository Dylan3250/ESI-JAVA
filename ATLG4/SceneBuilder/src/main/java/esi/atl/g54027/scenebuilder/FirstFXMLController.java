package esi.atl.g54027.scenebuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class FirstFXMLController {
    // implements Initializable {

    private String text = "";

    @FXML
    private Button button;

    @FXML
    private PasswordField password;

    @FXML
    private Label answer;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        answer.setText(password.getText());
    }

    public FirstFXMLController(String text) {
        this.text = text;
    }

    /**
     * Appelé par la classe parente pour y transférer des informations
     *
     * @param text message à insérer
     */
    public void setDefaultText(String text) {
        answer.setText(text);
    }

//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // Permet d'appeler des composants d'une autre URL
//    }
    public void initialize() {
        answer.setText("Chargé au démarrage");
        if (!text.equals(" ")) {
            password.setText(text);
        }
    }
}
