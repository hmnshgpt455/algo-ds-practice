package dataStructures.trees.modals.graphs;

import java.util.List;

public interface Graph<T> {

    Graph<T> addDirectedEdge(T u, T v);
    Graph<T> addUndirectedEdge(T u, T v);
    List<T> getBFSRepresentation(T startingNode);
    List<T> getDFSRepresentation(T startingNode);
    Boolean findIfGraphIsCyclic();
}
