package dataStructures.driverClasses.utils;

import dataStructures.impl.graphs.UnweightedDirectedAdjacencyListGraph;

public class GraphUtil {

    public void printGraph(UnweightedDirectedAdjacencyListGraph<?> graph) {
        graph.getAdjacencyList().forEach((vertex, adjacentVerticesList) -> {
            System.out.println("Adjacency list for vertex : " + vertex);
            adjacentVerticesList.forEach(v -> System.out.print(v + "-> "));
            System.out.println();
        });
    }
}
