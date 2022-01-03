package dataStructures.trees.abstraction.graphs;

public interface WeightedGraph<T> extends Graph<T> {

    WeightedGraph<T> addEdge(T source, T destination, Integer weight);
}
