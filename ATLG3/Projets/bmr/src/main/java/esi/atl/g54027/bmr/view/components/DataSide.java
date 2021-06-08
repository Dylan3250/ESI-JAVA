package esi.atl.g54027.bmr.view.components;

import esi.atl.g54027.bmr.model.LifeStyle;
import esi.atl.g54027.bmr.view.View;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Makes the side of data of the application.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class DataSide extends GridPane {

    /**
     * Makes the data side of the application (size, weight, sex, ...).
     *
     * @param view the given View to get given information
     */
    public DataSide(View view) {
        this.setHgap(10);
        this.setVgap(10);

        // left title
        Label datasTitle = new Label("Données :");
        datasTitle.setUnderline(true);
        this.add(datasTitle, 0, 0);

        // label and input for size
        Label sizeLabel = new Label("Taille (cm)");
        view.getSizeField().addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("\\d")
                    || view.getSizeField().getText().length() >= 3) {
                event.consume();
            }
        });
        view.getSizeField().setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                view.getController().checkAndCompute();
            }
        });
        view.getSizeField().setPromptText("Taille en cm");
        this.add(sizeLabel, 0, 1);
        this.add(view.getSizeField(), 1, 1);

        // label and input for weight
        Label weightLabel = new Label("Poids (kg)");
        view.getWeightField().addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("\\d|\\.")
                    || view.getWeightField().getText().length() >= 3) {
                event.consume();
            }
        });
        view.getWeightField().setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                view.getController().checkAndCompute();
            }
        });
        view.getWeightField().setPromptText("Poids en kg");
        this.add(weightLabel, 0, 2);
        this.add(view.getWeightField(), 1, 2);

        // label and input for year
        Label yearLabel = new Label("Âge (années)");
        view.getYearField().addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("\\d")
                    || view.getYearField().getText().length() >= 3) {
                event.consume();
            }
        });
        view.getYearField().setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                view.getController().checkAndCompute();
            }
        });
        view.getYearField().setPromptText("Âge en années");
        this.add(yearLabel, 0, 3);
        this.add(view.getYearField(), 1, 3);

        // label and choose for sex
        Label sexLabel = new Label("Sexe :");
        this.add(sexLabel, 0, 4);
        HBox sexBox = new HBox();
        // women choose
        view.getWomenChoose().setToggleGroup(view.getSexGroup());
        view.getWomenChoose().setSelected(true);
        // men choose
        view.getMenChoose().setToggleGroup(view.getSexGroup());
        view.getMenChoose().setPadding(new Insets(0, 0, 0, 20));
        // alignement for sex
        sexBox.getChildren().addAll(view.getWomenChoose(), view.getMenChoose());
        this.add(sexBox, 1, 4);

        // label and select for life' style
        Label lifeStyleLabel = new Label("Style de vie :");
        this.add(lifeStyleLabel, 0, 5);
        view.getLifeStyleChoose().getItems().addAll((Object[]) LifeStyle.values());
        view.getLifeStyleChoose().getSelectionModel().select(0);
        this.add(view.getLifeStyleChoose(), 1, 5);
    }
}
