package dataStructures.trees.impl.graphs;

import dataStructures.trees.abstraction.graphs.AbstractWeightedAdjacencyListGraph;
import dataStructures.trees.abstraction.graphs.WeightedGraph;
import dataStructures.trees.modals.graphs.WeightedNode;

import java.util.HashMap;
import java.util.Map;

public class WeightedUndirectedAdjacencyListGraph<T> extends AbstractWeightedAdjacencyListGraph<T> {

    @Override
    public WeightedGraph<T> addEdge(T source, T destination, Integer weight) {
        super.addEdge(source, destination, weight);
        super.addEdge(destination, source, weight);

        return this;
    }

    @Override
    public Boolean isCyclic() {
        Map<T, Boolean> visited = new HashMap<>();

        for (T key : adjacencyList.keySet()) {
            if (!visited.containsKey(key)) {
                if (isCyclic(key, visited, null)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isCyclic(T key, Map<T, Boolean> visited, T parent) {
        visited.put(key, true);
        for (WeightedNode<T> child : adjacencyList.get(key)) {
            if (!visited.containsKey(child.getValue())) {
                if (isCyclic(child.getValue(), visited, key)) {
                    return true;
                }
            } else if (child.getValue() != parent) {
                return true;
            }
        }

        return false;
    }
}
