package dataStructures.trees.driverClasses.binaryTree;

import dataStructures.trees.driverClasses.utils.BinaryTreeUtil;
import dataStructures.trees.modals.BinarySearchTree;
import dataStructures.trees.modals.BinaryTree;
import dataStructures.trees.modals.BinaryTreeNode;
import dataStructures.trees.modals.TreeLinkedList;

import java.util.Scanner;

public class ConstructTreeFromLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        final BinaryTreeUtil<BinaryTree<Integer>, BinaryTreeNode<Integer>, Integer> binaryTreeUtil = new BinaryTreeUtil<>();

        TreeLinkedList<Integer> linkedList = new TreeLinkedList<>();

        while (n > 0) {
            n--;
            linkedList.add(sc.nextInt());
        }

        BinaryTree<Integer> binaryTree = new BinaryTree<>(linkedList);
        System.out.println("Level order of created tree : ");
        binaryTreeUtil.getLevelOrderTraversal(binaryTree.getRoot()).forEach(el -> System.out.print(el + " "));
    }
}
