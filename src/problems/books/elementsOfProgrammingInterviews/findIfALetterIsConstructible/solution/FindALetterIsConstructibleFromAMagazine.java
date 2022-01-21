package problems.books.elementsOfProgrammingInterviews.findIfALetterIsConstructible.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

/**
 * Problem : 13.2 => Find if an anonymous letter can be created using a magazine
 * Page : 213 (Kindle : 227)
 * Time complexity : O(m+n)
 * Space complexity : O(k), k is the number of distinct characters in letter
 */

public class FindALetterIsConstructibleFromAMagazine {
    public static void main(String[] args) {
        System.out.println(findIfLetterIsConstructibleFromMagazine("This is a magazine", "Tthis"));
    }

    public static boolean findIfLetterIsConstructibleFromMagazine(String magazine, String letter) {

        Map<Character, Integer> characterToCountMap = new HashMap<>();

        IntStream.range(0, letter.length()).forEach(i -> {
            Character c = letter.charAt(i);
            Optional.ofNullable(characterToCountMap.get(c)).ifPresentOrElse(count -> characterToCountMap.put(c, count+1), () -> characterToCountMap.put(c, 1));
        });

        AtomicBoolean isConstructible = new AtomicBoolean(false);

        IntStream.range(0, magazine.length())
                .takeWhile((i) -> !isConstructible.get())
                .forEach(i -> {
                    Character currentMagazineCharacter = magazine.charAt(i);
                    Optional.ofNullable(characterToCountMap.get(currentMagazineCharacter)).ifPresent(count -> {
                        if (count == 1) {
                            characterToCountMap.remove(currentMagazineCharacter);
                        } else {
                            characterToCountMap.put(currentMagazineCharacter, count-1);
                        }
                    });

                    if (characterToCountMap.isEmpty()) {
                        isConstructible.set(true);
                    }
                });

        return isConstructible.get();

    }

}
