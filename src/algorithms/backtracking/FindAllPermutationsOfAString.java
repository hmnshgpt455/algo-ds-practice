package algorithms.backtracking;

import java.util.Scanner;

public class FindAllPermutationsOfAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();

        printAllPermutations(inputString);
    }

    private static void printAllPermutations(String inputString) {
        permute(inputString, inputString);
    }

    private static void permute(String inputString, String permutation) {
        if (inputString.length() == 0) {
            System.out.println(permutation);
        }
    }
}
