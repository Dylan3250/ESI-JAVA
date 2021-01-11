package esi.alg.g54027.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
    public static Tree<Integer> initTree() {
        //        10
        //    5        2
        //  8   9    1
        var racine = new Node<>(10);
        var n1_left = new Node<>(5);
        var n2_right = new Node<>(2);
        racine.addKind(n1_left);
        racine.addKind(n2_right);
        var n3_left = new Node<>(8);
        var n4_left = new Node<>(9);
        n1_left.addKind(n3_left);
        n1_left.addKind(n4_left);
        var n5_right = new Node<>(1);
        n2_right.addKind(n5_right);
        Tree<Integer> tree = new Tree<>(0);
        tree.setRacine(racine);
        return tree;
    }

    public static void courseWidth(Tree<Integer> tree) {
        var queue = new ArrayDeque<Node<Integer>>();
        Node<Integer> currentNode;

        if (tree.getRacine() != null) {
            queue.add(tree.getRacine());
            // System.out.println(tree.getRacine().getValue());
        }

        while (!queue.isEmpty()) {
            currentNode = queue.pop();
            for (int i = 0; i < currentNode.getNbChildren(); i++) {
                // System.out.println(currentNode.getKinds(i).getValue());
                queue.add(currentNode.getKinds(i));
            }
        }
    }

    public static void courseHeight(Tree<Integer> tree) {
        if (tree.getRacine() != null) {
            // System.out.println(tree.getRacine().getValue());
            algoCourseHeight(tree.getRacine());
        }
    }

    private static void algoCourseHeight(Node<Integer> node) {
        for (int i = 0; i < node.getNbChildren(); i++) {
            // System.out.println(node.getKinds(i).getValue());
            algoCourseHeight(node.getKinds(i));
        }
    }

    public static void searchBinaryOXO(Tree<Character> tree) {
        if (tree.getRacine() != null) {
            algoSearchBinaryOXO(tree.getRacine());
        }
    }

    private static void algoSearchBinaryOXO(Node<Character> node) {
        boolean isMaybeOXO = node.getValue() == 'X';
        for (int i = 0; i < node.getNbChildren(); i++) {
            if (isMaybeOXO
                    && i + 1 < node.getNbChildren()
                    && node.getKinds(i).getValue() == 'O'
                    && node.getKinds(i + 1).getValue() == 'O') {
            } else {
                algoSearchBinaryOXO(node.getKinds(i));
            }
        }
    }

    public static boolean isSymetric(Tree<Integer> tree) {
        return true;
    }

    public static void main(String[] args) {
        Tree<Integer> tree = initTree();
        // courseWidth(tree);
        // searchBinaryOXO(tree);
        System.out.println(isSymetric(tree));
    }
}
