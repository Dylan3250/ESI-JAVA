package esi.atl.g54027.td07.observer.dp;

/**
 *
 * @author aro
 */
public interface Observable {

    public void registerObserver(Observer obs);

    public void removeObserver(Observer obs);

    public void notifyObservers();

}
