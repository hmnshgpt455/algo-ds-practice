package dataStructures.modals.graphs;

public class Edge<T> {
    T source;
    T destination;

    public Edge(T source, T destination) {
        this.source = source;
        this.destination = destination;
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
}
