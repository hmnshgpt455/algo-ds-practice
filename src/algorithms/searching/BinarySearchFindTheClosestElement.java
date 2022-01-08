package algorithms.searching;

import java.util.Scanner;
import java.util.stream.IntStream;

public class BinarySearchFindTheClosestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] sortedArray = IntStream.range(0, n).map(i -> sc.nextInt()).toArray();
        int targetElement = sc.nextInt();

        int closestElementIndex = findTheClosestElement(sortedArray, 0, n - 1, targetElement);

        System.out.println("Closest index is " + closestElementIndex + " and closest element is " + sortedArray[closestElementIndex]);
    }

    private static int findTheClosestElement(int[] sortedArray, int startingIndex, int endingIndex, int targetElement) {

        if (Math.abs(startingIndex - endingIndex) == 1) {
            return Math.abs(sortedArray[startingIndex] - targetElement) > Math.abs(sortedArray[endingIndex] - targetElement) ?
                    endingIndex : startingIndex;
        }

        int mid = startingIndex + (endingIndex - startingIndex) / 2;

        if (sortedArray[mid] == targetElement) {
            return mid;
        }

        int midDiff = Math.abs(sortedArray[mid] - targetElement);
        int leftDiff = mid > 0 ? Math.abs(sortedArray[mid - 1] - targetElement) : Integer.MAX_VALUE;
        int rightDiff = mid < sortedArray.length - 1 ? Math.abs(sortedArray[mid + 1] - targetElement) : Integer.MAX_VALUE;

        //It means the element is closest to the mid element
        if (midDiff < leftDiff && midDiff < rightDiff) {
            return mid;
        }

        //Find the closest in the left sub-array
        if (sortedArray[mid] > targetElement) {
            return findTheClosestElement(sortedArray, startingIndex, mid - 1, targetElement);
        }

        //Find the closest in the right sub-array
        return findTheClosestElement(sortedArray, mid + 1, endingIndex, targetElement);

    }
}
