package problems.books.elementsOfProgrammingInterviews.checkIfTreeIsHeightBalanced.solution;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Problem 10.1 : Find if the tree is height balanced. (Height balance is same as BST)
 * Page : 152 (Kindle 166)
 * Time complexity : O(n), n = number of nodes in the tree
 */

public class FindIfTreeIsHeightBalanced {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree.left = new TreeNode();
        tree.left.left = new TreeNode();
        tree.right = new TreeNode();

        System.out.println(findIfTreeIsHeightBalanced(tree));
    }

    public static class TreeNode {
        private Integer data;
        private TreeNode left;
        private TreeNode right;
    }

    public static boolean findIfTreeIsHeightBalanced(TreeNode root) {
        AtomicBoolean isTreeHeightBalanced = new AtomicBoolean(true);
        findHeightAndUpdateAnswer(root, isTreeHeightBalanced);
        return isTreeHeightBalanced.get();
    }

    public static int findHeightAndUpdateAnswer(TreeNode root, AtomicBoolean isTreeHeightBalanced) {
        if (root == null) {
            isTreeHeightBalanced.set(true);
            return 0;
        }

        int leftHeight = findHeightAndUpdateAnswer(root.left, isTreeHeightBalanced);
        int rightHeight = findHeightAndUpdateAnswer(root.right, isTreeHeightBalanced);

        if (Math.abs(leftHeight-rightHeight) > 1) {
            isTreeHeightBalanced.set(false);
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
