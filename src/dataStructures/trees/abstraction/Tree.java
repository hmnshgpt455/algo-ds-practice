package dataStructures.trees.abstraction;

public interface Tree<T, V> {

    T insertKey(V key);

    T deleteKey(V key);
}
