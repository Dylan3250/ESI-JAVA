package esi.atl.g54027.threelayers.view;

import esi.atl.g54027.threelayers.model.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author jlc
 */
public class ButtonHandler implements EventHandler<ActionEvent> {

    private Model model;
    private View view;

    public ButtonHandler(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void handle(ActionEvent t) {
        System.out.println("DEBUG | VIEW       | On appuie sur le bouton");
        view.disableBouton();
        model.compute();
        view.setColorYellow();
        view.setNumber(model.getData());
    }

}
