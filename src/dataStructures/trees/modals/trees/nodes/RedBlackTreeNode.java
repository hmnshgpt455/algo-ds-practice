package dataStructures.trees.modals.trees.nodes;

import dataStructures.trees.abstraction.trees.AbstractBinaryTreeNode;
import dataStructures.trees.impl.trees.RedBlackTree;

public class RedBlackTreeNode<T extends Comparable<? super T>>
        extends AbstractBinaryTreeNode<T, RedBlackTreeNode<T>> {

    char color;
    RedBlackTreeNode<T> parent;


    public RedBlackTreeNode(char color, T value) {
        super(value);
        this.color = color;
    }

    public RedBlackTreeNode(T value) {
        super(value);
        color = 'B';
        parent = null;
    }

    public RedBlackTreeNode(T value, RedBlackTreeNode<T> parent) {
        super(value);
        this.parent = parent;
        this.color = 'R';
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
