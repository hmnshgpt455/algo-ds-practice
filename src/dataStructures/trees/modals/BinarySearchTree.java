package dataStructures.trees.modals;

import java.util.List;

public class BinarySearchTree<T> extends BinaryTree<T> {

    private int preIndex;

    @SuppressWarnings("unchecked")
    public BinarySearchTree(List<Integer> preOrder) {
        preIndex = 0;
        this.root = (BinaryTreeNode<T>) constructTreeUsingPreOrder(preOrder, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private BinaryTreeNode<Integer> constructTreeUsingPreOrder(List<Integer> preOrder, int maxValue, int minValue) {
        if (preIndex >= preOrder.size()) {
            return null;
        }

        int currentElement = preOrder.get(preIndex);

        if (currentElement <= maxValue && currentElement >= minValue) {
            BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preOrder.get(preIndex++));

            if (preIndex < preOrder.size()) {
                //Construct the left subtree
                root.setLeft(constructTreeUsingPreOrder(preOrder, currentElement, minValue));
            }

            if (preIndex < preOrder.size()) {
                //Construct the right subtree
                root.setRight(constructTreeUsingPreOrder(preOrder, maxValue, currentElement));
            }

            return root;
        }

        return null;
    }
}
