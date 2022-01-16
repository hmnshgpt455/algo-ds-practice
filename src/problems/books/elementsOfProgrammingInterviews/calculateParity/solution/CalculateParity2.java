package problems.books.elementsOfProgrammingInterviews.calculateParity.solution;

import java.util.Scanner;


/**
 * @author Himanshu Gupta
 * Problem statement : Calculate the parity of a 64-bit number. Parity is 1, if the number of set bits in the number is odd
 * and 0, if the number of set bits in the number is even.
 * Time complexity of this solution is O(k), where k is the number of set bits in the number
 * Space complexity is O(1)
 * Problem 5.1
 */

public class CalculateParity2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        System.out.println(calculateParity(number));
    }

    private static int calculateParity(long number) {
        int result = 0;
        while (number != 0) {
            //Flipping the rightmost set bit to 0
            number &= (number-1);
            //Updating the result
            result ^= 1;
        }
        return result;
    }
}
