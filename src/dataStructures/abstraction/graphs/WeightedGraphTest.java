package dataStructures.abstraction.graphs;

import dataStructures.impl.graphs.WeightedUndirectedAdjacencyListGraph;
import dataStructures.modals.graphs.Edge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class WeightedGraphTest {

    WeightedGraph<Integer> weightedGraph;

    @BeforeEach
    void setUp() {
        createGraph();
    }

    private void createGraph() {
        weightedGraph = new WeightedUndirectedAdjacencyListGraph<>();
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
    }

    @Test
    void getPrimMinimumSpanningTree() {
        List<Edge<Integer>> mst = weightedGraph.getPrimMinimumSpanningTree();
        assertEquals(weightedGraph.getBFSRepresentation(0).size()-1, mst.size());
    }

    @Test
    void getKruskalMinimumSpanningTree() {
        weightedGraph.addEdge(100, 200, 1);
        weightedGraph.addEdge(100, 300, 100);
        weightedGraph.addEdge(200, 300, 2);
        List<Edge<Integer>> primMst = weightedGraph.getPrimMinimumSpanningTree();
        List<Edge<Integer>> kruskalMst = weightedGraph.getKruskalMinimumSpanningTree();
        primMst.sort(Comparator.comparingInt(Edge::getSource));
        kruskalMst.sort(Comparator.comparingInt(Edge::getSource));
        assertNotEquals(primMst.size(), kruskalMst.size());
        System.out.println("Prim's");
        primMst.forEach(edge -> System.out.println(edge.getSource() + "-->" + edge.getDestination()));
        System.out.println("Kruskal");
        kruskalMst.forEach(edge -> System.out.println(edge.getSource() + "-->" + edge.getDestination()));

    }
}