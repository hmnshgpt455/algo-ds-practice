package algorithms.searching;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinarySearchFindElementExactly {

    public static void main(String[] args) {
        //Taking the list as input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] sortedArray = IntStream.range(0, n).map(i -> sc.nextInt()).toArray();
        int elementToBeFound = sc.nextInt();

        /*
        One way of creating List from IntStream
        List<Integer> sortedArray = IntStream.range(0, n)
                .map(sc::nextInt)
                .boxed()
                .collect(Collectors.toList()); */
        int indexOfTheElement = findElement(elementToBeFound, sortedArray);

        if (indexOfTheElement == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index : " + indexOfTheElement);
        }
    }

    private static int findElement(int elementToBeFound, int[] sortedArray) {

        return binarySearchForElement(elementToBeFound, sortedArray, 0, (sortedArray.length-1)/2, sortedArray.length-1);
    }

    private static int binarySearchForElement(int elementToBeFound, int[] sortedArray, int startingIndex, int mid, int endingIndex) {
        if (sortedArray[mid] == elementToBeFound) {
            return mid;
        }

        if (endingIndex <= startingIndex) {
            return -1;
        }

        if (elementToBeFound < sortedArray[mid]) {
            return binarySearchForElement(elementToBeFound, sortedArray, startingIndex, (startingIndex+mid-1)/2, mid-1);
        }

        return binarySearchForElement(elementToBeFound, sortedArray, mid+1, (mid+endingIndex+1)/2, endingIndex);
    }
}
