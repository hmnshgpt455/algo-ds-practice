package problems.books.elementsOfProgrammingInterviews.findClosestRepeatingPairsDistance.solution;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author Himanshu Gupta
 * Problem : 13.6 : Find the distance of closest pairs of same word.
 * Page : 218 (Kindle : 231)
 * Time complexity : O(n)
 * Space complexity : O(d), d => number of distinct words in the paragraph
 */

public class FindClosestRepeatingPairsDistance {
    public static void main(String[] args) {
        List<String> array = new ArrayList<>(List.of("All", "All", "and", "no", "play", "makes", "for", "no", "fun",
                "and", "no", "work", "no", "fun", "and", "no", "results"));
        System.out.println(distanceOfClosestRepeatingPair(array));
    }

    public static int distanceOfClosestRepeatingPair(List<String> array) {
        Map<String, Integer> map = new HashMap<>();
        AtomicInteger minimumDistance = new AtomicInteger(Integer.MAX_VALUE);

        IntStream.range(0, array.size()).forEach(i -> {
            String currentWord = array.get(i);
            Optional.ofNullable(map.get(currentWord)).ifPresentOrElse((lastIndex) ->{
                        minimumDistance.set(Math.min(minimumDistance.get(), (i-lastIndex)));
                        map.put(currentWord, i);},
                    () -> map.put(currentWord, i));
        });

        return minimumDistance.get();
    }

}
