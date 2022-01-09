package dataStructures.modals.graphs;

import java.util.Objects;

public class Edge<T> {
    private T source;
    private T destination;
    private Integer weight;

    public Edge(T source, T destination, Integer weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Edge(T source, T destination) {
        this.source = source;
        this.destination = destination;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public T getSource() {
        return source;
    }

    public void setSource(T source) {
        this.source = source;
    }

    public T getDestination() {
        return destination;
    }

    public void setDestination(T destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object obj) {
        Edge<?> edge = (Edge<?>) obj;
        if (Objects.equals(source, edge.getSource()) && Objects.equals(destination, edge.getDestination())) {
            return true;
        }
        if (Objects.equals(destination, edge.getSource()) && Objects.equals(source, edge.getDestination())) {
            return true;
        }
        return false;
    }
}
