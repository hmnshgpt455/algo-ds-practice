package dataStructures.driverClasses.graphs;

import dataStructures.abstraction.graphs.UnweightedGraph;
import dataStructures.impl.graphs.UnweightedUndirectedAdjacencyListGraph;

import java.util.Stack;

public class ShortestPathInUnweightedGraph {
    public static void main(String[] args) {
        UnweightedGraph<Integer> unweightedGraph = new UnweightedUndirectedAdjacencyListGraph<>();
        unweightedGraph.addEdge(0, 1)
                .addEdge(0, 3)
                .addEdge(1, 2)
                .addEdge(3, 4)
                .addEdge(3, 7)
                .addEdge(4, 5)
                .addEdge(4, 6)
                .addEdge(4, 7)
                .addEdge(5, 6)
                .addEdge(6, 7);

        System.out.println(unweightedGraph.getShortestDistanceBetweenSourceAndDestination(2, 6));
        Stack<Integer> path = unweightedGraph.getShortestPathFromSourceToDestination(2, 6);
        while (!path.isEmpty()) {
            System.out.print(path.pop() + " ");
        }
    }
}
