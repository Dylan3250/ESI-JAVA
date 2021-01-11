package esi.atl.g54027.td07.observer;

import esi.atl.g54027.td07.observer.model.SomethingWithAState;
import esi.atl.g54027.td07.observer.view.StateOfSomethingBinView;
import esi.atl.g54027.td07.observer.view.StateOfSomethingDecView;
import esi.atl.g54027.td07.observer.view.StateOfSomethingHexView;
import esi.atl.g54027.td07.observer.view.StateOfSomethingOctView;
import esi.atl.g54027.td07.observer.view.StateOfSomethingView;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author aro
 */
public class ObserverDP extends Application {

    private final static int WINDOW_WIDTH = 180;
    private final static int WINDOW_HEIGHT = 250;

    private SomethingWithAState observable;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setTitle("DP Observer");
        // primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setScene(scene);

        observable = new SomethingWithAState();
        StateOfSomethingView decView = new StateOfSomethingDecView(observable);
        StateOfSomethingView binaryView = new StateOfSomethingBinView(observable);
        StateOfSomethingView octalView = new StateOfSomethingOctView(observable);
        StateOfSomethingView hexView = new StateOfSomethingHexView(observable);
        root.getChildren().addAll(decView, binaryView, octalView, hexView);
        Button changeButton = new Button("Change");
        changeButton.setOnAction(e -> {
            observable.changeState();
        });
        root.getChildren().add(changeButton);
        primaryStage.show();
        observable.changeState();
    }

}
