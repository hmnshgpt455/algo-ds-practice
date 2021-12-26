package dataStructures.trees.driverClasses.binarySearchTree;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DriverHelper {

    public static List<Integer> getPreOrderRepresentationInput() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        return IntStream.range(0, n)
                .boxed()
                .map(i -> sc.nextInt())
                .collect(Collectors.toList());
    }
}
