package dataStructures.trees.modals;

public class AVLTreeNode<T extends Comparable<? super T>> extends BinaryTreeNode<T> {

    private int height;
    private AVLTreeNode<T> left;
    private AVLTreeNode<T> right;

    public AVLTreeNode() {
    }

    public AVLTreeNode(T value) {
        this.height = 0;
        this.left = null;
        this.right = null;
        this.value = value;
    }

    public AVLTreeNode(T value, int height) {
        this.height = height;
        this.value = value;
        this.right = null;
        this.left = null;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public AVLTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode<T> left) {
        this.left = left;
    }

    @Override
    public AVLTreeNode<T> getRight() {
        return right;
    }

    public void setRight(AVLTreeNode<T> right) {
        this.right = right;
    }

    public void incrementHeight() {
        this.height++;
    }
}
