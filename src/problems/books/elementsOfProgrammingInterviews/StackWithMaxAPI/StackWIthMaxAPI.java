package problems.books.elementsOfProgrammingInterviews.StackWithMaxAPI;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Problem statement : Implement a stack with the capability to get the max element till now
 * Problem no : 9.1
 * Page : 134 (Kindle : 145)
 * Time complexity :
 *  1. push : O(1)
 *  2. pop : O(1)
 *  3. getMax : O(1)
 */

public class StackWIthMaxAPI {
    public static void main(String[] args) {
        ModifiedStack stack = new ModifiedStack();
        stack.push(23);
        stack.push(25);
        stack.push(22);
        stack.push(11);
        stack.push(67);
        //System.out.println(stack.pop());
        System.out.println(stack.getMax());
        System.out.println(stack.pop());
        System.out.println(stack.getMax());
    }
    public static class StackElement {
        int data;
        int maxTillNow;

        StackElement(int data, int maxTillNow) {
            this.data = data;
            this.maxTillNow = maxTillNow;
        }
    }

    public static class ModifiedStack {
        Deque<StackElement> stack = new LinkedList<>();

        public int pop() {
            if (stack.isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return stack.removeFirst().data;
        }

        public void push(int element) {
            if (null == stack.peekFirst()) {
                stack.offerFirst(new StackElement(element, element));
            } else {
                stack.offerFirst(new StackElement(element, Math.max(stack.peekFirst().maxTillNow, element)));
            }
        }

        public int getMax() {
            if (stack.isEmpty()) {
                throw new IllegalStateException("stack is empty");
            }
            return stack.peekFirst().maxTillNow;
        }

    }

}
