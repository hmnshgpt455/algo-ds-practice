package dataStructures.trees.driverClasses.graphs;

import dataStructures.trees.driverClasses.utils.GraphUtil;
import dataStructures.trees.modals.graphs.UnweightedAdjacencyListGraph;

public class CreateGraph {
    public static void main(String[] args) {
        UnweightedAdjacencyListGraph<Integer> adjacencyListGraph = new UnweightedAdjacencyListGraph<>();
        adjacencyListGraph.addEdgeDirected(0, 1)
                .addEdgeDirected(0, 2)
                .addEdgeDirected(1, 2)
                .addEdgeDirected(2, 0)
                .addEdgeDirected(2, 3)
                .addEdgeDirected(3, 3);

        GraphUtil graphUtil = new GraphUtil();
        graphUtil.printGraph(adjacencyListGraph);

        System.out.println("BFS of the graph ");
        adjacencyListGraph.getBFSRepresentation(2).forEach(el -> System.out.print(el+" "));

        System.out.println("\nDFS of the graph");
        adjacencyListGraph.getDFSRepresentation(2).forEach(el -> System.out.print(el + " "));
    }
}
