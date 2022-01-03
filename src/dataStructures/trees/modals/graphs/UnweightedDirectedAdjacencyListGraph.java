package dataStructures.trees.modals.graphs;

import dataStructures.trees.abstraction.graphs.AbstractUnweightedAdjacencyListGraph;
import dataStructures.trees.abstraction.graphs.Graph;

import java.util.*;

public class UnweightedDirectedAdjacencyListGraph<T> extends AbstractUnweightedAdjacencyListGraph<T> {


    public UnweightedDirectedAdjacencyListGraph() {
        super();
    }

    @Override
    public Graph<T> addEdge(T source, T destination) {
        //In case of trivial graph, the child list will be null
        Optional.ofNullable(source).ifPresent(u -> super.addEdge(u, destination));
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

    public Deque<T> getTopologicalSort(T startingNode) {
        Deque<T> stack = new ArrayDeque<>();
        Map<T, Boolean> visited = new HashMap<>();

        if (this.isCyclic()) {
            throw new UnsupportedOperationException("Cannot find topological sort of a cyclic graph");
        } else {
            Optional.ofNullable(startingNode).ifPresent(key -> {
               topologicalSort(visited, stack, key);
            });

            adjacencyList.keySet().stream()
                    .filter(key -> !visited.containsKey(key) || !visited.get(key))
                    .forEach(key -> topologicalSort(visited, stack, key));
        }

        return stack;
    }

    public Deque<T> getTopologicalSort() {
        return getTopologicalSort(null);
    }

    private void topologicalSort(Map<T, Boolean> visited, Deque<T> stack, T key) {
        if (!visited.containsKey(key) || !visited.get(key)) {
            visited.put(key, true);

            Optional.ofNullable(adjacencyList.get(key))
                    .ifPresent(children -> children.stream().filter(child -> !visited.containsKey(child))
                    .forEach(child -> topologicalSort(visited, stack, child)));

            stack.offerFirst(key);
        }
    }
}
