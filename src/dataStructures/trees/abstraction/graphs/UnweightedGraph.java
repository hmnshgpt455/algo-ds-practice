package dataStructures.trees.abstraction.graphs;

public interface UnweightedGraph<T> extends Graph<T> {

    UnweightedGraph<T> addEdge(T source, T destination);
}
