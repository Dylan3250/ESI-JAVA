package esi.atl.g54027.game2048.view.components;

import esi.atl.g54027.game2048.model.Square;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Defines the GridPane to display each square with its value and color.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Board extends GridPane {

    private final Label[][] boardLabel = new Label[4][4];

    /**
     * Defines the constructor to make the board with its class and defines each
     * square in the board.
     */
    public Board() {
        this.getStyleClass().add("board");
        for (int i = 0; i < boardLabel.length; i++) {
            for (int j = 0; j < boardLabel[0].length; j++) {
                Label label = new Label();
                GridPane.setRowIndex(label, i);
                GridPane.setColumnIndex(label, j);
                boardLabel[i][j] = label;
                this.getChildren().add(label);
            }
        }
    }

    /**
     * Updates the board and color of each square with the new given array of
     * squares (values edited).
     *
     * @param squares the new given array of square
     */
    public void updateBoard(Square[][] squares) {
        for (int i = 0; i < boardLabel.length; i++) {
            for (int j = 0; j < boardLabel[0].length; j++) {
                String newValue = Integer.toString(squares[i][j].getValue());
                boardLabel[i][j].setText(newValue);
                boardLabel[i][j].getStyleClass().setAll(
                        "label", "label" + newValue);
            }
        }
    }
}
