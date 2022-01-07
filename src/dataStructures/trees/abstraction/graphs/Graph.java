package dataStructures.trees.abstraction.graphs;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public interface Graph<T> {

    List<T> getBFSRepresentation(T startingNode);
    List<T> getDFSRepresentation(T startingNode);
    Boolean isCyclic();
    Map<T, Integer> getShortestDistanceFromSourceToEveryNode(T source);
    Integer getShortestDistanceBetweenSourceAndDestination(T source, T destination);
    Stack<T> getShortestPathFromSourceToDestination(T source, T destination);
}
