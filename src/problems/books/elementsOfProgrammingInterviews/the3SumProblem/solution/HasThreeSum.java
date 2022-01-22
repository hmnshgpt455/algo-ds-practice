package problems.books.elementsOfProgrammingInterviews.the3SumProblem.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem : 18.4 : Find if the array has three elements whose sum is equal to a target sum. The elements can be repeated more than once.
 * Page : 340 (Kindle : 355)
 * Time complexity : O(nlogn + n)
 * Space complexity : O(1)
 */

public class HasThreeSum {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(11, 2, 5, 7, 3));
        System.out.println(hasThreeSum(arr, 6));
    }

    private static boolean hasThreeSum(List<Integer> list, int sum) {
        //O(nlogn)
        //Sort the array
        Collections.sort(list);

        for (int element : list) {
            if (hasTwoSum(list, sum - element)) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasTwoSum(List<Integer> sortedArray, int sum) {
        //O(n)
        int i = 0, j = sortedArray.size()-1;
        while (i <= j) {
            if ((sortedArray.get(i) + sortedArray.get(j)) == sum) {
                return true;
            } else if ((sortedArray.get(i) + sortedArray.get(j)) < sum) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }

    /*
        {11 2 5 7 3}, t = 21 => {2, 3, 5, 7, 11}
        el = 3 => sum = 18 (true)
        i = 0, j = 4 => 2 + 11 < 18
        i = 1, j = 4 => 3 + 11 < 18
        i = 2, j = 4 => 5 + 11 < 18
        i = 3, j = 4 => 7 + 11 = 18
                return true;
    */
}
