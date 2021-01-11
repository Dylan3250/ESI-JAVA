package esi.alg.g54027.list;

public class ElementListeBD<T> {

    private T valeur;
    private ElementListeBD<T> suivant;
    private ElementListeBD<T> precedent;

    public ElementListeBD(T valeur, ElementListeBD<T> suivant, ElementListeBD<T> precedent) {
        this.valeur = valeur;
        this.suivant = suivant;
        this.precedent = precedent;
    }

    public ElementListeBD(T valeur) {
        this.valeur = valeur;
        this.suivant = null;
        this.precedent = null;
    }

    public T getValeur() {
        return valeur;
    }

    public void setValeur(T valeur) {
        this.valeur = valeur;
    }

    public ElementListeBD<T> getSuivant() {
        return suivant;
    }

    public void setSuivant(ElementListeBD<T> suivant) {
        this.suivant = suivant;
    }

    public ElementListeBD<T> getPrecedent() {
        return precedent;
    }

    public void setPrecedent(ElementListeBD<T> precedent) {
        this.precedent = precedent;
    }
}
