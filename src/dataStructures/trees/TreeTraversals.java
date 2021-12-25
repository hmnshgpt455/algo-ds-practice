package dataStructures.trees;

import java.util.List;

public class TreeTraversals {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.getRoot().setLeft(new BinaryTreeNode<>(2));
        tree.getRoot().setRight(new BinaryTreeNode<>(3));
        tree.getRoot().getLeft().setLeft(new BinaryTreeNode<>(4));
        tree.getRoot().getLeft().setRight(new BinaryTreeNode<>(5));

        List<Integer> inOrderRepresentation = tree.getTreeRepresentation("inorder");
        List<Integer> preOrderRepresentation = tree.getTreeRepresentation("preorder");
        List<Integer> postOrderRepresentation = tree.getTreeRepresentation("postorder");

        inOrderRepresentation.forEach(System.out::print);
        System.out.println();
        preOrderRepresentation.forEach(System.out::print);
        System.out.println();
        postOrderRepresentation.forEach(System.out::print);
        System.out.println();
    }
}
