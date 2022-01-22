package problems.books.elementsOfProgrammingInterviews.reverseSubList.solution;

/**
 * @author Himanshu Gupta
 * Problem statement : Reverse a sublist in a singly linked list.
 * Page : 117 (Kindle : 131)
 * Time complexity : O(f), f = finisihing index
 * Space compliexty : No additional space used (O(1))
 */

public class ReverseSublist {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        reverseSubList(head, 1, 1);

        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
    }

    static class ListNode {
        ListNode next;
        int value;

        public ListNode() {
        }

        public ListNode(int value) {
            this.value = value;
        }
    }

    static private void reverseSubList(ListNode head, int start, int end) {
        int i = 0;
        ListNode dummy = head, prev = null, subListStartHead;
        while (i < start) {
            prev = dummy;
            dummy = dummy.next;
            i++;
        }

        subListStartHead = dummy;
        ListNode current = subListStartHead;

        while (i++ <= end) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        if (null != subListStartHead.next) {
            subListStartHead.next.next = prev;
        }
        subListStartHead.next = current;
    }

}
