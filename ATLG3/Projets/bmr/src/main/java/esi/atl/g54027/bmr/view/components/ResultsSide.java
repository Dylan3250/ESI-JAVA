package esi.atl.g54027.bmr.view.components;

import esi.atl.g54027.bmr.view.View;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Makes the side of results of the application.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class ResultsSide extends GridPane implements PropertyChangeListener {

    private final View view;

    /**
     * Makes the results side of the application (calories, BMR).
     *
     * @param view the given View to get given information
     */
    public ResultsSide(View view) {
        this.view = view;

        this.setHgap(10);
        this.setVgap(10);
        this.setAlignment(Pos.TOP_RIGHT);

        // right title
        Label resultsTitle = new Label("Résultats :");
        resultsTitle.setUnderline(true);
        this.getChildren().addAll(resultsTitle);

        // label and input for BMR
        Label BMRLabel = new Label("BMR");
        view.getBMRField().setEditable(false);
        view.getBMRField().setPromptText("Résultat du BMR");
        this.add(BMRLabel, 0, 1);
        this.add(view.getBMRField(), 1, 1);

        // label and input for Calories
        Label CaloriesLabel = new Label("Calories");
        view.getCaloriesField().setEditable(false);
        view.getCaloriesField().setPromptText("Dépense en calories");
        this.add(CaloriesLabel, 0, 2);
        this.add(view.getCaloriesField(), 1, 2);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Shows error if the property error is true
        if (evt.getPropertyName().equals("error")
                && evt.getNewValue().equals(true)) {
            view.transformError();
        }
        // Show the BMR value
        if (evt.getPropertyName().equals("BMR")) {
            view.showBMR((double) evt.getNewValue());
        }
        // Show the Calories value
        if (evt.getPropertyName().equals("Calories")) {
            view.showCalories((double) evt.getNewValue());
        }
    }
}
