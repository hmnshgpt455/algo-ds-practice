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
        List<Integer> levelOrderRepresentation = tree.getLevelOrderTraversal();

        System.out.print("Inorder --> ");
        inOrderRepresentation.forEach(System.out::print);
        System.out.println();
        System.out.print("Preorder --> ");
        preOrderRepresentation.forEach(System.out::print);
        System.out.println();
        System.out.print("Postorder --> ");
        postOrderRepresentation.forEach(System.out::print);
        System.out.println();
        System.out.print("Levelorder --> ");
        levelOrderRepresentation.forEach(System.out::print);
    }
}
