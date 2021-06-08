package esi.atl.g54027.bmr.controller;

import esi.atl.g54027.bmr.model.Model;
import esi.atl.g54027.bmr.view.View;
import javafx.stage.Stage;

/**
 * The controller class communicate with the view, and the model to display the
 * calcul of BMR/Calories or errors.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Controller {

    private final View view;
    private final Model model;
    private final Stage stage;

    /**
     * Defines the controller of the Application.
     *
     * @param stage the principal given stage of the JavaFX Application
     */
    public Controller(Stage stage) {
        this.stage = stage;
        model = new Model();
        view = new View();
    }

    /**
     * Makes the principal view of Application (with fields, buttons, etc) and
     * defines listeners.
     */
    public void run() {
        view.setController(this);
        view.makeView(stage);
        model.addPropertyChangeListener(view.getLCWeightBMR());
        model.addPropertyChangeListener(view.getLCWeightCalories());
        model.addPropertyChangeListener(view.getLCHeightBMR());
        model.addPropertyChangeListener(view.getRight());
    }

    /**
     * Checks the given values after the person given information in the view.
     * If given information are correct, makes the calcul, else displays errors.
     */
    public void checkAndCompute() {
        try {
            view.getSize();
            view.getWeight();
            view.getYear();
        } catch (NumberFormatException e) {
            model.makeError();
            return;
        }

        model.computeBMR(view.getSize(), view.getWeight(), view.getYear(),
                view.isMenChoose(), view.getLifeStyle());
    }
}
