package dataStructures.abstraction.disjointSets;

public interface DisjointSet<T> {

    DisjointSet<T> makeSet(T value);
    DisjointSet<T> union(T value1, T value2);
    T findSet(T value);
}
