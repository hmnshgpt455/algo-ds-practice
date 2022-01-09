package dataStructures.abstraction.graphs;

import dataStructures.modals.graphs.Edge;

import java.util.List;

public interface WeightedGraph<T> extends Graph<T> {

    WeightedGraph<T> addEdge(T source, T destination, Integer weight);
    List<Edge<T>> getPrimMinimumSpanningTree();
    List<Edge<T>> getKruskalMinimumSpanningTree();
}
