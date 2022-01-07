package dataStructures.driverClasses.graphs;

import dataStructures.abstraction.graphs.UnweightedGraph;
import dataStructures.impl.graphs.UnweightedUndirectedAdjacencyListGraph;

public class FindIfUndirectedGraphIsCyclic {
    public static void main(String[] args) {
        UnweightedGraph<Integer> graph1 = new UnweightedUndirectedAdjacencyListGraph<>();
        UnweightedGraph<Integer> graph2 = new UnweightedUndirectedAdjacencyListGraph<>();

        graph1.addEdge(1, 0)
                .addEdge(0, 2)
                .addEdge(0, 3)
                .addEdge(100, 100)
                .addEdge(3, 100)
                .addEdge(3, 4);

        graph2.addEdge(0, 1)
                .addEdge(2, 1);

        System.out.println("Is graph cyclic : " + graph1.isCyclic());
        System.out.println("Is graph cyclic : " + graph2.isCyclic());
    }
}
