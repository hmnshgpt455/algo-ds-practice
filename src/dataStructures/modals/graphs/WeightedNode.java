package dataStructures.modals.graphs;

import java.util.Objects;

public class WeightedNode<T> {
    T value;
    Integer weight;

    public WeightedNode() {
    }

    public WeightedNode(T value) {
        this.value = value;
        this.weight = null;
    }

    public WeightedNode(T value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeightedNode<?> that = (WeightedNode<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
