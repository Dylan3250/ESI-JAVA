package esi.atl.g54027.td07.observer.model;

import esi.atl.g54027.td07.observer.dp.Observable;
import esi.atl.g54027.td07.observer.dp.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SomethingWithAState implements Observable {

    private int state;
    private Random random;

    private final List<Observer> observers;

    public SomethingWithAState() {
        observers = new ArrayList<>();
        random = new Random();
    }

    public int getState() {
        return state;
    }

    public void changeState() {
        state = random.nextInt(10000);
        notifyObservers();
    }

    @Override
    public String toString() {
        return "state=" + state;
    }

    @Override
    public void registerObserver(Observer obs) {
        if (!observers.contains(obs)) {
            observers.add(obs);
        }
    }

    @Override
    public void removeObserver(Observer obs) {
        if (observers.contains(obs)) {
            observers.remove(obs);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update();
        }
    }

}
