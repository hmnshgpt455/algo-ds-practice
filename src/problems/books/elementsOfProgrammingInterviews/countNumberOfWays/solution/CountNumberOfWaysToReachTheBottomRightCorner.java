package problems.books.elementsOfProgrammingInterviews.countNumberOfWays.solution;

import java.util.stream.IntStream;

/**
 * Problem : 17.3 : Find the number of ways to reach from the top left corner to the bottom right corner, when only allowed
 * possible moves are moving to the right and moving to the bottom
 * Page : 312 (Kindle : 326)
 * Time complexity : O(nm)
 * Space complexity : O(nm)
 */
public class CountNumberOfWaysToReachTheBottomRightCorner {
    public static void main(String[] args) {
        System.out.println(findNumberOfWays(5, 6));
    }

    private static int findNumberOfWays(int rowSize, int columnSize) {
        int[][] dp = new int[rowSize][columnSize];
        IntStream.range(0, rowSize).forEach(i -> dp[i][0] = 1);
        IntStream.range(0, columnSize).forEach(j -> dp[0][j] = 1);
        IntStream.range(0, rowSize).forEach(i -> IntStream.range(0, columnSize)
            .forEach(j -> {
                if (i != 0 && j != 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }));

        return dp[rowSize-1][columnSize-1];
    }

}
