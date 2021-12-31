package dataStructures.trees.driverClasses.binarySearchTree;

import dataStructures.trees.driverClasses.utils.BinaryTreeUtil;
import dataStructures.trees.modals.BinarySearchTree;
import dataStructures.trees.modals.BinaryTree;
import dataStructures.trees.modals.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class ConstructBSTFromPreOrderRepresentation {
    public static void main(String[] args) {
        //List<Integer> preOrderRepresentation = DriverHelper.getPreOrderRepresentationInput();
        final BinaryTreeUtil<BinarySearchTree<Integer>, BinaryTreeNode<Integer>, Integer> binaryTreeUtil = new BinaryTreeUtil<>();
        List<Integer> preOrderRepresentation = new ArrayList<>(List.of(30, 20, 10, 25, 60, 50, 40, 55, 110, 100, 120));
        int n = preOrderRepresentation.size();
        BinarySearchTree<Integer> createdBst = new BinarySearchTree<>(preOrderRepresentation);
        List<Integer> createdBstPreOrderRepresentation = binaryTreeUtil.getTreeRepresentation("preorder", createdBst);
        boolean doesPreOrderMatch = IntStream.range(0, n)
                .allMatch(i -> Objects.equals(createdBstPreOrderRepresentation.get(i), preOrderRepresentation.get(i)));
        if (doesPreOrderMatch) {
            System.out.println("Pre orders match");
        } else {
            System.out.println("Preorders don't match");
        }

        System.out.println("Inorder traversal");
        binaryTreeUtil.getTreeRepresentation("inorder", createdBst).forEach(el -> System.out.print(el + " "));
    }
}
