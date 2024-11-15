package dsa.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] array = {55, 22 ,66 ,56, 23, 71, 59, 87, 10, 17};
        insertionSort(array);
    }
}
