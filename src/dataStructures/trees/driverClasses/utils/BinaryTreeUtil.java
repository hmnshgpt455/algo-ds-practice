package dataStructures.trees.driverClasses.utils;

import dataStructures.trees.abstraction.AbstractBinaryTreeNode;
import dataStructures.trees.abstraction.AbstractTree;

import java.util.*;

public class BinaryTreeUtil<G extends AbstractBinaryTreeNode<T, G>, T> {

    public List<T> getPostOrderTraversal(AbstractTree<G, T> tree) {
        List<T> representation = new ArrayList<>();
        postOrderTraversal(tree.getRoot(), representation);
        return representation;
    }

    private void postOrderTraversal(G root, List<T> representation) {
        Optional.ofNullable(root).ifPresent(r -> {
            Optional.ofNullable(root.getLeft()).ifPresent(left -> postOrderTraversal(left, representation));
            Optional.ofNullable(root.getRight()).ifPresent(right -> postOrderTraversal(right, representation));
            Optional.ofNullable(root.getValue()).ifPresent(representation::add);
        });
    }

    public List<T> getPreOrderTraversal(AbstractTree<G, T> tree) {
        List<T> representation = new ArrayList<>();
        preOrderTraversal(tree.getRoot(), representation);
        return representation;
    }

    private void preOrderTraversal(G root, List<T> representation) {
        Optional.ofNullable(root).ifPresent(r -> {
            Optional.ofNullable(root.getValue()).ifPresent(representation::add);
            Optional.ofNullable(root.getLeft()).ifPresent(left -> preOrderTraversal(left, representation));
            Optional.ofNullable(root.getRight()).ifPresent(right -> preOrderTraversal(right, representation));
        });
    }

    public List<T> getInOrderTraversal(AbstractTree<G, T> tree) {
        List<T> representation = new ArrayList<>();
        inOrderTraversal(representation, tree.getRoot());
        return representation;
    }

    private void inOrderTraversal(List<T> representation, G root) {
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
