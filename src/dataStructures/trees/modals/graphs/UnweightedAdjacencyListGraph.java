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
    public Graph<T> addDirectedEdge(T source, T destination) {
        //In case of trivial graph, the child list will be null
        if (adjacencyList.containsKey(source)) {
            Optional.ofNullable(adjacencyList.get(source))
                    .ifPresentOrElse(childList -> childList.add(destination), () -> Optional.ofNullable(destination)
                            .ifPresent(v -> {
                                List<T> newChildList = new ArrayList<>();
                                newChildList.add(destination);
                                adjacencyList.put(source, newChildList);
                            }));
        } else {
            Optional.ofNullable(destination).ifPresentOrElse(v -> {
                List<T> edgeList = new ArrayList<>();
                edgeList.add(v);
                adjacencyList.put(source, edgeList);
            }, () -> adjacencyList.put(source, null));

        }
        return this;
    }

    @Override
    public Graph<T> addUndirectedEdge(T u, T v) {
        this.addDirectedEdge(u, v);
        this.addDirectedEdge(v, u);
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

    @Override
    public Boolean findIfGraphIsCyclic() {
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
}
