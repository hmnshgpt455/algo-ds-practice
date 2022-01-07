package dataStructures.driverClasses.binarySearchTree;

import dataStructures.driverClasses.utils.BinaryTreeUtil;
import dataStructures.impl.trees.BinarySearchTree;
import dataStructures.impl.trees.BinaryTree;
import dataStructures.modals.trees.nodes.BinaryTreeNode;

import java.util.List;

public class ConstructBSTFromBinaryTree {
    public static void main(String[] args) {
        final BinaryTreeUtil<BinaryTreeNode<Integer>, Integer> binaryTreeUtil = new BinaryTreeUtil<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(new BinaryTreeNode<>(10));
        binaryTree.getRoot().setLeft(new BinaryTreeNode<>(30));
        binaryTree.getRoot().setRight(new BinaryTreeNode<>(15));
        binaryTree.getRoot().getLeft().setLeft(new BinaryTreeNode<>(20));
        binaryTree.getRoot().getRight().setRight(new BinaryTreeNode<>(5));

        List<Integer> originalInOrder = binaryTreeUtil.getInOrderTraversal(binaryTree);
        BinarySearchTree<Integer> createdBst = new BinarySearchTree<Integer>(binaryTree);
        List<Integer> newInOrder = binaryTreeUtil.getInOrderTraversal(createdBst);
        System.out.println("Original inorder");
        originalInOrder.forEach(el -> System.out.print(el + " "));
        System.out.println();
        System.out.println("New inorder");
        newInOrder.forEach(el -> System.out.print(el + " "));
    }
}
