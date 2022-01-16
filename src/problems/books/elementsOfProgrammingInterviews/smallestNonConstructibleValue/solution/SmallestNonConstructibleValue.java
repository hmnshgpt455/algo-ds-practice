package problems.books.elementsOfProgrammingInterviews.smallestNonConstructibleValue.solution;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
    Inputs : n = 6, arr = [12, 2, 1, 15, 2, 4]
    n = 2, [1, 12]
    Source : Elements of Programming interviews, page 32
    Time complexity O(nlogn)
 */

public class SmallestNonConstructibleValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inputArray = IntStream.range(0, n).map(i -> sc.nextInt()).toArray();
        System.out.println(findMinimumElementNotConstructible(inputArray));
    }

    public static int findMinimumElementNotConstructible(int[] inputArray) {
        Arrays.sort(inputArray);
        int maximumConstructibleSumTillNow = 0;
        for (int currentElement : inputArray) {
            if (currentElement > maximumConstructibleSumTillNow + 1) {
                break;
            } else {
                maximumConstructibleSumTillNow += currentElement;
            }
        }

        return maximumConstructibleSumTillNow + 1;
    }

}
