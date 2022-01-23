package problems.books.elementsOfProgrammingInterviews.findCycleHeadInTheSinglyLinkedList.solution;

import java.util.Optional;

/**
 * @author Himanshu Gupta
 * Problem : 8.3 : Find if there exists a cycle in the singly linkedList and also, find the head of the cycle, if it exists
 * Page : 117 (Kindle : 131)
 * Time complexity : O(n)
 * Space complexity : O(1)
 */

public class FindCycleHeadInASinglyLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.next = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
//        ListNode cycleHead = head.next;
//        head.next.next.next.next.next.next.next = cycleHead;
        Optional.ofNullable(findCycleHeadIfExists(head)).ifPresent(System.out::println);
    }

    static class ListNode {
        ListNode next;
        int data;

        public ListNode() {
        }

        public ListNode(int data) {
            this.data = data;
        }

        public ListNode(int data, ListNode next) {
            this.next = next;
            this.data = data;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "data=" + data +
                    '}';
        }
    }

    static public ListNode findCycleHeadIfExists(ListNode head) {
        int cycleLength = findCycleLength(head);
        if (cycleLength > 0) {
            return findCycleHead(head, cycleLength);
        }

        return null;
    }

    static private ListNode findCycleHead(ListNode head, int cycleLength) {
        ListNode iterator = head.next; //Normal iterator
        ListNode advanceIterator = iterator; //Iterator which is cycleLength ahead
        int nodesTraversed = 0;

        while (nodesTraversed < cycleLength) {
            advanceIterator = advanceIterator.next;
            nodesTraversed++;
        }

        while (advanceIterator != iterator) {
            iterator = iterator.next;
            advanceIterator = advanceIterator.next;
        }

        return iterator;
    }

    static private int findCycleLength(ListNode head) {
        ListNode fastIterator = head;
        ListNode slowIterator = head;
        boolean isCyclePresent = false;
        while (fastIterator != null && slowIterator != null) {
            fastIterator = fastIterator.next;
            if (fastIterator != null) fastIterator = fastIterator.next;
            slowIterator = slowIterator.next;
            if (fastIterator == slowIterator) {
                isCyclePresent = true;
                break;
            }
        }

        if (isCyclePresent) {
            return findCycleLength(fastIterator, slowIterator);
        }
        return 0;
    }

    static private int findCycleLength(ListNode fastIterator, ListNode slowIterator) {
        slowIterator = slowIterator.next;
        int cycleLength = 1;
        while (slowIterator != fastIterator) {
            cycleLength++;
            slowIterator = slowIterator.next;
        }

        return cycleLength;
    }

}
