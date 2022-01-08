package dataStructures.abstraction.graphs;

import java.util.*;

public abstract class AbstractUnweightedAdjacencyListGraph<T> implements UnweightedGraph<T> {

    protected final Map<T, List<T>> adjacencyList;

    public AbstractUnweightedAdjacencyListGraph() {
        this.adjacencyList = new HashMap<>();
    }

    @Override
    public UnweightedGraph<T> addEdge(T source, T destination) {
        //In case of trivial graph, the child list will be null
        Optional.ofNullable(adjacencyList.get(source))
                .ifPresentOrElse(childList -> Optional.ofNullable(destination).ifPresent(childList::add),
                        () -> Optional.ofNullable(destination)
                                .ifPresentOrElse(v -> {
                                    List<T> newChildList = new ArrayList<>();
                                    newChildList.add(v);
                                    adjacencyList.put(source, newChildList);
                                }, () -> adjacencyList.put(source, null)));
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

    @Override
    public Map<T, Integer> getShortestDistanceFromSourceToEveryNode(T source) {
        Map<T, Integer> shortestDistanceMap = new HashMap<>();
        Map<T, T> predecessorMap = new HashMap<>();

        doBfsAndUpdateMaps(source, shortestDistanceMap, predecessorMap);

        return shortestDistanceMap;
    }

    @Override
    public Integer getShortestDistanceBetweenSourceAndDestination(T source, T destination) {
        Map<T, Integer> shortestDistanceMap = new HashMap<>();
        shortestDistanceMap.put(source, 0);

        Queue<T> queue = new LinkedList<>();
        queue.add(source);
        Map<T, Boolean> visited = new HashMap<>();
        visited.put(source, true);
        while (!queue.isEmpty()) {
            T currentNode = queue.poll();
            if (adjacencyList.get(currentNode) != null) {
                for (T child : adjacencyList.get(currentNode)) {
                    if (!visited.containsKey(child)) {
                        if (child.equals(destination)) {
                            return shortestDistanceMap.get(currentNode) + 1;
                        } else {
                            visited.put(child, true);
                            shortestDistanceMap.put(child, shortestDistanceMap.get(currentNode) + 1);
                            queue.add(child);
                        }
                    }
                }
            }
        }

        return shortestDistanceMap.get(destination);
    }

    @Override
    public Stack<T> getShortestPathFromSourceToDestination(T source, T destination) {
        Stack<T> shortestPath = new Stack<>();
        Map<T, T> predecessorMap = new HashMap<>();

        Queue<T> queue = new LinkedList<>();
        queue.add(source);
        predecessorMap.put(source, null);
        Map<T, Boolean> visited = new HashMap<>();
        visited.put(source, true);
        boolean isDestinationReached = false;
        while (!queue.isEmpty()) {
            T currentNode = queue.poll();
            if (null != adjacencyList.get(currentNode)) {
                for (T child : adjacencyList.get(currentNode)) {
                    if (!visited.containsKey(child)) {
                        if (child.equals(destination)) {
                            predecessorMap.put(destination, currentNode);
                            isDestinationReached = true;
                            break;
                        } else {
                            visited.put(child, true);
                            predecessorMap.put(child, currentNode);
                            queue.add(child);
                        }
                    }
                }
            }
            if (isDestinationReached) {
                break;
            }
        }

        T currentNodeInPath = destination;
        shortestPath.push(currentNodeInPath);
        while (predecessorMap.get(currentNodeInPath) != null) {
            shortestPath.push(predecessorMap.get(currentNodeInPath));
            currentNodeInPath = predecessorMap.get(currentNodeInPath);
        }
        return shortestPath;
    }

    private void dfs(List<T> dfsRepresentation, T startingNode, Map<T, Boolean> visited) {
        if (!visited.containsKey(startingNode) || !visited.get(startingNode)) {
            visited.put(startingNode, true);
            this.adjacencyList.get(startingNode).forEach(node -> dfs(dfsRepresentation, node, visited));
            dfsRepresentation.add(startingNode);
        }
    }

    private void doBfsAndUpdateMaps(T source, Map<T, Integer> shortestDistanceMap, Map<T, T> predecessorMap) {
        Queue<T> queue = new LinkedList<>();
        queue.add(source);
        shortestDistanceMap.put(source, 0);
        predecessorMap.put(source, null);
        Map<T, Boolean> visited = new HashMap<>();
        visited.put(source, true);


        while (!queue.isEmpty()) {
            T currentPredecessor = queue.poll();
            Optional.ofNullable(adjacencyList.get(currentPredecessor)).ifPresent(childList -> childList.forEach(child -> {
                if (!visited.containsKey(child)) {
                    predecessorMap.put(child, currentPredecessor);
                    shortestDistanceMap.put(child, shortestDistanceMap.get(currentPredecessor) + 1);
                    visited.put(child, true);
                    queue.add(child);
                }
            }));
        }

    }

    public Map<T, List<T>> getAdjacencyList() {
        return adjacencyList;
    }
}
