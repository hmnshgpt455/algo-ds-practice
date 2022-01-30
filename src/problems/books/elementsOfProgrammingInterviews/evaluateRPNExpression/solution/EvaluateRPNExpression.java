package problems.books.elementsOfProgrammingInterviews.evaluateRPNExpression.solution;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Himanshu Gupta
 * Problem : 9.2 : Evaluate RPN expressions
 * Page : 135
 * Time complexity : O(n)
 * Space complexity : O(n)
 */

public class EvaluateRPNExpression {
    public static void main(String[] args) {
        System.out.println(evaluateRPNExpressions("3,4,+,2,x,1,+"));
    }

    static public int evaluateRPNExpressions(String exp) {
        String delimiter = ",";
        String[] expArray = exp.split(delimiter);
        Stack<Integer> executionStack = new Stack<>();
        Arrays.stream(expArray).forEach(el -> {
            switch(el) {
                case "+" :
                    executionStack.push(executionStack.pop() + executionStack.pop());
                    break;
                case "-" :
                    executionStack.push(executionStack.pop() - executionStack.pop());
                    break;
                case "x" :
                    executionStack.push(executionStack.pop() * executionStack.pop());
                    break;
                case "/" :
                    executionStack.push(executionStack.pop() / executionStack.pop());
                    break;
                default :
                    executionStack.push(Integer.parseInt(el));
            }
        });

        return executionStack.pop();
    }

}
