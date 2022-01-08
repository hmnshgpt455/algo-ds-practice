package dataStructures.abstraction.graphs;

import dataStructures.modals.graphs.WeightedNode;

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
    public Map<T, Integer> getShortestDistanceFromSourceToEveryNode(T source) {
        return dijkstraShortestPathFromSourceToEveryNode(source);
    }

    private Map<T, Integer> dijkstraShortestPathFromSourceToEveryNode(T source) {
        Map<T, Integer> shortestPathMap = new HashMap<>();
        //Create a min heap
        PriorityQueue<WeightedNode<T>> minHeap = new PriorityQueue<>(Comparator.comparingInt(WeightedNode::getWeight));
        this.adjacencyList.keySet().forEach(key -> {
           if (key.equals(source)) {
               shortestPathMap.put(key, 0);
           } else {
               shortestPathMap.put(key, Integer.MAX_VALUE);
           }
        });
        minHeap.add(new WeightedNode<>(source, 0));

        while (!minHeap.isEmpty()) {
            WeightedNode<T> minimumNode = minHeap.poll();
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

    @Override
    public Integer getShortestDistanceBetweenSourceAndDestination(T source, T destination) {
        Map<T, Integer> shortestDistanceMap = new HashMap<>();
        Map<T, T> predecessorMap = new HashMap<>();
        buildShortestPathDataMaps(source, destination, shortestDistanceMap, predecessorMap);

        return shortestDistanceMap.get(destination);
    }

    private void populateMaps(T destination, PriorityQueue<WeightedNode<T>> minHeap, Map<T, Integer> shortestDistanceMap,
                              Map<T, T> predecessorMap) {
        while (!minHeap.isEmpty()) {
            WeightedNode<T> minimumNode = minHeap.poll();
            if (minimumNode.getValue().equals(destination)) {
                return;
            }
            Optional.ofNullable(adjacencyList.get(minimumNode.getValue()))
                    .ifPresent(childList -> childList.forEach(child -> updateWeight(minimumNode, child, shortestDistanceMap, minHeap, predecessorMap)));
        }
    }

    private void updateWeight(WeightedNode<T> parent, WeightedNode<T> child, Map<T, Integer> shortestDistanceMap,
                              PriorityQueue<WeightedNode<T>> minHeap, Map<T, T> predecessorMap) {
        int sourceToParentWeight = parent.getWeight();
        int childWeight = child.getWeight();

        if (!shortestDistanceMap.containsKey(child.getValue()) ||
                (sourceToParentWeight + childWeight) < shortestDistanceMap.get(child.getValue())) {
            shortestDistanceMap.put(child.getValue(), sourceToParentWeight + childWeight);
            predecessorMap.put(child.getValue(), parent.getValue());
            minHeap.add(new WeightedNode<>(child.getValue(), sourceToParentWeight + child.getWeight()));
        }
    }

    @Override
    public Stack<T> getShortestPathFromSourceToDestination(T source, T destination) {

        Map<T, Integer> shortestDistanceMap = new HashMap<>();
        Map<T, T> predecessorMap = new HashMap<>();
        buildShortestPathDataMaps(source, destination, shortestDistanceMap, predecessorMap);
        Stack<T> shortestPath = new Stack<>();

        T currentNode = destination;
        shortestPath.push(destination);
        while (predecessorMap.get(currentNode) != null) {
            shortestPath.push(predecessorMap.get(currentNode));
            currentNode = predecessorMap.get(currentNode);
        }

        return shortestPath;
    }

    private void buildShortestPathDataMaps(T source, T destination, Map<T, Integer> shortestDistanceMap, Map<T, T> predecessorMap) {
        PriorityQueue<WeightedNode<T>> minHeap = new PriorityQueue<>(Comparator.comparingInt(WeightedNode::getWeight));
        shortestDistanceMap.put(source, 0);
        minHeap.add(new WeightedNode<>(source, 0));
        populateMaps(destination, minHeap, shortestDistanceMap, predecessorMap);
    }

}
