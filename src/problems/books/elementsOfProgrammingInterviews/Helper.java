package problems.books.elementsOfProgrammingInterviews;

public class Helper {
    public static void bin(Integer n) {
        if (n > 1)
            bin(n >> 1);

        System.out.printf("%d", n & 1);
    }

}
