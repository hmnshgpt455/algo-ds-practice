package dataStructures.trees.modals.graphs;

import java.util.List;

public interface Graph<T> {

    Graph<T> addEdge(T u, T v);
    Graph<T> addEdgeBidirectional(T u, T v);
    List<T> getBFSRepresentation(T startingNode);
}
