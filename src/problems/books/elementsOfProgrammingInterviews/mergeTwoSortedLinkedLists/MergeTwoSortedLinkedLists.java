package problems.books.elementsOfProgrammingInterviews.mergeTwoSortedLinkedLists;

/**
 * Problem statement : Merge two sorted linked lists
 * Time complexity : O(n)
 * Space complexity : O(1), because we are reusing the existing nodes
 */

public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(7);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(11);

        ListNode mergedList = getMergedLists(l1, l2);

        while (mergedList != null) {
            System.out.print(mergedList.data + " ");
            mergedList = mergedList.next;
        }
    }

    //It's similar to merge function in the merge sort

    static class ListNode {
        public Integer data;
        public ListNode next;

        public ListNode(Integer data) {
            this.data = data;
            this.next = null;
        }

        public ListNode() {
        }
    }

    static ListNode getMergedLists(ListNode l1, ListNode l2) {
        ListNode mergedList = new ListNode();
        ListNode current = mergedList;

        while (l1 != null && l2 != null) {
            if (l1.data.compareTo(l2.data) < 0) {
                //It means the data in l1 is less than the data in l2
                //We will update the current node to the lesser node
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        current.next = l1 != null ? l1 : l2;

        return mergedList.next;
    }

}
