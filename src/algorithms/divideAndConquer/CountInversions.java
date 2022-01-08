package algorithms.divideAndConquer;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CountInversions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = IntStream.range(0, n).map(i -> sc.nextInt()).toArray();

        int ans = countInversions(arr, 0, n - 1);

        System.out.println(ans);
    }

    private static int countInversions(int[] arr, int l, int r) {
        return countInversionsAndSort(arr, l, r);
    }

    private static int countInversionsAndSort(int[] arr, int l, int r) {
        int count = 0;

        if (l < r) {
            int mid = l + (r - l) / 2;

            //Count inversions in left sub array
            count += countInversionsAndSort(arr, l, mid);

            //Count inversions in right sub array
            count += countInversionsAndSort(arr, mid + 1, r);

            //Now count the inversions in the merged array
            count += mergeAndCount(arr, l, mid, r);
        }

        return count;
    }

    private static int mergeAndCount(int[] arr, int l, int mid, int r) {
        int inversionCount = 0, leftIndex = 0, rightIndex = 0, arrIndex = l;

        int[] leftSubArray = Arrays.copyOfRange(arr, l, mid + 1);
        int[] rightSubArray = Arrays.copyOfRange(arr, mid + 1, r + 1);

        while (leftIndex < leftSubArray.length && rightIndex < rightSubArray.length) {
            if (leftSubArray[leftIndex] > rightSubArray[rightIndex]) {

                //If the number at leftIndex in leftSubArray is more than the number at rightIndex in rightSubArray, that means all the numbers after leftIndex
                //will be greater than the number at rightIndex, so, we will add all those numbers in our count
                inversionCount += (leftSubArray.length - leftIndex);
                arr[arrIndex++] = rightSubArray[rightIndex++];
            } else {
                arr[arrIndex++] = leftSubArray[leftIndex++];
            }
        }

        while (leftIndex < leftSubArray.length) {
            arr[arrIndex++] = leftSubArray[leftIndex++];
        }

        while (rightIndex < rightSubArray.length) {
            arr[arrIndex++] = rightSubArray[rightIndex++];
        }

        return inversionCount;
    }
}
