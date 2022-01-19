package problems.books.elementsOfProgrammingInterviews;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Helper {
    public static void bin(Integer n) {
        if (n > 1)
            bin(n >> 1);

        System.out.printf("%d", n & 1);
    }

    public static List<Integer> takeArrayAsInput() {
        Scanner sc = new Scanner(System.in);
        return Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    }
    public static List<Double> takeDoubleArrayAsInput() {
        Scanner sc = new Scanner(System.in);
        return Arrays.stream(sc.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
    }

}
