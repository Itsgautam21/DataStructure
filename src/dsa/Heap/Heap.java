package dsa.Heap;
import java.util.Arrays;

/** A DataStructures.Heap is a special DataStructures.Tree-based data structure in which the tree is a complete binary tree. Generally,
    Heaps can be of two types:

    Max-DataStructures.Heap: In a Max-DataStructures.Heap the key present at the root node must be greatest among the keys present at all of its children.
        The same property must be recursively true for all sub-trees in that Binary DataStructures.Tree.
    Min-DataStructures.Heap: In a Min-DataStructures.Heap the key present at the root node must be minimum among the keys present at all of its children.
        The same property must be recursively true for all sub-trees in that Binary DataStructures.Tree.


    We can derive a tighter bound by observing that the running time of Heapify depends on the height of the tree
    ‘h’ (which is equal to lg(n), where n is number of nodes) and the heights of most sub-trees are small.
    The height ’h’ increases as we move upwards along the tree. Line-3 of Build-DataStructures.Heap runs a loop from the
    index of the last internal node (heapSize/2) with height = 1, to the index of root(1) with height = lg(n).
    Hence, Heapify takes different time for each node, which is O(h).

    For finding the Time Complexity of building a heap, we must know the number of nodes having height h.
    For this we use the fact that, A heap of size n has at most [ n / (2 ^ h + 1) ] nodes with height h.

    Time complexity for Building a Binary DataStructures.Heap is O(n).
 */

/*         1
          /  \
         2    4
        / \  /  \
      6   3 39   45
     /  \
    66   33

    (min heap)
*/
public class Heap {

    private final int[] heap;
    private int size;
    private final int capacity;

    Heap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity + 1];
        size = 0;
    }
    private int parent(int pos) { return pos / 2; }
    private int leftChild(int pos) { return (2 * pos); }
    private int rightChild(int pos) { return (2 * pos) + 1; }
    private boolean isLeaf(int pos) { return pos > (size / 2) && pos <= size; }
    private void swap(int first, int second) {
        int tmp = heap[first];
        heap[first] = heap[second];
        heap[second] = tmp;
    }
    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int data) {
        if (size >= capacity) return;
        heap[++size] = data;
        int current = size;
        //minHeapify(current);
        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }

    }
    public int delete() {
        int pooped = heap[1];
        heap[1] = heap[size--];
        minHeapify(1);
        return pooped;
    }
    public void sort(int[] arr) {
        for (int i : arr) insert(i);
        for (int i = 0; i < arr.length; i++) {
            int pooped = delete();
            arr[size] = pooped;
        }
    }
    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print("   " + heap[i]
                            + "\n /   \\ "
                            + "\n" + heap[2 * i] + "     " + heap[2 * i + 1]);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Heap heap = new Heap(16);
        heap.insert(1);
        heap.insert(2);
        heap.insert(4);
        heap.insert(6);
        heap.insert(3);
        heap.insert(39);
        heap.insert(45);
        heap.insert(66);
        heap.insert(33);
        heap.print();
        System.out.println("Deleted item is : "+ heap.delete());
        heap.print();
        int[] arr = {2, 3, 4, 5, 7, 6};
        Heap heapSort = new Heap(7);
        heapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
