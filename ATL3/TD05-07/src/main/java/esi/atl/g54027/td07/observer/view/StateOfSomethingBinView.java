package esi.atl.g54027.td07.observer.view;

import esi.atl.g54027.td07.observer.dp.Observable;

/**
 *
 * @author aro
 */
public class StateOfSomethingBinView extends StateOfSomethingView {

    public StateOfSomethingBinView(Observable observable) {
        super(observable);
    }

    @Override
    String stateStr(int state) {
        return "Binaire : " + Integer.toBinaryString(state);
    }

}
