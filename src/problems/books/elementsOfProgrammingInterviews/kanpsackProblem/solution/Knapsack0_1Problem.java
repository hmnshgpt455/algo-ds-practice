package problems.books.elementsOfProgrammingInterviews.kanpsackProblem.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Problem : 17.6 : 0-1 Knapsack problem
 * Page : 319 (Kindle : 333)
 * Time complexity : O(nm)
 * Space complexity : O(nm)
 */

public class Knapsack0_1Problem {
    public static void main(String[] args) {
        List<Integer> weights = new ArrayList<>(List.of(5, 3, 4, 2));
        List<Integer> values = new ArrayList<>(List.of(60, 50, 70, 30));

        System.out.println(findMaximumValueThatCanBeCarried(weights, values, 5));
    }

    public static int findMaximumValueThatCanBeCarried(List<Integer> weights, List<Integer> values, int maxWeight) {
        int n = weights.size();
        int[][] dp = new int[n][maxWeight+1];

        IntStream.range(0, n).forEach(i -> IntStream.range(0, maxWeight+1).forEach(j -> {
            int valueWithCurrentWeight = 0, valueWithoutCurrentWeight = 0;
            if (weights.get(i) <= j) {
                valueWithCurrentWeight = i > 0 ? dp[i-1][j-weights.get(i)] + values.get(i) : values.get(i);
            }

            valueWithoutCurrentWeight = i > 0 ? dp[i-1][j] : 0;

            dp[i][j] = Math.max(valueWithCurrentWeight, valueWithoutCurrentWeight);
        }));

        return dp[n-1][maxWeight];
    }

}
