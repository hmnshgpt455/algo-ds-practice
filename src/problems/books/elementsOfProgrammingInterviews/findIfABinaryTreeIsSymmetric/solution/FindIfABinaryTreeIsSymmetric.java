package problems.books.elementsOfProgrammingInterviews.findIfABinaryTreeIsSymmetric.solution;

/**
 * @author Himanshu Gupta
 * Problem : 10.2 : Check if binary tree is symmetric or not
 * Page : 154
 * Time complexity : O(n)
 * Space complexity : O(h) -> h is the height of the tree (due to recursion call stack)
 */
public class FindIfABinaryTreeIsSymmetric {
    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(314);
        binaryTreeNode.left = new BinaryTreeNode(6);
        binaryTreeNode.right = new BinaryTreeNode(6);
        binaryTreeNode.left.left = new BinaryTreeNode(10);
        binaryTreeNode.right.right = new BinaryTreeNode(10);
        binaryTreeNode.left.left.left = new BinaryTreeNode(11);
        binaryTreeNode.right.right.right = new BinaryTreeNode(11);
        binaryTreeNode.left.right = new BinaryTreeNode(5);
        binaryTreeNode.right.left = new BinaryTreeNode(5);
        binaryTreeNode.left.right.left = new BinaryTreeNode(4);
        binaryTreeNode.right.left.right = new BinaryTreeNode(4);
        binaryTreeNode.right.left.right.left = new BinaryTreeNode(4);
        System.out.println(checkIfBinaryTreeIsSymmetric(binaryTreeNode));
    }

    static class BinaryTreeNode {
        BinaryTreeNode left;
        BinaryTreeNode right;
        int data;

        public BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }

        public BinaryTreeNode(int data) {
            this.data = data;
        }

        public BinaryTreeNode() {
        }
    }

    static public boolean checkIfBinaryTreeIsSymmetric(BinaryTreeNode root) {
        return checkIfChildrenAreSymmetric(root.left, root.right);
    }

    static boolean checkIfChildrenAreSymmetric(BinaryTreeNode child1, BinaryTreeNode child2) {
        if (child1 == null && child2 == null) {
            return true;
        } else if (child1 != null && child2 != null) {
            return checkIfChildrenAreSymmetric(child1.left, child2.right) &&
                    checkIfChildrenAreSymmetric(child1.right, child2. left) && child2.data == child1.data;
        }

        return false;
    }

}
