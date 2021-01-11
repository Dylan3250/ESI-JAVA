package esi.atl.g54027.td07.observer.view;

import esi.atl.g54027.td07.observer.dp.Observable;

/**
 *
 * @author aro
 */
public class StateOfSomethingOctView extends StateOfSomethingView {

    public StateOfSomethingOctView(Observable observable) {
        super(observable);
    }

    @Override
    String stateStr(int state) {
        return "Octale : " + Integer.toOctalString(state);
    }

}
