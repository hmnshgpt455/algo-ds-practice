package problems.books.elementsOfProgrammingInterviews.reverseAStringPreservingSpaces.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Himanshu Gupta
 * Problem : 7.6 : Reverse a string
 * Page : 102
 * Time complexity : O(n)
 * Space complexity : O(n)
 */

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("alice is a bob mob"));
    }

    static public String reverseString(String sentence) {
        List<String> wordsArray = Arrays.asList(sentence.split(" "));
        int sentenceLength = wordsArray.size();

        IntStream.range(0, sentenceLength/2).forEach(i -> {
            Collections.swap(wordsArray, i, (sentenceLength - 1) - i);
        });

        StringBuilder result  = new StringBuilder();
        for (int i = 0; i < sentenceLength; i++) {
            if (i == sentenceLength-1) {
                result.append(wordsArray.get(i));
            } else {
                result.append(wordsArray.get(i)).append(" ");
            }
        }

        return result.toString();
    }

}
