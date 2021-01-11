package esi.alg.g54027.list;

import esi.alg.g54027.list.ElementList;

public class ListeChainee<T> {

    private ElementList<T> premier;

    public ListeChainee() {
        this.premier = null;
    }

    public ElementList<T> getPremier() {
        return premier;
    }

    public void setPremier(ElementList<T> premier) {
        this.premier = premier;
    }

    public boolean estVide() {
        return premier == null;
    }

    public void insererTete(T val) {
        premier = new ElementList(val, premier);
    }

    public void supprimerTete() {
        if (premier == null) {
            throw new IllegalArgumentException("La liste est vide");
        }
        premier = premier.getSuivant();
    }

    public void insererAprès(ElementList<T> elt, T val) {
        if (elt == null) {
            throw new IllegalArgumentException("L'élement est vide");
        }
        ElementList<T> eltInserer = new ElementList(val, elt.getSuivant());
        elt.setSuivant(eltInserer);
    }

    public void supprimerAprès(ElementList<T> elt) {
        if (elt == null) {
            throw new IllegalArgumentException("Element inexistant");
        } else if (elt.getSuivant() == null) {
            throw new IllegalArgumentException("Element suivant null");
        }

        elt.setSuivant(elt.getSuivant().getSuivant());
    }

    public int size() {
        ElementList<T> listTotal = premier;
        int count = 0;
        while (listTotal != null) {
            count += 1;
            listTotal = listTotal.getSuivant();
        }
        return count;
    }

    @Override
    public String toString() {
        ElementList<T> listTotal = premier;
        String s = "";
        while (listTotal != null) {
            s += listTotal.getValeur() + ", ";
            listTotal = listTotal.getSuivant();
        }
        return s;
    }
}
