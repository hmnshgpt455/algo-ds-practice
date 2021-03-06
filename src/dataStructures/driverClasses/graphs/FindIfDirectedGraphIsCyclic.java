package dataStructures.driverClasses.graphs;

import dataStructures.impl.graphs.UnweightedDirectedAdjacencyListGraph;

public class FindIfDirectedGraphIsCyclic {
    public static void main(String[] args) {
        UnweightedDirectedAdjacencyListGraph<Integer> graph = new UnweightedDirectedAdjacencyListGraph<>();
        graph.addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 2)
                .addEdge(2, 4)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .addEdge(150, 150)
                .addEdge(100, -1);

        System.out.println("Is graph cyclic : " + graph.isCyclic());
    }
}
