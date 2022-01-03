package dataStructures.trees.abstraction.graphs;

import java.util.List;

public interface Graph<T> {

    List<T> getBFSRepresentation(T startingNode);
    List<T> getDFSRepresentation(T startingNode);
    Boolean isCyclic();
}
