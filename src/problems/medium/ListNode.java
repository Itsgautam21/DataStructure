package problems.medium;

public class ListNode {

    int val;
    ListNode next;
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList {

    public ListNode head = null;
    public ListNode last = null;

    public void addStartNode(int value) {

        ListNode node = new ListNode(value, null);
        node.next = head;
        head = node;
    }

    public void addLastNode(int value) {

        ListNode node = new ListNode(value, null);
        if (head == null) {
            head = node;
            last = node;
        } else {
            last.next = node;
            last = last.next;
        }
    }

    public void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
