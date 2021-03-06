package dataStructures.driverClasses.binaryTree;

import dataStructures.driverClasses.utils.BinaryTreeUtil;
import dataStructures.impl.trees.BinaryTree;
import dataStructures.modals.trees.nodes.BinaryTreeNode;

import java.util.List;

public class TreeTraversals {

    public static void main(String[] args) {
        final BinaryTreeUtil<BinaryTreeNode<Integer>, Integer> binaryTreeUtil = new BinaryTreeUtil<>();
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.getRoot().setLeft(new BinaryTreeNode<>(2));
        tree.getRoot().setRight(new BinaryTreeNode<>(3));
        tree.getRoot().getLeft().setLeft(new BinaryTreeNode<>(4));
        tree.getRoot().getLeft().setRight(new BinaryTreeNode<>(5));

        List<Integer> inOrderRepresentation = binaryTreeUtil.getInOrderTraversal(tree);
        List<Integer> preOrderRepresentation = binaryTreeUtil.getPreOrderTraversal(tree);
        List<Integer> postOrderRepresentation = binaryTreeUtil.getPostOrderTraversal(tree);
        List<Integer> levelOrderRepresentation = binaryTreeUtil.getLevelOrderTraversal(tree.getRoot());

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
