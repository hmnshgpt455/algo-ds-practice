package dataStructures.driverClasses.disjointSets;

import dataStructures.abstraction.disjointSets.DisjointSet;
import dataStructures.impl.disjointSets.UnionByRankAndPathCompressionDisjointSet;

public class TestDisjointSetOperations {
    public static void main(String[] args) {
        DisjointSet<Integer> disjointSet = new UnionByRankAndPathCompressionDisjointSet<>();
        disjointSet.makeSet(1)
                .makeSet(2)
                .makeSet(3)
                .makeSet(4)
                .makeSet(5)
                .makeSet(6)
                .makeSet(7);

        disjointSet.union(3, 4)
                .union(6, 7)
                .union(2, 3)
                        .union(3, 6);
        System.out.println("2 -->" + disjointSet.findSet(2));
        System.out.println("4 -->" + disjointSet.findSet(4));
        System.out.println("3 -->" + disjointSet.findSet(3));
        System.out.println("6 -->" + disjointSet.findSet(6));
        System.out.println("7 -->" + disjointSet.findSet(7));
        System.out.println("7 -->" + disjointSet.findSet(7));
        System.out.println("Rank of 3");
    }
}
