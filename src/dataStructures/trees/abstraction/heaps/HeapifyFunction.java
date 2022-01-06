package dataStructures.trees.abstraction.heaps;

@FunctionalInterface
public interface HeapifyFunction<T> {

    /**
     *
     * @param value1 - First value
     * @param value2 - Second value
     * @return 0,1 or 2
     *
     * If > 0, the value1 should be placed towards to root of the heap
     * If < 0, the value1 should be placed towards the bottom of the heap
     * If == 0, no change
     */

    Integer heapCompare(T value1, T value2);
}
