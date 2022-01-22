package problems.books.elementsOfProgrammingInterviews.computeXPowerY.solution;

/**
 * @author Himanshu Gupta
 * Find x^y
 * Time complexity : O(n) -> where n is the index of the MSB of the power
 * Page : 54 (Kindle : 67)
 * Space complexity : O(1)
 */
public class FindXPowerY {
    public static void main(String[] args) {
        System.out.println(power(10, -5));
    }

    static double power(double x, long y) {
        long power = y;
        if (power < 0) {
            power = -power;
            x = 1/x;
        }
        double result = 1;
        while (power != 0) {
            if ((power & 1) != 0) {
                //If power is odd
                result *= x;
            }
            x *= x;
            power >>>= 1;
        }

        return result;
    }


    //x^y = x^((2^a) + (2^b) + (2^c) + …. + (2^n)), y is even
    //= x^(2^a) . x^(2^b) . x^(2^c) …. x ^ (2^n)
    //= ((x^2)^a) . ((x^2)^b) . ((x^2)^c) …. ((x^2)^n)
    //(x^2)^a can be considered multiplying x^2 a times, which can be done in a loop that will
    // run till the bit at index a is extracted out by doing right shift a times.

}
