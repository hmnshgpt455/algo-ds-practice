package dataStructures.trees.driverClasses.graphs;

import dataStructures.trees.abstraction.graphs.WeightedGraph;
import dataStructures.trees.impl.graphs.WeightedDirectedAdjacencyListGraph;
import dataStructures.trees.impl.graphs.WeightedUndirectedAdjacencyListGraph;

public class FindIfWeightedUndirectedGraphIsCyclic {
    public static void main(String[] args) {
        WeightedGraph<Integer> graph = new WeightedUndirectedAdjacencyListGraph<>();
        graph.addEdge(0, 1, 10)
                .addEdge(0, 2, 10)
                .addEdge(1, 2, 10)
                .addEdge(2, 4, 10)
                .addEdge(2, 3, 10)
                .addEdge(3, 4, 10)
                .addEdge(150, 150, 10)
                .addEdge(100, -1, 10);

        System.out.println("Is graph cyclic : " + graph.isCyclic());
    }
}
