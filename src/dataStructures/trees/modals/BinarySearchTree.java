package dataStructures.trees.modals;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> {

    private int preIndex;
    private int inOrderIndexToConvertToBST;

    public BinarySearchTree(List<T> preOrder) {
        preIndex = 0;
        T max = null, min = null;
        for (int i = 0; i<preOrder.size(); i++) {
            if (i == 0) {
                max = min = preOrder.get(i);
            } else {
                if (preOrder.get(i).compareTo(max) > 0) {
                    max = preOrder.get(i);
                } else if (preOrder.get(i).compareTo(min) < 0) {
                    min = preOrder.get(i);
                }
            }
        }
        this.root = constructTreeUsingPreOrder(preOrder, max, min);
    }

    public BinarySearchTree() {

    }

    private BinaryTreeNode<T> constructTreeUsingPreOrder(List<T> preOrder, T maxValue, T minValue) {
        if (preIndex >= preOrder.size()) {
            return null;
        }

        T currentElement = preOrder.get(preIndex);
        if ((currentElement.compareTo(maxValue) <= 0) && (currentElement.compareTo(minValue) >= 0)) {
            BinaryTreeNode<T> root = new BinaryTreeNode<>(preOrder.get(preIndex++));

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

    public BinarySearchTree(BinaryTree<T> binaryTree) {
        this.root = convertFromBinaryTreeToBST(binaryTree);
    }

    private BinaryTreeNode<T> convertFromBinaryTreeToBST(BinaryTree<T> binaryTree) {
        List<T> binaryTreeInOrder = binaryTree.getTreeRepresentation("inorder");
        Collections.sort(binaryTreeInOrder);
        inOrderIndexToConvertToBST = 0;
        convertToBST(binaryTree.getRoot(), binaryTreeInOrder);
        return binaryTree.getRoot();
    }

    private void convertToBST(BinaryTreeNode<T> root, List<T> binaryTreeInOrder) {

        if (!Objects.isNull(root)) {
            convertToBST(root.getLeft(), binaryTreeInOrder);
            root.setValue(binaryTreeInOrder.get(inOrderIndexToConvertToBST));
            inOrderIndexToConvertToBST++;
            convertToBST(root.getRight(), binaryTreeInOrder);
        }
    }
    
    public BinaryTreeNode<T> findKey(T key) {
        return findKeyRecursively(this.root, key);
    }

    private BinaryTreeNode<T> findKeyRecursively(BinaryTreeNode<T> root, T key) {
        if (root == null) {
            return null;
        }

        if (key.compareTo(root.getValue()) == 0) {
            return root;
        }

        if (key.compareTo(root.getValue()) < 0) {
            return findKeyRecursively(root.getLeft(), key);
        }

        if (key.compareTo(root.getValue()) > 0) {
            return findKeyRecursively(root.getRight(), key);
        }

        return null;
    }

    @Override
    public BinarySearchTree<T> insertKey(T key) {
        if (this.root == null) {
            this.root = new BinaryTreeNode<>();
        }
        insertKeyRecursively(key, this.root);
        return this;
    }

    private void insertKeyRecursively(T key, BinaryTreeNode<T> node) {
        if (key.compareTo(node.getValue()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode<>(key));
            } else {
                insertKeyRecursively(key, node.getLeft());
            }
        }
        if (key.compareTo(node.getValue()) > 0) {
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode<>(key));
            } else {
                insertKeyRecursively(key, node.getRight());
            }
        }
    }

}
