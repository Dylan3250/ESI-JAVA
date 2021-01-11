package esi.atl.g54027.td06;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author g54027
 */
public class PrintText extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private final BorderPane root = new BorderPane();

    private final HBox btnPanel = new HBox(10);
    private final Label lblTitle = new Label("Event Handling");
    private final TextArea txaMsg = new TextArea();
    private final Button btnInsert = new Button("Insert");
    private final TextField tfdCharacter = new TextField();
    private final Button btnQuit = new Button("Quit");

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Event Handling");
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root);

        //−−− Title
        lblTitle.setFont(Font.font(STYLESHEET_MODENA).font("System", FontWeight.BOLD, 20));
        lblTitle.setTextFill(Color.DARKGREEN);
        BorderPane.setAlignment(lblTitle, Pos.CENTER);
        BorderPane.setMargin(lblTitle, new Insets(0, 0, 10, 0));
        root.setTop(lblTitle);
        //−−− Text−Area
        txaMsg.setWrapText(true);
        txaMsg.setPrefColumnCount(15);
        txaMsg.setPrefRowCount(10);
        root.setCenter(txaMsg);
        //−−− Button Panel
        btnPanel.getChildren().add(btnInsert);
        btnPanel.getChildren().add(tfdCharacter);
        tfdCharacter.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (!event.getCharacter().matches("\\d")) {
                    event.consume();
                }
            }
        });
        btnPanel.getChildren().add(btnQuit);
        btnPanel.setAlignment(Pos.CENTER_RIGHT);
        btnPanel.setPadding(new Insets(10, 0, 0, 0));
        //−−− Button Events Handling
//        btnInsert.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                txaMsg.appendText(tfdCharacter.getText());
//            }
//        });

        // −−− Button Events Handling
//        btnInsert.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                txaMsg.appendText(tfdCharacter.getText());
//            }
//        });
//
//        primaryStage.addEventFilter(MouseEvent.MOUSE_CLICKED,
//                new GraphDisplayHandler("Stage Filter"));
//
//        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED,
//                new GraphDisplayHandler("Stage Handler"));
//
//        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,
//                new GraphDisplayHandler("Scene Filter"));
//
//        scene.addEventHandler(MouseEvent.MOUSE_CLICKED,
//                new GraphDisplayHandler("Scene Handler"));
//
//        root.addEventFilter(MouseEvent.MOUSE_CLICKED,
//                new GraphDisplayHandler("BorderPane Filter"));
//
//        root.addEventHandler(MouseEvent.MOUSE_CLICKED,
//                new GraphDisplayHandler("BorderPane Handler"));
//
//        btnInsert.addEventFilter(MouseEvent.MOUSE_CLICKED,
//                new GraphDisplayHandler("Insert Button Filter"));
//
//        btnInsert.addEventHandler(MouseEvent.MOUSE_CLICKED,
//                new GraphDisplayHandler("Insert Button Handler"));
//
//        btnPanel.addEventFilter(MouseEvent.MOUSE_CLICKED,
//                new GraphDisplayHandler("HBox Filter"));
//
//        btnPanel.addEventHandler(MouseEvent.MOUSE_CLICKED,
//                new GraphDisplayHandler("HBox Handler"));
        root.setBottom(btnPanel);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
