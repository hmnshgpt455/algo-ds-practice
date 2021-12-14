package algorithms.greedy;

import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.stream.IntStream;

public class FractionalKnapsackProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        AtomicInteger maximumWeight = new AtomicInteger(sc.nextInt());

        Double maximumValue = IntStream.range(0, n)
                .mapToObj(i -> new Item(sc.nextDouble(), sc.nextDouble()))
                .sorted(Comparator.comparingDouble(item -> (item.getWeight() / item.getValue())))
                .reduce(0.0, (ans, item) -> {
                    double valueToBeAdded = 0;
                    if (maximumWeight.get() > 0) {
                        if (maximumWeight.get() > item.getWeight()) {
                            maximumWeight.addAndGet((int) (-1 * item.getWeight()));
                            valueToBeAdded = item.getValue();
                        } else {
                            valueToBeAdded = (item.getValue() / item.getWeight()) * (maximumWeight.get());
                            maximumWeight.set(0);
                        }
                    }
                    return ans + valueToBeAdded;
                }, Double::sum);

        System.out.println(maximumValue);
    }

    static class Item {
        private final double value;
        private final double weight;

        public double getValue() {
            return value;
        }

        public double getWeight() {
            return weight;
        }

        public Item(double value, double weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}
