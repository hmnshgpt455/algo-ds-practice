package problems.books.elementsOfProgrammingInterviews.findLCAOfTwoNodesInBinaryTreeNode.solution;

/**
 * @author Himanshu Gupta
 * Problem : 10.4 : Find the LCA of two nodes of a Binary Tree who have links back to their parents
 * Page : 157 (Kindle : 171)
 * Time complexity : O(h) -> h is the depth of the tree
 * Space complexity : O(1)
 */

public class FindLCAOfTwoNodesInBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2, root);
        root.right = new BinaryTreeNode(3, root);
        root.left.left = new BinaryTreeNode(4, root.left);
        root.left.right = new BinaryTreeNode(5, root.left);
        root.left.left.left = new BinaryTreeNode(6, root.left.left);
        root.left.left.left.left = new BinaryTreeNode(7, root.left.left.left);
        System.out.println(findLCA(root.left.left.left.left, root.right));
    }

    static class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode parent;

        public BinaryTreeNode(int data, BinaryTreeNode parent) {
            this.data = data;
            this.parent = parent;
        }

        public BinaryTreeNode(int data) {
            this.data = data;
            this.parent = null;
        }

        @Override
        public String toString() {
            return "BinaryTreeNode{" +
                    "data=" + data +
                    '}';
        }
    }

    public static BinaryTreeNode findLCA(BinaryTreeNode node1, BinaryTreeNode node2) {
        int depth1 = getDepth(node1);
        int depth2 = getDepth(node2);


        if (depth1 > depth2) {
            int depthDifference = depth1 - depth2;
            while (depthDifference > 0) {
                node1 = node1.parent;
                depthDifference--;
            }
        } else {
            int depthDifference = depth2 - depth1;
            while (depthDifference > 0) {
                node2 = node2.parent;
                depthDifference--;
            }
        }

        return findLCAOfNodesWithSameDepth(node1, node2);
    }

    private static BinaryTreeNode findLCAOfNodesWithSameDepth(BinaryTreeNode node1, BinaryTreeNode node2) {
        while (node1 != node2) {
            node1 = node1.parent;
            node2 = node2.parent;
        }

        return node1;
    }

    private static int getDepth(BinaryTreeNode node) {
        int depth = 0;
        while (node.parent != null) {
            depth++;
            node = node.parent;
        }

        return depth;
    }

}
