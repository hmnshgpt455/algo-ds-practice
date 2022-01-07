package dataStructures.abstraction.trees;

public interface Tree<V> {

    Tree<V> insertKey(V key);

    Tree<V> deleteKey(V key);
}
