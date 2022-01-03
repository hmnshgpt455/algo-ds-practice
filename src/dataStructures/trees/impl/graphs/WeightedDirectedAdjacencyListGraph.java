package dataStructures.trees.impl.graphs;

import dataStructures.trees.abstraction.graphs.AbstractWeightedAdjacencyListGraph;
import dataStructures.trees.abstraction.graphs.WeightedGraph;
import dataStructures.trees.modals.graphs.WeightedNode;

import java.util.*;

public class WeightedDirectedAdjacencyListGraph<T> extends AbstractWeightedAdjacencyListGraph<T> {

    public WeightedDirectedAdjacencyListGraph() {
        super();
    }

    @Override
    public Boolean isCyclic() {
        Map<T, Boolean> visited = new HashMap<>();
        Map<T, Boolean> recursionStack = new HashMap<>();

        for (T key : adjacencyList.keySet()) {
            if (isCyclic(key, visited, recursionStack)) {
                return true;
            }
        }
        return null;
    }

    private boolean isCyclic(T key, Map<T, Boolean> visited, Map<T, Boolean> recursionStack) {

        if (visited.containsKey(key)) {
            return recursionStack.containsKey(key) && recursionStack.get(key);
        }
        visited.put(key, true);
        recursionStack.put(key, true);
        for (WeightedNode<T> child : adjacencyList.get(key)) {
            if (!visited.containsKey(key) && isCyclic(child.getValue(), visited, recursionStack)) {
                return true;
            }
        }
        recursionStack.put(key, false);
        return false;
    }

    public Deque<T> getTopologicalSort(T startingNode) {
        Deque<T> stack = new ArrayDeque<>();
        Map<T, Boolean> visited = new HashMap<>();

        if (this.isCyclic()) {
            throw new UnsupportedOperationException("Topological sort cannot be done for cyclic graphs");
        }

        Optional.ofNullable(startingNode).ifPresent(sn -> topologicalSort(startingNode, visited, stack));

        adjacencyList.keySet().stream().filter(key -> !visited.containsKey(key))
                .forEach(key -> topologicalSort(key, visited, stack));

        return stack;
    }

    private void topologicalSort(T node, Map<T, Boolean> visited, Deque<T> stack) {
        if (!visited.containsKey(node)) {
            visited.put(node, true);
            adjacencyList.get(node).forEach(child -> topologicalSort(child.getValue(), visited, stack));
            stack.offerFirst(node);
        }
    }
}
