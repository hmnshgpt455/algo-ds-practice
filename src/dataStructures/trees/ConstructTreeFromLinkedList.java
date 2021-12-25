package dataStructures.trees;

import java.util.Scanner;

public class ConstructTreeFromLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeLinkedList<Integer> linkedList = new TreeLinkedList<>();

        while (n > 0) {
            n--;
            linkedList.add(sc.nextInt());
        }

        BinaryTree<Integer> binaryTree = new BinaryTree<>(linkedList);
        System.out.println("Level order of created tree : ");
        binaryTree.getLevelOrderTraversal().forEach(el -> System.out.print(el + " "));
    }
}
