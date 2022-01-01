package dataStructures.trees.driverClasses.rebBlackTree;

import dataStructures.trees.driverClasses.utils.BinaryTreeUtil;
import dataStructures.trees.impl.trees.RedBlackTree;
import dataStructures.trees.modals.trees.nodes.RedBlackTreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConstructTreeUsingListOrInsertion {
    public static void main(String[] args) {
        List<Integer> keyList = new ArrayList<>(List.of(1, 4, 6, 3, 5, 7, 8, 2, 9));
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        BinaryTreeUtil<RedBlackTreeNode<Integer>, Integer> util = new BinaryTreeUtil<>();

        keyList.forEach(key -> {
            tree.insertKey(key);
            util.getInOrderTraversal(tree).forEach(el -> System.out.print(el + " "));
            System.out.println();
        });
        System.out.println("done");
    }
}
