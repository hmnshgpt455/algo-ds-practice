package dataStructures.trees.driverClasses.graphs;

import dataStructures.trees.driverClasses.utils.GraphUtil;
import dataStructures.trees.modals.graphs.AdjacencyListGraph;

public class CreateGraph {
    public static void main(String[] args) {
        AdjacencyListGraph<Integer> adjacencyListGraph = new AdjacencyListGraph<>();
        adjacencyListGraph.addEdge(0, 1)
                .addEdgeBidirectional(0, 4)
                .addEdgeBidirectional(1, 2)
                .addEdgeBidirectional(1, 3)
                .addEdgeBidirectional(1, 4)
                .addEdgeBidirectional(2, 3)
                .addEdgeBidirectional(3, 4)
                .addEdgeBidirectional(100, 200);

        GraphUtil graphUtil = new GraphUtil();
        graphUtil.printGraph(adjacencyListGraph);
    }
}
