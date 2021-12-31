package dataStructures.trees.driverClasses.utils;

import dataStructures.trees.modals.AbstractBinaryTreeNode;
import dataStructures.trees.modals.AbstractTree;

import java.util.*;

public class BinaryTreeUtil<V extends
        AbstractTree<G, ? super V, T>, G extends AbstractBinaryTreeNode<T, G>, T> {

     public List<T> getTreeRepresentation(String traversalType, AbstractTree<G, ?, T> tree) {
        List<T> inOrderRepresentation = new ArrayList<>();
        switch (traversalType) {
            case "inorder":
                inOrderTraversal(inOrderRepresentation, tree.getRoot());
                break;
            case "preorder":
                preOrderTraversal(inOrderRepresentation, tree.getRoot());
                break;
            case "postorder":
                postOrderTraversal(inOrderRepresentation, tree.getRoot());
                break;
        }

        return inOrderRepresentation;
    }

    private void postOrderTraversal(List<T> representation, G root) {
        Optional.ofNullable(root).ifPresent(r -> {
            Optional.ofNullable(root.getLeft()).ifPresent(left -> postOrderTraversal(representation, left));
            Optional.ofNullable(root.getRight()).ifPresent(right -> postOrderTraversal(representation, right));
            Optional.ofNullable(root.getValue()).ifPresent(representation::add);
        });
    }

    private void preOrderTraversal(List<T> representation, G root) {
        Optional.ofNullable(root).ifPresent(r -> {
            Optional.ofNullable(root.getValue()).ifPresent(representation::add);
            Optional.ofNullable(root.getLeft()).ifPresent(left -> preOrderTraversal(representation, left));
            Optional.ofNullable(root.getRight()).ifPresent(right -> preOrderTraversal(representation, right));
        });
    }

    private  void inOrderTraversal(List<T> representation, G root) {
        Optional.ofNullable(root).ifPresent(r -> {
            Optional.ofNullable(root.getLeft()).ifPresent(left -> inOrderTraversal(representation, left));
            Optional.ofNullable(root.getValue()).ifPresent(representation::add);
            Optional.ofNullable(root.getRight()).ifPresent(right -> inOrderTraversal(representation, right));
        });
    }

    public List<T> getLevelOrderTraversal(G root) {
        List<T> levelOrderRepresentation = new ArrayList<>();
        Queue<G> levelOrderQueue = new LinkedList<>();
        levelOrderQueue.add(root);
        levelOrderTraversal(levelOrderQueue, levelOrderRepresentation);

        return levelOrderRepresentation;
    }

    private void levelOrderTraversal(Queue<G> nodeQueue, List<T> levelOrderRepresentation) {
        if (!nodeQueue.isEmpty()) {
            G currentNode = nodeQueue.poll();

            levelOrderRepresentation.add(currentNode.getValue());

            Optional.ofNullable(currentNode.getLeft()).ifPresent(nodeQueue::add);
            Optional.ofNullable(currentNode.getRight()).ifPresent(nodeQueue::add);
            levelOrderTraversal(nodeQueue, levelOrderRepresentation);
        }
    }
}
