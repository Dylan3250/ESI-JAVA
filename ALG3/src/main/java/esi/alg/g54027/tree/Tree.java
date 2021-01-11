package esi.alg.g54027.tree;
// class don't work, just for use method with color

public class Tree<T> {
    private Node<T> racine;

    public Tree(T value) {
        this.racine = new Node<T>(value);
    }

    public Node<T> getRacine(){
        return racine;
    }

    public void setRacine(Node<T> newRacine) {
        racine = newRacine;
    }
}
