package algorithms.strings.patternSearching;

import java.util.Scanner;
import java.util.stream.IntStream;

public class NaivePatternMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputString = sc.next();
        String pattern = sc.next();

        printAllTheMatches(inputString, pattern);
    }

    private static void printAllTheMatches(String inputString, String pattern) {

        int inputStringLength = inputString.length();
        int patternLength = pattern.length();

        IntStream.range(0, inputStringLength - patternLength + 1).forEach(i -> {
           //We are looking at the substring which is starting at index i. We now need to check if this substring matches the pattern
           boolean doesPatternMatch = IntStream.range(0, patternLength).allMatch(j -> inputString.charAt(i+j) == pattern.charAt(j));

           if (doesPatternMatch) {
               System.out.println("Match found at : " + i);
           }
        });
    }
}
