package dataStructures.driverClasses.graphs;

import dataStructures.impl.graphs.WeightedDirectedAdjacencyListGraph;

import java.util.Deque;

public class TopologicalSortWeightedGraph {
    public static void main(String[] args) {
        WeightedDirectedAdjacencyListGraph<Integer> dag = new WeightedDirectedAdjacencyListGraph<>();

        dag.addEdge(5, 2, 10)
                .addEdge(5, 0, 10)
                .addEdge(4, 0, 10)
                .addEdge(4, 1, 10)
                .addEdge(2, 3, 10)
                .addEdge(3, 1, 10);

        Deque<Integer> topologicalSort = dag.getTopologicalSort();
        while (!topologicalSort.isEmpty()) {
            System.out.print(topologicalSort.pop() + " ");
        }
    }
}
