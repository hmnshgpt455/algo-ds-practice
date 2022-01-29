package problems.books.elementsOfProgrammingInterviews.findAllPermutations.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Problem : 16.3 variant : Generate all the permutations of an array. We can have duplicate elements
 * Page : 287 (Kindle : 301)
 * Time complexity : O(n * n!)
 * Space complexity : O(n!)
 */

public class FindAllPermutationsOfAnArrayDuplicateElements {
    public static void main(String[] args) {
        System.out.println(findAllPermutations(new ArrayList<>(List.of(2, 2, 3, 0))));
    }

    static List<List<Integer>> findAllPermutations(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();

        populatePermutations(0, array.size(), result, array);
        return result;
    }

    static void populatePermutations(int start, int end, List<List<Integer>> result, List<Integer> array) {
        if (start == array.size() - 1) {
            result.add(new ArrayList<>(array));
            return;
        }

        IntStream.range(start, end).forEach(j -> {
            if (j == start || array.get(start) != array.get(j)) {
                Collections.swap(array, start, j);
                populatePermutations(start + 1, end, result, array);
                Collections.swap(array, start, j);
            }
        });
    }
}
