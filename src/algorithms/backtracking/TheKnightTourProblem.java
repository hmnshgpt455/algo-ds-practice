package algorithms.backtracking;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class TheKnightTourProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        findPossibleMoves(n);
    }

    private static void findPossibleMoves(int n) {
        int[][] solutionChessboard = new int[n][n];

        IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> solutionChessboard[i][j] = -1));
        int[] possibleMovesVertically = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] possibleMovesHorizontally = {1, 2, 2, 1, -1, -2, -2, -1};
        solutionChessboard[0][0] = 0;

        boolean areDesiredMovesPossible =
                isDesiredMovesPossible(solutionChessboard, n, possibleMovesVertically, possibleMovesHorizontally,
                        1, 0, 0);

        if (areDesiredMovesPossible) {
            Arrays.stream(solutionChessboard).forEach(row -> {
                Arrays.stream(row).forEach(System.out::print);
                System.out.println("\n");
            });
        } else {
            System.out.println("Solution not possible");
        }
    }

    private static Boolean isDesiredMovesPossible(int[][] solutionChessboard, int n, int[] possibleMovesVertically,
                                                  int[] possibleMovesHorizontally, int moveNumber,
                                                  int currentXLoc, int currentYLoc) {
        AtomicBoolean isPossible = new AtomicBoolean();
        if (moveNumber == n * n) {
            return true;
        }

        //Find if any of all the possible solutions is good enough. Check for all possible moves.
        Arrays.stream(possibleMovesHorizontally).forEach(moveX -> Arrays.stream(possibleMovesVertically)
                .forEach(moveY -> {
                    //Find the next cell location that we will achieve by making this move
                    int nextXLoc = currentXLoc + moveX;
                    int nextYLoc = currentYLoc + moveY;

                    if (isNextLocationValid(nextXLoc, nextYLoc, n, solutionChessboard)) {
                        //Mark the move number for this cell
                        solutionChessboard[nextXLoc][nextYLoc] = moveNumber;
                        //If the next location is a valid one, find if the solution is possible with this move
                        boolean isNextMoveDesirable = isDesiredMovesPossible(solutionChessboard, n,
                                possibleMovesVertically, possibleMovesHorizontally, moveNumber + 1,
                                nextXLoc, nextYLoc);
                        //If the solution is possible through the next move
                        if (isNextMoveDesirable) {
                            isPossible.set(true);
                        } else {
                            isPossible.set(false);
                            //otherwise, mark it as false
                            solutionChessboard[nextXLoc][nextYLoc] = -1;
                        }
                    }
                }));
        return isPossible.get();
    }

    private static boolean isNextLocationValid(int nextXLoc, int nextYLoc, int N, int[][] chessboard) {
        return nextXLoc < N && nextXLoc >= 0 && nextYLoc < N && nextYLoc >= 0 &&
                chessboard[nextXLoc][nextYLoc] == -1;
    }
}
