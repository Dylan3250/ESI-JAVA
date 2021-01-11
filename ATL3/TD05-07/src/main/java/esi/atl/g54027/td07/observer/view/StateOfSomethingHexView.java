package esi.atl.g54027.td07.observer.view;

import esi.atl.g54027.td07.observer.dp.Observable;

/**
 *
 * @author aro
 */
public class StateOfSomethingHexView extends StateOfSomethingView {

    public StateOfSomethingHexView(Observable observable) {
        super(observable);
    }

    @Override
    String stateStr(int state) {
        return "Hexadécimal : " + Integer.toHexString(state);
    }

}
