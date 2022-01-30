package problems.books.elementsOfProgrammingInterviews.sortAKSortedArray.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author Himanshu Gupta
 * Problem : 11.3 : Sort a k sorted array. It means evenry element is at most k places away from the position at which it
 * would be if the array was sorted
 * Page : 180
 * Time complexity : O(nlogk)
 * Space complexity : O(k)
 */

public class FindAKSortedArray {
    public static void main(String[] args) {
        System.out.println(sortAKSortedArray(new ArrayList<>(List.of(3, -1, 2, 6, 4, 5, 8)), 2));
    }

    static List<Integer> sortAKSortedArray(List<Integer> array, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        AtomicInteger indexToPutNextElement = new AtomicInteger(0);

        IntStream.range(0, array.size()).forEach(i -> {
            minHeap.add(array.get(i));

            if (i >= k) {
                int nextLowestElement = minHeap.poll();
                array.set(indexToPutNextElement.get(), nextLowestElement);
                indexToPutNextElement.incrementAndGet();
            }
        });

        while (!minHeap.isEmpty()) {
            int nextLowestElement = minHeap.poll();
            array.set(indexToPutNextElement.get(), nextLowestElement);
            indexToPutNextElement.incrementAndGet();
        }

        return array;
    }

}
