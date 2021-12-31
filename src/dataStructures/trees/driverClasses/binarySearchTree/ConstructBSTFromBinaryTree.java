package dataStructures.trees.driverClasses.binarySearchTree;

import dataStructures.trees.driverClasses.utils.BinaryTreeUtil;
import dataStructures.trees.modals.BinarySearchTree;
import dataStructures.trees.modals.BinaryTree;
import dataStructures.trees.modals.BinaryTreeNode;

import java.util.List;

public class ConstructBSTFromBinaryTree {
    public static void main(String[] args) {
        final BinaryTreeUtil<BinaryTree<Integer>, BinaryTreeNode<Integer>, Integer> binaryTreeUtil = new BinaryTreeUtil<>();
        final BinaryTreeUtil<BinaryTree<Integer>, BinaryTreeNode<Integer>, Integer> binarySearchTreeUtil = new BinaryTreeUtil<>();

        BinaryTree<Integer> binaryTree = new BinaryTree<>(new BinaryTreeNode<>(10));
        binaryTree.getRoot().setLeft(new BinaryTreeNode<>(30));
        binaryTree.getRoot().setRight(new BinaryTreeNode<>(15));
        binaryTree.getRoot().getLeft().setLeft(new BinaryTreeNode<>(20));
        binaryTree.getRoot().getRight().setRight(new BinaryTreeNode<>(5));

        List<Integer> originalInOrder = binaryTreeUtil.getTreeRepresentation("inorder", binaryTree);
        BinarySearchTree<Integer> createdBst = new BinarySearchTree<Integer>(binaryTree);
        List<Integer> newInOrder = binarySearchTreeUtil.getTreeRepresentation("inorder", createdBst);
        System.out.println("Original inorder");
        originalInOrder.forEach(el -> System.out.print(el + " "));
        System.out.println();
        System.out.println("New inorder");
        newInOrder.forEach(el -> System.out.print(el + " "));
    }
}
