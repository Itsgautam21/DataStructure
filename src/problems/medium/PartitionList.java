package problems.medium;

/**
 * @Question 86
 */
public class PartitionList {

    private static ListNode partition(ListNode head, int x) {

        ListNode current = head;
        ListNode divideNode = null;
        while (current != null) {
            if (current.val >= x) {
                break;
            }
            divideNode = current;
            current = current.next;
        }
        ListNode previous = null;
        while (current != null) {
            if (current.val < x) {
                previous.next = current.next;
                if (divideNode == null) {
                    current.next = head;
                    head = current;
                    divideNode = current;
                    current = previous;
                } else {
                    current.next = divideNode.next;
                    divideNode.next = current;
                    current = previous;
                    divideNode = divideNode.next;
                }
            }
            previous = current;
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {

        int[] list = {4, 1, 3, 0, 2, 5, 2};
        int x = 3;
        LinkedList linkedList = new LinkedList();
        for (int item : list) {
            linkedList.addLastNode(item);
        }
        RotateList.display(linkedList.head);
        RotateList.display(partition(linkedList.head, x));
    }
}
