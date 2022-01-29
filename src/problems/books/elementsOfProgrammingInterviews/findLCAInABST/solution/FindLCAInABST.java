package problems.books.elementsOfProgrammingInterviews.findLCAInABST.solution;

import dataStructures.impl.trees.BinarySearchTree;
import dataStructures.modals.trees.nodes.BinaryTreeNode;

/**
 * @author Himanshu Guota
 * Problem : 15.4 : Find LCA of two nodes in BST
 * Page : 261 (Kindle : 275)
 * Time complexity : O(h)
 * Space complexity : O(1)
 */

public class FindLCAInABST {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insertKey(10)
                .insertKey(20)
                .insertKey(30)
                .insertKey(-1)
                .insertKey(-2)
                .insertKey(40)
                .insertKey(11)
                .insertKey(22)
                .insertKey(13)
                .insertKey(15)
                .insertKey(90)
                .insertKey(56);
        System.out.println(findLCA(bst.getRoot(), 40, 21));
    }
    

    static public int findLCA(BinaryTreeNode<Integer> root, int child1, int child2) {
        if ((root.getValue() >= child1 && root.getValue() <= child2) || (root.getValue() <= child1 && root.getValue() >= child2)) {
            return root.getValue();
        }

        if (root.getValue() < child1) {
            return findLCA(root.getRight(), child1, child2);
        }

        return findLCA(root.getLeft(), child1, child2);

    }

}
