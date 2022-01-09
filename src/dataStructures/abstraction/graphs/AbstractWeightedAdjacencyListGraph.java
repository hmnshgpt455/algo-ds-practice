package dataStructures.abstraction.graphs;

import dataStructures.abstraction.disjointSets.DisjointSet;
import dataStructures.impl.disjointSets.UnionByRankAndPathCompressionDisjointSet;
import dataStructures.modals.graphs.Edge;
import dataStructures.modals.graphs.WeightedNode;

import java.util.*;

/**
 * @author Himanshu Gupta
 * @param <T>
 */

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

    @Override
    public Map<T, Integer> getShortestDistanceFromSourceToEveryNode(T source) {
        return dijkstraShortestPathFromSourceToEveryNode(source);
    }

    @Override
    public Integer getShortestDistanceBetweenSourceAndDestination(T source, T destination) {
        Map<T, Integer> shortestDistanceMap = new HashMap<>();
        Map<T, T> predecessorMap = new HashMap<>();
        buildShortestPathDataMaps(source, destination, shortestDistanceMap, predecessorMap);

        return shortestDistanceMap.get(destination);
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

    @Override
    public List<Edge<T>> getPrimMinimumSpanningTree() {
        //This will hold the edges of the MST
        List<Edge<T>> minimumSpanningTreeEdges = new ArrayList<>();
        //This is the binary min heap according to the weights
        PriorityQueue<WeightedNode<T>> minHeap = new PriorityQueue<>(Comparator.comparingInt(WeightedNode::getWeight));
        //This will hold the node to the minimum edge length encountered till now. This will be updated to the latest minimum, if another lesser length is encountered
        Map<T, Integer> nodeToEdgeLengthMap = new HashMap<>();
        //This will hold the node to the edge to reach that node which will be included in MST.
        //This will again be updated based on if we get another edge that has lesser length. So, if above map gets updated, this will also get updated.
        Map<T, Edge<T>> nodeToEdgeIncludedInMST = new HashMap<>();
        //Initialize the weight of each node to be as INF
        adjacencyList.keySet().forEach(key -> nodeToEdgeLengthMap.put(key, Integer.MAX_VALUE));
        //Pick a random startingNode
        T startingNode = adjacencyList.keySet().iterator().next();
        //The edge length from the starting node to itself is 0
        nodeToEdgeLengthMap.put(startingNode, 0);
        minHeap.add(new WeightedNode<>(startingNode, 0));

        while (!minHeap.isEmpty()) {
            //Greedily picking the node with currently the least weighted edge
            WeightedNode<T> minimumWeightNode = minHeap.poll();
            //Remove this minimum from the map, so that it is not picked again
            nodeToEdgeLengthMap.remove(minimumWeightNode.getValue());
            if (nodeToEdgeIncludedInMST.get(minimumWeightNode.getValue()) != null) {
                //If the node is not the starting node, include it's edge in the result MST edge list.
                minimumSpanningTreeEdges.add(nodeToEdgeIncludedInMST.get(minimumWeightNode.getValue()));
            }

            //For each child update the data as required
            adjacencyList.get(minimumWeightNode.getValue())
                    .forEach(child -> updatePrimMSTData(minHeap, nodeToEdgeIncludedInMST, nodeToEdgeLengthMap, minimumWeightNode, child));
        }

        return minimumSpanningTreeEdges;
    }

    @Override
    public List<Edge<T>> getKruskalMinimumSpanningTree() {
        //Initialize the disjoint set which keeps the information of which vertex are included in the same set
        DisjointSet<T> verticesDisjointSet = new UnionByRankAndPathCompressionDisjointSet<>();
        //All the edges list
        List<Edge<T>> edgeList = new ArrayList<>();
        //Populate the data
        makeDisjointSetAndEdgeList(edgeList, verticesDisjointSet);
        //Sort the list, so that we can greedily pick the least weighted edge
        edgeList.sort(Comparator.comparingInt(Edge::getWeight));
        //Iterate through each edge and check if we can put it in the MST (if the edge vertices are not
        // in the same set, we pick that edge and put it in the MST)
        List<Edge<T>> mstEdgesList = new ArrayList<>();
        edgeList.forEach(edge -> {
            //Get the sets of both the source and the destination
           T set1 = verticesDisjointSet.findSet(edge.getSource());
           T set2 = verticesDisjointSet.findSet(edge.getDestination());

           if (!set1.equals(set2)) {
               //If both the vertices are not in the same set, that means their edge has not been included
               //Add the edge to the MST edges list because this is the edge which has the minimum weight till now.
               mstEdgesList.add(edge);
               //Make the sets of both the source and the destination same
               verticesDisjointSet.union(edge.getSource(), edge.getDestination());
           }
        });

        return mstEdgesList;
    }

    private void makeDisjointSetAndEdgeList(List<Edge<T>> edgeList, DisjointSet<T> verticesDisjointSet) {
        adjacencyList.forEach((vertex, neighbourList) -> {
            //Make a set for each vertex in the graph
            verticesDisjointSet.makeSet(vertex);
            Optional.ofNullable(neighbourList)
                    .ifPresent(neighbours -> neighbours
                            .forEach(neighbour -> {
                                //For each child, add a edge in the edge list
                                edgeList.add(new Edge<>(vertex, neighbour.getValue(), neighbour.getWeight()));
                            }));
        });
    }

    private void updatePrimMSTData(PriorityQueue<WeightedNode<T>> minHeap, Map<T, Edge<T>> nodeToEdgeIncludedInMST,
                                   Map<T, Integer> nodeToEdgeLengthMap, WeightedNode<T> parent, WeightedNode<T> child) {

        if (nodeToEdgeLengthMap.containsKey(child.getValue()) && nodeToEdgeLengthMap.get(child.getValue()) > child.getWeight()) {
            //If the stored length of an edge for the child node is more than the current edge length to the child, update the new weight
            nodeToEdgeLengthMap.put(child.getValue(), child.getWeight());
            //Update the edge in the MST for this child
            nodeToEdgeIncludedInMST.put(child.getValue(), new Edge<>(parent.getValue(), child.getValue()));
            //Remove the previous value
            minHeap.remove(child);
            //Add the new value
            minHeap.add(child);
        }
    }

    private void dfs(Map<T, Boolean> visited, T key, List<T> dfsRepresentation) {
        if (!visited.containsKey(key)) {
            visited.put(key, true);
            adjacencyList.get(key).stream().filter(child -> !visited.containsKey(child.getValue()))
                    .forEach(child -> dfs(visited, child.getValue(), dfsRepresentation));
            dfsRepresentation.add(key);
        }
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
            if (adjacencyList.get(minimumNode.getValue()) != null) {
                adjacencyList.get(minimumNode.getValue()).forEach(child -> updateWeight(minimumNode.getWeight(), child, shortestPathMap, minHeap));
            }
        }

        return shortestPathMap;
    }

    private void updateWeight(int sourceToParentWeight, WeightedNode<T> child, Map<T, Integer> shortestPathMap, PriorityQueue<WeightedNode<T>> minHeap) {
        //If the weight of (source to parent + parent to child) < current weight from source to child, update the weight
        if (!shortestPathMap.containsKey(child.getValue()) || (sourceToParentWeight + child.getWeight()) < shortestPathMap.get(child.getValue())) {
            shortestPathMap.put(child.getValue(), sourceToParentWeight + child.getWeight());
            minHeap.remove(child);
            minHeap.add(new WeightedNode<>(child.getValue(), sourceToParentWeight + child.getWeight()));
        }
    }

    private void populateMaps(PriorityQueue<WeightedNode<T>> minHeap, Map<T, Integer> shortestDistanceMap,
                              Map<T, T> predecessorMap) {
        while (!minHeap.isEmpty()) {
            WeightedNode<T> minimumNode = minHeap.poll();
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

    private void buildShortestPathDataMaps(T source, T destination, Map<T, Integer> shortestDistanceMap, Map<T, T> predecessorMap) {
        PriorityQueue<WeightedNode<T>> minHeap = new PriorityQueue<>(Comparator.comparingInt(WeightedNode::getWeight));
        shortestDistanceMap.put(source, 0);
        minHeap.add(new WeightedNode<>(source, 0));
        populateMaps(minHeap, shortestDistanceMap, predecessorMap);
    }

}
