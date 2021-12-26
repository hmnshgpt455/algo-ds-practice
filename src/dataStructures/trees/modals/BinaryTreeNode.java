package dataStructures.trees.modals;

public class BinaryTreeNode<T> implements TreeNode {

    private BinaryTreeNode<T> right;
    private BinaryTreeNode<T> left;
    private T value;

    public BinaryTreeNode(BinaryTreeNode<T> right, BinaryTreeNode<T> left, T value) {
        this.right = right;
        this.left = left;
        this.value = value;
    }

    public BinaryTreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode() {
        this.left = null;
        this.right = null;
        this.value = null;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
