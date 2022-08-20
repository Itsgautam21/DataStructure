package Sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
                if (array[j] < array[minIndex])
                    minIndex = j;
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {55, 22 ,66 ,56, 23, 71, 59, 87, 10, 17};
        selectionSort(array);
    }
}
