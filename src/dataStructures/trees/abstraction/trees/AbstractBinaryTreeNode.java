package dataStructures.trees.abstraction.trees;

public abstract class AbstractBinaryTreeNode<T, N extends AbstractBinaryTreeNode<T, N>> {
    protected N left;
    protected N right;
    protected T value;

    public AbstractBinaryTreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public AbstractBinaryTreeNode() {
        this.left = null;
        this.right = null;
        this.value = null;
    }

    public N getLeft() {
        return left;
    }

    public void setLeft(N left) {
        this.left = left;
    }

    public N getRight() {
        return right;
    }

    public void setRight(N right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
