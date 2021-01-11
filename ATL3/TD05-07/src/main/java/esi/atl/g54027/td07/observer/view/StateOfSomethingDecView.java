package esi.atl.g54027.td07.observer.view;

import esi.atl.g54027.td07.observer.dp.Observable;

/**
 *
 * @author aro
 */
public class StateOfSomethingDecView extends StateOfSomethingView {

    public StateOfSomethingDecView(Observable observable) {
        super(observable);
    }

    @Override
    String stateStr(int state) {
        return "Décimal : " + Integer.toString(state);
    }

}
