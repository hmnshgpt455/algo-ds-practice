package dataStructures.trees.driverClasses.binarySearchTree;

import dataStructures.trees.driverClasses.utils.BinaryTreeUtil;
import dataStructures.trees.impl.trees.BinarySearchTree;
import dataStructures.trees.modals.trees.nodes.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class ConstructBSTFromPreOrderRepresentation {
    public static void main(String[] args) {
        //List<Integer> preOrderRepresentation = DriverHelper.getPreOrderRepresentationInput();
        final BinaryTreeUtil<BinaryTreeNode<Integer>, Integer> binaryTreeUtil = new BinaryTreeUtil<>();
        List<Integer> preOrderRepresentation = new ArrayList<>(List.of(30, 20, 10, 25, 60, 50, 40, 55, 110, 100, 120));
        int n = preOrderRepresentation.size();
        BinarySearchTree<Integer> createdBst = new BinarySearchTree<>(preOrderRepresentation);
        List<Integer> createdBstPreOrderRepresentation = binaryTreeUtil.getPreOrderTraversal(createdBst);
        boolean doesPreOrderMatch = IntStream.range(0, n)
                .allMatch(i -> Objects.equals(createdBstPreOrderRepresentation.get(i), preOrderRepresentation.get(i)));
        if (doesPreOrderMatch) {
            System.out.println("Pre orders match");
        } else {
            System.out.println("Preorders don't match");
        }

        System.out.println("Inorder traversal");
        binaryTreeUtil.getInOrderTraversal(createdBst).forEach(el -> System.out.print(el + " "));
    }
}
