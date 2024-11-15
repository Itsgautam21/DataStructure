package problems;

public class DeleteElements {
    /**
     * @Question :203
     */
    public static ListNode delete(ListNode head, int val) {
        ListNode curr = head;
        ListNode prev;
        if (head.val == val) return head.next;
        else {
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
                if (curr.val == val)
                    prev.next = curr.next;
            }
            return head;
        }
    }
    
    public static ListNode deleteElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode curr = head;
        ListNode newHead = head;
        while (curr != null) {
            if (curr.val == val) {
                curr = delete(newHead, val);
                newHead = curr;
            } else curr = curr.next;
        }
        return newHead;
    }
    public static void main(String[] args) {
    
    }
}
