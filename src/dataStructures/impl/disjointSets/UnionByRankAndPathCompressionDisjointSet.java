package dataStructures.impl.disjointSets;

import dataStructures.abstraction.disjointSets.DisjointSet;
import dataStructures.modals.disjointSets.RankedDisjointSetNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Himanshu Gupta
 * Space complexity : O(n)
 * Time complexity : O(n*f(n))
 * This f(n) is proved to be a very slow increasing function. For most cases, f(n) <= 4
 * So, effectively time complexity : O(n)
 * @param <T>
 */

public class UnionByRankAndPathCompressionDisjointSet<T> implements DisjointSet<T> {

    private final Map<T, RankedDisjointSetNode<T>> setMap;

    public UnionByRankAndPathCompressionDisjointSet() {
        this.setMap = new HashMap<>();
    }

    @Override
    public DisjointSet<T> makeSet(T value) {
        //Create a new set with rank = 0 and parent = itself
        RankedDisjointSetNode<T> newNode = new RankedDisjointSetNode<>(value, 0);
        setMap.put(value, newNode);
        return this;
    }

    @Override
    public DisjointSet<T> union(T value1, T value2) {
        //Get the set nodes for the values
        RankedDisjointSetNode<T> node1 = setMap.get(value1);
        RankedDisjointSetNode<T> node2 = setMap.get(value2);
        //Get parent for both the nodes
        RankedDisjointSetNode<T> parent1 = findSet(node1);
        RankedDisjointSetNode<T> parent2 = findSet(node2);

        if (parent1.getRank() > parent2.getRank()) {
            //Set the parent of parent2 to parent1 because parent1 rank is greater than parent2
            //parent1 will become the representative here
            parent2.setParent(parent1);
        } else if (parent1.getRank() < parent2.getRank()) {
            //Set the parent of parent1 to parent2 because the rank of parent2 is greater than the parent1
            //parent2 will become the representative here
            parent1.setParent(parent2);
        } else {
            //Both the ranks are same. So, it does not matter which parent we choose as representative. Also,
            // we increase the rank of the parent which is chosen as representative
            parent1.setRank(parent1.getRank() + 1);
            parent2.setParent(parent1);
        }
        return this;
    }

    @Override
    public T findSet(T value) {
        //Find the node for the value and start finding it's parent
        return findSet(setMap.get(value)).getValue();
    }

    private RankedDisjointSetNode<T> findSet(RankedDisjointSetNode<T> node) {
        if (node.getParent() == node) {
            //If the node's parent is node itself, that means node is the representative
            return node;
        }

        //Go to the node's parent recursively and find the representative
        //Also, after finding do the path compression by setting the parent of every node to the representative node
        node.setParent(findSet(node.getParent()));
        return node.getParent();
    }
}
