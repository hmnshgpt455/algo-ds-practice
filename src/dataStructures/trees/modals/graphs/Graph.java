package dataStructures.trees.modals.graphs;

public interface Graph<T> {

    Graph<T> addEdge(T u, T v);
    Graph<T> addEdgeBidirectional(T u, T v);
}
