package esi.atl.g54027.mvvm.view;

import esi.atl.g54027.mvvm.model.ViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author jlc
 */
public class ButtonHandler implements EventHandler<ActionEvent> {

    private ViewModel viewModel;

    public ButtonHandler(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void handle(ActionEvent t) {
        System.out.println("DEBUG | VIEW       | On appuie sur le bouton");
        viewModel.doSomething();
    }

}
