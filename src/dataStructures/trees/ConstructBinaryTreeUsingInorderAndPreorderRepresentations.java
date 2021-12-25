package dataStructures.trees;

import java.util.Scanner;

public class ConstructBinaryTreeUsingInorderAndPreorderRepresentations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inOrder = sc.next();
        String preOrder = sc.next();

        BinaryTree<Character> createdBinaryTree = new BinaryTree<>(inOrder, preOrder, null);

        String newInOrder = createdBinaryTree.getTreeRepresentation("inorder")
                .stream().reduce(new String(""), (resultString, node) -> resultString + node, String::concat);

        String newPreOrder = createdBinaryTree.getTreeRepresentation("preorder")
                .stream().reduce(new String(""), (resultString, node) -> resultString + node, String::concat);

        if (inOrder.equals(newInOrder)) {
            System.out.println("Inorder matched");
        }
        if (preOrder.equals(newPreOrder)) {
            System.out.println("Preorder matched");
        }
    }
}
