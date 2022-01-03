package dataStructures.trees.driverClasses.graphs;

import dataStructures.trees.impl.graphs.UnweightedDirectedAdjacencyListGraph;

import java.util.Deque;

public class TopologicalSort {
    public static void main(String[] args) {
        UnweightedDirectedAdjacencyListGraph<Integer> dag = new UnweightedDirectedAdjacencyListGraph<>();

        dag.addEdge(5, 2)
                .addEdge(5, 0)
                .addEdge(4, 0)
                .addEdge(4, 1)
                .addEdge(2, 3)
                .addEdge(3, 1);

        Deque<Integer> topologicalSort = dag.getTopologicalSort();
        while (!topologicalSort.isEmpty()) {
            System.out.print(topologicalSort.pop() + " ");
        }
    }
}
