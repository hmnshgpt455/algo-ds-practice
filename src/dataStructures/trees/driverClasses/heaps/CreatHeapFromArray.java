package dataStructures.trees.driverClasses.heaps;

import dataStructures.trees.impl.heaps.ListHeap;

import java.util.ArrayList;
import java.util.List;

public class CreatHeapFromArray {
    public static void main(String[] args) {
        ListHeap<Integer> heap = new ListHeap<>(new ArrayList<>(List.of(1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17)), Integer::compare);
        heap.getHeapArray().forEach(el -> System.out.print(el + " "));
    }
}
