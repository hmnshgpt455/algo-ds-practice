package problems.books.elementsOfProgrammingInterviews.dutchFlagPartition.solution;

import problems.books.elementsOfProgrammingInterviews.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Himanshu Gupta
 * Problem : 6.1 Page 62 (Kindle : 75)
 * Given an array of int and index i. Partition the array such that the elements less than a[i] appear first, followed
 * by equal elements, followed by larger elements.
 * Time complexity : O(n)
 * Space complexity : O(n)
 */
public class DutchFlagPartition1 {
    public static void main(String[] args) {
        List<Integer> inputArray = Helper.takeArrayAsInput();
        int i = new Scanner(System.in).nextInt();
        dutchFlagPartitioning(i, inputArray).forEach(el -> System.out.print(el + " "));
    }

    static List<Integer> dutchFlagPartitioning(int i, List<Integer> inputArray) {
        Integer[] partitionedArray = new Integer[inputArray.size()];
        int pivot = inputArray.get(i);
        int startIndex = 0, endIndex = inputArray.size()-1;
        for(int el : inputArray) {
            if (el < pivot) {
                partitionedArray[startIndex++] = el;
            }
            if (el > pivot) {
                partitionedArray[endIndex--] = el;
            }
        }
        for (int k = startIndex; k<=endIndex; k++) {
            partitionedArray[k] = pivot;
        }

        return Arrays.asList(partitionedArray);
    }

}
