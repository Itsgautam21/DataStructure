package Sorting;
import java.util.Arrays;

public class BubbleSort {

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
    public static void bubbleSortModified(int[] array) {
        int n = array.length;
        for (int round = 1; round < n; round++) {
            int flag = 0;
            for (int index = 0; index < n - round; index++) {
                if (array[index] > array[index + 1]) {
                    flag = 1;
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
                if (flag == 0) break;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int round = 1; round < n; round++) {
            for (int index = 0; index < n - round; index++) {
                if (array[index] > array[index + 1]) {
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {55, 22 ,66 ,56, 23, 71, 59, 87, 10, 17};
        bubbleSort(array);
        bubbleSortModified(array);
    }
}
