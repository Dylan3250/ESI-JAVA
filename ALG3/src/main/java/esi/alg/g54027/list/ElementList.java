package esi.alg.g54027.list;

public class ElementList<T> {

    private T valeur;
    private ElementList<T> suivant;

    public ElementList(T val, ElementList<T> elt) {
        this.valeur = val;
        this.suivant = elt;
    }

    public ElementList(T val) {
        this.valeur = val;
        this.suivant = null;
    }

    public T getValeur() {
        return valeur;
    }

    public void setValeur(T valeur) {
        this.valeur = valeur;
    }

    public ElementList<T> getSuivant() {
        return suivant;
    }

    public void setSuivant(ElementList<T> suivant) {
        this.suivant = suivant;
    }
}
