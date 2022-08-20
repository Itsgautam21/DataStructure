package LinkedList;

class SinglyNode {
    int data;
    SinglyNode next;
    SinglyNode(int data) {
        this.data = data;
        this.next = null;
    }
}
public class SinglyLinkedList {

    static SinglyNode head = null;
    static {
        int[] array = {1, 2, 3, 4, 5};
        for (int item : array) create(item);
        display(head);
    }

    public static void create(int data) {
        SinglyNode newNode = new SinglyNode(data);
        if (head == null) head = newNode;
        else {
            SinglyNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public static SinglyNode addFirst(int data) {
        SinglyNode newNode = new SinglyNode(data);
        if (head != null) newNode.next = head;
        head = newNode;
        return head;
    }
    public static SinglyNode addLast(int data) {
        SinglyNode newNode = new SinglyNode(data);
        SinglyNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
        return head;
    }
    public static SinglyNode addPosition(int data, int pos) {
        SinglyNode newNode = new SinglyNode(data);
        SinglyNode temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }
    public static SinglyNode deleteFirst() {
        if (head == null) return null;
        head = head.next;
        return head;
    }
    public static SinglyNode deleteLast() {
        SinglyNode temp = head;
        while (temp.next.next != null) temp = temp.next;
        temp.next = null;
        return head;
    }
    public static SinglyNode deletePosition(int pos) {
        SinglyNode temp = head;
        for (int i = 0; i < pos - 1; i++) temp = temp.next;
        temp.next = temp.next.next;
        return head;
    }
    public static SinglyNode reverse() {
        SinglyNode current = head;
        SinglyNode prev = null, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }


    public static void display(SinglyNode head) {
        SinglyNode node = head;
        while (node != null) {
            if (node.next == null) System.out.print(node.data);
            else System.out.print(node.data + " --> ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        display(addFirst(0));
        display(addLast(6));
        display(addPosition( 11, 2));
        display(deleteFirst());
        display(deleteLast());
        display(deletePosition(3));
        display(reverse());
    }
}
