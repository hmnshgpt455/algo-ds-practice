package dataStructures.trees;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinaryTree<T> implements Tree {

    private BinaryTreeNode<T> root;

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public BinaryTree(T value) {
        this.root = new BinaryTreeNode<T>(value);
    }

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    private int preIndex = 0;

    List<T> getTreeRepresentation(String traversalType) {
        List<T> inOrderRepresentation = new ArrayList<>();
        switch (traversalType) {
            case "inorder":
                inOrderTraversal(inOrderRepresentation, this.getRoot());
                break;
            case "preorder":
                preOrderTraversal(inOrderRepresentation, this.getRoot());
                break;
            case "postorder":
                postOrderTraversal(inOrderRepresentation, this.getRoot());
                break;
        }

        return inOrderRepresentation;
    }

    @SuppressWarnings("unchecked")
    public BinaryTree(String inOrderTraversal, String preOrderTraversal, String postOrderTraversal) {
        this.root = (BinaryTreeNode<T>) Optional.of(inOrderTraversal)
                .flatMap(inOrder -> Optional.ofNullable(preOrderTraversal)
                        .map(preOrder -> {
                            HashMap<Character, Integer> characterToIndexMap = buildCharacterToIndexMap(inOrderTraversal);
                            return convertToBinaryTreeUsingInorderAndPreOrder(preOrder, characterToIndexMap,
                                    0, inOrder.length()-1);
                        }))
                .orElseGet(BinaryTreeNode::new);
    }

    private HashMap<Character, Integer> buildCharacterToIndexMap(String traversal) {
        return (HashMap<Character, Integer>) IntStream.range(0, traversal.length())
                .boxed()
                .collect(Collectors.toMap(traversal::charAt, Function.identity()));
    }

    private BinaryTreeNode<Character> convertToBinaryTreeUsingInorderAndPreOrder(String preOrder,
                                                                                 HashMap<Character, Integer> characterIntegerHashMap,
                                                                                 int startIndex, int endIndex) {

        if (startIndex > endIndex) {
            return null;
        }

        BinaryTreeNode<Character> root = new BinaryTreeNode<>(preOrder.charAt(preIndex++));

        int indexOfRootInInOrder = characterIntegerHashMap.get(root.getValue());

        //The left subtree will be from the startIndex of current tree to the previous of index where the root was found in inorder traversal
        root.setLeft(convertToBinaryTreeUsingInorderAndPreOrder(preOrder, characterIntegerHashMap,
                startIndex, indexOfRootInInOrder - 1));

        //The right subtree will be from the index + 1, where index = the index where the root was found in inorder traversal to the endIndex of the current subtree
        root.setRight(convertToBinaryTreeUsingInorderAndPreOrder(preOrder, characterIntegerHashMap,
                indexOfRootInInOrder + 1, endIndex));


        return root;
    }

    private void postOrderTraversal(List<T> representation, BinaryTreeNode<T> root) {
        Optional.ofNullable(root).ifPresent(r -> {
            Optional.ofNullable(root.getLeft()).ifPresent(left -> postOrderTraversal(representation, left));
            Optional.ofNullable(root.getRight()).ifPresent(right -> postOrderTraversal(representation, right));
            Optional.ofNullable(root.getValue()).ifPresent(representation::add);
        });
    }

    private void preOrderTraversal(List<T> representation, BinaryTreeNode<T> root) {
        Optional.ofNullable(root).ifPresent(r -> {
            Optional.ofNullable(root.getValue()).ifPresent(representation::add);
            Optional.ofNullable(root.getLeft()).ifPresent(left -> preOrderTraversal(representation, left));
            Optional.ofNullable(root.getRight()).ifPresent(right -> preOrderTraversal(representation, right));
        });
    }

    private void inOrderTraversal(List<T> representation, BinaryTreeNode<T> root) {
        Optional.ofNullable(root).ifPresent(r -> {
            Optional.ofNullable(root.getLeft()).ifPresent(left -> inOrderTraversal(representation, left));
            Optional.ofNullable(root.getValue()).ifPresent(representation::add);
            Optional.ofNullable(root.getRight()).ifPresent(right -> inOrderTraversal(representation, right));
        });
    }

}
