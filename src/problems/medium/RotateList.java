package problems.medium;

/**
 * @Question : 61
 */

public class RotateList {

    public static ListNode head = null;

    public static void addNode(int value) {
        ListNode node = new ListNode(value, null);
        node.next = head;
        head = node;
    }

    public static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * rotate k times list right.
     *
     * @param head head node.
     * @param k    no of times rotation.
     * @return head of the rotated list.
     */
    public static ListNode rotate(ListNode head, int k) {

        if (head == null || head.next == null)
            return head;

        int count = 1;
        ListNode lastNode = head;
        // get size of the list;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            count++;
        }
        k = k % count;

        ListNode temp = head;
        for (int i = 1; i < count - k; i++) {
            temp = temp.next;
        }
        lastNode.next = head;
        head = temp.next;
        temp.next = null;
        return head;
    }

    /**
     * rotate k list times to right (optimise).
     *
     * @param head head node
     * @param k    no of times rotation
     * @return head of rotated list.
     */
    public static ListNode rotateM2(ListNode head, int k) {

        if (head == null || head.next == null)
            return head;
        int count = 1;
        ListNode lastNode = head;
        // get size of the list
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            count++;
        }
        k = k % count;
        lastNode.next = head;
        for (int i = 0; i < count - k; i++) {
            head = head.next;
            lastNode = lastNode.next;
        }
        // to break from cycle in the list.
        lastNode.next = null;
        return head;
    }

    public static void main(String[] args) {
        addNode(5);
        addNode(4);
        addNode(3);
        addNode(2);
        addNode(1);
        display(head);
        //display(rotate(head, 2));
        display(rotateM2(head, 2));
    }
}
