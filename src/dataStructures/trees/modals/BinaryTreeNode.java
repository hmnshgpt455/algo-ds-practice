package dataStructures.trees.modals;

import dataStructures.trees.driverClasses.abstraction.AbstractBinaryTreeNode;

public class BinaryTreeNode<T> extends AbstractBinaryTreeNode<T, BinaryTreeNode<T>> {

    public BinaryTreeNode(T value) {
        super(value);
    }

    public BinaryTreeNode() {
        super();
    }
}
