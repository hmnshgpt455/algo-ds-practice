package dataStructures.trees.modals.trees.nodes;

import dataStructures.trees.abstraction.trees.AbstractBinaryTreeNode;

public class BinaryTreeNode<T> extends AbstractBinaryTreeNode<T, BinaryTreeNode<T>> {

    public BinaryTreeNode(T value) {
        super(value);
    }

    public BinaryTreeNode() {
        super();
    }
}
