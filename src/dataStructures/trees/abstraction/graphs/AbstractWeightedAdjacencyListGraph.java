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

    @Override
    public Map<T, Integer> findDistanceFromANode(T source, Comparator<T> comparator) {
        return dijkstraShortestPathFromSourceToEveryNode(source, comparator);
    }

    private Map<T, Integer> dijkstraShortestPathFromSourceToEveryNode(T source, Comparator<T> comparator) {
        Map<T, Integer> shortestPathMap = new HashMap<>();
        //Create a min heap
        PriorityQueue<WeightedNode<T>> minHeap = new PriorityQueue<>(Comparator.comparingInt(WeightedNode::getWeight));
        this.adjacencyList.keySet().forEach(key -> {
           if (comparator.compare(key, source) == 0) {
               shortestPathMap.put(key, 0);
           } else {
               shortestPathMap.put(key, Integer.MAX_VALUE);
           }
        });
        minHeap.add(new WeightedNode<>(source, 0));

        while (!minHeap.isEmpty()) {
            WeightedNode<T> minimumNode = minHeap.poll();
            shortestPathMap.put(minimumNode.getValue(), minimumNode.getWeight());
            adjacencyList.get(minimumNode.getValue()).forEach(child -> updateWeight(minimumNode.getWeight(), child, shortestPathMap, minHeap));
        }

        return shortestPathMap;
    }

    private void updateWeight(int sourceToParentWeight, WeightedNode<T> child, Map<T, Integer> shortestPathMap, PriorityQueue<WeightedNode<T>> minHeap) {
        //If the weight of (source to parent + parent to child) < current weight from source to child, update the weight
        if ((sourceToParentWeight + child.getWeight()) < shortestPathMap.get(child.getValue())) {
            shortestPathMap.put(child.getValue(), sourceToParentWeight + child.getWeight());
            minHeap.add(new WeightedNode<>(child.getValue(), sourceToParentWeight + child.getWeight()));
        }
    }


}
