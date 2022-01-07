package dataStructures.driverClasses.binaryTree;

import dataStructures.impl.trees.BinaryTree;
import dataStructures.modals.trees.common.TreeLinkedList;
import dataStructures.modals.trees.nodes.BinaryTreeNode;
import dataStructures.driverClasses.utils.BinaryTreeUtil;

import java.util.Scanner;

public class ConstructTreeFromLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        final BinaryTreeUtil<BinaryTreeNode<Integer>, Integer> binaryTreeUtil = new BinaryTreeUtil<>();

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
