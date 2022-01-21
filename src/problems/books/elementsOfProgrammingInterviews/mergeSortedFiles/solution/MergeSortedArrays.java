package problems.books.elementsOfProgrammingInterviews.mergeSortedFiles.solution;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author Himanshu Gupta
 * Problem 11.1 : Merge multiple sorted arrays.
 * Space complexity : O(k)
 * Time complexity : O(n*logk)
 */

public class MergeSortedArrays {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(new ArrayList<>(List.of(1, 2, 6, 7, 11)));
        listOfLists.add(new ArrayList<>(List.of(1, 11, 22, 23, 34)));
        listOfLists.add(new ArrayList<>(List.of(6, 16, 78, 90, 1001, 1221)));
        listOfLists.add(new ArrayList<>(List.of(34, 56, 67, 76)));

        mergeSortedArrays(listOfLists).forEach(el -> System.out.print(el + " "));
    }

    //Merge sorted arrays

    public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays) {
        PriorityQueue<HeapElement> minHeap = new PriorityQueue<>(Comparator.comparingInt(el -> el.value));
        List<Integer> outputArray = new ArrayList<>();
        IntStream.range(0, sortedArrays.size()).forEach(i -> {
           HeapElement newHeapElement = new HeapElement(i, 0, sortedArrays.get(i).get(0));
           minHeap.add(newHeapElement);
        });

        while (!minHeap.isEmpty()) {
            HeapElement minimumElement = minHeap.remove();
            if (sortedArrays.get(minimumElement.arrayNumber).size() > (minimumElement.index + 1)) {
                HeapElement nextHeapElement = new HeapElement(minimumElement.arrayNumber, minimumElement.index + 1,
                        sortedArrays.get(minimumElement.arrayNumber).get(minimumElement.index + 1));
                minHeap.add(nextHeapElement);
            }

            outputArray.add(minimumElement.value);
        }

        return outputArray;
    }

    static class HeapElement {
        public int arrayNumber;
        public int index;
        public int value;

        public HeapElement(int arrayNumber, int index, int value) {
            this.arrayNumber = arrayNumber;
            this.index = index;
            this.value = value;
        }
    }


}
