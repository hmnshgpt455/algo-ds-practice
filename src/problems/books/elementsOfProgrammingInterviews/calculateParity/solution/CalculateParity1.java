package problems.books.elementsOfProgrammingInterviews.calculateParity.solution;

import java.util.Scanner;

/**
 * @author Himanshu Gupta
 * Problem statement : Calculate the parity of a 64-bit number. Parity is 1, if the number of set bits in the number is odd
 * and 0, if the number of set bits in the number is even.
 * Time complexity of this solution is O(n), where n is the bits in the number
 * Space complexity is O(1)
 * Problem 5.1
 *
 */
public class CalculateParity1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        System.out.println(calculateParity(number));
    }

    private static int calculateParity(long number) {
        int result = 0;
        while (number != 0) {
            /*
              Check the current last bit and update the result
              result = 0, last bit = 0 => result should remain 0, because no new set bit
              result = 1, last bit = 0 => result should remain 1, because no new set bit
              result = 0, last bit = 1 => result should become 1, because we have got a new set and because the result
              till now was 0, that means the number of set bits was even
              result = 1, last bit = 1 => result becomes 0, because till now the number of set bits was odd
              number & 1 => this will either give 1 or 0 depending on the last bit
             */
            result ^= (number & 1);
            //Right Shift all the bits by 1 place, so that we can check the next bit
            number >>>= 1;
        }
        return result;
    }
}
