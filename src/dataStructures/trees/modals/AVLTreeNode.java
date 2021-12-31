package dataStructures.trees.modals;

public class AVLTreeNode<T extends Comparable<? super T>> extends AbstractBinaryTreeNode<T, AVLTreeNode<T>> {

    private int height;

    public AVLTreeNode() {
        super();
    }

    public AVLTreeNode(T value) {
        super(value);
        this.height = 0;
    }

    public AVLTreeNode(T value, int height) {
        super(value);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
