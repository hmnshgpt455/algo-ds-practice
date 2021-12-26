package dataStructures.trees.driverClasses.binarySearchTree;

import dataStructures.trees.modals.BinarySearchTree;
import dataStructures.trees.modals.BinaryTree;
import dataStructures.trees.modals.BinaryTreeNode;

import java.util.List;

public class ConstructBSTFromBinaryTree {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(new BinaryTreeNode<>(10));
        binaryTree.getRoot().setLeft(new BinaryTreeNode<>(30));
        binaryTree.getRoot().setRight(new BinaryTreeNode<>(15));
        binaryTree.getRoot().getLeft().setLeft(new BinaryTreeNode<>(20));
        binaryTree.getRoot().getRight().setRight(new BinaryTreeNode<>(5));

        List<Integer> originalInOrder = binaryTree.getTreeRepresentation("inorder");
        BinarySearchTree<Integer> createdBst = new BinarySearchTree<Integer>(binaryTree, Integer::compareTo);
        List<Integer> newInOrder = createdBst.getTreeRepresentation("inorder");
        System.out.println("Original inorder");
        originalInOrder.forEach(el -> System.out.print(el + " "));
        System.out.println();
        System.out.println("New inorder");
        newInOrder.forEach(el -> System.out.print(el + " "));
    }
}
