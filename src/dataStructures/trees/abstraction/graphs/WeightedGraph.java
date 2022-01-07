package dataStructures.trees.abstraction.graphs;

import java.util.Comparator;
import java.util.Map;

public interface WeightedGraph<T> extends Graph<T> {

    WeightedGraph<T> addEdge(T source, T destination, Integer weight);

    Map<T, Integer> findDistanceFromANode(T source, Comparator<T> comparator);
}
