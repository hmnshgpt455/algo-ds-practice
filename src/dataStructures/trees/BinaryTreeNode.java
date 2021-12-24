package dataStructures.trees;

public class BinaryTreeNode implements TreeNode {

    private BinaryTreeNode right;
    private BinaryTreeNode left;
    private Integer value;

    public BinaryTreeNode(BinaryTreeNode right, BinaryTreeNode left, Integer value) {
        this.right = right;
        this.left = left;
        this.value = value;
    }

    public BinaryTreeNode(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }
}
