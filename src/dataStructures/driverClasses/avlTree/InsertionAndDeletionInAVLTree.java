package dataStructures.driverClasses.avlTree;

import dataStructures.driverClasses.utils.BinaryTreeUtil;
import dataStructures.modals.trees.nodes.AVLTreeNode;
import dataStructures.impl.trees.AVLTree;

public class InsertionAndDeletionInAVLTree {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        final BinaryTreeUtil<AVLTreeNode<Integer>, Integer> avlTreeUtil = new BinaryTreeUtil<>();
        avlTree.insertKey(10).insertKey(20).insertKey(30).insertKey(40).insertKey(50).insertKey(25).insertKey(55).insertKey(60).insertKey(100)
                .insertKey(110).insertKey(120);

        System.out.println("Pre order before deletion");
        avlTreeUtil.getPreOrderTraversal(avlTree).forEach(el -> System.out.print(el + " "));
        System.out.println("\n-----------");

        //Case 1 : Deleting leaf node
        avlTree.deleteKey(120);
        System.out.println("After case 1 deletion");
        avlTreeUtil.getPreOrderTraversal(avlTree).forEach(el -> System.out.print(el + " "));
        System.out.println("\n------------");

        //Case 2 : Deleting node with one child
        avlTree.deleteKey(110);
        System.out.println("After case 2 deletion");
        avlTreeUtil.getPreOrderTraversal(avlTree).forEach(el -> System.out.print(el + " "));
        System.out.println("\n------------");

        //Case 3 : Deleting node with both children
        avlTree.deleteKey(60);
        System.out.println("After case 2 deletion");
        avlTreeUtil.getPreOrderTraversal(avlTree).forEach(el -> System.out.print(el + " "));
        System.out.println("\n------------");

        //R-R case
        avlTree.deleteKey(10).deleteKey(25);
        System.out.println("After case r-r deletion");
        avlTreeUtil.getPreOrderTraversal(avlTree).forEach(el -> System.out.print(el + " "));
        System.out.println("\n------------");

    }
}
