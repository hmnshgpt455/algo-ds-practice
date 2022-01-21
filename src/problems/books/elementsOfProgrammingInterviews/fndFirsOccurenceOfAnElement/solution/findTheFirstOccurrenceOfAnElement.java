package problems.books.elementsOfProgrammingInterviews.fndFirsOccurenceOfAnElement.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem : 12.1 => Find the first occurrence of an element in a sorted array
 * Page : 190 (Kindle : 204)
 * Time complexity : O(logn) => n = number of elements in the array
 * Space complexity : O(n)
 */

public class findTheFirstOccurrenceOfAnElement {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(1, 2, 4, 6, 6, 6, 6, 9, 10));
        System.out.println(findFirstOccurenceOfANumber(11, arr));
    }

    private static int findFirstOccurenceOfANumber(int target, List<Integer> sortedArray) {
        return binarySearch(0, sortedArray.size()-1, sortedArray, target);
    }

    public static int binarySearch(int l, int r, List<Integer> sortedArray, int target) {
        if (l > r) {
            return -1;
        }
        int mid = (r-l)/2 + l;
        //mid == target
        if (sortedArray.get(mid) == target) {
            //This the first occurence
            if (mid == 0 || sortedArray.get(mid-1) != target) {
                return mid;
            }
        }

        //if the mid is >= target
        if (sortedArray.get(mid) >= target) {
            //Take the left sub array
            return binarySearch(l, mid-1, sortedArray, target);
        } else {
            return binarySearch(mid+1, r, sortedArray, target);
        }
    }


    //1 2 4 6 6 6 7 9 => 8, target = 9
    //Itr : 1 -> l = 0, r = 7, mid = 3, ar[mid] = 6 => l = 4, r = 7
    //Itr : 2 -> l = 4, r = 7, mid = 5, ar[mid] = 6 => l = 6, r = 7
    //Itr : 3 -> l =6, r = 7, mid = 6, ar[mid] = 7=> l = 7, r = 7
    //Itr : 4 -> l = 7, r = 7, mid = 7, ar[mid] = 9, return mid

    //1 2 4 6 6 6 7 9 10 => 9, target = 6
    //Itr : 1 -> l = 0, r = 8, mid = 4, ar[mid] = 6 => l = 0, r = 3
    //Itr : 2 -> l = 0, r = 3, mid = 1, ar[mid] = 2 => l = 2, r = 3
    //Itr : 3 -> l = 2, r = 3, mid = 2, ar[mid] = 4 => l = 3, r = 3
    //Itr : 4 -> l = 3, r = 3, mid = 3, ar[mid] = 6, return mid;


}
