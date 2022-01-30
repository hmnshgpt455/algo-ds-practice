package problems.books.elementsOfProgrammingInterviews.findSmallestElementInACyclicSortedArray.solution;

import java.util.List;

/**
 * @author Himanshu Gupta
 * Problem : 12.3 : Find the smallest element in a cyclic sorted array. Cyclic sorted array means the array can be sorted
 * by shifting few elements to the right or left.
 * Page : 192
 * Time complexity : O(logn)
 * Space complexity : O(1)
 */

public class FindSmallestElementInACyclicSortedArray {
    public static void main(String[] args) {
        System.out.println(findTheSmallestElement(List.of(1, 2, 3, 4, 5, 6, 0)));
    }

    static public int findTheSmallestElement(List<Integer> array) {
        return binarySearchForTheSmallestElement(array, 0, array.size()-1, array.get(array.size()-1));
    }

    static int binarySearchForTheSmallestElement(List<Integer> array, int start, int end, int lastElement) {
        int mid = (start) + (end-start)/2;
        int leftElement = mid > start ? array.get(mid-1) : Integer.MAX_VALUE;
        int rightElement = mid < end ? array.get(mid+1) : Integer.MAX_VALUE;

        if ((array.get(mid) < leftElement) && (array.get(mid) < rightElement)) {
            return array.get(mid);
        }

        if (start < end) {
            if (array.get(mid) < lastElement) {
                return binarySearchForTheSmallestElement(array, 0, mid-1, lastElement);
            } else {
                return binarySearchForTheSmallestElement(array, mid+1, end, lastElement);
            }
        }

        return -1;
    }

}
