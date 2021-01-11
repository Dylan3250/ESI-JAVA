package esi.alg.g54027.list;

public class ListeBD<T> {

    private ElementListeBD<T> premier;
    private ElementListeBD<T> dernier;

    public ListeBD() {
        this.premier = null;
        this.dernier = null;
    }

    public ElementListeBD<T> getPremier() {
        return premier;
    }

    public void setPremier(ElementListeBD<T> premier) {
        this.premier = premier;
    }

    public ElementListeBD<T> getDernier() {
        return dernier;
    }

    public void setDernier(ElementListeBD<T> dernier) {
        this.dernier = dernier;
    }

    public boolean estVide() {
        return premier == null;
    }

    public void insererTete(T val) {
        ElementListeBD<T> newElt = new ElementListeBD(val, premier, null);
        if (!estVide()) {
            premier.setPrecedent(newElt);
        } else {
            dernier = newElt;
        }
        premier = newElt;
    }

    public void insererFin(T val) {
        ElementListeBD<T> newElt = new ElementListeBD(val, null, dernier);
        if (!estVide()) {
            dernier.setSuivant(newElt);
        } else {
            premier = newElt;
        }
        dernier = newElt;
    }

    public void insererApres(ElementListeBD<T> elt, T val) {
        if (elt == null || elt == dernier) {
            insererFin(val);
        } else {
            ElementListeBD<T> newElt = new ElementListeBD(val, elt.getSuivant(), elt);
            elt.setSuivant(newElt);
            elt.getSuivant().setPrecedent(elt);
        }
    }

    public void insererAvant(ElementListeBD<T> elt, T val) {
        if (elt == null || elt == premier) {
            insererTete(val);
        } else {
            ElementListeBD<T> newElt = new ElementListeBD(val, elt, elt.getPrecedent());
            elt.getPrecedent().setSuivant(newElt);
            elt.setPrecedent(newElt);
        }
    }

    public void supprimerTête() {
        if (!estVide() && dernier != premier) {
            premier = premier.getSuivant();
            premier.setPrecedent(null);
        } else if (premier == dernier) {
            premier = dernier = null;
        } else if (estVide()) {
            throw new IllegalArgumentException("Liste déjà vide");
        }
    }

    public void supprimerFin() {
        if (!estVide() && dernier != premier) {
            dernier = dernier.getPrecedent();
            dernier.setSuivant(null);
        } else if (premier == dernier) {
            premier = dernier = null;
        } else if (estVide()) {
            throw new IllegalArgumentException("Liste déjà vide");
        }
    }

    public void supprimer(ElementListeBD<T> elt) {
        if (elt == premier) {
            supprimerTête();
        } else if (elt == dernier) {
            supprimerFin();
        } else {
            elt.getPrecedent().setSuivant(elt.getSuivant());
            elt.getSuivant().setPrecedent(elt.getPrecedent());
        }
    }

    @Override
    public String toString() {
        ElementListeBD<T> listTotal = premier;
        String s = "";
        while (listTotal != null) {
            s += listTotal.getValeur() + ", ";
            listTotal = listTotal.getSuivant();
        }
        return s;
    }
}
