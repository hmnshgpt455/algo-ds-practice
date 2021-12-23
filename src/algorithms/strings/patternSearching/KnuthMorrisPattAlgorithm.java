package algorithms.strings.patternSearching;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KnuthMorrisPattAlgorithm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();
        String pattern = sc.next();

        List<Integer> occurrencesList = searchForAllTheOccurrences(pattern, inputString);
        occurrencesList.forEach(occurrence -> System.out.println("Match found at " + occurrence));
    }

    private static List<Integer> searchForAllTheOccurrences(String pattern, String inputString) {
        int[] lps = preProcessPatternAndGenerateLpsArray(pattern);
        return kmpSearch(lps, pattern, inputString);
    }

    private static List<Integer> kmpSearch(int[] lps, String pattern, String inputString) {
        List<Integer> listOfAllOccurrences = new ArrayList<>();
        int j = 0;

        int inputStringLength = inputString.length(), patternLength = pattern.length();
        for (int i = 0; i< inputStringLength; i++) {
            if (inputString.charAt(i) == pattern.charAt(j)) {
                if (j == patternLength - 1) {
                    listOfAllOccurrences.add(i-patternLength+1);
                    j = 0;
                } else {
                    j++;
                }
            } else {
                if (j != 0) {
                    j = lps[j-1];
                }
            }
        }

        return listOfAllOccurrences;
    }

    private static int[] preProcessPatternAndGenerateLpsArray(String pattern) {
        int i = 0;
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        //Creating longest proper suffix array for each length of the pattern
        for (int j = 1; j<pattern.length(); j++) {
            //If the chars at i and j are equal, increment both i and j, so that there is a possibility to get
            //a longer proper suffix for the next length
            if (pattern.charAt(i) == pattern.charAt(j)) {
                //The lps at j will be equal to the length of the chars which are equal at both prefix and suffix
                //So, that will be 1 plus the i. Like i = 0, lps[j] = 1 (there is one element that is a proper suffix)
                lps[j] = i+1;
                i++;
            } else {
                //If the chars at i and j are not equal, take the previous lps to current i and check that
                /*
                    What we know here,
                    pattern[0..i-1] = pattern[j-lps[i-1]...j-1]
                    and let's say we have lps[i-1] (from now on we call it k) != 0, that means there is a sub-pattern inside the substring from
                    0...i-1 which is a proper suffix,
                    i.e. pattern[0...k-1] = pattern[x...i-1] (for some x that will be calculated based on the length of the lps)
                    Similarly, the same pattern will repeat in the lps ending at j
                    Check one note fot the diagrammatic explanation
                 */
                while (i != 0 && pattern.charAt(i) != pattern.charAt(j)) {
                    i = lps[i-1];
                }

                if (pattern.charAt(i) == pattern.charAt(j)) {
                    lps[j] = i+1;
                    i++;
                } else {
                    lps[j] = 0;
                }
            }
        }

        return lps;
    }
}
