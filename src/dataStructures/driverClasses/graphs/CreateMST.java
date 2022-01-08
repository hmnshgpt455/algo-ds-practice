package dataStructures.driverClasses.graphs;

import dataStructures.abstraction.graphs.WeightedGraph;
import dataStructures.impl.graphs.WeightedUndirectedAdjacencyListGraph;

public class CreateMST {
    public static void main(String[] args) {
        WeightedGraph<Integer> weightedGraph = new WeightedUndirectedAdjacencyListGraph<>();
        weightedGraph.addEdge(0, 1, 4)
                .addEdge(0, 7, 8)
                .addEdge(1, 2, 8)
                .addEdge(1, 7, 11)
                .addEdge(2, 3, 7)
                .addEdge(2, 8, 2)
                .addEdge(2, 5, 4)
                .addEdge(3, 4, 9)
                .addEdge(3, 5, 14)
                .addEdge(4, 5, 10)
                .addEdge(5, 6, 2)
                .addEdge(6, 7, 1)
                .addEdge(6, 8, 6)
                .addEdge(7, 8, 7);
        weightedGraph.getPrimMinimumSpanningTree().forEach(edge -> System.out.println(edge.getSource() + "-->" + edge.getDestination()));
    }
}
