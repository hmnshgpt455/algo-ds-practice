package dataStructures.trees.driverClasses.binaryTree;

import dataStructures.trees.driverClasses.utils.BinaryTreeUtil;
import dataStructures.trees.modals.BinaryTree;
import dataStructures.trees.modals.BinaryTreeNode;

import java.util.Scanner;

public class ConstructBinaryTreeUsingInorderAndPreorderRepresentations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inOrder = sc.next();
        String preOrder = sc.next();
        final BinaryTreeUtil<BinaryTreeNode<Character>, Character> binaryTreeUtil = new BinaryTreeUtil<>();

        BinaryTree<Character> createdBinaryTree = new BinaryTree<>(inOrder, preOrder, null);

        String newInOrder = binaryTreeUtil.getInOrderTraversal(createdBinaryTree)
                .stream().reduce("", (resultString, node) -> resultString + node, String::concat);

        String newPreOrder = binaryTreeUtil.getPreOrderTraversal(createdBinaryTree)
                .stream().reduce("", (resultString, node) -> resultString + node, String::concat);

        if (inOrder.equals(newInOrder)) {
            System.out.println("Inorder matched");
        }
        if (preOrder.equals(newPreOrder)) {
            System.out.println("Preorder matched");
        }
    }
}
