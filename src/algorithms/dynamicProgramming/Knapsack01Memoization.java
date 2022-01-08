package algorithms.dynamicProgramming;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Knapsack01Memoization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] values = IntStream.range(0, n).map(i -> sc.nextInt()).toArray();
        int[] weights = IntStream.range(0, n).map(i -> sc.nextInt()).toArray();
        int maximumWeight = sc.nextInt();

        int[][] dp = new int[n + 1][maximumWeight + 1];

        IntStream.range(0, n + 1).forEach(i -> IntStream.range(0, maximumWeight + 1).forEach(j -> {
            if (i == 0 || j == 0) {
                dp[i][j] = 0;
            } else if (weights[i - 1] <= j) {
                dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }));

        System.out.println(dp[n][maximumWeight]);
    }
}
