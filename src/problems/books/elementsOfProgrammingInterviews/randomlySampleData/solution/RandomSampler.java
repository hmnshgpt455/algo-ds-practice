package problems.books.elementsOfProgrammingInterviews.randomlySampleData.solution;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author Himanshu Gupta
 * Problem : 6.11 : Randomly find a sample subset of size k from an input array
 * Page : 78 (Kindle : 92)
 * Time complexity : O(k)
 * Space complexity : O(1)
 */

public class RandomSampler {
    public static void main(String[] args) {
        List<Integer> inputArray = new ArrayList<>(List.of(9,9,19,29,199,22,11,229,119,22));
        int k = 4;
        randomSampling(k, inputArray);
        IntStream.range(0, k).forEach(i -> System.out.println(inputArray.get(i) + " "));
    }

    public static void randomSampling(int subsetSize, List<?> inputCollection) {
        Random randomGen = new Random();

        IntStream.range(0, subsetSize).forEach(i -> {
            int randomIndex = randomGen.nextInt(inputCollection.size() - i) + i;
            Collections.swap(inputCollection, i, randomIndex);
        });
    }

}
