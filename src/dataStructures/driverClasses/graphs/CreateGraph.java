package dataStructures.driverClasses.graphs;

import dataStructures.driverClasses.utils.GraphUtil;
import dataStructures.impl.graphs.UnweightedDirectedAdjacencyListGraph;

public class CreateGraph {
    public static void main(String[] args) {
        UnweightedDirectedAdjacencyListGraph<Integer> adjacencyListGraph = new UnweightedDirectedAdjacencyListGraph<>();
        adjacencyListGraph.addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .addEdge(2, 3)
                .addEdge(3, 3);

        GraphUtil graphUtil = new GraphUtil();
        graphUtil.printGraph(adjacencyListGraph);

        System.out.println("BFS of the graph ");
        adjacencyListGraph.getBFSRepresentation(2).forEach(el -> System.out.print(el+" "));

        System.out.println("\nDFS of the graph");
        adjacencyListGraph.getDFSRepresentation(2).forEach(el -> System.out.print(el + " "));
    }
}
