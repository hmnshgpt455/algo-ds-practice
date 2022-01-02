package dataStructures.trees.driverClasses.graphs;

import dataStructures.trees.modals.graphs.UnweightedAdjacencyListGraph;

public class FindIfDirectedGraphIsCyclic {
    public static void main(String[] args) {
        UnweightedAdjacencyListGraph<Integer> graph = new UnweightedAdjacencyListGraph<>();
        graph.addDirectedEdge(0, 1)
                .addDirectedEdge(0, 2)
                .addDirectedEdge(1, 2)
                .addDirectedEdge(2, 4)
                .addDirectedEdge(2, 3)
                .addDirectedEdge(3, 4)
                .addDirectedEdge(150, null)
                .addDirectedEdge(100, -1);

        System.out.println("Is graph cyclic : " + graph.findIfGraphIsCyclic());
    }
}
