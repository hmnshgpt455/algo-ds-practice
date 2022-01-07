package dataStructures.modals.trees.nodes;

import dataStructures.abstraction.trees.AbstractBinaryTreeNode;

public class BinaryTreeNode<T> extends AbstractBinaryTreeNode<T, BinaryTreeNode<T>> {

    public BinaryTreeNode(T value) {
        super(value);
    }

    public BinaryTreeNode() {
        super();
    }
}
