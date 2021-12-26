package dataStructures.trees.driverClasses.binarySearchTree;

import dataStructures.trees.modals.BinarySearchTree;
import dataStructures.trees.modals.ListNode;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConstructBSTFromPreOrderRepresentation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> preOrderRepresentation = IntStream.range(0, n)
                .boxed()
                .map(i -> sc.nextInt())
                .collect(Collectors.toList());

        BinarySearchTree<Integer> createdBst = new BinarySearchTree<>(preOrderRepresentation, Integer::compareTo);
        List<Integer> createdBstPreOrderRepresentation = createdBst.getTreeRepresentation("preorder");
        boolean doesPreOrderMatch = IntStream.range(0, n)
                .allMatch(i -> Objects.equals(createdBstPreOrderRepresentation.get(i), preOrderRepresentation.get(i)));
        if (doesPreOrderMatch) {
            System.out.println("Pre orders match");
        } else {
            System.out.println("Preorders don't match");
        }

        System.out.println("Inorder traversal");
        createdBst.getTreeRepresentation("inorder").forEach(el -> System.out.print(el + " "));
    }
}
