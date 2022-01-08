package algorithms.divideAndConquer;

import java.util.Scanner;

public class ComputePower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float number = sc.nextFloat();
        int power = sc.nextInt();

        float ans = computePower(number, power);

        System.out.println(ans);
    }

    private static float computePower(float number, int power) {
        if (power == 0) {
            return 1;
        }

        float halfPowerValue = computePower(number, power / 2);

        //If the power is even, then it means the halfPowerValue is sufficient
        if (power % 2.0 == 0) {
            return halfPowerValue * halfPowerValue;
        }
        //Because the power is odd, so, need to multiply extra number to incorporate for the loss due to type conversion
        if (power < 0) {
            //It means we have to multiply number power -1
            return (halfPowerValue * halfPowerValue) / number;
        }
        return number * halfPowerValue * halfPowerValue;
    }
}
