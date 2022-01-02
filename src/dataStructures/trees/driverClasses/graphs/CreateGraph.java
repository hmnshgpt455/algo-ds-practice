package dataStructures.trees.driverClasses.graphs;

import dataStructures.trees.driverClasses.utils.GraphUtil;
import dataStructures.trees.modals.graphs.UnweightedAdjacencyListGraph;

public class CreateGraph {
    public static void main(String[] args) {
        UnweightedAdjacencyListGraph<Integer> adjacencyListGraph = new UnweightedAdjacencyListGraph<>();
        adjacencyListGraph.addDirectedEdge(0, 1)
                .addDirectedEdge(0, 2)
                .addDirectedEdge(1, 2)
                .addDirectedEdge(2, 0)
                .addDirectedEdge(2, 3)
                .addDirectedEdge(3, 3);

        GraphUtil graphUtil = new GraphUtil();
        graphUtil.printGraph(adjacencyListGraph);

        System.out.println("BFS of the graph ");
        adjacencyListGraph.getBFSRepresentation(2).forEach(el -> System.out.print(el+" "));

        System.out.println("\nDFS of the graph");
        adjacencyListGraph.getDFSRepresentation(2).forEach(el -> System.out.print(el + " "));
    }
}
