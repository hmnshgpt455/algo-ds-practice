package problems.books.elementsOfProgrammingInterviews.numberOfWaysToBuildAScore.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Himanshu Gupta
 * Problem : 17.1 FInd the possible number of combinations of the total score, given all the indiidual scores
 * Time complexity : O(nm), n = number of possible individual scores, m = Total score
 * Space complexuty : O(nm)
 */

public class NumberOfCombinationsToBuildAScore {
    public static void main(String[] args) {
        List<Integer> scores = new ArrayList<>(List.of(2, 3, 7));
        System.out.println(findNumberOfPermutations(scores, 12));
    }

    public static int findNumberOfPermutations(List<Integer> scores, Integer totalScore) {
        int[][] dp = new int[scores.size()][totalScore+1];
        //Initializing the values for 0 score
        IntStream.range(0, scores.size()).forEach(i -> dp[i][0] = 1);

        IntStream.range(0, scores.size()).forEach(i -> IntStream.range(1, totalScore+1).forEach(j -> {
            int waysWithCurrentScore = 0, waysWithoutCurrentScore = 0;
            if (j >= scores.get(i)) {
                //When we are using score[j] to construct totalScore
                waysWithCurrentScore = dp[i][j-scores.get(i)];
            }

            if (i>0) {
                waysWithoutCurrentScore = dp[i-1][j];
            }

            dp[i][j] = waysWithCurrentScore + waysWithoutCurrentScore;

        }));

        return dp[scores.size()-1][totalScore];
    }

    /*
    totalScores = 12, {2, 3, 7}

    0 1 2 3 4 5 6 7 8 9 10 11 12		//score.get(i) = 3
    2	1 0 1 0 1 0 1 0 1 0 01 00 01
    2, 3	1 0 1 1 1 1 2 1 2 2 02 02 03
    2,3,7	1 0 1 1 1 1 2 2 2 3 03 03 04
    */

    //ans = 4
    //Time complexity : O(nm)
    //Space complexity : O(nm)

}
