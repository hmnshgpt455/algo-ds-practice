package problems.books.elementsOfProgrammingInterviews.stockProfit.solution;

import problems.books.elementsOfProgrammingInterviews.Helper;

import java.util.List;

/**
 * Problem statement : Find the maximum profit for a series of stock prices.
 * Time complexity : O(n)
 * Space complexity : O(1)
 * Problem : 6.1 page 61(Kindle : 75)
 */

public class MaximumProfit {
    public static void main(String[] args) {
        System.out.println(findMaximumProfit(Helper.takeDoubleArrayAsInput()));
    }
    static Double findMaximumProfit(List<Double> prices) {
        double minimumTillNow = Double.MAX_VALUE, maxProfit = Double.MIN_VALUE;
        for (Double price : prices) {
            maxProfit = Math.max(maxProfit, price-minimumTillNow);
            minimumTillNow = Math.min(minimumTillNow, price);
        }
        return maxProfit;

    }

}
