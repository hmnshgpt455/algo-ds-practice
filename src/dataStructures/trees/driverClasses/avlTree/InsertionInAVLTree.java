package dataStructures.trees.driverClasses.avlTree;

import dataStructures.trees.modals.AVLTree;

import java.util.List;

public class InsertionInAVLTree {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insertKey(10).insertKey(20).insertKey(30).insertKey(40).insertKey(50).insertKey(25).insertKey(55).insertKey(60).insertKey(100)
                .insertKey(110).insertKey(120);

        List<Integer> preOrder = avlTree.getTreeRepresentation("preorder");
        preOrder.forEach(el -> System.out.print(el + " "));
    }
}
