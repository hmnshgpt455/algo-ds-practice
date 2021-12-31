package dataStructures.trees.modals;

public class BinaryTreeNode<T> extends AbstractBinaryTreeNode<T, BinaryTreeNode<T>> {

    public BinaryTreeNode(T value) {
        super(value);
    }

    public BinaryTreeNode() {
        super();
    }
}
