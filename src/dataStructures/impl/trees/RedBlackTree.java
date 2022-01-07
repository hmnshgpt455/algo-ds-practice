package dataStructures.impl.trees;

import dataStructures.abstraction.trees.AbstractTree;
import dataStructures.abstraction.trees.Tree;
import dataStructures.modals.trees.nodes.RedBlackTreeNode;

import java.util.List;
import java.util.Optional;

public class RedBlackTree<T extends Comparable<? super T>> extends AbstractTree<RedBlackTreeNode<T>, T> {

    private boolean leftLeftCase = false;
    private boolean leftRightCase = false;
    private boolean rightLeftCase = false;
    private boolean rightRightCase = false;

    @Override
    public Tree<T> insertKey(T key) {
        this.root = insertKeyRecursively(key, this.root, null);
        return this;
    }

    public RedBlackTree() {
        this.root = null;
    }

    public RedBlackTree(List<T> keys) {
        this.root = null;
        keys.forEach(this::insertKey);
    }

    private RedBlackTreeNode<T> insertKeyRecursively(T key, RedBlackTreeNode<T> root, RedBlackTreeNode<T> parent) {
        return Optional.ofNullable(root)
                .map((node) -> {
                    if (node.getValue().compareTo(key) < 0) {
                        node.setRight(insertKeyRecursively(key, node.getRight(), node));
                    } else {
                        node.setLeft(insertKeyRecursively(key, node.getLeft(), node));
                    }

                    if (this.leftLeftCase) {
                        this.leftLeftCase = false;
                        //Do right case
                        //We are currently at the grandparent of the newly inserted node. Exchange the color of grandparent and parent
                        node.getLeft().setColor('B');
                        node.setColor('R');
                        return rightRotate(node);
                    }

                    if (this.leftRightCase) {
                        this.leftRightCase = false;
                        //Recolor
                        node.setColor('R');
                        node.getLeft().getRight().setColor('B');
                        //Do left rotation then do right rotation
                        node.setLeft(leftRotate(node.getLeft()));
                        return rightRotate(node);
                    }

                    if (this.rightRightCase) {
                        this.rightRightCase = false;
                        node.setColor('R');
                        node.getRight().setColor('B');
                        //Do left rotation
                        return leftRotate(node);
                    }

                    if (this.rightLeftCase) {
                        this.rightLeftCase = false;
                        //Do right rotation and then do left rotation
                        node.getRight().getLeft().setColor('B');
                        node.setColor('R');

                        //Perform rotation
                        node.setRight(rightRotate(node.getRight()));
                        return leftRotate(node);
                    }

                    return resolveConflictIfAny(node);

                })
                .orElseGet(() -> Optional.ofNullable(parent)
                        .map(p -> new RedBlackTreeNode<>(key, p)).orElse(new RedBlackTreeNode<>(key)));
    }

    private RedBlackTreeNode<T> rightRotate(RedBlackTreeNode<T> pivot) {
        RedBlackTreeNode<T> pivotParent = pivot.getParent();
        RedBlackTreeNode<T> leftChild = pivot.getLeft();
        RedBlackTreeNode<T> leftChild_RightChild = leftChild.getRight();

        leftChild.setRight(pivot);
        leftChild.setParent(pivotParent);
        pivot.setParent(leftChild);
        pivot.setLeft(leftChild_RightChild);
        Optional.ofNullable(leftChild_RightChild).ifPresent(l -> l.setParent(pivot));

        return leftChild;
    }

    private RedBlackTreeNode<T> leftRotate(RedBlackTreeNode<T> pivot) {
        RedBlackTreeNode<T> pivotParent = pivot.getParent();
        RedBlackTreeNode<T> rightChild = pivot.getRight();
        RedBlackTreeNode<T> rightChild_leftChild = rightChild.getLeft();

        rightChild.setLeft(pivot);
        rightChild.setParent(pivotParent);
        pivot.setParent(rightChild);
        pivot.setRight(rightChild_leftChild);
        Optional.ofNullable(rightChild_leftChild).ifPresent(r -> r.setParent(pivot));

        return rightChild;
    }

    private RedBlackTreeNode<T> resolveConflictIfAny(RedBlackTreeNode<T> node) {
        if (node.getColor() == 'R') {

            boolean isConflictWithLeftChild = Optional.ofNullable(node.getLeft())
                    .map(left -> left.getColor() == node.getColor()).orElse(false);
            boolean isConflictWithRightChild = Optional.ofNullable(node.getRight())
                    .map(right -> right.getColor() == node.getColor()).orElse(false);

            if (isConflictWithLeftChild || isConflictWithRightChild) {
                //conflict with left child
                if (node.getParent().getLeft() == node) {
                    //Node is the left child and sibling is the right child OR parent is
                    // left node of the grandparent and uncle is right node of the grandparent
                    if (node.getParent().getRight() != null && node.getParent().getRight().getColor() == 'R') {
                        //Only recoloring is required if the uncle is not null, and it's color is red
                        node.setColor('B');
                        node.getParent().getRight().setColor('B');
                        if (node.getParent() != this.root) {
                            node.getParent().setColor('R');
                        }
                    } else {
                        //Need to do rotation
                        if (isConflictWithLeftChild) {
                            //Left-Left case
                            this.leftLeftCase = true;
                        } else {
                            //Left-right case
                            this.leftRightCase = true;
                        }
                    }
                } else {
                    //Node is the right child of it's parent, and it's sibling is right child
                    if (node.getParent().getLeft() != null && node.getParent().getRight().getColor() == 'R') {
                        //Only recoloring is required if the uncle is not null, and it's color is red
                        node.setColor('B');
                        node.getParent().getLeft().setColor('B');
                        if (node.getParent() != this.root) {
                            node.getParent().setColor('R');
                        }
                    } else {
                        //Need to do rotation
                        if (isConflictWithLeftChild) {
                            //Right-left case
                            this.rightLeftCase = true;
                        } else {
                            //right-right case
                            this.rightRightCase = true;
                        }
                    }
                }
            }
        }
        return node;
    }

    @Override
    public Tree<T> deleteKey(T key) {
        return null;
    }


}
