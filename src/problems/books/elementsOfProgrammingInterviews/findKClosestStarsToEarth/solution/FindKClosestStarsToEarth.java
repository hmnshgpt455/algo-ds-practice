package problems.books.elementsOfProgrammingInterviews.findKClosestStarsToEarth.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Himanshu Gupta
 * Problem 11.4 : Find the K closest stars to the earth. Earth is at (0,0,0) and there are approximately 10^12 stars in total. That means the data set is very large and
 * cannot be stored in the memory
 * Page : 180 (Kindle 203)
 * Time complexity : O(nlogk) -> n is the number of stars
 * Space complexity : O(k)
 */

public class FindKClosestStarsToEarth {
    public static void main(String[] args) {
        List<Star> allStars = new ArrayList<>(List.of(new Star(1,2 , 3), new Star(2, 2, 3), new Star(5,6, 2)
        , new Star(1, 1, 1), new Star(1, 2, 3), new Star(0.1, 0.1, 0.1)));
        System.out.println(findTheKClosestStars(allStars, 3));
    }

    static class Star implements Comparable<Star> {
        double x;
        double y;
        double z;

        public Star(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Star{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }

        public double distanceFromEarth() {
            return Math.sqrt(x*x + y*y + z*z);
        }

        public int compareTo(Star star) {
            return Double.compare(this.distanceFromEarth(), star.distanceFromEarth());
        }
    }


    public static List<Star> findTheKClosestStars(List<Star> allStars, int k) {
        PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

        allStars.forEach(star -> {
            maxHeap.add(star);
            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        });

        List<Star> closestStarsList = new ArrayList<>(maxHeap);
        Collections.sort(closestStarsList);

        return closestStarsList;
    }

}
