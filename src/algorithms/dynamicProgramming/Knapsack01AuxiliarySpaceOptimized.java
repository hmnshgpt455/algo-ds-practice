package algorithms.dynamicProgramming;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Knapsack01AuxiliarySpaceOptimized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] values = IntStream.range(0, n).map(i -> sc.nextInt()).toArray();
        int[] weights = IntStream.range(0, n).map(i -> sc.nextInt()).toArray();
        int maximumWeight = sc.nextInt();
        int[][] dp = new int[2][maximumWeight+1];

        IntStream.range(0, n+1).forEach(i -> IntStream.range(0, maximumWeight+1).forEach(j -> {
            if (j == 0 || i == 0) {
                dp[i % 2][j] = 0;
            } else if (j >= weights[i-1]) {
                dp[i % 2][j] = Math.max(dp[((i-1) % 2)][j], values[i-1] + dp[((i-1) % 2)][j-weights[i-1]]);
            } else {
                dp[i%2][j] = 0;
            }
        }));

        System.out.println(dp[n%2][maximumWeight]);
    }
}
