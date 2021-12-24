package dataStructures.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BinaryTree implements Tree {

    private BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTree(int value) {
        this.root = new BinaryTreeNode(value);
    }

    public BinaryTree() {
        this.root = null;
    }

    List<Integer> getTreeRepresentation(String traversalType) {
        List<Integer> inOrderRepresentation = new ArrayList<>();
        switch (traversalType) {
            case "inorder":
                inOrderTraversal(inOrderRepresentation, this.getRoot());
                break;
            case "preorder":
                preOrderTraversal(inOrderRepresentation, this.getRoot());
                break;
            case "postorder":
                postOrderTraversal(inOrderRepresentation, this.getRoot());
                break;
        }

        return inOrderRepresentation;
    }

    private void postOrderTraversal(List<Integer> representation, BinaryTreeNode root) {
        Optional.ofNullable(root).ifPresent(r -> {
            Optional.ofNullable(root.getLeft()).ifPresent(left -> postOrderTraversal(representation, left));
            Optional.ofNullable(root.getRight()).ifPresent(right -> postOrderTraversal(representation, right));
            Optional.ofNullable(root.getValue()).ifPresent(representation::add);
        });
    }

    private void preOrderTraversal(List<Integer> representation, BinaryTreeNode root) {
        Optional.ofNullable(root).ifPresent(r -> {
            Optional.ofNullable(root.getValue()).ifPresent(representation::add);
            Optional.ofNullable(root.getLeft()).ifPresent(left -> preOrderTraversal(representation, left));
            Optional.ofNullable(root.getRight()).ifPresent(right -> preOrderTraversal(representation, right));
        });
    }

    private void inOrderTraversal(List<Integer> representation, BinaryTreeNode root) {
        Optional.ofNullable(root).ifPresent(r -> {
            Optional.ofNullable(root.getLeft()).ifPresent(left -> inOrderTraversal(representation, left));
            Optional.ofNullable(root.getValue()).ifPresent(representation::add);
            Optional.ofNullable(root.getRight()).ifPresent(right -> inOrderTraversal(representation, right));
        });
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }
}
