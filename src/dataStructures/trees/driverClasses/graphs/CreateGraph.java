package dataStructures.trees.driverClasses.graphs;

import dataStructures.trees.driverClasses.utils.GraphUtil;
import dataStructures.trees.modals.graphs.AdjacencyListGraph;

public class CreateGraph {
    public static void main(String[] args) {
        AdjacencyListGraph<Integer> adjacencyListGraph = new AdjacencyListGraph<>();
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
    }
}
