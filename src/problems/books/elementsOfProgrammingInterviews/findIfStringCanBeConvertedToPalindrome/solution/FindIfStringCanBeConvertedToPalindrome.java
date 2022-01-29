package problems.books.elementsOfProgrammingInterviews.findIfStringCanBeConvertedToPalindrome.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Himanshu Gupta
 * Problem : 13.1 : Check if string can be permuted to form a palindrome
 * Page : 212
 * Time complexity : O(n)
 * Space complexity : O(c)
 */

public class FindIfStringCanBeConvertedToPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindromicPermutationPossible("aabcbaa"));
    }

    static public boolean isPalindromicPermutationPossible(String input) {
        Map<Character, Integer> charToCountMap = new HashMap<>();
        int oddCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (charToCountMap.containsKey(c)) {
                charToCountMap.put(c, charToCountMap.get(c)+1);
            } else {
                charToCountMap.put(c, 1);
            }
            if (charToCountMap.get(c) % 2 == 0) {
                oddCount--;
            } else {
                oddCount++;
            }
        }

        if (input.length() % 2 == 0) {
            return !(oddCount > 0);
        } else {
            return (oddCount == 1);
        }
    }

}
