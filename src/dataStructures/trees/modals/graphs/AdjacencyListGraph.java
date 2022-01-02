package dataStructures.trees.modals.graphs;

import java.util.*;

public class AdjacencyListGraph<T> implements Graph<T> {

    private final Map<T, List<T>> adjacencyList;

    public AdjacencyListGraph() {
        adjacencyList = new HashMap<>();
    }

    public AdjacencyListGraph(HashMap<T, List<T>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    @Override
    public Graph<T> addEdge(T u, T v) {
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
    public Graph<T> addEdgeBidirectional(T u, T v) {
        this.addEdge(u, v);
        this.addEdge(v, u);
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

    public Map<T, List<T>> getAdjacencyList() {
        return adjacencyList;
    }
}
