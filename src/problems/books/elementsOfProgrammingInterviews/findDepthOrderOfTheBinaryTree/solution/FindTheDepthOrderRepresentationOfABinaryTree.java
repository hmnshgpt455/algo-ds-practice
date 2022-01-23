package problems.books.elementsOfProgrammingInterviews.findDepthOrderOfTheBinaryTree.solution;

import java.util.*;

/**
 * @author Himanshu Gupta
 * Problem : 9.7 : Compute the depth order representation of the tree. The same depth data should be clubbed together.
 * So, it is different from BFS.
 * Page : 143 (Kindle : 157)
 * Time complexity : O(n)
 * Space complexity : O(n), apart from saving the result
 */

public class FindTheDepthOrderRepresentationOfABinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(314);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(6);
        root.left.left = new BinaryTreeNode(271);
        root.left.right = new BinaryTreeNode(561);
        root.right.left = new BinaryTreeNode(2);
        root.right.right = new BinaryTreeNode(271);
        root.left.left.left = new BinaryTreeNode(28);
        root.left.left.right = new BinaryTreeNode(0);
        root.left.right.right = new BinaryTreeNode(3);
        root.left.right.right.left = new BinaryTreeNode(17);
        root.right.left.right = new BinaryTreeNode(1);
        root.right.right.right = new BinaryTreeNode(28);
        findTheBinaryTreeNodeOrderWithRespectToDepth(root).forEach(System.out::println);
    }

    static class BinaryTreeNode {
        BinaryTreeNode left;
        BinaryTreeNode right;
        int data;

        //Constructors
        BinaryTreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    static public List<List<Integer>> findTheBinaryTreeNodeOrderWithRespectToDepth(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<BinaryTreeNode> currentDepthQueue = new LinkedList<>();
        Queue<BinaryTreeNode> nextDepthQueue = new LinkedList<>();
        currentDepthQueue.add(root);
        List<Integer> currentDepthNodeList = new ArrayList<>();

        while (!currentDepthQueue.isEmpty()) {
            BinaryTreeNode currentNode = currentDepthQueue.poll();
            currentDepthNodeList.add(currentNode.data);

            if (currentNode.left != null) {
                nextDepthQueue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                nextDepthQueue.add(currentNode.right);
            }

            if (currentDepthQueue.isEmpty()) {
                //Traversed the current depth
                //Add the current node list in the result set
                result.add(currentDepthNodeList);
                currentDepthNodeList = new ArrayList<>();
                if (!nextDepthQueue.isEmpty()) {
                    //We have child nodes to traverse
                    currentDepthQueue = nextDepthQueue;
                    nextDepthQueue = new LinkedList<>();
                }
            }
        }

        return result;
    }

}
