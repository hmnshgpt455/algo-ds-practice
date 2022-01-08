package dataStructures.driverClasses.graphs;

import dataStructures.abstraction.graphs.WeightedGraph;
import dataStructures.impl.graphs.WeightedDirectedAdjacencyListGraph;

import java.util.Map;
import java.util.Stack;

public class ShortestPathInWeightedGraph {
    public static void main(String[] args) {
        WeightedGraph<Integer> weightedGraph = new WeightedDirectedAdjacencyListGraph<>();
        weightedGraph.addEdge(0,1, 4)
                .addEdge(0, 7, 8)
                .addEdge(1, 2, 8)
                .addEdge(1, 7, 11)
                .addEdge(1, 0, 7)
                .addEdge(2, 1, 8)
                .addEdge(2, 3, 7)
                .addEdge(2, 8, 2)
                .addEdge(2, 5, 4)
                .addEdge(3, 2, 7)
                .addEdge(3, 4, 9)
                .addEdge(3, 5, 14)
                .addEdge(4, 3, 9)
                .addEdge(4, 5, 10)
                .addEdge(5, 4, 10)
                .addEdge(5, 6, 2)
                .addEdge(6, 5, 2)
                .addEdge(6, 7, 1)
                .addEdge(6, 8, 6)
                .addEdge(7, 0, 8)
                .addEdge(7, 1, 11)
                .addEdge(7, 6, 1)
                .addEdge(7, 8, 7)
                .addEdge(8, 2, 2)
                .addEdge(8, 6, 6)
                .addEdge(8, 7, 1);

        Map<Integer, Integer> shortestPathMap = weightedGraph.getShortestDistanceFromSourceToEveryNode(8);
        shortestPathMap.forEach((key, value) -> System.out.println(key + " " + value));
        System.out.println(weightedGraph.getShortestDistanceBetweenSourceAndDestination(8, 5));
        Stack<Integer> shortestPath = weightedGraph.getShortestPathFromSourceToDestination(8, 6);
        while (!shortestPath.isEmpty()) {
            System.out.print(shortestPath.pop() + " ");
        }
    }
}
