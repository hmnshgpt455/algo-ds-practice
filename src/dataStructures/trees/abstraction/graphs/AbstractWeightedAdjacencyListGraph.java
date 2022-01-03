package dataStructures.trees.abstraction.graphs;

import dataStructures.trees.modals.graphs.WeightedNode;

import java.util.*;

public abstract class AbstractWeightedAdjacencyListGraph<T> implements WeightedGraph<T> {

    protected final Map<T, List<WeightedNode<T>>> adjacencyList;

    public AbstractWeightedAdjacencyListGraph() {
        this.adjacencyList = new HashMap<>();
    }

    @Override
    public WeightedGraph<T> addEdge(T source, T destination, Integer weight) {
        Optional.ofNullable(adjacencyList.get(source))
                .ifPresentOrElse(childList -> childList.add(new WeightedNode<>(destination, weight)),
                        () -> adjacencyList.put(source, new ArrayList<>(List.of(new WeightedNode<>(destination, weight)))));
        return this;
    }

    @Override
    public List<T> getBFSRepresentation(T startingNode) {

        Queue<WeightedNode<T>> vertexQueue = new LinkedList<>(adjacencyList.get(startingNode));
        Map<T, Boolean> visited = new HashMap<>();
        List<T> bfsRepresentation = new ArrayList<>();
        bfsRepresentation.add(startingNode);
        visited.put(startingNode, true);
        while (!vertexQueue.isEmpty()) {
            WeightedNode<T> currentNode = vertexQueue.poll();
            if (!visited.containsKey(currentNode.getValue())) {
                bfsRepresentation.add(currentNode.getValue());
                visited.put(currentNode.getValue(), true);
                vertexQueue.addAll(adjacencyList.get(currentNode.getValue()));
            }
        }

        return bfsRepresentation;
    }

    @Override
    public List<T> getDFSRepresentation(T startingNode) {
        List<T> dfsRepresentation = new ArrayList<>();
        Map<T, Boolean> visited = new HashMap<>();

        dfs(visited, startingNode, dfsRepresentation);

        return null;
    }

    private void dfs(Map<T, Boolean> visited, T key, List<T> dfsRepresentation) {
        if (!visited.containsKey(key)) {
            visited.put(key, true);
            adjacencyList.get(key).stream().filter(child -> !visited.containsKey(child.getValue()))
                    .forEach(child -> dfs(visited, child.getValue(), dfsRepresentation));
            dfsRepresentation.add(key);
        }
    }

}
