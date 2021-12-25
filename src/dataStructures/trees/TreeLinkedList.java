package dataStructures.trees;

public class TreeLinkedList<T> {

    private ListNode<T> head;
    private ListNode<T> last;

    public TreeLinkedList() {
        this.head = null;
    }

    public TreeLinkedList(ListNode<T> head) {
        this.head = head;
    }

    public ListNode<T> getHead() {
        return head;
    }

    public void setHead(ListNode<T> head) {
        this.head = head;
    }

    public TreeLinkedList<T> add(T data) {
        if (head == null) {
            head = new ListNode<>(data);
            last = head;
            head.setNext(null);
        } else {
            ListNode<T> newNode = new ListNode<>(data);
            last.setNext(newNode);
            last = newNode;
        }
        return this;
    }
}
