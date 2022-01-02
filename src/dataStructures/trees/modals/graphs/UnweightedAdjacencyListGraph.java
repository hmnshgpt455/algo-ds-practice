package dataStructures.trees.modals.graphs;

import java.util.*;

public class UnweightedAdjacencyListGraph<T> implements Graph<T> {

    private final Map<T, List<T>> adjacencyList;

    public UnweightedAdjacencyListGraph() {
        adjacencyList = new HashMap<>();
    }

    public UnweightedAdjacencyListGraph(HashMap<T, List<T>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    @Override
    public Graph<T> addEdgeDirected(T u, T v) {
        if (adjacencyList.containsKey(u)) {
            adjacencyList.get(u).add(v);
        } else {
            List<T> edgeList = new ArrayList<>();
            edgeList.add(v);
            adjacencyList.put(u, edgeList);
        }
        return this;
    }

    @Override
    public Graph<T> addUndirectedEdge(T u, T v) {
        this.addEdgeDirected(u, v);
        this.addEdgeDirected(v, u);
        return this;
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
