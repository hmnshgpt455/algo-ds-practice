package problems.books.elementsOfProgrammingInterviews.dutchFlagPartition.solution;

import problems.books.elementsOfProgrammingInterviews.Helper;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Himanshu Gupta
 * Problem : 6.1 Page 62 (Kindle : 75)
 * Given an array of int and index i. Partition the array such that the elements less than a[i] appear first, followed
 * by equal elements, followed by larger elements.
 * Time complexity : O(n)
 * Space complexity : O(1)
 */

public class DutchFlagPartition2 {
    public static void main(String[] args) {
        dutchFlagPartition(Helper.takeArrayAsInput(), new Scanner(System.in).nextInt())
                .forEach(el -> System.out.print(el + " "));
    }
    static List<Integer> dutchFlagPartition(List<Integer> inputArray, int pivotIndex) {
        int pivot = inputArray.get(pivotIndex);
        int lessIndex = 0, equalIndex = 0, greaterIndex = inputArray.size();

        while (equalIndex < greaterIndex) {
            if (inputArray.get(equalIndex) < pivot) {
                Collections.swap(inputArray, equalIndex++, lessIndex++);
            } else if (inputArray.get(equalIndex) == pivot) {
                equalIndex++;
            } else if (inputArray.get(equalIndex) > pivot) {
                Collections.swap(inputArray, equalIndex, --greaterIndex);
            }
        }

        return inputArray;
    }

}
