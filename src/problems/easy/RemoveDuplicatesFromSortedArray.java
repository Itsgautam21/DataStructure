package problems.easy;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] array) {
       int k = 1;
       for (int i = 1; i < array.length; i++) {
           if (array[i] != array[i - 1]) {
               array[k] = array[i];
               k++;
           }
       }
       return k;
    }

    public static void main(String[] args) {
        int[] testCase1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = removeDuplicates(testCase1);
        System.out.println(Arrays.toString(testCase1) + ", " + k);
    }
}
