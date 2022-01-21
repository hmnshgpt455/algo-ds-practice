package problems.books.elementsOfProgrammingInterviews.findIntersectionOfTwoSortedArrays.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Himanshu Gupta
 * Problem : 14.1 => FInd the intersection of two sorted arrays.
 * Page : 237
 * Time complexity : O(m+n), m = number of elements in list1 and number of elements in list2
 * Space compleixty : O(1)
 */

public class FindIntersectionOfTwoSortedArrays {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(List.of(1, 2, 7, 5, 8, 11));
        List<Integer> l2 = new ArrayList<>(List.of(5, 6, 7, 5, 8, 11));
        findIntersectionOfTwoSortedArrays(l1, l2).forEach(e -> System.out.print(e + " "));
    }

    static List<Integer> findIntersectionOfTwoSortedArrays(List<Integer> arr1, List<Integer> arr2) {
        int i = 0, j = 0;
        List<Integer> resultSet = new ArrayList<>();

        while (i < arr1.size() && j < arr2.size()) {
            //Both the elements are equal
            if ((arr1.get(i) == arr2.get(j)) && (i == 0 || arr1.get(i) != arr1.get(i-1))) {
                resultSet.add(arr1.get(i));
                i++;
                j++;
            } else if (arr1.get(i) < arr2.get(j)) {
                i++;
            } else if (arr1.get(i) > arr2.get(j)) {
                j++;
            }
        }

        return resultSet;
    }

}
