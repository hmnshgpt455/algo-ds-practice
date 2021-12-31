package dataStructures.trees.driverClasses.binaryTree;

import dataStructures.trees.driverClasses.utils.BinaryTreeUtil;
import dataStructures.trees.modals.BinaryTree;
import dataStructures.trees.modals.BinaryTreeNode;

import java.util.List;

public class TreeTraversals {

    public static void main(String[] args) {
        final BinaryTreeUtil<BinaryTree<Integer>, BinaryTreeNode<Integer>, Integer> binaryTreeUtil = new BinaryTreeUtil<>();
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.getRoot().setLeft(new BinaryTreeNode<>(2));
        tree.getRoot().setRight(new BinaryTreeNode<>(3));
        tree.getRoot().getLeft().setLeft(new BinaryTreeNode<>(4));
        tree.getRoot().getLeft().setRight(new BinaryTreeNode<>(5));

        List<Integer> inOrderRepresentation = binaryTreeUtil.getTreeRepresentation("inorder", tree);
        List<Integer> preOrderRepresentation = binaryTreeUtil.getTreeRepresentation("preorder", tree);
        List<Integer> postOrderRepresentation = binaryTreeUtil.getTreeRepresentation("postorder", tree);
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
