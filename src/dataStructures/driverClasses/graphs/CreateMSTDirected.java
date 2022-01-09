package dataStructures.driverClasses.graphs;

import dataStructures.abstraction.graphs.WeightedGraph;
import dataStructures.impl.graphs.WeightedDirectedAdjacencyListGraph;

public class CreateMSTDirected {
    public static void main(String[] args) {
        WeightedGraph<Integer> graph = new WeightedDirectedAdjacencyListGraph<>();
        graph.addEdge(1, 4, 1)
                .addEdge(3, 4, 40)
                .addEdge(3, 1, 20);
        graph.getKruskalMinimumSpanningTree().forEach(edge -> System.out.println(edge.getSource() + "-->" + edge.getDestination()));
    }
}
