package dataStructures.trees.modals.graphs;

import dataStructures.trees.abstraction.graphs.AbstractAdjacencyListGraph;
import dataStructures.trees.abstraction.graphs.Graph;

import java.util.*;

public class UnweightedDirectedAdjacencyListGraph<T> extends AbstractAdjacencyListGraph<T> {


    public UnweightedDirectedAdjacencyListGraph() {
        super();
    }

    @Override
    public Graph<T> addEdge(T source, T destination) {
        //In case of trivial graph, the child list will be null
        if (adjacencyList.containsKey(source)) {
            Optional.ofNullable(adjacencyList.get(source))
                    .ifPresentOrElse(childList -> childList.add(destination), () -> Optional.ofNullable(destination)
                            .ifPresent(v -> {
                                List<T> newChildList = new ArrayList<>();
                                newChildList.add(destination);
                                adjacencyList.put(source, newChildList);
                            }));
        } else {
            Optional.ofNullable(destination).ifPresentOrElse(v -> {
                List<T> edgeList = new ArrayList<>();
                edgeList.add(v);
                adjacencyList.put(source, edgeList);
            }, () -> adjacencyList.put(source, null));

        }
        return this;
    }

    @Override
    public Boolean isCyclic() {
        Map<T, Boolean> visited = new HashMap<>();
        Map<T, Boolean> recursionStack = new HashMap<>();

        for(T key : this.adjacencyList.keySet()) {
            if (isCyclic(visited, recursionStack, key)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCyclic(Map<T, Boolean> visited, Map<T, Boolean> recursionStack, T key) {

        if (recursionStack.containsKey(key) && recursionStack.get(key)) {
            return true;
        }

        if (visited.containsKey(key) && visited.get(key)) {
            return false;
        }

        recursionStack.put(key, true);
        visited.put(key, true);

        if (adjacencyList.get(key) != null) { //This check is for trivial graph
            for (T child : adjacencyList.get(key)) {
                if (isCyclic(visited, recursionStack, child)) {
                    return true;
                }
            }
        }
        recursionStack.put(key, false);
        return false;
    }
}
