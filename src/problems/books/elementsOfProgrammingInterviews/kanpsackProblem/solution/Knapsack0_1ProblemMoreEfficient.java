package problems.books.elementsOfProgrammingInterviews.kanpsackProblem.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Himanshu Gupta
 * Problem : 17.6 : 0-1 Knapsack problem
 * Page : 319 (Kindle : 333)
 * Time complexity : O(nm)
 * Space complexity : O(m)
 */

public class Knapsack0_1ProblemMoreEfficient {
    public static void main(String[] args) {
        List<Integer> weights = new ArrayList<>(List.of(5, 3, 4, 2));
        List<Integer> values = new ArrayList<>(List.of(60, 50, 70, 30));

        System.out.println(findMaximumValueThatCanBeCarried(weights, values, 5));
    }

    public static int findMaximumValueThatCanBeCarried(List<Integer> weights, List<Integer> values, int maxWeight) {
        int n = weights.size();
        int[][] dp = new int[2][maxWeight+1];

        IntStream.range(0, n).forEach(i -> IntStream.range(0, maxWeight+1).forEach(j -> {
            int valueWithCurrentWeight = 0, valueWithoutCurrentWeight;
            if (weights.get(i) <= j) {
                valueWithCurrentWeight = i > 0 ? dp[(i-1)%2][j-weights.get(i)] + values.get(i) : 0;
            }

            valueWithoutCurrentWeight = i > 0 ? dp[(i-1)%2][j] : 0;

            dp[i%2][j] = Math.max(valueWithCurrentWeight, valueWithoutCurrentWeight);
        }));

        return dp[(n-1)%2][maxWeight];
    }

}
