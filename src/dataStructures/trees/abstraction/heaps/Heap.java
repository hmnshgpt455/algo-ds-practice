package dataStructures.trees.abstraction.heaps;

public interface Heap<T> {

    T getTop();
    T extractTop();
    Heap<T> decreaseKey(T value);
    Heap<T> decreaseKey(T value, T amount);
    Heap<T> incrementKey(T value);
    Heap<T> incrementKey(T value, T amount);
    Heap<T> insertKey(T value);
    Heap<T> deleteKey(T value);
}
