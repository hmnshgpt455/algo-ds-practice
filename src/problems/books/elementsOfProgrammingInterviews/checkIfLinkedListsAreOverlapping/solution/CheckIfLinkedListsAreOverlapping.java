package problems.books.elementsOfProgrammingInterviews.checkIfLinkedListsAreOverlapping.solution;

import java.util.Arrays;

/**
 * @author Himanshu Gupta
 * Problem : 8.4 : Check if two linked lists overlap
 * Page : 119
 * Time complexity : O(n)
 * Space complexity : O(1)
 */

public class CheckIfLinkedListsAreOverlapping {
    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode(10);
        l1.next = new LinkedListNode(20);
        l1.next.next = new LinkedListNode(30);
        l1.next.next.next = new LinkedListNode(30);

//        LinkedListNode l2 = new LinkedListNode(11);
//        l2.next = new LinkedListNode(11);
//        l2.next.next = new LinkedListNode(11);
//        l2.next.next.next = new LinkedListNode(11);
//        l2.next.next.next.next = new LinkedListNode(11);
//        l2.next.next.next.next.next = new LinkedListNode(11);
//        l2.next.next.next.next.next.next = l1.next.next.next;
        LinkedListNode l2 = new LinkedListNode(10);
        l2.next = new LinkedListNode(20);
        l2.next.next = l1.next.next;

        System.out.println(areListsOverlapping(l1, l2));
    }

    static class LinkedListNode {
        int data;
        LinkedListNode next;

        public LinkedListNode(int data) {
            this.data = data;
        }
    }

    static public boolean areListsOverlapping(LinkedListNode list1, LinkedListNode list2) {
        LinkedListNode lastNode = null;
        boolean ans = false;
        while ((list1 != null || list2 != null) && !ans) {
            if (lastNode != null) {
                ans = lastNode == list1 || lastNode == list2;
            }
            ans = ans || list1 == list2;
            if (list1 != null) {
                if (list1.next != null) {
                    list1 = list1.next;
                } else {
                    lastNode = lastNode == null ? list1 : lastNode;
                    list1 = null;
                }
            }

            if (list2 != null) {
                if (list2.next != null) {
                    list2 = list2.next;
                } else {
                    lastNode = lastNode == null ? list2 : lastNode;
                    list2 = null;
                }
            }

        }

        return ans;
    }

}
