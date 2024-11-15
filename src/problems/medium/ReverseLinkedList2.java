package problems.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Question : 92
 */
public class ReverseLinkedList2 {

    private static ListNode reverseList(ListNode head, int left, int right) {

        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        ListNode startNode = null;
        ListNode leftNode = null;
        int position = 1;

        while (current != null) {
            next = current.next;
            if (position == left - 1) {
                leftNode = current;
            }
            else if (position >= left && position <= right) {
                if (position == left) {
                    startNode = current;
                }
                current.next = prev;
            }
            else if (position == right + 1) {
                if (startNode != null) startNode.next = current;
                if (leftNode == null) head = prev;
                else leftNode.next = prev;
            }
            position++;
            prev = current;
            current = next;
        }
        // if 'right' position has last node of the list.
        if (position == right + 1) {
            if (startNode != null) startNode.next = null;
            if (leftNode == null) head = prev;
            else leftNode.next = prev;
        }
        return head;
    }

    private static ListNode reverseListM2(ListNode head, int left, int right) {

        int position = 1;
        ListNode current = head;
        Stack<ListNode> stack = new Stack<>();
        List<ListNode> nodes = new ArrayList<>();
        while (current != null) {
            if (position >= left && position <= right) {
                nodes.add(null);
                stack.push(current);
            } else nodes.add(current);
            current = current.next;
        }
        ListNode nHead = null;
        ListNode last = null;
        for (ListNode item : nodes) {
            if (nHead == null) {
                if (item == null) nHead = stack.pop();
                else nHead = item;
                last = nHead;
            } else {
                if (item == null) last.next = stack.pop();
                else last.next = item;
                last = last.next;
            }
        }
        if (last != null)
            last.next = null;
        return nHead;
    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        LinkedList list = new LinkedList();
        LinkedList list1 = new LinkedList();
        for (int item : array) {
            list.addLastNode(item);
        }
        for (int item : array) {
            list1.addLastNode(item);
        }
        int left = 0;
        int right = 5;
        list.display(list.head);
        list.display(reverseList(list.head, left, right));
        list.display(reverseListM2(list1.head, left, right));
    }
}
