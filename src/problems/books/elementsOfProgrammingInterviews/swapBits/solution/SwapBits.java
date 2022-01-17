package problems.books.elementsOfProgrammingInterviews.swapBits.solution;

import problems.books.elementsOfProgrammingInterviews.Helper;

import java.util.Scanner;

/**
 * @author Himanshu Gupta
 * Problem : Swap the two bits at positions i and j
 * Problem #5.2
 * Logic :
 *  1. Find the bits at position i and j by (number >>> i) & 1
 *  2. If the bits are not same :
 *      i. Create a bitMask = (1 << i) | (1 << j) -> This bit mask will have only i and j bits set </>
 */

public class SwapBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer number = sc.nextInt();
        int i = sc.nextInt();
        int j = sc.nextInt();
        Helper.bin(number);
        System.out.println();
        number = swapBits(number, i, j);
        Helper.bin(number);
    }

    private static Integer swapBits(Integer number, int i, int j) {
        //Calculate the bit at i'th position
        int bit_i = (number >>> i) & 1;
        int bit_j = (number >>> j) & 1;
        if (bit_i != bit_j) {
            //In the bitmask only the i'th and the jth bits are set
            int bitMask = (1 << i) | (1 << j);
            number ^= bitMask;
        }

        return number;
    }
}
