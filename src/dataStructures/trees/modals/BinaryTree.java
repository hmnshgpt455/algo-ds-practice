package dataStructures.trees.modals;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinaryTree<T> extends AbstractTree<BinaryTreeNode<T>, BinaryTree<T>, T> {

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public BinaryTree(T value) {
        this.root = new BinaryTreeNode<T>(value);
    }

    public BinaryTree() {
        this.root = null;
    }


    private int preIndex = 0;

    public BinaryTree(TreeLinkedList<T> linkedList) {
        this.root = createTreeFromLinkedList(linkedList);
    }

    private BinaryTreeNode<T> createTreeFromLinkedList(TreeLinkedList<T> linkedList) {
        Queue<BinaryTreeNode<T>> treeQueue = new LinkedList<>();
        ListNode<T> head = linkedList.getHead();
        treeQueue.add(new BinaryTreeNode<>(head.getData()));
        BinaryTreeNode<T> root = treeQueue.peek();
        head = head.getNext();

        while (!treeQueue.isEmpty() && head != null) {
            BinaryTreeNode<T> currentElement = treeQueue.poll();
            currentElement.setLeft(new BinaryTreeNode<>(head.getData()));
            treeQueue.add(currentElement.getLeft());
            head = head.getNext();
            if (head != null) {
                currentElement.setRight(new BinaryTreeNode<>(head.getData()));
                treeQueue.add(currentElement.getRight());
                head = head.getNext();
            }
        }
        return root;
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

    @SuppressWarnings("unchecked")
    public BinaryTree(List<T> inOrderTraversal, List<T> levelOrderTraversal) {
        this.root = (BinaryTreeNode<T>) Optional.ofNullable(inOrderTraversal)
                .flatMap(inOrder -> Optional.ofNullable(levelOrderTraversal)
                        .map(levelOrder -> {
                            HashMap<T, Integer> elementsToIndexMapForInorder = buildElementToIndexMap(inOrder);
                            HashMap<T, Integer> elementsToIndexMapForLevelOrder = buildElementToIndexMap(levelOrder);
                            Queue<BinaryTreeNode<T>> levelQueue = new LinkedList<>();
                            levelQueue.add(new BinaryTreeNode<>(levelOrder.get(0)));
                            convertToBinaryTreeUsingLevelOrderAndInorder(elementsToIndexMapForInorder, elementsToIndexMapForLevelOrder,
                                    0, inOrder.size()-1, 0, levelQueue, inOrder, levelOrder);
                            return new BinaryTreeNode<Integer>(1);
                        })).orElse(null);
    }

    private BinaryTreeNode convertToBinaryTreeUsingLevelOrderAndInorder(HashMap<T, Integer> elementsToIndexMapForInorder,
                                                                        HashMap<T, Integer> elementsToIndexMapForLevelOrder,
                                                                        int startIndex, int endIndex, int numberOfSiblingsToTheRight,
                                                                        Queue<BinaryTreeNode<T>> levelQueue, List<T> inOrder,
                                                                        List<T> levelOrder) {
        return null;

    }

    private HashMap<T, Integer> buildElementToIndexMap(List<T> inOrder) {
        return (HashMap<T, Integer>) IntStream.range(0, inOrder.size())
                .boxed()
                .collect(Collectors.toMap(inOrder::get, Function.identity()));
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

    @Override
    BinaryTree<T> insertKey(T key) {
        return null;
    }
}
