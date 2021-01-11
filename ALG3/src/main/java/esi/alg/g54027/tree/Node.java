package esi.alg.g54027.tree;

import java.util.LinkedList;
import java.util.List;
// class don't work, just for use method with color

public class Node<T> {
    private T value;
    private List<Node<T>> kinds;

    public Node(T value) {
        this.value = value;
        kinds = new LinkedList<Node<T>>();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getNbChildren() {
        return kinds.size();
    }

    public Node<T> getKinds(int i) {
        return kinds.get(i);
    }

    public void setKinds(int i, Node<T> newKind) {
        kinds.set(i, newKind);
    }

    public void addKind(Node<T> newKind) {
        kinds.add(newKind);
    }

    public void removeKind(int i) {
        kinds.remove(i);
    }
}
