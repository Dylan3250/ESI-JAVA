package esi.atl.g54027.mvvm.view;

import esi.atl.g54027.mvvm.model.ViewModel;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author jlc
 */
public class ViewBinary {

    private Text text;

    public ViewBinary(Stage primaryStage) {
        System.out.println("DEBUG | VIEW2      | Construction");

        text = new Text();
        HBox box = new HBox(20, text);
        box.setAlignment(Pos.CENTER);
        Scene scene = new Scene(box);
        Stage secondStage = new Stage();
        secondStage.setMinHeight(100);
        secondStage.setMinWidth(100);
        double centerXPosition = primaryStage.getX() + primaryStage.getWidth();
        double centerYPosition = primaryStage.getY() + primaryStage.getHeight() / 2d;
        secondStage.setX(centerXPosition);
        secondStage.setY(centerYPosition);
        secondStage.setScene(scene);
        secondStage.show();
    }

    public void bind(ViewModel viewModel) {
        text.textProperty().bind(viewModel.getBinaryValue());
    }
}
