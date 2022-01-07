package dataStructures.driverClasses.binarySearchTree;

import dataStructures.driverClasses.utils.BinaryTreeUtil;
import dataStructures.modals.trees.nodes.BinaryTreeNode;
import dataStructures.impl.trees.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class DeleteKeyInBST {
    public static void main(String[] args) {
        List<Integer> preOrderRepresentation = new ArrayList<>(List.of(30, 20, 10, 25, 60, 50, 40, 55, 110, 100, 120));
        int n = preOrderRepresentation.size();

        final BinaryTreeUtil<BinaryTreeNode<Integer>, Integer> binaryTreeUtil = new BinaryTreeUtil<>();

        BinarySearchTree<Integer> createdBst = new BinarySearchTree<>(preOrderRepresentation);
        createdBst.deleteKey(120)
                .deleteKey(110)
                        .deleteKey(30);

//        //Case 1 : Deleting leaf node
//        createdBst.deleteKey(120);
//        System.out.println("After case 1");
//        createdBst.getTreeRepresentation("preorder").forEach(el -> System.out.print(el + " "));
//        System.out.println("\n-------------");
//
//        //Case 2 : Deleting node with 1 child
//        System.out.println("After case 2");
//        createdBst.deleteKey(110);
//        createdBst.getTreeRepresentation("preorder").forEach(el -> System.out.print(el + " "));
//        System.out.println("\n-------------");
//
//        //Case 3 : Deleting node with 2 children
//        System.out.println("After case 3");
//        createdBst.deleteKey(30);
        binaryTreeUtil.getInOrderTraversal(createdBst).forEach(el -> System.out.print(el + " "));
    }
}
