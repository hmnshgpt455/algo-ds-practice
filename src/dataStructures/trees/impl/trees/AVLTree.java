package dataStructures.trees.impl.trees;

import dataStructures.trees.abstraction.AbstractTree;
import dataStructures.trees.modals.trees.nodes.AVLTreeNode;

import java.util.Optional;

public class AVLTree<T extends Comparable<? super T>> extends AbstractTree<AVLTreeNode<T>, T> {

    public AVLTree() {
        super();
    }

    @Override
    public AVLTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(AVLTreeNode<T> root) {
        this.root = root;
    }

    @Override
    public AVLTree<T> insertKey(T key) {
        if (this.root == null) {
            this.root = new AVLTreeNode<>(key);
        } else {
            this.root = insertKeyRecursively(key, this.root);
        }
        return this;
    }

    public AVLTree<T> deleteKey(T key) {
        this.root = deleteKeyRecursively(key, this.root);

        return this;
    }

    private AVLTreeNode<T> deleteKeyRecursively(T key, AVLTreeNode<T> node) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.getValue()) < 0) {
            node.setLeft(deleteKeyRecursively(key, node.getLeft()));
            return node;
        }

        if (key.compareTo(node.getValue()) > 0) {
            node.setRight(deleteKeyRecursively(key, node.getRight()));
            return node;
        }

        if (node.getValue().compareTo(key) == 0) {
            //Leaf node
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }

            //Both children present
            if (node.getLeft() != null && node.getRight() != null) {
                T inOrderSuccessorValue = findInOrderSuccessor(node.getRight());
                node.setValue(inOrderSuccessorValue);
                node.setRight(deleteKeyRecursively(inOrderSuccessorValue, node.getRight()));
                return node;
            }

            //Only right child present
            Optional.ofNullable(node.getRight()).ifPresent(right -> {
                node.setValue(right.getValue());
                node.setRight(null);
            });

            //Only left child is present
            Optional.ofNullable(node.getLeft()).ifPresent(left -> {
                node.setValue(left.getValue());
                node.setLeft(null);
            });

            node.setHeight(getHeight(node));
            return balanceTheNodeIfUnbalanced(node, key);
        }

        return  null;
    }

    private T findInOrderSuccessor(AVLTreeNode<T> node) {
        return Optional.ofNullable(node.getLeft()).map(this::findInOrderSuccessor).orElse(node.getValue());
    }

    private AVLTreeNode<T> insertKeyRecursively(T key, AVLTreeNode<T> node) {

        if (node == null) {
            return new AVLTreeNode<>(key);
        }

        if (key.compareTo(node.getValue()) < 0) {
            node.setLeft(insertKeyRecursively(key, node.getLeft()));
        }

        if (key.compareTo(node.getValue()) > 0) {
            node.setRight(insertKeyRecursively(key, node.getRight()));
        }

        node.setHeight(getHeight(node));
        return balanceTheNodeIfUnbalanced(node, key);
    }

    private int getHeight(AVLTreeNode<T> node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return 0;
        }
        return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
    }

    private int height(AVLTreeNode<T> node) {
        return Optional.ofNullable(node).map(AVLTreeNode::getHeight).orElse(0);
    }

    private int getBalanceFactor(AVLTreeNode<T> node) {
        return Optional.ofNullable(node.getLeft()).map(AVLTreeNode::getHeight).orElse(-1)
                - Optional.ofNullable(node.getRight()).map(AVLTreeNode::getHeight).orElse(-1);
    }

    private AVLTreeNode<T> balanceTheNodeIfUnbalanced(AVLTreeNode<T> node, T key) {
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            //It means it can be Left-Right or Left-Left scenario
            if (node.getLeft().getValue().compareTo(key) > 0) {
                //left-left case
            } else {
                //Left-right case
                node.setLeft(doLeftRotation(node.getLeft())); //Set the updated left, because the previous connection is broken. Check the rotation to understand better
            }
            return doRightRotation(node);
        } else if (balanceFactor < -1) {
            //It is either right-right case or right-left case
            if (node.getRight().getValue().compareTo(key) < 0) {
                //Right-right case
            } else {
                //Right-left case
                node.setRight(doRightRotation(node.getRight()));
            }
            return doLeftRotation(node);
        }

        return node;
    }

    private AVLTreeNode<T> doLeftRotation(AVLTreeNode<T> pivot) {
        AVLTreeNode<T> rightChild = pivot.getRight();
        AVLTreeNode<T> rightChild_leftChild = rightChild.getLeft();
        rightChild.setLeft(pivot);
        pivot.setRight(rightChild_leftChild);

        pivot.setHeight(getHeight(pivot));
        rightChild.setHeight(getHeight(rightChild));

        return rightChild;
    }

    private AVLTreeNode<T> doRightRotation(AVLTreeNode<T> pivot) {
        AVLTreeNode<T> leftChild = pivot.getLeft();
        AVLTreeNode<T> leftChild_rightChild = leftChild.getRight();
        leftChild.setRight(pivot);
        pivot.setLeft(leftChild_rightChild);

        pivot.setHeight(getHeight(pivot));
        leftChild.setHeight(getHeight(leftChild));

        return leftChild;
    }
}
