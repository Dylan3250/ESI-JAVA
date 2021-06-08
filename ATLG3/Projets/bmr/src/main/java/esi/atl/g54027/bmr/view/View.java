package esi.atl.g54027.bmr.view;

import esi.atl.g54027.bmr.controller.Controller;
import esi.atl.g54027.bmr.model.LifeStyle;
import esi.atl.g54027.bmr.view.components.*;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

/**
 * Alls methods to display and send values to calculate the BMR with JavaFX.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class View {

    private final TextField sizeField = new TextField();
    private final TextField weightField = new TextField();
    private final TextField yearField = new TextField();
    private final ToggleGroup sexGroup = new ToggleGroup();
    private final RadioButton menChoose = new RadioButton("Homme");
    private final RadioButton womenChoose = new RadioButton("Femme");
    private final ChoiceBox lifeStyleChoose = new ChoiceBox<LifeStyle>();
    private final TextField BMRField = new TextField();
    private final TextField CaloriesField = new TextField();
    private final esi.atl.g54027.bmr.view.components.LCWeightBMR LCWeightBMR = new LCWeightBMR(this);
    private final esi.atl.g54027.bmr.view.components.LCWeightCalories LCWeightCalories = new LCWeightCalories(this);
    private final esi.atl.g54027.bmr.view.components.LCHeightBMR LCHeightBMR = new LCHeightBMR(this);
    private final DataSide left = new DataSide(this);
    private final ResultsSide right = new ResultsSide(this);
    private Controller controller;

    /**
     * Resets input used user clicked on reset button.
     */
    private void resetInputs() {
        sizeField.clear();
        weightField.clear();
        yearField.clear();
        womenChoose.setSelected(true);
        lifeStyleChoose.getSelectionModel().select(0);
        BMRField.setStyle("-fx-text-fill: inherit;");
        BMRField.clear();
        CaloriesField.setStyle("-fx-text-fill: inherit;");
        CaloriesField.clear();
    }

    /**
     * Transforms input text and shows dialog box for show the error message.
     */
    public void transformError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Données invalides");
        alert.setHeaderText("Données invalides");
        alert.setContentText("Les informations indiquées ne correspondent pas à "
                + "ce qui est attendu, merci de réessayer.");
        alert.showAndWait();
        BMRField.setText("Erreur !");
        BMRField.setStyle("-fx-text-fill: red;");
        CaloriesField.setText("Erreur !");
        CaloriesField.setStyle("-fx-text-fill: red;");
    }

    /**
     * Edits the calories field with computed calories.
     *
     * @param calories the given calories to show
     */
    public void showCalories(double calories) {
        CaloriesField.setStyle("-fx-text-fill: inherit;");
        CaloriesField.setText(Double.toString(calories));
    }

    /**
     * Edits the BMR field with the computed BMR.
     *
     * @param bmr the given BMR to show
     */
    public void showBMR(double bmr) {
        BMRField.setStyle("-fx-text-fill: inherit;");
        BMRField.setText(Double.toString(bmr));
    }

    /**
     * Makes the principal view of Application with all fields and imports.
     *
     * @param stage the principal stage of JavaFX
     */
    public void makeView(Stage stage) {

        // alignement of left and right side
        HBox innerHbox = new HBox(10);
        innerHbox.setAlignment(Pos.TOP_CENTER);
        innerHbox.getChildren().addAll(left, right);
        innerHbox.setPadding(new Insets(0, 0, 20, 0));

        // -----------------------------
        // ------ BUTTONS
        // -----------------------------
        Button calcul = new Button("Calcul du BMR");
        calcul.setMinWidth(450);
        calcul.setOnAction(e -> controller.checkAndCompute());

        Button reset = new Button("Vider les informations");
        reset.setMinWidth(450);
        reset.setOnAction(e -> resetInputs());

        // -----------------------------
        // ------ LINES CHART
        // -----------------------------
        TabPane tabsChart = new TabPane();
        tabsChart.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        Tab weightBMR = new Tab("Weight (kg) VS BMR");
        weightBMR.setContent(LCWeightBMR);
        Tab weightCalories = new Tab("Weight (KG) VS Calories");
        weightCalories.setContent(LCWeightCalories);
        Tab heightBMR = new Tab("Height (CM) VS BMR");
        heightBMR.setContent(LCHeightBMR);
        tabsChart.getTabs().addAll(weightBMR, weightCalories, heightBMR);

        // -----------------------------
        // ------ MENU BAR
        // -----------------------------
        Menu menu = new Menu("Fichier");
        MenuItem leave = new MenuItem("Quitter");
        leave.setOnAction(e -> Platform.exit());
        menu.getItems().add(leave);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);

        // -----------------------------
        // ------ GLOBAL CONFIGURATION
        // -----------------------------
        // container of left part
        VBox vboxCalcul = new VBox(10);
        vboxCalcul.getChildren().addAll(innerHbox, calcul, reset);
        vboxCalcul.setAlignment(Pos.TOP_CENTER);

        // container of left part (vbox) and linechart
        HBox containerStruct = new HBox(20);
        containerStruct.setAlignment(Pos.TOP_CENTER);
        containerStruct.getChildren().addAll(vboxCalcul, tabsChart);

        // the principal container with menubar and the structure
        VBox container = new VBox(10);
        container.getChildren().addAll(menuBar, containerStruct);

        Scene scene = new Scene(container, 1100, 350);
        // option with prinipal stage
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass()
                .getClassLoader().getResourceAsStream("icon.png"))));
        URL css = getClass().getResource("/styles.css");
        if (css != null) {
            scene.getStylesheets().add(css.toExternalForm());
        }
        stage.setTitle("Calculer le BMR");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        container.requestFocus();
    }

    /**
     * Gets the size field of user.
     *
     * @return the size field
     */
    public TextField getSizeField() {
        return sizeField;
    }

    /**
     * Gets the given size of user.
     *
     * @return the given size
     */
    public int getSize() {
        return Integer.parseInt(sizeField.getText());
    }

    /**
     * Gets the given weight field of user.
     *
     * @return the given weight field
     */
    public TextField getWeightField() {
        return weightField;
    }

    /**
     * Gets the given weight of user.
     *
     * @return the given weight
     */
    public double getWeight() {
        return Double.parseDouble(weightField.getText());
    }

    /**
     * Gets the given year field of user.
     *
     * @return the given year field
     */
    public TextField getYearField() {
        return yearField;
    }

    /**
     * Gets the given year of user.
     *
     * @return the given year
     */
    public int getYear() {
        return Integer.parseInt(yearField.getText());
    }

    /**
     * Gets the sex group with chosen sex.
     *
     * @return the sex group
     */
    public ToggleGroup getSexGroup() {
        return sexGroup;
    }

    /**
     * Gets the status of men choose in sex group.
     *
     * @return the men choose
     */
    public RadioButton getMenChoose() {
        return menChoose;
    }

    /**
     * Checks if the men is choose.
     *
     * @return true if the men is choose, else otherwise
     */
    public boolean isMenChoose() {
        return menChoose.isSelected();
    }

    /**
     * Gets the status of women choose in sex group.
     *
     * @return the women choose
     */
    public RadioButton getWomenChoose() {
        return womenChoose;
    }

    /**
     * Gets the given field life style chosen of user.
     *
     * @return the given field life style
     */
    public ChoiceBox getLifeStyleChoose() {
        return lifeStyleChoose;
    }

    /**
     * Gets the given life style chosen of user.
     *
     * @return the given life style
     */
    public LifeStyle getLifeStyle() {
        return (LifeStyle) lifeStyleChoose.getValue();
    }

    /**
     * Gets the calculated BMR or failed.
     *
     * @return the calculated BMR or failed
     */
    public TextField getBMRField() {
        return BMRField;
    }

    /**
     * Gets the calculated Calories or failed.
     *
     * @return the calculated Calories or failed
     */
    public TextField getCaloriesField() {
        return CaloriesField;
    }

    /**
     * Gets the controller of the view.
     *
     * @return the controller of the view
     */
    public Controller getController() {
        return controller;
    }

    /**
     * Defines the controller of View.
     *
     * @param controller the given controller of Application
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Gets the line chart define in other class for Weight VS BMR.
     *
     * @return the line chart Weight VS BMR for Application
     */
    public LCWeightBMR getLCWeightBMR() {
        return LCWeightBMR;
    }

    /**
     * Gets the line chart define in other class for Weight VS Calories.
     *
     * @return the line chart Weight VS Calories for Application
     */
    public LCWeightCalories getLCWeightCalories() {
        return LCWeightCalories;
    }

    /**
     * Gets the line chart define in other class for Height VS BMR.
     *
     * @return the line chart Height VS BMR for Application
     */
    public LCHeightBMR getLCHeightBMR() {
        return LCHeightBMR;
    }

    /**
     * Gets the left side with all fields (size, weight, ...).
     *
     * @return the left side of the Application
     */
    public DataSide getLeft() {
        return left;
    }

    /**
     * Gets the right side with calculated fields (BMR and Calories).
     *
     * @return the right side of the Application
     */
    public ResultsSide getRight() {
        return right;
    }
}
