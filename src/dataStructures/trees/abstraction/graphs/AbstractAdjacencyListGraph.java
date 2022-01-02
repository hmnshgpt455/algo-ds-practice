package dataStructures.trees.abstraction.graphs;

import java.util.*;

public abstract class AbstractAdjacencyListGraph<T> implements Graph<T> {

    protected final Map<T, List<T>> adjacencyList;

    public AbstractAdjacencyListGraph() {
        this.adjacencyList = new HashMap<>();
    }

    @Override
    public List<T> getBFSRepresentation(T startingNode) {
        List<T> bfsRepresentation = new ArrayList<>();
        LinkedList<T> queue = new LinkedList<>();
        queue.add(startingNode);
        Map<T, Boolean> visited = new HashMap<>();
        while (!queue.isEmpty()) {
            T currentHead = queue.poll();
            if (!visited.containsKey(currentHead) || !visited.get(currentHead)) {
                visited.put(currentHead, true);
                bfsRepresentation.add(currentHead);
                queue.addAll(this.adjacencyList.get(currentHead));
            }
        }

        return bfsRepresentation;
    }

    @Override
    public List<T> getDFSRepresentation(T startingNode) {
        List<T> dfsRepresentation = new ArrayList<>();
        Map<T, Boolean> visited = new HashMap<>();
        dfs(dfsRepresentation, startingNode, visited);
        return dfsRepresentation;
    }

    private void dfs(List<T> dfsRepresentation, T startingNode, Map<T, Boolean> visited) {
        if (!visited.containsKey(startingNode) || visited.get(startingNode)) {
            visited.put(startingNode, false);
            this.adjacencyList.get(startingNode).forEach(node -> dfs(dfsRepresentation, node, visited));
            dfsRepresentation.add(startingNode);
        }
    }

    public Map<T, List<T>> getAdjacencyList() {
        return adjacencyList;
    }
}
