package dataStructures.abstraction.disjointSets;

import dataStructures.impl.disjointSets.UnionByRankAndPathCompressionDisjointSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DisjointSetTest {

    DisjointSet<Integer> disjointSet;

    @Test
    void makeSet() {
        initializeData();
        assertEquals(2, disjointSet.findSet(2));
        assertEquals(4, disjointSet.findSet(4));
        assertEquals(4, disjointSet.findSet(4));

    }

    private void initializeData() {
        disjointSet = new UnionByRankAndPathCompressionDisjointSet<>();
        disjointSet.makeSet(1)
                .makeSet(2)
                .makeSet(3)
                .makeSet(4)
                .makeSet(5)
                .makeSet(6)
                .makeSet(7);
    }

    @Test
    void union() {
        initializeData();
        disjointSet.union(3, 2)
                .union(4, 3)
                .union(6, 7)
                .union(3, 6);
        assertEquals(3, disjointSet.findSet(3));
        assertEquals(3, disjointSet.findSet(4));
        assertEquals(3, disjointSet.findSet(2));
        assertEquals(3, disjointSet.findSet(6));
        assertEquals(3, disjointSet.findSet(7));
    }

    @Test
    void findSet() {
        initializeData();
        disjointSet.union(3, 2)
                .union(4, 3)
                .union(6, 7)
                .union(3, 6);
        assertEquals(3, disjointSet.findSet(7));
    }
}