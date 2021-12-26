package dataStructures.trees.modals;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> {

    private int preIndex;

    public BinarySearchTree(List<T> preOrder, Comparator<T> comparator) {
        preIndex = 0;
        T max = null, min = null;
        for (int i = 0; i<preOrder.size(); i++) {
            if (i == 0) {
                max = min = preOrder.get(i);
            } else {
                if (comparator.compare(preOrder.get(i), max) > 0) {
                    max = preOrder.get(i);
                } else if (comparator.compare(preOrder.get(i), min) < 0) {
                    min = preOrder.get(i);
                }
            }
        }
        this.root = constructTreeUsingPreOrder(preOrder, max, min, comparator);
    }

    private BinaryTreeNode<T> constructTreeUsingPreOrder(List<T> preOrder, T maxValue, T minValue, Comparator<T> comparator) {
        if (preIndex >= preOrder.size()) {
            return null;
        }

        T currentElement = preOrder.get(preIndex);

        if ((comparator.compare(currentElement, maxValue) <= 0) && (comparator.compare(currentElement, minValue) >= 0)) {
            BinaryTreeNode<T> root = new BinaryTreeNode<>(preOrder.get(preIndex++));

            if (preIndex < preOrder.size()) {
                //Construct the left subtree
                root.setLeft(constructTreeUsingPreOrder(preOrder, currentElement, minValue, comparator));
            }

            if (preIndex < preOrder.size()) {
                //Construct the right subtree
                root.setRight(constructTreeUsingPreOrder(preOrder, maxValue, currentElement, comparator));
            }

            return root;
        }

        return null;
    }
}
