package dataStructures.trees.driverClasses.utils;

import dataStructures.trees.modals.graphs.UnweightedAdjacencyListGraph;

public class GraphUtil {

    public void printGraph(UnweightedAdjacencyListGraph<?> graph) {
        graph.getAdjacencyList().forEach((vertex, adjacentVerticesList) -> {
            System.out.println("Adjacency list for vertex : " + vertex);
            adjacentVerticesList.forEach(v -> System.out.print(v + "-> "));
            System.out.println();
        });
    }
}
