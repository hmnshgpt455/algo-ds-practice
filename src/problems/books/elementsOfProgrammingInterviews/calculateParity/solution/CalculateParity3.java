package problems.books.elementsOfProgrammingInterviews.calculateParity.solution;

import java.util.Scanner;

public class CalculateParity3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        System.out.println(0x1);
        System.out.println(calculateParity(number));
    }
    public static int calculateParity(long x) {
        x ^= (x >>> 32);
        x ^= (x >>>16);
        x ^= (x >>> 8);
        x ^= (x >>> 4);
        x ^= (x >>> 2);
        x ^= (x >>> 1);

        return (int)(x & 0x1);
    }

}
