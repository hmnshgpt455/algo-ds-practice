package dataStructures.impl.heaps;

import dataStructures.abstraction.heaps.Heap;
import dataStructures.abstraction.heaps.HeapifyFunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListHeap<T> implements Heap<T> {

    private List<T> heapArray;
    private HeapifyFunction<T> heapifyFunction;

    public ListHeap(List<T> heapArray, HeapifyFunction<T> heapifyFunction) {
        this.heapifyFunction = heapifyFunction;
        this.heapArray = buildHeapFromArray(heapArray);
    }

    private List<T> buildHeapFromArray(List<T> heapArray) {
        int sizeOfTheArray = heapArray.size();
        int lastNonLeafNodeIndex = (sizeOfTheArray/2) - 1;
        for (int i = lastNonLeafNodeIndex; i >= 0; i--) {
            heapify(i, heapArray);
        }
        return heapArray;
    }

    private void heapify(int index, List<T> heapArray) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        T parent = heapArray.get(index);

        int childIndexToCompare = getChildIndexToCompare(leftChildIndex, rightChildIndex, heapArray);

        if (childIndexToCompare == -1) {
            return;
        }

        if (heapifyFunction.heapCompare(parent, heapArray.get(childIndexToCompare)) < 0) {
            Collections.swap(heapArray, index, childIndexToCompare);
            heapify(childIndexToCompare, heapArray);
        }

    }

    private int getChildIndexToCompare(int leftChildIndex, int rightChildIndex, List<T> heapArray) {
        if (leftChildIndex >= heapArray.size() && rightChildIndex >= heapArray.size()) {
            return -1;
        }

        if (rightChildIndex >= heapArray.size()) {
            return leftChildIndex;
        }

        return heapifyFunction
                .heapCompare(heapArray.get(leftChildIndex), heapArray.get(rightChildIndex)) > 0 ?
                leftChildIndex : rightChildIndex;
    }

    public List<T> getHeapArray() {
        return heapArray;
    }

    public void setHeapArray(List<T> heapArray) {
        this.heapArray = heapArray;
    }

    public ListHeap(HeapifyFunction<T> heapifyFunction) {
        this.heapifyFunction = heapifyFunction;
        this.heapArray = new ArrayList<>();
    }

    @Override
    public T getTop() {
        return this.heapArray.get(0);
    }

    @Override
    public T extractTop() {
        T elementToRemove = heapArray.get(0);
        this.heapArray.remove(0);
        this.heapArray = buildHeap();
        return elementToRemove;
    }

    private List<T> buildHeap() {
        int sizeOfTheArray = heapArray.size();
        int lastNonLeafNodeIndex = (sizeOfTheArray/2) - 1;
        for (int i = lastNonLeafNodeIndex; i >= 0; i--) {
            heapify(i, heapArray);
        }
        return heapArray;
    }

    @Override
    public Heap<T> decreaseKey(T value) {
        return null;
    }

    @Override
    public Heap<T> decreaseKey(T value, T amount) {

        return null;
    }

    @Override
    public Heap<T> incrementKey(T value) {
        return null;
    }

    @Override
    public Heap<T> incrementKey(T value, T amount) {
        return null;
    }

    @Override
    public Heap<T> insertKey(T value) {
        return null;
    }

    @Override
    public Heap<T> deleteKey(T value) {
        return null;
    }
}
