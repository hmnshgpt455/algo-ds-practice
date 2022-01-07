package dataStructures.driverClasses.binarySearchTree;

import dataStructures.impl.trees.BinarySearchTree;
import dataStructures.modals.trees.nodes.BinaryTreeNode;

import java.util.List;

public class FindAndSearchKeyInBST {
    public static void main(String[] args) {
        List<Integer> preOrderRepresentation = DriverHelper.getPreOrderRepresentationInput();

        BinarySearchTree<Integer> createdBst = new BinarySearchTree<>(preOrderRepresentation);

        createdBst.insertKey(-1);
        BinaryTreeNode<Integer> foundNode = createdBst.findKey(-1);

        if (foundNode != null) {
            System.out.println("Value found " + foundNode.getValue());
        } else {
            System.out.println("Node not found");
        }

    }
}
