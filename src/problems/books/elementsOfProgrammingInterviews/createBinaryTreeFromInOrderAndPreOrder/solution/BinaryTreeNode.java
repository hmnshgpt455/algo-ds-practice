package problems.books.elementsOfProgrammingInterviews.createBinaryTreeFromInOrderAndPreOrder.solution;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(List<Integer> preOrder, List<Integer> inOrder) {
        Map<Integer, Integer> keyToIndexMapInOrder = IntStream.range(0, inOrder.size())
                .boxed()
                .collect(Collectors.toMap(inOrder::get, Function.identity()));

        BinaryTreeNode node = constructBinaryTree(preOrder, 0, 0, inOrder.size()-1, keyToIndexMapInOrder);
        this.data = node.data;
        this.left = node.left;
        this.right = node.right;
    }

    private BinaryTreeNode constructBinaryTree(List<Integer> preOrder, int preOrderStart,
                                               int inOrderStart, int inOrderEnd, Map<Integer, Integer> map) {
        BinaryTreeNode newNode = null;
        if (preOrderStart < preOrder.size()) {
            newNode = new BinaryTreeNode(preOrder.get(preOrderStart));
            int index = map.get(newNode.data) - 1;
            int leftSubtreeLength = index > inOrderStart ? (index - inOrderStart + 1) : 0;

            if (index >= inOrderStart) {
                newNode.left = constructBinaryTree(preOrder, preOrderStart + 1, inOrderStart, index, map);
            }

            if (index + 2 <= inOrderEnd) {
                newNode.right = constructBinaryTree(preOrder, preOrderStart + leftSubtreeLength + 1,
                        index + 2, inOrderEnd, map);
            }

        }

        return newNode;
    }
}




