package esi.atl.g54027.bmr.view.components;

import esi.atl.g54027.bmr.view.View;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Defines the line chart for weight VS BMR of the application.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class LCWeightBMR extends LineChart<Number, Number>
        implements PropertyChangeListener {

    private final XYChart.Series<Number, Number> men = new XYChart.Series<>();
    private final XYChart.Series<Number, Number> women = new XYChart.Series<>();
    private final View view;

    /**
     * Makes the line chart for weight VS BMR of the application.
     *
     * @param view the given View to get given information
     */
    public LCWeightBMR(View view) {
        super(new NumberAxis(), new NumberAxis());
        this.view = view;

        this.setTitle("Poids vs Indice BMR");
        this.getXAxis().setLabel("Poids (kg)");
        this.getYAxis().setLabel("BMR");
        men.setName("Homme");
        women.setName("Femme");

        this.getData().addAll(men, women);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Add new point for Weight VS BMR
        if (evt.getPropertyName().equals("BMR")) {
            var data = new XYChart.Data(
                    view.getWeight(),
                    (Double) evt.getNewValue());
            (view.isMenChoose() ? men : women).getData().add(data);
        }
    }
}
