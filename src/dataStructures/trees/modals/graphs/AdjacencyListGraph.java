package dataStructures.trees.modals.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    public Map<T, List<T>> getAdjacencyList() {
        return adjacencyList;
    }
}
