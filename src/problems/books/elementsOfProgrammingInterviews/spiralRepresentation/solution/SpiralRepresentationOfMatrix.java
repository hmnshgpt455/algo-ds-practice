package problems.books.elementsOfProgrammingInterviews.spiralRepresentation.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author Himanshu Gupta
 * Problem : 6.17 : Generate the spiral representation
 * Page no : 87 (Kindle : 101)
 * Time complexity : O(n^2)
 * Space complexity : O(n^2) {Just to save the representation}
 */

public class SpiralRepresentationOfMatrix {
    public static void main(String[] args) {
        AtomicInteger n = new AtomicInteger(1);
        List<List<Integer>> matrix = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> {
            List<Integer> arr = new ArrayList<>();
            IntStream.range(0, 5).forEach(j -> arr.add(n.getAndIncrement()));
            matrix.add(arr);
        });
        printSpiralForm(matrix).forEach(el -> System.out.print(el + " "));
    }

    private static List<Integer> printSpiralForm(List<List<Integer>> matrix) {
        List<Integer> spiralRepresentation = new ArrayList<>();

        updateSpiralRepresentation(matrix, 0, spiralRepresentation);

        return spiralRepresentation;
    }

    static void updateSpiralRepresentation(List<List<Integer>> matrix, int offset, List<Integer> spiralRepresentation) {
        if ((matrix.size() - (2*offset)) < 0) {
            return;
        }
        if ((matrix.size() - (2*offset)) == 1) {
            spiralRepresentation.add(matrix.get(offset).get(offset));
            return;
        }

        //Four iterations for all the 4 sides
        int n = matrix.size();
        //Left to right
        IntStream.range(offset, n-offset).forEach(i -> spiralRepresentation.add(matrix.get(offset).get(i)));

        //Top to bottom
        IntStream.range(offset+1, n-offset).forEach(i -> spiralRepresentation.add(matrix.get(i).get(n-offset-1)));

        //Right to left
        for (int i = n-offset-2; i>=offset; i--) {
            spiralRepresentation.add(matrix.get(n-offset-1).get(i));
        }

        //Bottom to top
        for (int i = n-offset-2; i>offset; i--) {
            spiralRepresentation.add(matrix.get(i).get(offset));
        }

        updateSpiralRepresentation(matrix, offset+1, spiralRepresentation);
    }
}
