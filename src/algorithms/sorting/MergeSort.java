package algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = IntStream.range(0, n).map(i -> sc.nextInt()).toArray();

        sortArray(arr);

        Arrays.stream(arr).forEach(el -> System.out.print(el + " "));
    }

    static void sortArray(int[] arr) {
        mergeSort(arr, 0 ,arr.length - 1);
    }

    static void mergeSort(int[] arr, int startingIndex, int endingIndex) {
        if (endingIndex > startingIndex) {
            int mid = startingIndex + (endingIndex-startingIndex)/2;
            mergeSort(arr, startingIndex, mid);
            mergeSort(arr, mid+1, endingIndex);

            merge(arr, startingIndex, mid, endingIndex);
        }
    }

    static void merge(int[] arr, int startingIndex, int mid, int endingIndex) {
        int leftSubArrayIndex = 0;
        int rightSubArrayIndex = 0;
        int arrayIndex = startingIndex;

        int[] leftSubArray = Arrays.stream(arr, startingIndex, mid+1).toArray();
        int[] rightSubArray = Arrays.stream(arr, mid+1, endingIndex+1).toArray();

        while (leftSubArrayIndex < leftSubArray.length && rightSubArrayIndex < rightSubArray.length) {
            if (leftSubArray[leftSubArrayIndex] <= rightSubArray[rightSubArrayIndex]) {
                arr[arrayIndex] = leftSubArray[leftSubArrayIndex];
                leftSubArrayIndex++;
            } else {
                arr[arrayIndex] = rightSubArray[rightSubArrayIndex];
                rightSubArrayIndex++;
            }
            arrayIndex++;
        }

        while (leftSubArrayIndex < leftSubArray.length) {
            arr[arrayIndex] = leftSubArray[leftSubArrayIndex];
            leftSubArrayIndex++;
            arrayIndex++;
        }

        while (rightSubArrayIndex < rightSubArray.length) {
            arr[arrayIndex] = rightSubArray[rightSubArrayIndex];
            rightSubArrayIndex++;
            arrayIndex++;
        }
    }
}
