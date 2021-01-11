package esi.atl.g54027.td07.observer.view;

import esi.atl.g54027.td07.observer.dp.Observable;
import esi.atl.g54027.td07.observer.dp.Observer;
import esi.atl.g54027.td07.observer.model.SomethingWithAState;
import javafx.geometry.Insets;
import javafx.scene.control.Label;

/**
 *
 * @author aro
 */
public abstract class StateOfSomethingView extends Label implements Observer {

    private SomethingWithAState observable;

    public StateOfSomethingView(Observable observable) {
        if (observable == null) {
            throw new IllegalArgumentException("Nothing to observe");
        }
        this.observable = (SomethingWithAState)observable;
        setPadding(new Insets(15.0));
        observable.registerObserver(this);
    }

    abstract String stateStr(int state);
    
    @Override
    public void update() {
        setText(stateStr(observable.getState()));
    }
    
}
