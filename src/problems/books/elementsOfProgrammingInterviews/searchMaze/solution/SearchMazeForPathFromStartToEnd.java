package problems.books.elementsOfProgrammingInterviews.searchMaze.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Himanshu Gupta
 * Problem : 19.1 => Search the maze to find a path from a starting cell to ending cell.
 * Time complexity : O(nm)
 * Space complexity : O(nm)
 */

public class SearchMazeForPathFromStartToEnd {
    public static void main(String[] args) {
        List<List<Integer>> maze = new ArrayList<>();
        int n,m;
        maze.add(new ArrayList<>(List.of(0,1,1,1,1,1,0,0,1,1)));
        maze.add(new ArrayList<>(List.of(1,1,0,1,1,1,1,1,1,1)));
        maze.add(new ArrayList<>(List.of(0,1,0,1,1,0,0,1,0,0)));
        maze.add(new ArrayList<>(List.of(1,1,1,0,0,0,1,1,0,1)));
        maze.add(new ArrayList<>(List.of(1,0,0,1,1,1,1,1,1,1)));
        maze.add(new ArrayList<>(List.of(1,0,0,1,1,0,1,0,0,1)));
        maze.add(new ArrayList<>(List.of(1,1,1,1,0,1,1,1,1,1)));
        maze.add(new ArrayList<>(List.of(0,1,0,1,0,1,0,1,1,1)));
        maze.add(new ArrayList<>(List.of(0,1,0,0,1,1,1,0,0,0)));
        maze.add(new ArrayList<>(List.of(1,1,1,1,1,1,1,0,0,1)));
        searchMazeForPath(maze, new Coordinate(9, 0), new Coordinate(0, 9)).forEach(System.out::println);
    }

    //It will hold the coordinates
    static class Coordinate {
        int x;
        int y;

        //It will need to implement equals and hashCode methods
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }

            Coordinate that = (Coordinate)o;
            return that.x == this.x && that.y == this.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }

    static public List<Coordinate> searchMazeForPath(List<List<Integer>> maze, Coordinate start, Coordinate end) {
        List<Coordinate> path = new ArrayList<>();
        path.add(new Coordinate(start.x, start.y));
        if (!isPossibleToReach(path, maze, start, end)) {
            path.remove(0);
        }

        return path;
    }

    static public boolean isPossibleToReach(List<Coordinate> path, List<List<Integer>> maze, Coordinate curr, Coordinate end) {
        if (curr.equals(end)) {
            return true; //We have found the path
        }

        final int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] move : moves) {
            if (isMoveFeasible(move, maze, curr)) {
                Coordinate next = new Coordinate(curr.x + move[0], curr.y + move[1]);
                path.add(next);
                if (isPossibleToReach(path, maze, next, end)) {
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }

        return false;
    }

    static private boolean isMoveFeasible(int[] move, List<List<Integer>> maze, Coordinate curr) {
        int newX = curr.x + move[0];
        int newY = curr.y + move[1];

        if (newX >= 0 && newX < maze.size() && newY >= 0 && newY < maze.get(0).size() && maze.get(newX).get(newY) == 1) {
            maze.get(newX).set(newY, 0);
            return true;
        }

        return false;
    }

}
