package dataStructures.trees.modals.graphs;

import dataStructures.trees.abstraction.graphs.Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UnweightedUndirectedAdjacencyListGraph<T> extends UnweightedDirectedAdjacencyListGraph<T> {
    @Override
    public Graph<T> addEdge(T source, T destination) {
        Optional.ofNullable(source).ifPresent(u -> super.addEdge(u, destination));
        Optional.ofNullable(destination).ifPresent(v -> super.addEdge(v, source));
        return this;
    }

    @Override
    public Boolean isCyclic() {

        Map<T, Boolean> visited = new HashMap<>();
        for (T key : adjacencyList.keySet()) {
            if (!visited.containsKey(key) || !visited.get(key)) {
                if (isCyclic(key, visited, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclic(T key, Map<T, Boolean> visited, T parent) {

        visited.put(key, true);
        if (adjacencyList.get(key) != null) {
            for (T connectedNode : adjacencyList.get(key)) {
                if (!visited.containsKey(connectedNode) || !visited.get(connectedNode)) {
                    if (isCyclic(connectedNode, visited, key)) {
                        return true;
                    }
                } else if (parent != connectedNode) {
                    return true;
                }
            }
        }

        return false;
    }
}
