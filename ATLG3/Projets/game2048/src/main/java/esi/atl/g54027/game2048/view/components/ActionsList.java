package esi.atl.g54027.game2048.view.components;

import esi.atl.g54027.game2048.model.Direction;
import esi.atl.g54027.game2048.model.GameStatus;
import javafx.scene.control.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Defines the ListView to display actions of the player, messages of the end
 * (player won, lost, welcome), etc.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class ActionsList extends ListView {

    private static final SimpleDateFormat formater
            = new SimpleDateFormat("HH:mm:ss");

    /**
     * Defines the constructor of the actionslist with its size.
     */
    public ActionsList() {
        this.setPrefHeight(280);
        this.setPrefWidth(280);
    }

    /**
     * Defines the message to add on the actionslist with the given direction.
     *
     * @param direction the given direction to display in the actionslist
     */
    public void updateDisplacement(Direction direction) {
        String dateNow = formater.format(new Date());
        var str = new StringBuilder(dateNow);

        switch (direction) {
            case RIGHT:
                str.append(" - Glisse à droite");
                break;
            case LEFT:
                str.append(" - Glisse à gauche");
                break;
            case BOTTOM:
                str.append(" - Glisse en bas");
                break;
            case TOP:
                str.append(" - Glisse en haut");
                break;
            case INVALID:
                str.append(" - Glisse invalide");
        }
        this.getItems().add(0, str);
    }

    /**
     * Defines the message to add on the actionslist with the given status.
     *
     * @param status the given status to display in the actionslist.
     */
    public void updateStatus(GameStatus status) {
        String dateNow = formater.format(new Date());
        var str = new StringBuilder(dateNow);

        switch (status) {
            case LOST:
                str.append(" - Vous avez perdu");
                break;
            case WON:
                str.append(" - Vous avez gagné");
                break;
            case STARTED:
                this.getItems().clear();
                str.append(" - Bonne chance !");
        }
        this.getItems().add(0, str);
    }
}
