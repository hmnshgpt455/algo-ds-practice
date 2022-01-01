package dataStructures.trees.modals.trees.nodes;

import dataStructures.trees.abstraction.AbstractBinaryTreeNode;

public class RedBlackTreeNode<T extends Comparable<? super T>>
        extends AbstractBinaryTreeNode<T, RedBlackTreeNode<T>> {

    char color;
    RedBlackTreeNode<T> parent;

    public RedBlackTreeNode(T value) {
        super(value);
        color = 'R';
        parent = null;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public RedBlackTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(RedBlackTreeNode<T> parent) {
        this.parent = parent;
    }
}
